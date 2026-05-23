package com.c1prep.gloria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.c1prep.gloria.model.ExamAttempt;

@Repository
public interface ExamAttemptRepository extends JpaRepository<ExamAttempt, Long> {
    
    List<ExamAttempt> findAllByOrderByCompletedAtDesc();
}