package com.example.dscatalog.services;

import com.example.dscatalog.dto.ProductDTO;
import com.example.dscatalog.entities.Product;
import com.example.dscatalog.repositories.ProductRepository;
import com.example.dscatalog.services.exceptions.DatabaseException;
import com.example.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(PageRequest pageRequest){
        Page<Product> list = repository.findAll(pageRequest);
        Page<ProductDTO> listDTO = list.map(x -> new ProductDTO(x));

        return listDTO;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product category = obj.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        return new ProductDTO(category, category.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product category = new Product();
        //category.setName(dto.getName());
        repository.save(category);

        return new ProductDTO(category);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try{
            Product category = repository.getReferenceById(id);
            //category.setName(dto.getName());
            repository.save(category);

            return new ProductDTO(category);
        }
        catch (jakarta.persistence.EntityNotFoundException e) {
            throw new EntityNotFoundException("ID não encontrado" + id);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Elemento não encontrado ou inexistente");
        } try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
