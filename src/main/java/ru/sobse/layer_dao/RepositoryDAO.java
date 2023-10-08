package ru.sobse.layer_dao;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RepositoryDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String queryCustomerProducts;

    public RepositoryDAO(NamedParameterJdbcTemplate jdbcTemplate, HikariDataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;

        queryCustomerProducts = read("customer_products.sql");
    }

    public List<String> fetchProduct(String nameCustomer) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("name", nameCustomer);

        return jdbcTemplate.query(queryCustomerProducts,
                queryParams,
                ((rs, rowNum) -> {return rs.getString("product_name");}));
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream()) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
                return bufferedReader.lines().collect(Collectors.joining("\n"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
