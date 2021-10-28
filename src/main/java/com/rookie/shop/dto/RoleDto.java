package com.rookie.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDto {
    @NotNull
    private Short roleId;

    @NotNull
    private String roleName;

    @NotNull
    private Long userId;
}
