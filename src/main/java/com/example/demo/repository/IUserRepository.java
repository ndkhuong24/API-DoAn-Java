package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users,Integer> {
    @Query("SELECT DISTINCT ar.user.username FROM Authority ar WHERE ar.role.name IN ('admin', 'user')")
    List<Users> getAdministrators();

    Users getUsersByUsername(String username);
}
