package com.c1prep.gloria.controller;

import com.c1prep.gloria.model.SentenceTransformation;
import com.c1prep.gloria.model.WordTransformation;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseRestController {

    private final EntityManager entityManager;

    public ExerciseRestController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/api/exercises/explain")
    public String getExplanation(@RequestParam Long id, @RequestParam String type) {
        // Simuliamo un leggero delay per rendere l'effetto del "caricamento dell'AI" realistico
        try { Thread.sleep(400); } catch (InterruptedException ignored) {}

        if ("WORD".equalsIgnoreCase(type)) {
            WordTransformation w = entityManager.find(WordTransformation.class, id);
            if (w != null && w.getExplanation() != null) {
                return "[Database Explain]: " + w.getExplanation();
            }
        } else if ("SENTENCE".equalsIgnoreCase(type)) {
            SentenceTransformation s = entityManager.find(SentenceTransformation.class, id);
            if (s != null && s.getExplanation() != null) {
                return "[Database Explain]: " + s.getExplanation();
            }
        }

        // Se un domani integri Python o LLM puoi agganciarlo qui
        return "Spiegazione AI standard: Ricorda che il livello C1 richiede un uso accurato di prefissi/suffissi e strutture idiomatiche avanzate.";
    }
}