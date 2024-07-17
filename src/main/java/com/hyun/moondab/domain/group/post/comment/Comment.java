package com.hyun.moondab.domain.group.post.comment;

import com.hyun.moondab.domain.group.post.GroupPost;
import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long authorId;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_item_id")
    private GroupPost groupPost;

}
