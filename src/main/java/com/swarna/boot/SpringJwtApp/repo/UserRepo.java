package com.swarna.boot.SpringJwtApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swarna.boot.SpringJwtApp.model.CustomUser;

public interface UserRepo extends JpaRepository<CustomUser, Integer> {

	Optional<CustomUser> findByUsername(String username);

}
