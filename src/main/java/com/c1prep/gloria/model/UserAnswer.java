package com.c1prep.gloria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_answers")
public class UserAnswer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_id", nullable = false)
    private ExamAttempt attempt;

    // Identifica a quale esercizio si riferisce la risposta
    private Long exerciseId; 

    private String answerGiven; // La risposta scritta dall'utente
    private boolean isCorrect;  // Se la risposta era giusta o meno
}