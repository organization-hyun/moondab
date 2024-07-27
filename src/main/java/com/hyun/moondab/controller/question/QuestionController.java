package com.hyun.moondab.controller.question;

import com.hyun.moondab.application.question.QuestionService;
import com.hyun.moondab.controller.question.dto.QuestionRq;
import com.hyun.moondab.controller.question.dto.QuestionRs;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "질문 조회", description = "날짜 데이터를 기준으로 질문을 조회한다.")
    @GetMapping
    public QuestionRs getQuestion(QuestionRq rq) {
        return questionService.getQuestion(rq);
    }

}
