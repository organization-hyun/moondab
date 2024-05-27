package com.hyun.moondab.controller.group.dto;

import com.hyun.moondab.domain.group.Group;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupsRs {

    private List<GroupDto> groups;

    public static GroupsRs of(List<Group> groups) {
        return new GroupsRs(groups.stream()
                .map(GroupDto::of)
                .collect(Collectors.toList()));
    }

}
