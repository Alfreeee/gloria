package com.c1prep.gloria.service;

import com.c1prep.gloria.model.Exam;
import com.c1prep.gloria.model.ExamType;
import com.c1prep.gloria.repository.ExamRepository;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam getNewExam(ExamType type) {
        // 1. Prova a prendere un esame mai fatto controllando direttamente la tabella degli attempt
        return examRepository.findRandomUnattemptedByType(type)
                // 2. Fallback: Se sono finiti gli esami vergini, prendine uno random qualsiasi
                .or(() -> examRepository.findRandomByType(type))
                // 3. Se il DB è proprio vuoto, lancia l'eccezione
                .orElseThrow(() -> new RuntimeException("Nessun exam disponibile per il tipo: " + type));
    }

    // Aggiungi questo metodo all'interno di ExamService.java

    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Esame non trovato con ID: " + id));
    }
}