package com.hyun.moondab.domain.group;

import java.util.List;

public interface GroupRepositoryCustom {
    List<Group> findAllByUserId(Long userId);
}
