package com.hyun.moondab.domain.question;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Integer questionMonth;

    private Integer questionDay;

    public static Question create(int questionMonth, int questionDay, String content) {
        validateDate(questionMonth, questionDay);
        return new Question(questionMonth, questionDay, content);
    }

    private static void validateDate(int questionMonth, int questionDay) {
        if (!(1 <= questionMonth && questionMonth <= 12)) {
            throw new IllegalStateException("월은 1부터 12까지 가능합니다.");
        }
        if (!(1 <= questionDay && questionDay <= 31)) {
            throw new IllegalStateException("일은 1부터 31까지 가능합니다.");
        }
    }

    @Builder
    private Question(Integer questionMonth, Integer questionDay, String content) {
        this.questionMonth = questionMonth;
        this.questionDay = questionDay;
        this.content = content;
    }

}
