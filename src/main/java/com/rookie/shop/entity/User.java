package com.rookie.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "Users", indexes = {
            @Index(name = "us_name_index",columnList = "username")
    })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 120)
  private String password;

  @NotBlank
  private String fullName;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  private String phone;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name="user_role",
              joinColumns = @JoinColumn(name="user_id"),
              inverseJoinColumns = @JoinColumn(name="role_id"))
  private Set<Role> roles = new HashSet<>();

  @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
  private Collection<Address> address;

  @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
  private Collection<Order> orders;

  @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
  private Collection<Review> review;

  public User(String username, String fullName, String email, String phone, String password) {
    this.username = username;
    this.fullName = fullName;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }

}
