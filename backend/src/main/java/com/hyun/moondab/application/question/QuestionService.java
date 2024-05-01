package com.hyun.moondab.application.question;

import com.hyun.moondab.controller.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    public QuestionDto getQuestion(Long id) {
        return new QuestionDto(id);
    }

}
