package com.hyun.moondab.domain.group;

import com.hyun.moondab.domain.group.user.GroupUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GroupTest {

    @DisplayName("그룹을 생성한다.")
    @Test
    void create_group() {
        //given
        String title = "기본 그룹";

        //when
        Group group = Group.create(title);

        //then
        assertThat(group.getTitle()).isEqualTo(title);
    }

    @DisplayName("그룹 구성원을 추가한다.")
    @Test
    void add_group_user() {
        //given
        Group group = createGroup();
        GroupUser groupUser = createGroupUser(1L);

        //when
        group.addGroupUser(groupUser);

        //then
        assertThat(group.getGroupUsers()).hasSize(1)
                .containsExactly(groupUser);
        assertThat(groupUser.getGroup()).isEqualTo(group);
    }

    private Group createGroup() {
        return Group.builder()
                .title("기본 그룹")
                .build();
    }

    private GroupUser createGroupUser(Long userId) {
        return GroupUser.builder()
                .userId(userId)
                .build();
    }

}