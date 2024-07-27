package com.hyun.moondab.controller.question.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class QuestionRq {

    private Integer month;
    private Integer day;

    @Builder
    private QuestionRq(Integer month, Integer day) {
        this.month = month;
        this.day = day;
    }

}