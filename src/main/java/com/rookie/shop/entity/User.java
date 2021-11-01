package com.rookie.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(
    name = "Users", indexes = {
            @Index(name = "us_rl_index",columnList = "role_id")
    })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(generator = "Sequence-generator")
  @GenericGenerator(
      name = "sequence_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "user_sequence"),
        @Parameter(name = "increment_size", value = "1")
      })
  private Long id;

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  @NotNull
  private Short status;

  @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Customer customer;

  @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "role_id",nullable = false)
  private Role role;

  @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
  private Collection<Address> address;

  @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
  private Collection<Order> orders;

  @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
  private Collection<Review> review;


}
