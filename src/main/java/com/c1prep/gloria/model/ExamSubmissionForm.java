package com.c1prep.gloria.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamSubmissionForm {
    private Long examId;
    // La chiave della mappa sarà l'ID dell'esercizio, il valore sarà la stringa inserita dall'utente
    private Map<Long, String> responses = new HashMap<>();
}