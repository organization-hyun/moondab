package com.hyun.moondab.application.group.post;

import com.hyun.moondab.controller.group.post.dto.GroupPostRs;
import com.hyun.moondab.domain.group.post.GroupPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupPostService {

    private final GroupPostRepository groupPostRepository;

    public GroupPostRs getGroupPost(Long id) {
        return GroupPostRs.of(groupPostRepository.findAllByGroupId(id));
    }
}
