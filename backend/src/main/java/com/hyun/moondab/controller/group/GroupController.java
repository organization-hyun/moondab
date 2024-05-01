package com.hyun.moondab.controller.group;

import com.hyun.moondab.application.group.GroupService;
import com.hyun.moondab.controller.group.dto.GroupsRs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/users/{userId}/groups")
    public GroupsRs getGroups(@PathVariable Long userId) {
        return groupService.getGroups(userId);
    }

}
