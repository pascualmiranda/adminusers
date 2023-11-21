package com.pmn.adminusers.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="user_rol")
public class UserRol {
    @Id
    @SequenceGenerator(name = "user_rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_rol_sequence")
    private Integer id;
    private boolean active;
    @Column(name="created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rol_id")
    private Rol rol;

    public UserRol() {
    }

    public UserRol(boolean active, LocalDateTime createdAt, User user, Rol rol) {
        this.active = active;
        this.createdAt = createdAt;
        this.user = user;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UserRol{" +
                "id=" + id +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", rol=" + rol +
                '}';
    }
}
