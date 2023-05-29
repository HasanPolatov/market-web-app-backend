package com.example.myfirstfullstackwebsite.repositories;

import com.example.myfirstfullstackwebsite.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    Optional<MyUser> findOneByUsername(String username);

}
