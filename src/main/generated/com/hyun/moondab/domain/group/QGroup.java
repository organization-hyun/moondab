package com.hyun.moondab.domain.group;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGroup is a Querydsl query type for Group
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGroup extends EntityPathBase<Group> {

    private static final long serialVersionUID = 1193558503L;

    public static final QGroup group = new QGroup("group1");

    public final ListPath<com.hyun.moondab.domain.group.post.GroupPost, com.hyun.moondab.domain.group.post.QGroupPost> groupPosts = this.<com.hyun.moondab.domain.group.post.GroupPost, com.hyun.moondab.domain.group.post.QGroupPost>createList("groupPosts", com.hyun.moondab.domain.group.post.GroupPost.class, com.hyun.moondab.domain.group.post.QGroupPost.class, PathInits.DIRECT2);

    public final ListPath<com.hyun.moondab.domain.group.user.GroupUser, com.hyun.moondab.domain.group.user.QGroupUser> groupUsers = this.<com.hyun.moondab.domain.group.user.GroupUser, com.hyun.moondab.domain.group.user.QGroupUser>createList("groupUsers", com.hyun.moondab.domain.group.user.GroupUser.class, com.hyun.moondab.domain.group.user.QGroupUser.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QGroup(String variable) {
        super(Group.class, forVariable(variable));
    }

    public QGroup(Path<? extends Group> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroup(PathMetadata metadata) {
        super(Group.class, metadata);
    }

}

