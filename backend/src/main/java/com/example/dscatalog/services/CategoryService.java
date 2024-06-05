package com.example.dscatalog.services;

import com.example.dscatalog.dto.CategoryDTO;
import com.example.dscatalog.entities.Category;
import com.example.dscatalog.repositories.CategoryRepository;
import com.example.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();
        List<CategoryDTO> listDTO = list.stream().map(x -> new CategoryDTO(x)).toList();

        return listDTO;
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category category = obj.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        repository.save(category);

        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try{
            Category category = repository.getReferenceById(id);
            category.setName(dto.getName());
            repository.save(category);

            return new CategoryDTO(category);
        }
        catch (jakarta.persistence.EntityNotFoundException e) {
            throw new EntityNotFoundException("ID não encontrado" + id);
        }
    }
}
