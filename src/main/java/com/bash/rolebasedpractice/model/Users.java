package com.bash.rolebasedpractice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_data")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

//    New field for user-specific permissions
//    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_permissions", joinColumns = @JoinColumn(name = "user_id"))
//    private Set<String> individualPermissions = new HashSet<>();

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles.add(Role.USER);
    }
}
