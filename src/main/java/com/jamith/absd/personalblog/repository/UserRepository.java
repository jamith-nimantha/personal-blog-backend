package com.jamith.absd.personalblog.repository;

import com.jamith.absd.personalblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
