package com.rookie.rookie.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    @NotEmpty
    private String roleId;
    @NotEmpty
    private String name;

}
