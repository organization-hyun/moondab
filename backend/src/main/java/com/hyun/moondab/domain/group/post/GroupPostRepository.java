package com.hyun.moondab.domain.group.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupPostRepository extends JpaRepository<GroupPost, Long>, GroupPostRepositoryCustom{
}
