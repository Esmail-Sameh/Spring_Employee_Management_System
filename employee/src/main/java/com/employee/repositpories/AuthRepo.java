package com.employee.repositpories;

import com.employee.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepo extends JpaRepository<UserAccount, UUID> {


}
