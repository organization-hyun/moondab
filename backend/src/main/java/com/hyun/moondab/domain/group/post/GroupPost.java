package com.hyun.moondab.domain.group.post;

import com.hyun.moondab.domain.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public static GroupPost create(String content) {
        return new GroupPost(content);
    }

    private GroupPost(String content) {
        this.content = content;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
