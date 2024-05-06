package com.hyun.moondab.domain.group;

import com.hyun.moondab.domain.group.post.GroupPost;
import com.hyun.moondab.domain.group.user.GroupUser;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupUser> groupUsers = new ArrayList<>();

    public static Group create(String title) {
        return new Group(title);
    }

    @Builder
    private Group(String title) {
        this.title = title;
    }

    public void addGroupUser(Long userId) {
        GroupUser groupUser = GroupUser.create(this, userId);
        this.groupUsers.add(groupUser);
    }

    public void addGroupPost(GroupPost groupPost) {
        this.groupPosts.add(groupPost);
        groupPost.setGroup(this);
    }

}
