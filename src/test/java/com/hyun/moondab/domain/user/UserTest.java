package com.hyun.moondab.domain.user;

import com.hyun.moondab.domain.answer.Answer;
import com.hyun.moondab.domain.question.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("문항에 대한 답변을 작성한다.")
    @Test
    void writeAnswer() {
        //given
        User user = new User();
        Question question = Question.builder()
                .questionMonth(1)
                .questionDay(1)
                .content("올해 꼭 이루고 싶은 목표가 있나요?")
                .build();
        String content = "멋진 개발자 되기";
        Boolean isPublic = true;

        //when
        Answer answer = user.writeAnswer(question, content, isPublic);

        //then
        assertThat(answer)
                .extracting("user", "question", "content", "views", "isPublic")
                .containsExactly(user, question, content, 0, isPublic);
    }

}