package com.hyun.moondab.controller.group.post.dto;

import com.hyun.moondab.domain.group.post.GroupPost;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class GroupPostRs {
    private List<GroupPostDto> groupPosts;

    public static GroupPostRs of(List<GroupPost> groupPosts) {
        return new GroupPostRs(groupPosts.stream()
                .map(g -> GroupPostDto.of(g))
                .collect(Collectors.toList()));

    }
}
