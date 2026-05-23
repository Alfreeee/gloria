package com.c1prep.gloria.controller;

import com.c1prep.gloria.model.*;
import com.c1prep.gloria.service.AttemptService;
import com.c1prep.gloria.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;
    private final AttemptService attemptService;

    public ExamController(ExamService examService, AttemptService attemptService) {
        this.examService = examService;
        this.attemptService = attemptService;
    }

    @GetMapping("/word-transformation/new")
    public String randomWordExam(Model model) {
        Exam exam = examService.getNewExam(ExamType.WORD_TRANSFORMATION);
        ExamSubmissionForm form = new ExamSubmissionForm();
        form.setExamId(exam.getId());
        model.addAttribute("exam", exam);
        model.addAttribute("submissionForm", form);
        return "exam/word-exam";
    }

    @GetMapping("/sentence-transformation/new")
    public String randomSentenceExam(Model model) {
        Exam exam = examService.getNewExam(ExamType.SENTENCE_TRANSFORMATION);
        ExamSubmissionForm form = new ExamSubmissionForm();
        form.setExamId(exam.getId());
        model.addAttribute("exam", exam);
        model.addAttribute("submissionForm", form);
        return "exam/sentence-exam";
    }

    @PostMapping("/submit")
    public String submitExam(@ModelAttribute ExamSubmissionForm form, Model model) {
        if (form == null) {
            form = new ExamSubmissionForm();
        }

        ExamAttempt attempt = attemptService.saveExamAttempt(form);

        model.addAttribute("exam", attempt.getExam());
        model.addAttribute("score", attempt.getScore());
        model.addAttribute("totalQuestions", attempt.getTotalQuestions());
        model.addAttribute("percent", attempt.getScorePercent());
        model.addAttribute("submissionForm", form); 
        model.addAttribute("attempt", attempt);   // Passiamo l'attempt anche qui
        model.addAttribute("isArchive", false);    // Specifichiamo che è una consegna fresca!

        return "exam/results";
    }

    @GetMapping("/completed")
    public String listCompletedExams(Model model) {
        List<ExamAttempt> attempts = attemptService.getAllAttemptsOrdered();
        model.addAttribute("attempts", attempts);
        return "exam/completed-exams";
    }

    @GetMapping("/completed/{id}")
    public String viewCompletedExamDetail(@PathVariable Long id, Model model) {
        ExamAttempt attempt = attemptService.getAttemptById(id);
        if (attempt == null) {
            throw new RuntimeException("Tentativo non trovato: " + id);
        }

        ExamSubmissionForm fakeForm = new ExamSubmissionForm();
        fakeForm.setExamId(attempt.getExam().getId());
        for (UserAnswer ans : attempt.getAnswers()) {
            fakeForm.getResponses().put(ans.getExerciseId(), ans.getAnswerGiven());
        }

        model.addAttribute("exam", attempt.getExam());
        model.addAttribute("score", attempt.getScore());
        model.addAttribute("totalQuestions", attempt.getTotalQuestions());
        model.addAttribute("percent", attempt.getScorePercent());
        model.addAttribute("submissionForm", fakeForm); 
        model.addAttribute("attempt", attempt); 
        model.addAttribute("isArchive", true);     // Specifichiamo che stiamo leggendo dallo storico!

        return "exam/results";
    }

    @PostMapping("/attempt/delete/{id}")
    public String deleteAttempt(@PathVariable Long id) {
        attemptService.deleteAttemptById(id);
        return "redirect:/exam/completed";
    }
}