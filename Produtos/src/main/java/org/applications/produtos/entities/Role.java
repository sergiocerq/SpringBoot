package org.applications.produtos.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.applications.produtos.dtos.RoleDTO;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;

    public Role (RoleDTO roleDTO) {
        this.id = roleDTO.id();
        this.role = roleDTO.role();
    }

    public Role(Role role) {
        this.id = role.getId();
        this.role = role.getRole();
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
