package com.hyun.moondab.config.init;

import com.hyun.moondab.domain.group.Group;
import com.hyun.moondab.domain.group.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData implements ApplicationRunner {

    private final GroupRepository groupRepository;

    @Override
    public void run(ApplicationArguments args) {
        Group group = Group.create("기본 그룹");
        group.addGroupUser(1L);
        groupRepository.save(group);
    }

}
