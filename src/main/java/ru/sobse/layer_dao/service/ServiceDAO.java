package ru.sobse.layer_dao.service;

import org.springframework.stereotype.Service;
import ru.sobse.layer_dao.repository.RepositoryDAO;

import java.util.List;

@Service
public class ServiceDAO {

    private RepositoryDAO repository;

    public ServiceDAO(RepositoryDAO repository) {
        this.repository = repository;
    }

    public List<String> fetchProduct(String nameCustomer) {
        return repository.fetchProduct(nameCustomer);
    }
}
