package com.hyun.moondab.question

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/questions")
class QuestionController {

    private final val sampleQuestionText: String = "오늘 하루는 어땠나요?"

    @GetMapping("/question")
    fun getQuestion(): QuestionResponse {
        return QuestionResponse(1L, sampleQuestionText)
    }

}