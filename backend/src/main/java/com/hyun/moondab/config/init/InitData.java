package com.hyun.moondab.config.init;

import com.hyun.moondab.domain.group.Group;
import com.hyun.moondab.domain.group.GroupRepository;
import com.hyun.moondab.domain.group.post.GroupPost;
import com.hyun.moondab.domain.group.post.GroupPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData implements ApplicationRunner {

    private final GroupRepository groupRepository;
    private final GroupPostRepository groupPostRepository;

    @Override
    public void run(ApplicationArguments args) {
        Group group = initGroup();
        initGroupPostByGroup(group);
    }

    private Group initGroup() {
        Group group = Group.create("기본 그룹");
        group.addGroupUser(1L);
        return groupRepository.save(group);
    }

    private void initGroupPostByGroup(Group group) {
        GroupPost groupPost = GroupPost.create("기본 게시글");
        groupPost.setGroup(group);
        groupPostRepository.save(groupPost);
    }


}
