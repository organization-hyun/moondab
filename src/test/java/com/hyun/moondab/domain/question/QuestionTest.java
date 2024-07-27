package com.hyun.moondab.domain.question;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class QuestionTest {

    @DisplayName("날짜 정보를 통해 문항 생성을 할 수 있다.")
    @Test
    void create() {
        // given
        String content = "올해 꼭 이루고 싶은 목표가 있나요?";
        int month1 = 1;
        int day1 = 1;
        int month12 = 12;
        int day31 = 31;

        // when
        Question question1 = Question.create(month1, day1, content);
        Question question2 = Question.create(month12, day31, content);

        //then
        assertThat(List.of(question1, question2))
                .extracting("questionMonth", "questionDay", "content")
                .containsExactly(
                        tuple(month1, day1, content),
                        tuple(month12, day31, content)
                );
    }

    @DisplayName("문항 생성 month 예외 케이스")
    @Test
    void create_month_exception() {
        //given
        String content = "올해 꼭 이루고 싶은 목표가 있나요?";
        int day = 1;
        int month0 = 0;
        int month13 = 13;

        //when & then
        assertThatThrownBy(() -> Question.create(month0, day, content))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("월은 1부터 12까지 가능합니다.");
        assertThatThrownBy(() -> Question.create(month13, day, content))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("월은 1부터 12까지 가능합니다.");
    }

}