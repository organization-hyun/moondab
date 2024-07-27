package com.hyun.moondab.application.question;

import com.hyun.moondab.controller.question.dto.QuestionRq;
import com.hyun.moondab.controller.question.dto.QuestionRs;
import com.hyun.moondab.domain.question.Question;
import com.hyun.moondab.domain.question.QuestionRepository;
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
class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    @DisplayName("날짜 데이터를 기준으로 질문을 조회한다.")
    @Test
    void getQuestion() {
        //given
        int month = 1;
        int day = 1;
        String content = "올해 꼭 이루고 싶은 목표가 있나요?";
        Question savedQuestion = questionRepository.save(Question.create(month, day, content));

        //when
        QuestionRs rs = questionService.getQuestion(QuestionRq.builder()
                .month(month)
                .day(day)
                .build()
        );

        //then
        assertThat(rs.getId()).isEqualTo(savedQuestion.getId());
        assertThat(rs.getContent()).isEqualTo(content);
    }

}