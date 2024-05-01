package com.hyun.moondab.domain.group.post;

import com.hyun.moondab.domain.group.Group;
import jakarta.persistence.*;

@Entity
public class GroupPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

}
