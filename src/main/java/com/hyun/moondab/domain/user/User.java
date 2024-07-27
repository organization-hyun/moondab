package com.hyun.moondab.domain.user;

import com.hyun.moondab.domain.answer.Answer;
import com.hyun.moondab.domain.question.Question;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Answer writeAnswer(Question question, String content, Boolean isPublic) {
        return Answer.create(this, question, content, isPublic);
    }

}
