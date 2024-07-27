package com.hyun.moondab.controller.question.dto;

import com.hyun.moondab.domain.question.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionRs {

    private Long id;
    private String content;

    public static QuestionRs of(Question question) {
        return new QuestionRs(question.getId(), question.getContent());
    }
}
