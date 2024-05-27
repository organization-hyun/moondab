package com.hyun.moondab.domain.group.post;

import java.util.List;

public interface GroupPostRepositoryCustom {
    List<GroupPost> findAllByGroupId(Long groupId);
}
