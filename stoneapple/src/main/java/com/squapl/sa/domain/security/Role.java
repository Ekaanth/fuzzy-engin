package com.squapl.sa.domain.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by z00382545 on 10/20/16.
 */

@Entity
public class Role {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;

    public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


}
