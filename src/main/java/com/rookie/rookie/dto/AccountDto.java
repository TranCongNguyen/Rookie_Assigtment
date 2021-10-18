package com.rookie.rookie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private String roleId;
}
