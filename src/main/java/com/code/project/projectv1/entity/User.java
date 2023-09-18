package com.code.project.projectv1.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "At least 1 character")
    private String firstName;

    @Size(min = 2, message = "At least 1 character")
    private String lastName;

    @Size(min = 2, message = "At least 1 character")
    private String username;

    @Column(length = 60)
    @NotNull(message = "is required")
    @Size(min = 2, message = "At least 2")
    private String password;
    @OneToMany(targetEntity = Role.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Role> role;

    public void addRole(Role role){
        this.role.add(role);
    }

}
