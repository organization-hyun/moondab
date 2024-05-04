package com.hyun.moondab.domain.group;

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

}