package com.pmn.adminusers.repositories;

import com.pmn.adminusers.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
}
