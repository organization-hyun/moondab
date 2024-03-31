package com.hyun.moondab.domain

class Question(
    val id: Long,
    val text: String
)

data class QuestionResponse(
    val id: Long,
    val text: String = "오늘 하루는 어땠나요?"
)