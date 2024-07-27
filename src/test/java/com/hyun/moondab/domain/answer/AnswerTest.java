package com.hyun.moondab.domain.answer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @DisplayName("답변의 조회수를 증가시킨다.")
    @Test
    void incrementViews() {
        //given
        Answer answer = Answer.builder().build();

        //when
        answer.incrementViews();
        answer.incrementViews();
        answer.incrementViews();

        //then
        Assertions.assertThat(answer)
                .extracting("views")
                .isEqualTo(3);
    }

}