package com.hyun.moondab.domain.group;

import com.hyun.moondab.domain.group.post.GroupPost;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "groups")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupPost> groupPosts = new ArrayList<>();

    public static Group create(String title) {
        return new Group(title);
    }

    private Group(String title) {
        this.title = title;
    }

    public void addGroupPost(GroupPost groupPost) {
        this.groupPosts.add(groupPost);
        groupPost.setGroup(this);
    }

}
