package com.hyun.moondab.domain.group;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.hyun.moondab.domain.group.QGroup.group;
import static com.hyun.moondab.domain.group.user.QGroupUser.groupUser;

@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Group> findAllByUserId(Long userId) {
        return queryFactory.selectFrom(group)
                .leftJoin(groupUser).on(group.id.eq(groupUser.groupId))
                .where(groupUser.userId.eq(userId))
                .fetch();
    }

}
