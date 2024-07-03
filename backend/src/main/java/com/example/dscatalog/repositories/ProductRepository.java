package com.example.dscatalog.repositories;

import com.example.dscatalog.entities.Category;
import com.example.dscatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
