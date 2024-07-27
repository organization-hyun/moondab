package com.hyun.moondab.config.init;

import com.hyun.moondab.domain.group.Group;
import com.hyun.moondab.domain.group.GroupRepository;
import com.hyun.moondab.domain.question.Question;
import com.hyun.moondab.domain.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
@RequiredArgsConstructor
@Slf4j
public class InitData implements ApplicationRunner {

    private final QuestionRepository questionRepository;
    private final GroupRepository groupRepository;

    @Override
    public void run(ApplicationArguments args) {
        Group group = Group.create("기본 그룹");
        group.addGroupUser(1L);
        groupRepository.save(group);
        createQuestion();
    }

    private void createQuestion() {
        Question question = Question.create(1, 1, "올해 꼭 이루고 싶은 목표가 있나요?");
        questionRepository.save(question);
    }

}
