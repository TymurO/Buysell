package com.example.buysell.repository;

import com.example.buysell.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            select p from Product p
            """)
    Collection<Product> getAllProducts();

    @Query("""
            select p from Product p where p.name like %?1%
            """)
    Collection<Product> getProductsByName(String name);
}
