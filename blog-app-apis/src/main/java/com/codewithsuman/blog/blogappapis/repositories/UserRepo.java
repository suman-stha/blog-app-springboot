package com.codewithsuman.blog.blogappapis.repositories;

import com.codewithsuman.blog.blogappapis.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
