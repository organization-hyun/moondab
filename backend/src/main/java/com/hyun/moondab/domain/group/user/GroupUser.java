package com.hyun.moondab.domain.group.user;

import com.hyun.moondab.domain.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    private Long userId;

    public void setGroup(Group group) {
        this.group = group;
    }

    @Builder
    private GroupUser(Long userId) {
        this.userId = userId;
    }

}
