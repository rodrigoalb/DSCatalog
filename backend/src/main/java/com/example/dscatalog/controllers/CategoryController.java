package com.example.dscatalog.controllers;

import com.example.dscatalog.dto.CategoryDTO;
import com.example.dscatalog.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dscatalog.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping 
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> list = new ArrayList<>();
        list = service.findAll();
        return ResponseEntity.ok(list);
    }

}