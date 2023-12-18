package com.productservice.productservice.inheritancerelations.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_userrepository")
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    User save(User user);
}
