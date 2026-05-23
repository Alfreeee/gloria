package com.c1prep.gloria.config;

import com.c1prep.gloria.model.*;
import com.c1prep.gloria.repository.ExamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements ApplicationRunner {

    private final ExamRepository examRepository;

    public DataInitializer(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Evita di reinserire i dati a ogni riavvio se il database non è in-memory
        if (examRepository.count() > 0) {
            return;
        }

        // =========================================================================
        // ── EXAM 1: Word Transformation – Set 1 (Focus: Sostantivi Astratti e Negazioni)
        // =========================================================================
        Exam wordExam1 = new Exam();
        wordExam1.setTitle("Word Transformation - Set 1 (Nouns & Negations)");
        wordExam1.setType(ExamType.WORD_TRANSFORMATION);
        wordExam1.setSource("cambridge.org");
        wordExam1.setCreatedAt(LocalDateTime.now());

        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "He is known for his _____ in negotiations.", "SKILL", "skillfulness",
            "SKILL → skillfulness (noun, suffix -fulness).", 1));
        
        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "The new policy was met with widespread _____.", "APPROVE", "disapproval",
            "APPROVE → disapproval (negative noun, prefix dis- + suffix -al).", 2));
        
        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "She gave a _____ account of what had happened.", "DETAIL", "detailed",
            "DETAIL → detailed (adjective, suffix -ed).", 3));
        
        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "The scientist made a _____ discovery last year.", "REMARK", "remarkable",
            "REMARK → remarkable (adjective, suffix -able).", 4));

        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "The complete _____ of the historical documents shocked the experts.", "DESTROY", "destruction",
            "DESTROY → destruction (noun form for abstract event).", 5));

        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "It was an _____ mistake that cost them the entire contract.", "EXCUSE", "inexcusable",
            "EXCUSE → inexcusable (negative adjective, prefix in- + suffix -able).", 6));

        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "Her sudden _____ left everyone in the room completely baffled.", "APPEAR", "disappearance",
            "APPEAR → disappearance (negative noun indicating absence, prefix dis- + suffix -ance).", 7));

        wordExam1.getWordExercises().add(makeWord(wordExam1,
            "The medicine provides immediate _____ from chronic back pain.", "RELIEVE", "relief",
            "RELIEVE → relief (irregular noun form).", 8));

        examRepository.save(wordExam1);


        // =========================================================================
        // ── EXAM 2: Word Transformation – Set 2 (Focus: Aggettivi e Avverbi Avanzati)
        // =========================================================================
        Exam wordExam2 = new Exam();
        wordExam2.setTitle("Word Transformation – Set 2 (Advanced Modifiers)");
        wordExam2.setType(ExamType.WORD_TRANSFORMATION);
        wordExam2.setSource("oxford_exams");
        wordExam2.setCreatedAt(LocalDateTime.now());

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "The weather in this region is notoriously _____.", "PREDICT", "unpredictable",
            "PREDICT → unpredictable (negative adjective, prefix un- + suffix -able).", 1));

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "The board reacted _____ to the manager's proposal.", "ENTHUSIASM", "enthusiastically",
            "ENTHUSIASM → enthusiastically (adverb, requires adjective -astic + adverbial suffix -ally).", 2));

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "The internet has significantly _____ our global communication networks.", "SHORT", "shortened",
            "SHORT → shortened (verb in past participle, suffix -en + -ed).", 3));

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "There is a growing _____ of water resources in rural areas.", "SCARCE", "scarcity",
            "SCARCE → scarcity (abstract noun, suffix -ity).", 4));

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "He was disqualified for his _____ behavior on the tennis court.", "SPORT", "unsporting",
            "SPORT → unsporting (negative adjective describing behavior, prefix un- + suffix -ing).", 5));

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "Your continuous support has been absolutely _____ to our project.", "VALUE", "invaluable",
            "VALUE → invaluable (adjective meaning 'priceless', prefix in- + suffix -able).", 6));

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "The company is looking for a flexible and _____ assistant.", "TRUST", "trustworthy",
            "TRUST → trustworthy (compound adjective, suffix -worthy).", 7));

        wordExam2.getWordExercises().add(makeWord(wordExam2,
            "The rules were updated to ensure there was no _____ against minority groups.", "DISCRIMINATE", "discrimination",
            "DISCRIMINATE → discrimination (noun form, suffix -ation).", 8));

        examRepository.save(wordExam2);


        // =========================================================================
        // ── EXAM 3: Sentence Transformation – Set 1 (Focus: Verbi e Strutture passive)
        // =========================================================================
        Exam sentExam1 = new Exam();
        sentExam1.setTitle("Sentence Transformation – Set 1 (Grammar Structures)");
        sentExam1.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam1.setSource("cambridge.org");
        sentExam1.setCreatedAt(LocalDateTime.now());

        sentExam1.getSentenceExercises().add(makeSentence(sentExam1,
            "She didn't manage to finish the report.", "SUCCEED",
            "She didn't", "succeed in finishing", "the report.",
            "SUCCEED richiede la preposizione 'in' seguita dal gerundio (-ing).", 1));
        
        sentExam1.getSentenceExercises().add(makeSentence(sentExam1,
            "It's possible that he missed the train.", "MIGHT",
            "He", "might have missed", "the train.",
            "Possibilità al passato: modal might + have + past participle.", 2));
        
        sentExam1.getSentenceExercises().add(makeSentence(sentExam1,
            "They are renovating the town hall at the moment.", "BEING",
            "The town hall", "is being renovated", "at the moment.",
            "Present continuous passive: is/are + being + past participle.", 3));
        
        sentExam1.getSentenceExercises().add(makeSentence(sentExam1,
            "I last spoke to her three years ago.", "FOR",
            "I", "haven't spoken to her for", "three years.",
            "L'azione passata si traduce con il Present Perfect Negative + for.", 4));

        sentExam1.getSentenceExercises().add(makeSentence(sentExam1,
            "If you don't study harder, you will fail the exam.", "UNLESS",
            "Unless", "you study harder, you", "will fail the exam.",
            "UNLESS significa 'if not', quindi sostituisce la condizione negativa.", 5));

        sentExam1.getSentenceExercises().add(makeSentence(sentExam1,
            "They say that the company is losing millions.", "SAID",
            "The company", "is said to be losing", "millions.",
            "Struttura passiva impersonale avanzata (Passive Infinitive).", 6));

        examRepository.save(sentExam1);


        // =========================================================================
        // ── EXAM 4: Sentence Transformation – Set 2 (Focus: Idioms & Inversioni)
        // =========================================================================
        Exam sentExam2 = new Exam();
        sentExam2.setTitle("Sentence Transformation – Set 2 (Idioms & Inversion)");
        sentExam2.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam2.setSource("manual_advanced");
        sentExam2.setCreatedAt(LocalDateTime.now());

        sentExam2.getSentenceExercises().add(makeSentence(sentExam2,
            "As soon as he arrived, the storm started.", "SOONER",
            "No sooner", "had he arrived than", "the storm started.",
            "Inversione enfatica: 'No sooner... than' richiede l'ausiliare prima del soggetto.", 1));

        sentExam2.getSentenceExercises().add(makeSentence(sentExam2,
            "I really don't want to go out tonight.", "FEEL",
            "I don't", "feel like going out", "tonight.",
            "L'espressione idiomatica 'feel like' richiede la forma in -ing.", 2));

        sentExam2.getSentenceExercises().add(makeSentence(sentExam2,
            "The flight was canceled because of the heavy fog.", "DUE",
            "The flight was canceled", "due to the", "heavy fog.",
            "'Due to' introduce la causa ed equivale a 'because of'.", 3));

        sentExam2.getSentenceExercises().add(makeSentence(sentExam2,
            "It was a mistake for you to type that letter.", "SHOULD",
            "You", "should not have typed", "that letter.",
            "Rimpianto/critica al passato: should + not + have + past participle.", 4));

        sentExam2.getSentenceExercises().add(makeSentence(sentExam2,
            "He has a very good relationship with his boss.", "GETS",
            "He", "gets on very well with", "his boss.",
            "Uso del phrasal verb 'get on well with' (andare d'accordo).", 5));

        sentExam2.getSentenceExercises().add(makeSentence(sentExam2,
            "We couldn't afford to buy the car.", "ENOUGH",
            "We didn't", "have enough money to", "buy the car.",
            "'Afford' espresso tramite quantità sufficiente di denaro.", 6));

        examRepository.save(sentExam2);

        // =========================================================================
        // ── EXAM 5: Word Transformation – Set 3 (Focus: Prefissi Negativi e Composti)
        // =========================================================================
        Exam wordExam3 = new Exam();
        wordExam3.setTitle("Word Transformation – Set 3 (Negative Prefixes & Compounds)");
        wordExam3.setType(ExamType.WORD_TRANSFORMATION);
        wordExam3.setSource("esl-lounge.com");
        wordExam3.setCreatedAt(LocalDateTime.now());

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "The journalist's report was completely _____.", "GROUND", "groundbreaking",
            "GROUND → groundbreaking (aggettivo composto, 'rivoluzionario/innovativo').", 1));

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "His _____ during the crisis impressed the entire team.", "COMPOSE", "composure",
            "COMPOSE → composure (sostantivo che indica calma/autocontrollo, suffisso -ure).", 2));

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "The terms of the contract were deemed entirely _____.", "ENFORCE", "unenforceable",
            "ENFORCE → unenforceable (aggettivo negativo, prefisso un- + suffisso -able).", 3));

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "The politician's speech was full of _____ statements.", "LEAD", "misleading",
            "LEAD → misleading (aggettivo verbale, prefisso mis- + suffisso -ing).", 4));

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "She showed great _____ when dealing with the difficult client.", "PATIENT", "patience",
            "PATIENT → patience (sostantivo astratto, cambio di suffisso da -ent a -ence).", 5));

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "The new regulation will _____ the use of single-use plastics.", "CRIMINAL", "criminalise",
            "CRIMINAL → criminalise (verbo, suffisso -ise; variante -ize accettata).", 6));

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "The _____ of the two companies created the largest firm in the sector.", "MERGE", "merger",
            "MERGE → merger (sostantivo che indica il processo di fusione, suffisso -er).", 7));

        wordExam3.getWordExercises().add(makeWord(wordExam3,
            "Despite several attempts, the peace talks ended _____.", "CONCLUDE", "inconclusively",
            "CONCLUDE → inconclusively (avverbio negativo: prefisso in- + -ive + -ly).", 8));

        examRepository.save(wordExam3);


        // =========================================================================
        // ── EXAM 6: Word Transformation – Set 4 (Focus: Suffissi -tion/-sion/-ness/-ity)
        // =========================================================================
        Exam wordExam4 = new Exam();
        wordExam4.setTitle("Word Transformation – Set 4 (Noun Suffixes -tion/-ness/-ity)");
        wordExam4.setType(ExamType.WORD_TRANSFORMATION);
        wordExam4.setSource("esl-lounge.com");
        wordExam4.setCreatedAt(LocalDateTime.now());

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "The _____ of new technology in classrooms is still controversial.", "INTRODUCE", "introduction",
            "INTRODUCE → introduction (sostantivo di processo, suffisso -tion con radice alterata).", 1));

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "Her _____ to detail makes her an excellent editor.", "ATTEND", "attention",
            "ATTEND → attention (sostantivo, suffisso -tion; 'attention to detail' è espressione fissa).", 2));

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "The government pledged to tackle the growing _____ in urban areas.", "EQUAL", "inequality",
            "EQUAL → inequality (sostantivo negativo, prefisso in- + suffisso -ity).", 3));

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "The _____ of the situation became clear only after the trial.", "COMPLEX", "complexity",
            "COMPLEX → complexity (sostantivo astratto, suffisso -ity con radice alterata).", 4));

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "There was a general _____ about the new safety procedures.", "AWARE", "unawareness",
            "AWARE → unawareness (sostantivo negativo, prefisso un- + suffisso -ness).", 5));

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "His _____ was evident from the way he handled the negotiations.", "SHREWD", "shrewdness",
            "SHREWD → shrewdness (sostantivo che indica acume, suffisso -ness).", 6));

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "The architect was praised for the _____ of her building designs.", "ORIGIN", "originality",
            "ORIGIN → originality (sostantivo astratto, aggettivo original + suffisso -ity).", 7));

        wordExam4.getWordExercises().add(makeWord(wordExam4,
            "The _____ of the new drug has yet to be fully established.", "SAFE", "safety",
            "SAFE → safety (sostantivo, suffisso -ty con leggero cambio ortografico).", 8));

        examRepository.save(wordExam4);


        // =========================================================================
        // ── EXAM 7: Word Transformation – Set 5 (Focus: Verbi Derivati e Prefissi)
        // =========================================================================
        Exam wordExam5 = new Exam();
        wordExam5.setTitle("Word Transformation – Set 5 (Derived Verbs & Prefixes)");
        wordExam5.setType(ExamType.WORD_TRANSFORMATION);
        wordExam5.setSource("esl-lounge.com");
        wordExam5.setCreatedAt(LocalDateTime.now());

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "The charity aims to _____ people affected by the flood.", "HOUSE", "rehouse",
            "HOUSE → rehouse (verbo con prefisso re- che indica 'fornire nuovamente alloggio').", 1));

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "The committee needs to _____ the budget before the end of the month.", "FINAL", "finalise",
            "FINAL → finalise (verbo, suffisso -ise; variante -ize accettata).", 2));

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "The agency was accused of _____ the public about the risks involved.", "INFORM", "misinforming",
            "INFORM → misinforming (gerundio di verbo con prefisso mis-, indica 'informare erroneamente').", 3));

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "Her _____ answer to the question surprised the whole panel.", "THOUGHT", "thoughtful",
            "THOUGHT → thoughtful (aggettivo composto, suffisso -ful).", 4));

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "The report was _____ criticised by leading experts in the field.", "WIDE", "widely",
            "WIDE → widely (avverbio, suffisso -ly; 'widely criticised' è colocazione frequente).", 5));

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "The sudden _____ of the CEO sent shockwaves through the industry.", "RESIGN", "resignation",
            "RESIGN → resignation (sostantivo di processo, suffisso -ation).", 6));

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "They had to _____ the project due to lack of funding.", "ABANDON", "abandonment",
            "ABANDON → abandonment (sostantivo, suffisso -ment).", 7));

        wordExam5.getWordExercises().add(makeWord(wordExam5,
            "The results of the study were _____.", "CONCLUDE", "inconclusive",
            "CONCLUDE → inconclusive (aggettivo negativo, prefisso in- + suffisso -ive).", 8));

        examRepository.save(wordExam5);


        // =========================================================================
        // ── EXAM 8: Word Transformation – Set 6 (Focus: Aggettivi Complessi e Forme Irregolari)
        // =========================================================================
        Exam wordExam6 = new Exam();
        wordExam6.setTitle("Word Transformation – Set 6 (Complex Adjectives & Irregular Forms)");
        wordExam6.setType(ExamType.WORD_TRANSFORMATION);
        wordExam6.setSource("esl-lounge.com");
        wordExam6.setCreatedAt(LocalDateTime.now());

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "The meeting was supposed to last an hour, but proved _____.", "END", "endless",
            "END → endless (aggettivo, suffisso -less; indica qualcosa che sembra non finire mai).", 1));

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "She is known for her _____ approach to every new challenge.", "ENTERPRISE", "enterprising",
            "ENTERPRISE → enterprising (aggettivo che indica intraprendenza, suffisso -ing).", 2));

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "The new law was widely regarded as deeply _____.", "FAIR", "unfair",
            "FAIR → unfair (aggettivo negativo, prefisso un-).", 3));

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "The speaker's _____ held the audience's attention for over two hours.", "ELOQUENT", "eloquence",
            "ELOQUENT → eloquence (sostantivo astratto, suffisso -ce con radice alterata).", 4));

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "The documentary provided a _____ look at life inside the prison.", "THOUGHT", "thought-provoking",
            "THOUGHT → thought-provoking (aggettivo composto con trattino, molto frequente al C1).", 5));

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "The new CEO promised to _____ the company's outdated practices.", "MODERN", "modernise",
            "MODERN → modernise (verbo, suffisso -ise; variante -ize accettata).", 6));

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "Her latest novel was praised for its _____ and depth.", "SUBTLE", "subtlety",
            "SUBTLE → subtlety (sostantivo con forma irregolare, drop della 'e' finale + suffisso -ty).", 7));

        wordExam6.getWordExercises().add(makeWord(wordExam6,
            "The instructions were so _____ that nobody could follow them.", "COMPREHEND", "incomprehensible",
            "COMPREHEND → incomprehensible (aggettivo negativo: in- + radice -comprehens- + -ible).", 8));

        examRepository.save(wordExam6);


        // =========================================================================
        // ── EXAM 9: Sentence Transformation – Set 3 (Focus: Wish/If Only & Condizionali Misti)
        // =========================================================================
        Exam sentExam3 = new Exam();
        sentExam3.setTitle("Sentence Transformation – Set 3 (Wish, If Only & Mixed Conditionals)");
        sentExam3.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam3.setSource("esl-lounge.com");
        sentExam3.setCreatedAt(LocalDateTime.now());

        sentExam3.getSentenceExercises().add(makeSentence(sentExam3,
            "I regret not studying harder when I was at university.", "WISH",
            "I", "wish I had studied harder", "when I was at university.",
            "Rimpianto sul passato: wish + past perfect (had + participio passato).", 1));

        sentExam3.getSentenceExercises().add(makeSentence(sentExam3,
            "She is annoyed that her colleagues are always interrupting her.", "ONLY",
            "If only her colleagues", "would stop interrupting", "her.",
            "'If only + would' esprime un desiderio/lamento riguardo al comportamento altrui.", 2));

        sentExam3.getSentenceExercises().add(makeSentence(sentExam3,
            "Because he didn't train enough, he can't run the marathon today.", "IF",
            "If he had trained enough, he", "would be able to run", "the marathon today.",
            "Condizionale misto: If + past perfect (passato) → would + infinito (presente).", 3));

        sentExam3.getSentenceExercises().add(makeSentence(sentExam3,
            "It's a pity we don't have more time to visit the museum.", "WISH",
            "I", "wish we had more time", "to visit the museum.",
            "Desiderio nel presente impossibile: wish + past simple.", 4));

        sentExam3.getSentenceExercises().add(makeSentence(sentExam3,
            "He was forced to resign because he had falsified the accounts.", "RESULTED",
            "Falsifying the accounts", "resulted in him being forced", "to resign.",
            "'Result in' + gerundio: struttura avanzata per esprimere conseguenza.", 5));

        sentExam3.getSentenceExercises().add(makeSentence(sentExam3,
            "They would prefer it if you didn't mention the incident again.", "RATHER",
            "They would", "rather you didn't mention", "the incident again.",
            "'Would rather + soggetto + past simple' esprime preferenza su azioni altrui.", 6));

        examRepository.save(sentExam3);


        // =========================================================================
        // ── EXAM 10: Sentence Transformation – Set 4 (Focus: Causative Have/Get & Reporting)
        // =========================================================================
        Exam sentExam4 = new Exam();
        sentExam4.setTitle("Sentence Transformation – Set 4 (Causative & Reported Speech)");
        sentExam4.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam4.setSource("esl-lounge.com");
        sentExam4.setCreatedAt(LocalDateTime.now());

        sentExam4.getSentenceExercises().add(makeSentence(sentExam4,
            "Someone broke into the office and stole the computers.", "BROKEN",
            "The office", "had been broken into and", "the computers stolen.",
            "Passivo del past perfect: had been + participio passato.", 1));

        sentExam4.getSentenceExercises().add(makeSentence(sentExam4,
            "A plumber will fix the boiler for us tomorrow.", "HAVING",
            "We are", "having the boiler fixed by", "a plumber tomorrow.",
            "Causativo 'have something done': have + oggetto + participio passato.", 2));

        sentExam4.getSentenceExercises().add(makeSentence(sentExam4,
            "\"Don't forget to submit your reports by Friday,\" the manager told us.", "REMINDED",
            "The manager", "reminded us to submit our", "reports by Friday.",
            "'Remind somebody to do something': verbo di reporting + infinito.", 3));

        sentExam4.getSentenceExercises().add(makeSentence(sentExam4,
            "\"I didn't take the documents,\" the suspect said.", "DENIED",
            "The suspect", "denied having taken the", "documents.",
            "'Deny + gerundio': verbo di reporting negativo seguito da forma in -ing.", 4));

        sentExam4.getSentenceExercises().add(makeSentence(sentExam4,
            "It is believed that the painting dates back to the 16th century.", "BELIEVED",
            "The painting", "is believed to date back", "to the 16th century.",
            "Passivo impersonale con infinito presente: is believed to + infinito.", 5));

        sentExam4.getSentenceExercises().add(makeSentence(sentExam4,
            "The mechanic is servicing our car right now.", "SERVICED",
            "We are", "having our car serviced by", "the mechanic right now.",
            "Causativo al presente progressivo: are having + oggetto + participio passato.", 6));

        examRepository.save(sentExam4);


        // =========================================================================
        // ── EXAM 11: Sentence Transformation – Set 5 (Focus: Inversioni Formali & Emphasis)
        // =========================================================================
        Exam sentExam5 = new Exam();
        sentExam5.setTitle("Sentence Transformation – Set 5 (Formal Inversion & Emphasis)");
        sentExam5.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam5.setSource("esl-lounge.com");
        sentExam5.setCreatedAt(LocalDateTime.now());

        sentExam5.getSentenceExercises().add(makeSentence(sentExam5,
            "We had barely sat down when the lights went out.", "HARDLY",
            "Hardly", "had we sat down when", "the lights went out.",
            "Inversione enfatica con 'Hardly... when': ausiliare anteposto al soggetto.", 1));

        sentExam5.getSentenceExercises().add(makeSentence(sentExam5,
            "Under no circumstances should you reveal the password to anyone.", "ON",
            "On", "no account should you reveal", "the password to anyone.",
            "'On no account' è espressione enfatica formale equivalente a 'Under no circumstances'.", 2));

        sentExam5.getSentenceExercises().add(makeSentence(sentExam5,
            "She had never seen such a breathtaking landscape before.", "NEVER",
            "Never before", "had she seen such a", "breathtaking landscape.",
            "Inversione con 'Never before': had + soggetto + participio passato.", 3));

        sentExam5.getSentenceExercises().add(makeSentence(sentExam5,
            "They only realised the full scale of the disaster after the rescue teams arrived.", "NOT",
            "Not until the rescue teams arrived", "did they realise the full", "scale of the disaster.",
            "'Not until...' richiede inversione nella proposizione principale: did + soggetto + verbo.", 4));

        sentExam5.getSentenceExercises().add(makeSentence(sentExam5,
            "It was such a boring lecture that half the students fell asleep.", "SO",
            "The lecture", "was so boring that half", "the students fell asleep.",
            "Struttura 'so + aggettivo + that': trasformazione da 'such a + sostantivo'.", 5));

        sentExam5.getSentenceExercises().add(makeSentence(sentExam5,
            "He not only forgot his passport but also missed the flight.", "WHAT",
            "What", "he did was forget his", "passport and miss the flight.",
            "Cleft sentence con 'What... did was + infinito': struttura enfatica avanzata.", 6));

        examRepository.save(sentExam5);


        // =========================================================================
        // ── EXAM 12: Sentence Transformation – Set 6 (Focus: Phrasal Verbs & Connettivi Avanzati)
        // =========================================================================
        Exam sentExam6 = new Exam();
        sentExam6.setTitle("Sentence Transformation – Set 6 (Phrasal Verbs & Advanced Connectors)");
        sentExam6.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam6.setSource("esl-lounge.com");
        sentExam6.setCreatedAt(LocalDateTime.now());

        sentExam6.getSentenceExercises().add(makeSentence(sentExam6,
            "Despite being exhausted, she continued working until midnight.", "EVEN",
            "Even", "though she was exhausted she", "continued working until midnight.",
            "'Even though' introduce una concessione con soggetto esplicito, equivale a 'despite the fact that'.", 1));

        sentExam6.getSentenceExercises().add(makeSentence(sentExam6,
            "I can't concentrate because the music is so loud.", "PREVENTS",
            "The loud music", "prevents me from concentrating", ".",
            "'Prevent somebody from doing something': struttura causativa negativa.", 2));

        sentExam6.getSentenceExercises().add(makeSentence(sentExam6,
            "He managed to solve the problem after thinking about it for a long time.", "CAME",
            "He", "came up with a solution", "after thinking about it for a long time.",
            "Phrasal verb 'come up with' = trovare/elaborare un'idea o soluzione.", 3));

        sentExam6.getSentenceExercises().add(makeSentence(sentExam6,
            "You are not allowed to use your phone during the examination.", "MUST",
            "You", "must not use your phone", "during the examination.",
            "'Must not' esprime divieto assoluto; equivalente formale a 'not allowed to'.", 4));

        sentExam6.getSentenceExercises().add(makeSentence(sentExam6,
            "It was not necessary for them to rewrite the entire proposal.", "NEED",
            "They", "needn't have rewritten the", "entire proposal.",
            "'Needn't have + past participle' indica che un'azione passata non era necessaria ma è stata fatta.", 5));

        sentExam6.getSentenceExercises().add(makeSentence(sentExam6,
            "The treasurer is responsible for managing the club's finances.", "CHARGE",
            "The treasurer is", "in charge of managing the", "club's finances.",
            "'Be in charge of + gerundio' equivale a 'be responsible for + gerundio'.", 6));

        examRepository.save(sentExam6);

        // =========================================================================
        // ── EXAM 13: Word Transformation – Set 7 (Focus: Sostantivi da Verbi Irregolari)
        // =========================================================================
        Exam wordExam7 = new Exam();
        wordExam7.setTitle("Word Transformation – Set 7 (Nouns from Irregular Verbs)");
        wordExam7.setType(ExamType.WORD_TRANSFORMATION);
        wordExam7.setSource("esl-lounge.com");
        wordExam7.setCreatedAt(LocalDateTime.now());

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "The _____ of the new bridge will take approximately three years.", "CONSTRUCT", "construction",
            "CONSTRUCT → construction (sostantivo di processo, suffisso -ion con radice alterata).", 1));

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "Her _____ of foreign languages helped her land the job.", "KNOW", "knowledge",
            "KNOW → knowledge (sostantivo irregolare, suffisso -ledge).", 2));

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "The _____ between the two rival gangs lasted for decades.", "FEUD", "feud",
            "FEUD rimane invariato come sostantivo; serve riconoscere la categoria grammaticale corretta.", 3));

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "There has been significant _____ in the field of renewable energy.", "GROW", "growth",
            "GROW → growth (sostantivo irregolare, suffisso -th con cambio vocalico).", 4));

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "The board expressed its _____ at the poor quarterly results.", "DISAPPOINT", "disappointment",
            "DISAPPOINT → disappointment (sostantivo, prefisso dis- già presente + suffisso -ment).", 5));

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "He showed great _____ in completing the marathon despite his injury.", "DETERMINE", "determination",
            "DETERMINE → determination (sostantivo, suffisso -ation con drop della 'e').", 6));

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "The _____ of the ancient ruins attracted thousands of tourists.", "DISCOVER", "discovery",
            "DISCOVER → discovery (sostantivo, suffisso -y con leggera alterazione della radice).", 7));

        wordExam7.getWordExercises().add(makeWord(wordExam7,
            "There was a general _____ that the reforms were long overdue.", "AGREE", "agreement",
            "AGREE → agreement (sostantivo, suffisso -ment).", 8));

        examRepository.save(wordExam7);


        // =========================================================================
        // ── EXAM 14: Word Transformation – Set 8 (Focus: Avverbi di Grado e Intensità)
        // =========================================================================
        Exam wordExam8 = new Exam();
        wordExam8.setTitle("Word Transformation – Set 8 (Degree Adverbs & Intensifiers)");
        wordExam8.setType(ExamType.WORD_TRANSFORMATION);
        wordExam8.setSource("esl-lounge.com");
        wordExam8.setCreatedAt(LocalDateTime.now());

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "She spoke so _____ that the audience could not follow her argument.", "RAPID", "rapidly",
            "RAPID → rapidly (avverbio di modo, suffisso -ly).", 1));

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "The two candidates' policies are _____ different from each other.", "FUNDAMENTAL", "fundamentally",
            "FUNDAMENTAL → fundamentally (avverbio di grado, suffisso -ly; parola lunga frequente al C1).", 2));

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "He was _____ opposed to any form of compromise.", "FIRM", "firmly",
            "FIRM → firmly (avverbio, suffisso -ly; 'firmly opposed' è collocazione C1).", 3));

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "The new vaccine proved _____ effective in clinical trials.", "REMARK", "remarkably",
            "REMARK → remarkably (avverbio intensificatore, suffisso -able + -ly).", 4));

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "The two reports reached _____ different conclusions.", "STARK", "starkly",
            "STARK → starkly (avverbio, suffisso -ly; 'starkly different' è collocazione avanzata).", 5));

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "She _____ denied any involvement in the scandal.", "CATEGORIC", "categorically",
            "CATEGORIC → categorically (avverbio, aggettivo -al + suffisso -ly).", 6));

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "The project was _____ more expensive than originally estimated.", "CONSIDER", "considerably",
            "CONSIDER → considerably (avverbio di grado: -able + -ly; indica 'notevolmente').", 7));

        wordExam8.getWordExercises().add(makeWord(wordExam8,
            "He is _____ regarded as one of the greatest novelists of the century.", "WIDE", "widely",
            "WIDE → widely (avverbio, suffisso -ly; 'widely regarded' è collocazione molto frequente).", 8));

        examRepository.save(wordExam8);


        // =========================================================================
        // ── EXAM 15: Word Transformation – Set 9 (Focus: Aggettivi da Sostantivi – Suffissi -ful/-less/-ous/-al)
        // =========================================================================
        Exam wordExam9 = new Exam();
        wordExam9.setTitle("Word Transformation – Set 9 (Adjectives: -ful/-less/-ous/-al)");
        wordExam9.setType(ExamType.WORD_TRANSFORMATION);
        wordExam9.setSource("esl-lounge.com");
        wordExam9.setCreatedAt(LocalDateTime.now());

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "The charity worker's actions were truly _____.", "SELFLESS", "selfless",
            "SELFLESS è già un aggettivo; riconoscere la forma corretta senza aggiungere suffissi errati.", 1));

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "The new campus facilities are _____ to all registered students.", "ACCESS", "accessible",
            "ACCESS → accessible (aggettivo, suffisso -ible).", 2));

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "His _____ attitude towards money led him into serious debt.", "CARE", "careless",
            "CARE → careless (aggettivo negativo per mancanza di cura, suffisso -less).", 3));

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "The _____ side effects of the medication were not made public.", "HARM", "harmful",
            "HARM → harmful (aggettivo, suffisso -ful).", 4));

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "The senator gave a _____ account of events at the press conference.", "CONTROVERSY", "controversial",
            "CONTROVERSY → controversial (aggettivo, suffisso -al con radice alterata).", 5));

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "The volcano became _____ again after years of dormancy.", "ACTIVE", "active",
            "ACTIVE → active; oppure VOLCANO → verificare contesto. Qui: VOLCANO non è la base — si usa ACTIVE direttamente.", 6));

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "It would be _____ to ignore the warning signs.", "FOOL", "foolish",
            "FOOL → foolish (aggettivo, suffisso -ish).", 7));

        wordExam9.getWordExercises().add(makeWord(wordExam9,
            "The documentary painted a _____ picture of life in the war zone.", "HORROR", "horrifying",
            "HORROR → horrifying (aggettivo participiale, verbo horrify + suffisso -ing).", 8));

        examRepository.save(wordExam9);


        // =========================================================================
        // ── EXAM 16: Word Transformation – Set 10 (Focus: Parole con Doppio Prefisso e Cambi Radice)
        // =========================================================================
        Exam wordExam10 = new Exam();
        wordExam10.setTitle("Word Transformation – Set 10 (Double Prefix & Root Changes)");
        wordExam10.setType(ExamType.WORD_TRANSFORMATION);
        wordExam10.setSource("esl-lounge.com");
        wordExam10.setCreatedAt(LocalDateTime.now());

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "The artist's latest work received overwhelmingly _____ reviews.", "FAVOUR", "unfavourable",
            "FAVOUR → unfavourable (aggettivo negativo, prefisso un- + suffisso -able; British spelling).", 1));

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "The new model is far more _____ than its predecessor.", "RELY", "reliable",
            "RELY → reliable (aggettivo, suffisso -able con cambio ortografico: y → i).", 2));

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "She made several _____ attempts before finally giving up.", "SUCCESS", "unsuccessful",
            "SUCCESS → unsuccessful (aggettivo negativo, prefisso un- + suffisso -ful).", 3));

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "The company's _____ has grown steadily over the past decade.", "REPUTE", "reputation",
            "REPUTE → reputation (sostantivo con cambio di radice, suffisso -ation).", 4));

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "His _____ of the contract's terms led to a lengthy legal dispute.", "INTERPRET", "misinterpretation",
            "INTERPRET → misinterpretation (prefisso mis- + suffisso -ation; doppia derivazione).", 5));

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "The politician's comments were widely seen as deeply _____.", "RESPECT", "disrespectful",
            "RESPECT → disrespectful (prefisso dis- + suffisso -ful; doppia derivazione).", 6));

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "The technology has the potential to _____ the entire industry.", "REVOLUTION", "revolutionise",
            "REVOLUTION → revolutionise (verbo, suffisso -ise; variante -ize accettata).", 7));

        wordExam10.getWordExercises().add(makeWord(wordExam10,
            "The team showed great _____ in the face of adversity.", "RESILIENT", "resilience",
            "RESILIENT → resilience (sostantivo astratto, cambio suffisso -ent → -ence).", 8));

        examRepository.save(wordExam10);


        // =========================================================================
        // ── EXAM 17: Sentence Transformation – Set 7 (Focus: Modali Perfetti e Deduzione)
        // =========================================================================
        Exam sentExam7 = new Exam();
        sentExam7.setTitle("Sentence Transformation – Set 7 (Perfect Modals & Deduction)");
        sentExam7.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam7.setSource("esl-lounge.com");
        sentExam7.setCreatedAt(LocalDateTime.now());

        sentExam7.getSentenceExercises().add(makeSentence(sentExam7,
            "I'm sure it was Tom who sent that anonymous email.", "MUST",
            "It", "must have been Tom who sent", "that anonymous email.",
            "Deduzione logica sul passato: must have + participio passato.", 1));

        sentExam7.getSentenceExercises().add(makeSentence(sentExam7,
            "It was wrong of you to leave without saying goodbye.", "SHOULD",
            "You", "should not have left without", "saying goodbye.",
            "Critica su azione passata: should not have + participio passato.", 2));

        sentExam7.getSentenceExercises().add(makeSentence(sentExam7,
            "I don't think she understood the gravity of the situation.", "CANNOT",
            "She", "cannot have understood the gravity", "of the situation.",
            "Deduzione negativa sul passato: cannot have + participio passato.", 3));

        sentExam7.getSentenceExercises().add(makeSentence(sentExam7,
            "Perhaps he took the wrong turn at the roundabout.", "COULD",
            "He", "could have taken the wrong", "turn at the roundabout.",
            "Possibilità passata: could have + participio passato.", 4));

        sentExam7.getSentenceExercises().add(makeSentence(sentExam7,
            "It wasn't necessary for her to wait, but she did.", "NEED",
            "She", "needn't have waited", ".",
            "'Needn't have + participio passato': azione passata inutile ma comunque compiuta.", 5));

        sentExam7.getSentenceExercises().add(makeSentence(sentExam7,
            "I'm certain they didn't receive the invoice in time.", "CANNOT",
            "They", "cannot have received the invoice", "in time.",
            "Certezza negativa nel passato: cannot have + participio passato.", 6));

        examRepository.save(sentExam7);


        // =========================================================================
        // ── EXAM 18: Sentence Transformation – Set 8 (Focus: Gerundi e Infiniti Avanzati)
        // =========================================================================
        Exam sentExam8 = new Exam();
        sentExam8.setTitle("Sentence Transformation – Set 8 (Gerunds & Advanced Infinitives)");
        sentExam8.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam8.setSource("esl-lounge.com");
        sentExam8.setCreatedAt(LocalDateTime.now());

        sentExam8.getSentenceExercises().add(makeSentence(sentExam8,
            "He regrets not attending the conference.", "WISHES",
            "He", "wishes he had attended the", "conference.",
            "Rimpianto passato: wish + past perfect (had + participio passato).", 1));

        sentExam8.getSentenceExercises().add(makeSentence(sentExam8,
            "It was pointless to argue with the committee.", "WORTH",
            "It was not", "worth arguing with the", "committee.",
            "'Worth + gerundio': struttura impersonale per esprimere utilità/inutilità.", 2));

        sentExam8.getSentenceExercises().add(makeSentence(sentExam8,
            "She is always the last person to leave the office.", "NEVER",
            "She", "never leaves the office before", "everyone else.",
            "Riformulazione di 'last to do': uso di 'never... before' con comparativo.", 3));

        sentExam8.getSentenceExercises().add(makeSentence(sentExam8,
            "He admitted that he had stolen the money from the safe.", "ADMITTED",
            "He", "admitted to having stolen the", "money from the safe.",
            "'Admit to + gerundio perfetto (having + participio)': forma corretta dopo questo verbo.", 4));

        sentExam8.getSentenceExercises().add(makeSentence(sentExam8,
            "They expect us to submit the final draft by next Monday.", "SUPPOSED",
            "We are", "supposed to submit the final", "draft by next Monday.",
            "'Be supposed to + infinito': obbligo/aspettativa esterna.", 5));

        sentExam8.getSentenceExercises().add(makeSentence(sentExam8,
            "There is no point in submitting the application after the deadline.", "USE",
            "It is no", "use submitting the application after", "the deadline.",
            "'It is no use + gerundio': struttura idiomatica per esprimere inutilità.", 6));

        examRepository.save(sentExam8);


        // =========================================================================
        // ── EXAM 19: Sentence Transformation – Set 9 (Focus: Comparativi e Superlativi Avanzati)
        // =========================================================================
        Exam sentExam9 = new Exam();
        sentExam9.setTitle("Sentence Transformation – Set 9 (Advanced Comparatives & Superlatives)");
        sentExam9.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam9.setSource("esl-lounge.com");
        sentExam9.setCreatedAt(LocalDateTime.now());

        sentExam9.getSentenceExercises().add(makeSentence(sentExam9,
            "I have never eaten such a delicious meal in my life.", "BEST",
            "It is the", "best meal I have ever", "eaten in my life.",
            "Superlativo assoluto con present perfect: 'the best... I have ever + participio'.", 1));

        sentExam9.getSentenceExercises().add(makeSentence(sentExam9,
            "As the weeks passed, the situation grew worse and worse.", "WORSE",
            "The situation", "kept getting worse as the", "weeks passed.",
            "'Keep + gerundio' esprime un'azione continua e progressiva.", 2));

        sentExam9.getSentenceExercises().add(makeSentence(sentExam9,
            "The more you practise, the better your results will be.", "DIRECT",
            "There is a", "direct link between how much", "you practise and how good your results are.",
            "Riformulazione della struttura 'the more... the more' con nesso causale esplicito.", 3));

        sentExam9.getSentenceExercises().add(makeSentence(sentExam9,
            "Nothing could be more absurd than his explanation.", "MOST",
            "His explanation was the", "most absurd thing imaginable", ".",
            "Superlativo assoluto rafforzato: 'the most + adjective + thing imaginable'.", 4));

        sentExam9.getSentenceExercises().add(makeSentence(sentExam9,
            "She is not as experienced as her colleague.", "LESS",
            "She is", "less experienced than her", "colleague.",
            "Comparativo di minoranza: less + aggettivo + than.", 5));

        sentExam9.getSentenceExercises().add(makeSentence(sentExam9,
            "No other city in the country is as polluted as this one.", "MOST",
            "This is the", "most polluted city in the", "country.",
            "Conversione da comparativo assoluto a superlativo relativo.", 6));

        examRepository.save(sentExam9);


        // =========================================================================
        // ── EXAM 20: Sentence Transformation – Set 10 (Focus: Connettivi di Contrasto e Concessione)
        // =========================================================================
        Exam sentExam10 = new Exam();
        sentExam10.setTitle("Sentence Transformation – Set 10 (Contrast & Concession Linkers)");
        sentExam10.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam10.setSource("esl-lounge.com");
        sentExam10.setCreatedAt(LocalDateTime.now());

        sentExam10.getSentenceExercises().add(makeSentence(sentExam10,
            "Although the film received poor reviews, it was a box-office success.", "DESPITE",
            "Despite", "receiving poor reviews the film", "was a box-office success.",
            "'Despite + gerundio': preposizione di concessione senza soggetto nella subordinata.", 1));

        sentExam10.getSentenceExercises().add(makeSentence(sentExam10,
            "He is very talented, but he tends to be rather arrogant.", "WHILE",
            "While", "he is very talented he", "tends to be rather arrogant.",
            "'While' introduce una concessione con contrasto directo tra due proposizioni.", 2));

        sentExam10.getSentenceExercises().add(makeSentence(sentExam10,
            "The company continued to expand in spite of the economic downturn.", "THOUGH",
            "Even though there", "was an economic downturn the", "company continued to expand.",
            "'Even though + soggetto + verbo': equivalente di 'in spite of the fact that'.", 3));

        sentExam10.getSentenceExercises().add(makeSentence(sentExam10,
            "She passed the exam. However, she did not celebrate.", "YET",
            "She passed the exam,", "yet she did not celebrate", ".",
            "'Yet' come congiunzione avversativa formale, equivalente a 'but' con valore di sorpresa.", 4));

        sentExam10.getSentenceExercises().add(makeSentence(sentExam10,
            "Regardless of his qualifications, he was not offered the position.", "MATTER",
            "No matter", "what his qualifications were he", "was not offered the position.",
            "'No matter what/how' introduce una concessione universale, equivalente a 'regardless of'.", 5));

        sentExam10.getSentenceExercises().add(makeSentence(sentExam10,
            "The weather was terrible, but they still managed to complete the hike.", "SPITE",
            "In spite of", "the terrible weather they still", "managed to complete the hike.",
            "'In spite of + noun phrase': preposizione concessiva formale.", 6));

        examRepository.save(sentExam10);

        // =========================================================================
        // ── EXAM 5 [BIS]: Word Transformation – Set 3 (Focus: Advanced C1 Vocabulary & Collocations)
        // =========================================================================
        Exam wordExam991 = new Exam();
        wordExam991.setTitle("Word Transformation – Set 3 (Advanced C1 Vocabulary)");
        wordExam991.setType(ExamType.WORD_TRANSFORMATION);
        wordExam991.setSource("esl-lounge");
        wordExam991.setCreatedAt(LocalDateTime.now());

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "His explanation was so _____ that nobody understood what he meant.", "CONFUSE", "confusing",
            "CONFUSE → confusing (adjective describing the effect produced).", 1));

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "The manager expressed her _____ with the team's poor performance.", "SATISFY", "dissatisfaction",
            "SATISFY → dissatisfaction (negative abstract noun with prefix dis- + suffix -action).", 2));

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "It is highly _____ that the company will expand overseas next year.", "PROBABLE", "improbable",
            "PROBABLE → improbable (negative adjective with prefix im-).", 3));

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "The witness gave a remarkably _____ description of the suspect.", "ACCURACY", "accurate",
            "ACCURACY → accurate (adjective form).", 4));

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "The new regulations will come into _____ at the beginning of next month.", "EFFECTIVE", "effect",
            "EFFECTIVE → effect (fixed expression: come into effect).", 5));

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "Her comments during the meeting were completely _____ and offended several colleagues.", "APPROPRIATE", "inappropriate",
            "APPROPRIATE → inappropriate (negative adjective with prefix in-).", 6));

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "The documentary provided a fascinating _____ into life in the Arctic.", "SEE", "insight",
            "SEE → insight (irregular noun meaning deep understanding).", 7));

        wordExam991.getWordExercises().add(makeWord(wordExam991,
            "The athlete's sudden _____ from professional sport shocked his fans.", "WITHDRAW", "withdrawal",
            "WITHDRAW → withdrawal (noun form with suffix -al).", 8));

        examRepository.save(wordExam991);


        // =========================================================================
        // ── EXAM 6 [BIS]: Sentence Transformation – Set 3 (Focus: Advanced C1 Structures & Expressions)
        // =========================================================================
        Exam sentExam991 = new Exam();
        sentExam991.setTitle("Sentence Transformation – Set 3 (Advanced C1 Structures)");
        sentExam991.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam991.setSource("esl-lounge");
        sentExam991.setCreatedAt(LocalDateTime.now());

        sentExam991.getSentenceExercises().add(makeSentence(sentExam991,
            "I regret not telling her the truth earlier.", "WISH",
            "I", "wish I had told her", "the truth earlier.",
            "Rimpianto nel passato: wish + past perfect.", 1));

        sentExam991.getSentenceExercises().add(makeSentence(sentExam991,
            "It wasn't necessary for them to bring any food.", "NEED",
            "They", "didn't need to bring", "any food.",
            "Assenza di necessità: didn't need to + verbo base.", 2));

        sentExam991.getSentenceExercises().add(makeSentence(sentExam991,
            "You can borrow my laptop whenever you need it.", "DISPOSAL",
            "I can put my laptop", "at your disposal whenever you", "need it.",
            "Espressione formale: put something at someone's disposal.", 3));

        sentExam991.getSentenceExercises().add(makeSentence(sentExam991,
            "The last time I went to Paris was five years ago.", "BEEN",
            "I", "haven't been to Paris for", "five years.",
            "Present Perfect con 'for' per indicare durata temporale.", 4));

        sentExam991.getSentenceExercises().add(makeSentence(sentExam991,
            "She started working here immediately after graduating.", "SOONER",
            "No sooner", "had she graduated than she", "started working here.",
            "Inversione avanzata con 'No sooner... than'.", 5));

        sentExam991.getSentenceExercises().add(makeSentence(sentExam991,
            "People believe that the painting was stolen during the war.", "THOUGHT",
            "The painting is", "thought to have been stolen", "during the war.",
            "Passive reporting structure: is thought to have been + past participle.", 6));

        examRepository.save(sentExam991);

        // =========================================================================
        // ── EXAM 21: Word Transformation – Set 11 (Focus: Nominalizzazioni da Aggettivi)
        // =========================================================================
        Exam wordExam11 = new Exam();
        wordExam11.setTitle("Word Transformation – Set 11 (Nominalisations from Adjectives)");
        wordExam11.setType(ExamType.WORD_TRANSFORMATION);
        wordExam11.setSource("esl-lounge.com");
        wordExam11.setCreatedAt(LocalDateTime.now());

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "The _____ of the evidence presented in court was questionable.", "RELEVANT", "relevance",
            "RELEVANT → relevance (sostantivo astratto, suffisso -ance con cambio -ent → -ance).", 1));

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "The _____ of the new regulations was widely praised by industry leaders.", "CLEAR", "clarity",
            "CLEAR → clarity (sostantivo astratto, suffisso -ity con radice alterata).", 2));

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "There is a real _____ of skilled workers in the construction sector.", "SHORT", "shortage",
            "SHORT → shortage (sostantivo, suffisso -age; indica mancanza/carenza).", 3));

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "The council acknowledged the _____ of the local transport network.", "ADEQUATE", "inadequacy",
            "ADEQUATE → inadequacy (sostantivo negativo: prefisso in- + suffisso -cy con radice -acy).", 4));

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "His _____ in the face of criticism was admirable.", "HUMBLE", "humility",
            "HUMBLE → humility (sostantivo, suffisso -ity con drop della 'e' e cambio radice).", 5));

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "The _____ of the defendant's alibi raised serious doubts.", "CREDIBLE", "incredibility",
            "CREDIBLE → incredibility (sostantivo negativo: prefisso in- + suffisso -ity).", 6));

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "She showed great _____ when dealing with the bereaved family.", "SENSITIVE", "sensitivity",
            "SENSITIVE → sensitivity (sostantivo, suffisso -ity con drop della 'e').", 7));

        wordExam11.getWordExercises().add(makeWord(wordExam11,
            "The _____ of the new system soon became apparent to all staff.", "EFFICIENT", "efficiency",
            "EFFICIENT → efficiency (sostantivo, cambio suffisso -ent → -ency).", 8));

        examRepository.save(wordExam11);


        // =========================================================================
        // ── EXAM 22: Word Transformation – Set 12 (Focus: Parole Composte e Collocazioni C1)
        // =========================================================================
        Exam wordExam12 = new Exam();
        wordExam12.setTitle("Word Transformation – Set 12 (Compound Words & C1 Collocations)");
        wordExam12.setType(ExamType.WORD_TRANSFORMATION);
        wordExam12.setSource("esl-lounge.com");
        wordExam12.setCreatedAt(LocalDateTime.now());

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The prime minister gave a _____ speech that moved the entire nation.", "HEART", "heartfelt",
            "HEART → heartfelt (aggettivo composto: heart + felt; indica sincerità profonda).", 1));

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The company launched a _____ campaign to attract younger consumers.", "BREAK", "groundbreaking",
            "BREAK → groundbreaking (aggettivo composto che indica qualcosa di rivoluzionario).", 2));

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The rescue operation was _____ coordinated by three separate agencies.", "JOINT", "jointly",
            "JOINT → jointly (avverbio, suffisso -ly; 'jointly coordinated' è collocazione formale).", 3));

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The new chairman's vision for the company proved highly _____.", "SIGHT", "farsighted",
            "SIGHT → farsighted (aggettivo composto: far + sighted; indica lungimiranza).", 4));

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The initiative received _____ support from both political parties.", "WHOLE", "wholehearted",
            "WHOLE → wholehearted (aggettivo composto: whole + hearted; indica pieno sostegno).", 5));

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The transition to renewable energy requires a _____ approach.", "MANY", "many-sided",
            "MANY → many-sided (aggettivo composto con trattino; indica un approccio multiforme).", 6));

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The professor's lecture was _____ and easy to follow despite the topic's complexity.", "LOGIC", "logical",
            "LOGIC → logical (aggettivo, suffisso -al).", 7));

        wordExam12.getWordExercises().add(makeWord(wordExam12,
            "The new policy was introduced in a _____ manner, without prior consultation.", "HIGH", "high-handed",
            "HIGH → high-handed (aggettivo composto con trattino; indica arroganza/autoritarismo).", 8));

        examRepository.save(wordExam12);


        // =========================================================================
        // ── EXAM 23: Word Transformation – Set 13 (Focus: Verbi con Prefissi over-/under-/out-)
        // =========================================================================
        Exam wordExam13 = new Exam();
        wordExam13.setTitle("Word Transformation – Set 13 (Verbs: over-/under-/out- Prefixes)");
        wordExam13.setType(ExamType.WORD_TRANSFORMATION);
        wordExam13.setSource("esl-lounge.com");
        wordExam13.setCreatedAt(LocalDateTime.now());

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "The film completely _____ all expectations at the box office.", "PERFORM", "outperformed",
            "PERFORM → outperformed (verbo con prefisso out- che indica 'fare meglio di', al past simple).", 1));

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "The restaurant was heavily criticised for _____ its customers.", "CHARGE", "overcharging",
            "CHARGE → overcharging (gerundio con prefisso over- che indica 'addebitare troppo').", 2));

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "Many junior employees feel _____ and underpaid.", "VALUE", "undervalued",
            "VALUE → undervalued (participio passato con prefisso under- che indica 'sottovalutato').", 3));

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "The team consistently _____ their rivals throughout the season.", "RUN", "outran",
            "RUN → outran (verbo irregolare con prefisso out-; past simple di 'outrun').", 4));

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "The report concluded that the region was severely _____.", "DEVELOP", "underdeveloped",
            "DEVELOP → underdeveloped (aggettivo con prefisso under- che indica sviluppo insufficiente).", 5));

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "She felt she had been _____ for the position due to her lack of connections.", "LOOK", "overlooked",
            "LOOK → overlooked (verbo con prefisso over- che indica 'essere ignorato/trascurato').", 6));

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "The young athlete _____ several older and more experienced competitors.", "SMART", "outsmarted",
            "SMART → outsmarted (verbo con prefisso out- che indica 'essere più astuto di').", 7));

        wordExam13.getWordExercises().add(makeWord(wordExam13,
            "He was known for _____ his personal affairs with those of the company.", "MIX", "overmixing",
            "MIX → overmixing (gerundio con prefisso over-, qui nel senso di 'mischiare eccessivamente').", 8));

        examRepository.save(wordExam13);


        // =========================================================================
        // ── EXAM 24: Word Transformation – Set 14 (Focus: Suffissi -ment/-ance/-ence/-ship)
        // =========================================================================
        Exam wordExam14 = new Exam();
        wordExam14.setTitle("Word Transformation – Set 14 (Suffixes: -ment/-ance/-ence/-ship)");
        wordExam14.setType(ExamType.WORD_TRANSFORMATION);
        wordExam14.setSource("esl-lounge.com");
        wordExam14.setCreatedAt(LocalDateTime.now());

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "The _____ between the two leaders was evident from the start.", "FRIEND", "friendship",
            "FRIEND → friendship (sostantivo, suffisso -ship che indica relazione/stato).", 1));

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "The CEO expressed his _____ at the lack of progress.", "FRUSTRATE", "frustration",
            "FRUSTRATE → frustration (sostantivo, suffisso -tion con drop della 'e').", 2));

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "The _____ of the two theories has long been debated.", "COMPATIBLE", "incompatibility",
            "COMPATIBLE → incompatibility (sostantivo negativo: prefisso in- + suffisso -ity).", 3));

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "His _____ of the local culture helped him integrate quickly.", "KNOW", "knowledge",
            "KNOW → knowledge (sostantivo irregolare, suffisso -ledge).", 4));

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "The _____ of the two companies was announced at a press conference.", "PARTNER", "partnership",
            "PARTNER → partnership (sostantivo, suffisso -ship che indica accordo formale).", 5));

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "The scheme was criticised for its _____ on private funding.", "DEPEND", "dependence",
            "DEPEND → dependence (sostantivo, suffisso -ence).", 6));

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "There has been a marked _____ in the quality of public services.", "DETERIORATE", "deterioration",
            "DETERIORATE → deterioration (sostantivo, suffisso -ion con drop della 'e').", 7));

        wordExam14.getWordExercises().add(makeWord(wordExam14,
            "The _____ shown by the volunteers was deeply moving.", "COMMIT", "commitment",
            "COMMIT → commitment (sostantivo, suffisso -ment con raddoppio della consonante finale).", 8));

        examRepository.save(wordExam14);


        // =========================================================================
        // ── EXAM 25: Sentence Transformation – Set 11 (Focus: Passivo con Verbi di Percezione)
        // =========================================================================
        Exam sentExam11 = new Exam();
        sentExam11.setTitle("Sentence Transformation – Set 11 (Passive with Perception Verbs)");
        sentExam11.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam11.setSource("esl-lounge.com");
        sentExam11.setCreatedAt(LocalDateTime.now());

        sentExam11.getSentenceExercises().add(makeSentence(sentExam11,
            "People consider her to be the finest soprano of her generation.", "CONSIDERED",
            "She", "is considered to be the finest soprano", "of her generation.",
            "Passivo impersonale: is/are considered + to be + complemento.", 1));

        sentExam11.getSentenceExercises().add(makeSentence(sentExam11,
            "Experts believe that the ruins date back to the Bronze Age.", "BELIEVED",
            "The ruins", "are believed to date back to", "the Bronze Age.",
            "Passivo impersonale con infinito presente: are believed + to + infinito.", 2));

        sentExam11.getSentenceExercises().add(makeSentence(sentExam11,
            "It is reported that the suspect fled the country last night.", "REPORTED",
            "The suspect", "is reported to have fled the country", "last night.",
            "Passivo impersonale con infinito perfetto: is reported + to have + participio.", 3));

        sentExam11.getSentenceExercises().add(makeSentence(sentExam11,
            "They say that the new treatment has shown remarkable results.", "SAID",
            "The new treatment", "is said to have shown remarkable", "results.",
            "Passivo impersonale al presente: is said + to have + participio passato.", 4));

        sentExam11.getSentenceExercises().add(makeSentence(sentExam11,
            "People know that he made his fortune through property investment.", "KNOWN",
            "He", "is known to have made his fortune", "through property investment.",
            "Passivo di 'know': is known + to have + participio passato.", 5));

        sentExam11.getSentenceExercises().add(makeSentence(sentExam11,
            "Witnesses claim that the vehicle was travelling at excessive speed.", "CLAIMED",
            "The vehicle", "is claimed to have been travelling at", "excessive speed.",
            "Passivo con infinito progressivo perfetto: is claimed + to have been + gerundio.", 6));

        examRepository.save(sentExam11);


        // =========================================================================
        // ── EXAM 26: Sentence Transformation – Set 12 (Focus: Cleft Sentences e Enfasi)
        // =========================================================================
        Exam sentExam12 = new Exam();
        sentExam12.setTitle("Sentence Transformation – Set 12 (Cleft Sentences & Emphasis)");
        sentExam12.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam12.setSource("esl-lounge.com");
        sentExam12.setCreatedAt(LocalDateTime.now());

        sentExam12.getSentenceExercises().add(makeSentence(sentExam12,
            "The lack of communication caused all the problems.", "WHAT",
            "What caused all the problems", "was the lack of communication", ".",
            "Cleft sentence con 'What': What + soggetto + verbo + was + focus.", 1));

        sentExam12.getSentenceExercises().add(makeSentence(sentExam12,
            "She only started feeling better after she changed her diet.", "IT",
            "It was only after she changed her diet", "that she started feeling better", ".",
            "Cleft sentence con 'It was... that': struttura enfatica per isolare l'elemento chiave.", 2));

        sentExam12.getSentenceExercises().add(makeSentence(sentExam12,
            "Nobody expected him to win the championship.", "LAST",
            "He was", "the last person anyone expected to", "win the championship.",
            "'The last person... to do': struttura enfatica per esprimere totale improbabilità.", 3));

        sentExam12.getSentenceExercises().add(makeSentence(sentExam12,
            "His dedication impressed me most.", "THING",
            "The thing that impressed me most", "was his dedication", ".",
            "Cleft sentence con 'The thing that': struttura enfatica con soggetto nominalizzato.", 4));

        sentExam12.getSentenceExercises().add(makeSentence(sentExam12,
            "I really want you to listen to me carefully.", "ALL",
            "All I want is", "for you to listen to me", "carefully.",
            "'All I want is for + soggetto + infinito': struttura enfatica con 'all' come soggetto.", 5));

        sentExam12.getSentenceExercises().add(makeSentence(sentExam12,
            "The director alone had the authority to approve the budget.", "ONLY",
            "It was only the director", "who had the authority to approve", "the budget.",
            "Cleft sentence con 'It was only... who': enfasi sull'unicità del soggetto.", 6));

        examRepository.save(sentExam12);


        // =========================================================================
        // ── EXAM 27: Sentence Transformation – Set 13 (Focus: Preposizioni Complesse e Formali)
        // =========================================================================
        Exam sentExam13 = new Exam();
        sentExam13.setTitle("Sentence Transformation – Set 13 (Complex & Formal Prepositions)");
        sentExam13.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam13.setSource("esl-lounge.com");
        sentExam13.setCreatedAt(LocalDateTime.now());

        sentExam13.getSentenceExercises().add(makeSentence(sentExam13,
            "He agreed to the proposal because he wanted to avoid a conflict.", "ORDER",
            "He agreed to the proposal", "in order to avoid", "a conflict.",
            "'In order to + infinito': preposizione complessa di scopo, più formale di 'to' semplice.", 1));

        sentExam13.getSentenceExercises().add(makeSentence(sentExam13,
            "The festival was cancelled because of the severe weather conditions.", "OWING",
            "The festival was cancelled", "owing to the severe weather", "conditions.",
            "'Owing to + noun phrase': preposizione formale di causa, equivalente a 'because of'.", 2));

        sentExam13.getSentenceExercises().add(makeSentence(sentExam13,
            "She completed the project successfully with the help of her team.", "AID",
            "She completed the project successfully", "with the aid of her", "team.",
            "'With the aid of': espressione preposizionale formale equivalente a 'with the help of'.", 3));

        sentExam13.getSentenceExercises().add(makeSentence(sentExam13,
            "The new policy applies to all employees without any exceptions.", "REGARDLESS",
            "The new policy applies to all employees", "regardless of any", "exceptions.",
            "'Regardless of': preposizione formale che indica assenza di condizioni.", 4));

        sentExam13.getSentenceExercises().add(makeSentence(sentExam13,
            "He was promoted as a reward for his outstanding performance.", "VIRTUE",
            "He was promoted", "by virtue of his outstanding", "performance.",
            "'By virtue of': preposizione formale che indica causa meritoria.", 5));

        sentExam13.getSentenceExercises().add(makeSentence(sentExam13,
            "They decided to postpone the launch until market conditions improve.", "PENDING",
            "They decided to postpone the launch", "pending an improvement in market", "conditions.",
            "'Pending + noun': preposizione formale che indica attesa di una condizione futura.", 6));

        examRepository.save(sentExam13);


        // =========================================================================
        // ── EXAM 28: Sentence Transformation – Set 14 (Focus: Condizionali Invertiti e Formali)
        // =========================================================================
        Exam sentExam14 = new Exam();
        sentExam14.setTitle("Sentence Transformation – Set 14 (Inverted & Formal Conditionals)");
        sentExam14.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam14.setSource("esl-lounge.com");
        sentExam14.setCreatedAt(LocalDateTime.now());

        sentExam14.getSentenceExercises().add(makeSentence(sentExam14,
            "If you should need any further assistance, please contact us.", "SHOULD",
            "Should", "you need any further assistance please", "contact us.",
            "Condizionale formale invertito con 'Should': omissione di 'if' + inversione soggetto/ausiliare.", 1));

        sentExam14.getSentenceExercises().add(makeSentence(sentExam14,
            "If I had known about the meeting, I would have attended.", "HAD",
            "Had", "I known about the meeting I", "would have attended.",
            "Condizionale III invertito: omissione di 'if' + had + soggetto + participio passato.", 2));

        sentExam14.getSentenceExercises().add(makeSentence(sentExam14,
            "If it were not for the financial support, the project would fail.", "WERE",
            "Were", "it not for the financial support", "the project would fail.",
            "Condizionale II invertito con 'Were': omissione di 'if' + were + soggetto.", 3));

        sentExam14.getSentenceExercises().add(makeSentence(sentExam14,
            "If the deadline is not met, the contract will be cancelled.", "UNLESS",
            "Unless", "the deadline is met the", "contract will be cancelled.",
            "'Unless' sostituisce 'if not': la condizione diventa affermativa nella subordinata.", 4));

        sentExam14.getSentenceExercises().add(makeSentence(sentExam14,
            "If you hadn't reminded me, I would have completely forgotten.", "BUT",
            "But", "for your reminder I would have", "completely forgotten.",
            "'But for + noun': struttura formale equivalente a 'if it hadn't been for'.", 5));

        sentExam14.getSentenceExercises().add(makeSentence(sentExam14,
            "Provided that all parties agree, the deal will be finalised tomorrow.", "LONG",
            "As", "long as all parties agree the", "deal will be finalised tomorrow.",
            "'As long as': connettivo condizionale equivalente a 'provided that'.", 6));

        examRepository.save(sentExam14);


        // =========================================================================
        // ── EXAM 29: Sentence Transformation – Set 15 (Focus: Discorso Indiretto Avanzato)
        // =========================================================================
        Exam sentExam15 = new Exam();
        sentExam15.setTitle("Sentence Transformation – Set 15 (Advanced Reported Speech)");
        sentExam15.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam15.setSource("esl-lounge.com");
        sentExam15.setCreatedAt(LocalDateTime.now());

        sentExam15.getSentenceExercises().add(makeSentence(sentExam15,
            "\"You really should see a doctor,\" she told him.", "URGED",
            "She", "urged him to see a", "doctor.",
            "'Urge somebody to do something': verbo di reporting che esprime forte raccomandazione.", 1));

        sentExam15.getSentenceExercises().add(makeSentence(sentExam15,
            "\"I will look into the matter immediately,\" the director promised.", "UNDERTOOK",
            "The director", "undertook to look into the", "matter immediately.",
            "'Undertake to do something': verbo formale di reporting che esprime impegno solenne.", 2));

        sentExam15.getSentenceExercises().add(makeSentence(sentExam15,
            "\"Why don't you apply for the scholarship?\" her tutor suggested.", "ENCOURAGED",
            "Her tutor", "encouraged her to apply for", "the scholarship.",
            "'Encourage somebody to do something': verbo di reporting per suggerimento positivo.", 3));

        sentExam15.getSentenceExercises().add(makeSentence(sentExam15,
            "\"It was me who leaked the information,\" he confessed.", "CONFESSED",
            "He", "confessed to having leaked the", "information.",
            "'Confess to + gerundio perfetto': verbo di reporting + to + having + participio.", 4));

        sentExam15.getSentenceExercises().add(makeSentence(sentExam15,
            "\"I'm sorry I missed the deadline,\" she said.", "APOLOGISED",
            "She", "apologised for having missed the", "deadline.",
            "'Apologise for + gerundio perfetto': struttura di reporting per scuse su azione passata.", 5));

        sentExam15.getSentenceExercises().add(makeSentence(sentExam15,
            "\"Don't touch any of the equipment,\" the technician warned us.", "WARNED",
            "The technician", "warned us not to touch", "any of the equipment.",
            "'Warn somebody not to do something': infinito negativo nel discorso indiretto.", 6));

        examRepository.save(sentExam15);


        // =========================================================================
        // ── EXAM 30: Sentence Transformation – Set 16 (Focus: Strutture con Sostantivi Verbali)
        // =========================================================================
        Exam sentExam16 = new Exam();
        sentExam16.setTitle("Sentence Transformation – Set 16 (Nominalisation & Formal Register)");
        sentExam16.setType(ExamType.SENTENCE_TRANSFORMATION);
        sentExam16.setSource("esl-lounge.com");
        sentExam16.setCreatedAt(LocalDateTime.now());

        sentExam16.getSentenceExercises().add(makeSentence(sentExam16,
            "The government decided to increase taxes on luxury goods.", "DECISION",
            "The government", "made a decision to increase", "taxes on luxury goods.",
            "Nominalizzazione del verbo 'decide': 'make a decision to + infinito'.", 1));

        sentExam16.getSentenceExercises().add(makeSentence(sentExam16,
            "They agreed to extend the contract for another two years.", "REACHED",
            "They", "reached an agreement to extend", "the contract for another two years.",
            "Nominalizzazione di 'agree': 'reach an agreement to + infinito'.", 2));

        sentExam16.getSentenceExercises().add(makeSentence(sentExam16,
            "The board will discuss the merger at next week's meeting.", "DISCUSSION",
            "The merger will", "come up for discussion at", "next week's board meeting.",
            "'Come up for discussion': struttura nominale formale equivalente a 'be discussed'.", 3));

        sentExam16.getSentenceExercises().add(makeSentence(sentExam16,
            "Researchers have suggested that sleep deprivation affects memory.", "SUGGESTION",
            "There has", "been a suggestion that sleep", "deprivation affects memory.",
            "Nominalizzazione con struttura esistenziale: 'There has been a suggestion that'.", 4));

        sentExam16.getSentenceExercises().add(makeSentence(sentExam16,
            "She assumed that the report had already been submitted.", "ASSUMPTION",
            "She was", "under the assumption that the", "report had already been submitted.",
            "'Be under the assumption that': struttura nominale formale equivalente a 'assume that'.", 5));

        sentExam16.getSentenceExercises().add(makeSentence(sentExam16,
            "He failed to disclose his financial interests before the vote.", "FAILURE",
            "His", "failure to disclose his financial", "interests before the vote was criticised.",
            "Nominalizzazione con 'failure to + infinito': struttura formale tipica del registro scritto C1.", 6));

        examRepository.save(sentExam16);
    }

    // Metodo helper WordTransformation invariato
    private WordTransformation makeWord(Exam exam, String sentence,
                                        String baseWord, String solution,
                                        String explanation, int orderIndex) {
        WordTransformation w = new WordTransformation();
        w.setExam(exam);
        w.setSentence(sentence);
        w.setBaseWord(baseWord);
        w.setSolution(solution);
        w.setExplanation(explanation);
        w.setOrderIndex(orderIndex);
        return w;
    }

    // Metodo helper SentenceTransformation con i 3 segmenti per il layout inline
    private SentenceTransformation makeSentence(Exam exam, String originalSentence,
                                                 String keyWord, String sentenceStart, 
                                                 String solution, String sentenceEnd,
                                                 String explanation, int orderIndex) {
        SentenceTransformation s = new SentenceTransformation();
        s.setExam(exam);
        s.setOriginalSentence(originalSentence);
        s.setKeyWord(keyWord);
        s.setSentenceStart(sentenceStart);
        s.setSolution(solution); 
        s.setSentenceEnd(sentenceEnd);
        s.setExplanation(explanation);
        s.setOrderIndex(orderIndex);
        return s;
    }
}