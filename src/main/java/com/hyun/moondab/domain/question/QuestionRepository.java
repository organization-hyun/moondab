package com.hyun.moondab.domain.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByQuestionMonthAndQuestionDay(Integer month, Integer day);
}
