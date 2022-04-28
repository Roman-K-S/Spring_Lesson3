package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EntityManagerProductDao implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        if (product.getId() == null){
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    @Override
    public Product edit(Product product) {
        return null;
    }

    @Override
    public Product viewById(Integer id) {
        TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.viewById", Product.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public List<Product> viewAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        Product product = new Product();
        product.setId(id);
        delete(product);
    }

    public void delete(Product product){
        Product mergeProduct = entityManager.merge(product);
        entityManager.remove(mergeProduct);
    }
}
