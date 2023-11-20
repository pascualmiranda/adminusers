package com.pmn.adminusers.repositories;

import com.pmn.adminusers.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
