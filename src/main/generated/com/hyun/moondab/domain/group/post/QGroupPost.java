package com.hyun.moondab.domain.group.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGroupPost is a Querydsl query type for GroupPost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGroupPost extends EntityPathBase<GroupPost> {

    private static final long serialVersionUID = -1537954487L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGroupPost groupPost = new QGroupPost("groupPost");

    public final StringPath content = createString("content");

    public final com.hyun.moondab.domain.group.QGroup group;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGroupPost(String variable) {
        this(GroupPost.class, forVariable(variable), INITS);
    }

    public QGroupPost(Path<? extends GroupPost> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGroupPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGroupPost(PathMetadata metadata, PathInits inits) {
        this(GroupPost.class, metadata, inits);
    }

    public QGroupPost(Class<? extends GroupPost> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.group = inits.isInitialized("group") ? new com.hyun.moondab.domain.group.QGroup(forProperty("group")) : null;
    }

}

