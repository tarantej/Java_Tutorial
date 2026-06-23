package com.dashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<DashboardUsers, Integer>
{
    Optional<DashboardUsers> findByUsername(String username);
}