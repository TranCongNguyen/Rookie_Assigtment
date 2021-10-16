package com.rookie.rookie.domain;

import ch.qos.logback.classic.db.names.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Authorizes",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username","role_id"})
})
public class Authorize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="role_id")
    private  Role role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="username")
    private Account account;
}
