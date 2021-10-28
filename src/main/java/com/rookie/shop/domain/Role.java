package com.rookie.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import  org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Roles",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})},indexes = {
        @Index(name = "rl_us_index",columnList = "id",unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="role_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    private Short id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "role_name",length = 50)
    private RoleName roleName;

    @OneToMany(mappedBy = "role")
    private Collection<User> user;

}
