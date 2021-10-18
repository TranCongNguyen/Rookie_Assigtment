package com.rookie.rookie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account implements Serializable {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="role_id")
    Role role;

}
