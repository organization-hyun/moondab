package com.hyun.moondab.domain.answer;

import com.hyun.moondab.domain.question.Question;
import com.hyun.moondab.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    private String content;

    private Integer views;

    private Boolean isPublic;

    public static Answer create(User user, Question question, String content, Boolean isPublic) {
        return new Answer(user, question, content, isPublic);
    }

    @Builder
    private Answer(User user, Question question, String content, Boolean isPublic) {
        this.user = user;
        this.question = question;
        this.content = content;
        this.isPublic = isPublic;
        this.views = 0;
    }

    public void incrementViews() {
        this.views++;
    }

}
