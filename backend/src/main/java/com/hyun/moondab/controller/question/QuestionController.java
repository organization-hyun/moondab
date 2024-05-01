package com.hyun.moondab.controller.question;

import com.hyun.moondab.application.question.QuestionService;
import com.hyun.moondab.controller.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{id}")
    public QuestionDto getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

}
