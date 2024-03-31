package com.hyun.moondab.controller

import com.hyun.moondab.domain.QuestionResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/questions")
class QuestionController {

    @GetMapping("/{id}")
    fun getQuestion(@PathVariable id: Long) : QuestionResponse {
        return QuestionResponse(id);
    }

}