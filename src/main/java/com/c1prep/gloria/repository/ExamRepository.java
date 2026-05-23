package com.c1prep.gloria.repository;

import com.c1prep.gloria.model.Exam;
import com.c1prep.gloria.model.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    
    List<Exam> findByType(ExamType type);

    @Query(value = "SELECT * FROM exams e " +
                "WHERE e.type = :#{#type.name()} " +
                "AND e.id NOT IN (SELECT ea.exam_id FROM exam_attempts ea) " +
                "ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Exam> findRandomUnattemptedByType(@Param("type") ExamType type);

    @Query(value = "SELECT * FROM exams WHERE type = :#{#type.name()} ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Exam> findRandomByType(@Param("type") ExamType type);

    
}