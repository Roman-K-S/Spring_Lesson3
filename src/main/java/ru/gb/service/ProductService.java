package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product edit(Product product){
        return productRepository.edit(product);
    }

    public Product viewById(Integer id){
        return productRepository.viewById(id).orElse(new Product());
    }

    public List<Product> viewAll() {
        return productRepository.viewAll();
    }

    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }

}
