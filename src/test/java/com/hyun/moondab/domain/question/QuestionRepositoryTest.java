package com.hyun.moondab.domain.question;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @DisplayName("날짜에 해당하는 질문을 조회한다.")
    @Test
    void findByMonthAndDay() {
        //given
        Integer month = 1;
        Integer day = 1;
        String content = "올해 꼭 이루고 싶은 목표가 있나요?";
        questionRepository.save(Question.create(month, day, content));

        //when
        Question question = questionRepository.findByQuestionMonthAndQuestionDay(month, day);

        assertThat(question)
                .extracting("questionMonth", "questionDay", "content")
                .containsExactly(month, day, content);
    }

}