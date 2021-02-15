package com.ebi.utility.repository;

import com.ebi.utility.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Harshal Patil
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
