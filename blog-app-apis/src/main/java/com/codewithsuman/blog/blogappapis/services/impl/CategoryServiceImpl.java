package com.codewithsuman.blog.blogappapis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.codewithsuman.blog.blogappapis.entities.Category;
import com.codewithsuman.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.codewithsuman.blog.blogappapis.payloads.CategoryDto;
import com.codewithsuman.blog.blogappapis.repositories.CategoryRepo;
import com.codewithsuman.blog.blogappapis.services.CategoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelmapper;

    // Create
    @Override
    // public void createCategory(){

    // return null;
    // }
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelmapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelmapper.map(addedCat, CategoryDto.class);
    }

    // update
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCatetgoryDescription());
        Category updatedcat = this.categoryRepo.save(cat);
        return this.modelmapper.map(updatedcat, CategoryDto.class);
    }

    // delete
    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        this.categoryRepo.delete(cat);
    }

    // get by id
    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

        return this.modelmapper.map(cat, CategoryDto.class);
    }

    // get all
    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelmapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
        return catDtos;
    }

}
