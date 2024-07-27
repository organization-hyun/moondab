package com.hyun.moondab.application.question;

import com.hyun.moondab.controller.question.dto.QuestionRq;
import com.hyun.moondab.controller.question.dto.QuestionRs;
import com.hyun.moondab.domain.question.Question;
import com.hyun.moondab.domain.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionRs getQuestion(QuestionRq rq) {
        Question question = questionRepository.findByQuestionMonthAndQuestionDay(rq.getMonth(), rq.getDay());
        return QuestionRs.of(question);
    }

}
