package com.hyun.moondab.controller.group.dto;

import com.hyun.moondab.domain.group.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroupDto {

    private Long id;
    private String title;

    public static GroupDto of(Group group) {
        return new GroupDto(group.getId(), group.getTitle());
    }

}
