package com.hyun.moondab.domain.group;

import com.hyun.moondab.domain.group.post.GroupPost;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "group")
    private List<GroupPost> groupPosts = new ArrayList<>();

}
