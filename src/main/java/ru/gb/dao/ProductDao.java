package ru.gb.dao;

import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductDao {

    Product save(Product product);

    Product edit(Product product);

    Product viewById(Integer id);

    List<Product> viewAll();

    void deleteById(Integer id);
}
