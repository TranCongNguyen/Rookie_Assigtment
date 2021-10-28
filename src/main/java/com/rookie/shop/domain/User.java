package com.rookie.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(
    name = "Users",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})},
    indexes = {@Index(name = "us_un_index", columnList = "username", unique = true)})
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

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private Collection<User> user;

  @Column(name = "username", length = 50)
  @NotNull
  private String username;

  @Column(name = "password", length = 20)
  @NotNull
  private String password;

  @Column(name = "full_name")
  @NotNull
  private String fullName;

  @NotNull private String email;

  @NotNull private String phone;

  @NotNull private Boolean gender;
}
