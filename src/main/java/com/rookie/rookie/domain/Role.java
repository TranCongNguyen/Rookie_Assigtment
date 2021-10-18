package com.rookie.rookie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Roles")
public class Role {
    @Id
    @Column(name="role_id")
    private String roleId;
    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Account> account;

}
