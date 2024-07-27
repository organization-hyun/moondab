package com.hyun.moondab.domain.question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class QuestionTest {

    @DisplayName("날짜 정보를 통해 문항 생성을 할 수 있다.")
    @Test
    void create() {
        // given
        int month = 1;
        int day = 1;
        String content = "올해 꼭 이루고 싶은 목표가 있나요?";

        // when
        Question question = Question.create(month, day, content);

        //then
        assertThat(question)
                .extracting("questionMonth", "questionDay", "content")
                .containsExactly(month, day, content);
    }

}