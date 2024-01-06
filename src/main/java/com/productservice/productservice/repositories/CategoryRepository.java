package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Category;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
//    @Override
//    Category save(Category category);
}
