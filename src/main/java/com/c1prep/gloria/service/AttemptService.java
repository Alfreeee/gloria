package com.c1prep.gloria.service;

import com.c1prep.gloria.model.*;
import com.c1prep.gloria.repository.ExamAttemptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttemptService {

    private final ExamService examService;
    private final ExamAttemptRepository attemptRepository;

    // Sfruttiamo un unico costruttore pulito per iniettare sia il servizio che il repository.
    // Rimosso del tutto l'EntityManager!
    public AttemptService(ExamService examService, ExamAttemptRepository attemptRepository) {
        this.examService = examService;
        this.attemptRepository = attemptRepository;
    }

    /**
     * Calcola il punteggio del modulo d'esame e salva il tentativo nel Database.
     */
    @Transactional
    public ExamAttempt saveExamAttempt(ExamSubmissionForm form) {
        Exam exam = examService.getExamById(form.getExamId());
        
        ExamAttempt attempt = new ExamAttempt();
        attempt.setExam(exam);
        attempt.setCompletedAt(LocalDateTime.now());

        int score = 0;
        int totalQuestions = 0;

        if (exam.getType() == ExamType.WORD_TRANSFORMATION) {
            totalQuestions = exam.getWordExercises().size();
            for (WordTransformation ex : exam.getWordExercises()) {
                String userAns = form.getResponses().get(ex.getId());
                
                boolean isCorrect = userAns != null && userAns.trim().equalsIgnoreCase(ex.getSolution().trim());
                if (isCorrect) score++;

                UserAnswer ua = new UserAnswer();
                ua.setAttempt(attempt);
                ua.setExerciseId(ex.getId());
                ua.setAnswerGiven(userAns);
                ua.setCorrect(isCorrect);
                attempt.getAnswers().add(ua);
            }
        } else {
            totalQuestions = exam.getSentenceExercises().size();
            for (SentenceTransformation ex : exam.getSentenceExercises()) {
                String userAns = form.getResponses().get(ex.getId());
                
                boolean isCorrect = userAns != null && userAns.trim().equalsIgnoreCase(ex.getSolution().trim());
                if (isCorrect) score++;

                UserAnswer ua = new UserAnswer();
                ua.setAttempt(attempt);
                ua.setExerciseId(ex.getId());
                ua.setAnswerGiven(userAns);
                ua.setCorrect(isCorrect);
                attempt.getAnswers().add(ua);
            }
        }

        attempt.setScore(score);
        attempt.setTotalQuestions(totalQuestions);
        
        ExamAttempt savedAttempt = attemptRepository.saveAndFlush(attempt);
        return savedAttempt;
    }

    /**
     * Recupera lo storico di tutte le sessioni completate da Gloria ordina dalla più recente.
     */
    public List<ExamAttempt> getAllAttemptsOrdered() {
        return attemptRepository.findAllByOrderByCompletedAtDesc();
    }

    public ExamAttempt getAttemptById(Long id) {
        return attemptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tentativo non trovato con ID: " + id));
    }

    /**
     * Elimina definitivamente un tentativo e le sue risposte associate dal DB.
     */
    @Transactional
    public void deleteAttemptById(Long id) {
        ExamAttempt attempt = attemptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tentativo non trovato con ID: " + id));
        
        attemptRepository.delete(attempt);
    }
}