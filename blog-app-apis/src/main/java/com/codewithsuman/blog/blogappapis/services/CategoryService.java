package com.codewithsuman.blog.blogappapis.services;

import java.util.List;

import com.codewithsuman.blog.blogappapis.payloads.CategoryDto;

public interface CategoryService {
    // Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    // Inside interface methods are automatically public so no need to write
    // "public" keywords
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // Delete
    void deleteCategory(Integer categoryId);

    // Get
    CategoryDto getCategory(Integer categoryId);

    // Get All
    List<CategoryDto> getCategories();
}
