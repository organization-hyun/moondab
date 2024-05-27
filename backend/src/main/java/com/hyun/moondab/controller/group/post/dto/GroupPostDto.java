package com.hyun.moondab.controller.group.post.dto;

import com.hyun.moondab.domain.group.post.GroupPost;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupPostDto {

    private Long id;
    private String content;
    private Long groupId;

    public static GroupPostDto of(GroupPost groupPost) {
        return new GroupPostDto(groupPost.getId(), groupPost.getContent(), groupPost.getGroup().getId());
    }
}
