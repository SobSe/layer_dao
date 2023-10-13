package ru.sobse.layer_dao;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    public RepositoryDAO(NamedParameterJdbcTemplate jdbcTemplate, HikariDataSource dataSource, EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> fetchProduct(String nameCustomer) {

        String query = "select o.product_name  from Orders o where lower(customer.name) = lower(:name)";
        return  entityManager.createQuery(query, String.class)
                .setParameter("name", nameCustomer)
                .getResultList();

    }

}
