package com.codewithsuman.blog.blogappapis.repositories;

import com.codewithsuman.blog.blogappapis.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
