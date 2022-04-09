package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    List<Product> products = new ArrayList<>();

    private int count;

    public Product save(Product product){
        product.setId(count++);
        products.add(product);

        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }

    public Product edit(Product product){
        return products.set(product.getId(), product);
    }

    public Optional<Product> viewById(Integer id){
        if (id < products.size()){
            return Optional.of(products.get(id));
        }else{
            return Optional.empty();
        }
    }

    public List<Product> viewAll(){
        return new ArrayList<>(products);
    }

    public void deleteById(Integer id){
        if (id < products.size()) {
            products.remove(id.intValue());
        }
    }
}
