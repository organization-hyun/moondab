package com.hyun.moondab.application.group;

import com.hyun.moondab.controller.group.dto.GroupsRs;
import com.hyun.moondab.domain.group.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupsRs getGroups(Long userId) {
        return GroupsRs.of(groupRepository.findAllByUserId(userId));
    }

}
