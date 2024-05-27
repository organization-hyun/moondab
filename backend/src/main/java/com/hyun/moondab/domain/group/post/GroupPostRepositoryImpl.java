package com.hyun.moondab.domain.group.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.hyun.moondab.domain.group.QGroup.group;
import static com.hyun.moondab.domain.group.post.QGroupPost.groupPost;

@RequiredArgsConstructor
public class GroupPostRepositoryImpl implements GroupPostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<GroupPost> findAllByGroupId(Long groupId) {
        return queryFactory.selectFrom(groupPost)
                .leftJoin(groupPost.group, group)
                .where(group.id.eq(groupId))
                .fetch();
    }

}
