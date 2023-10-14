package ru.sobse.layer_dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sobse.layer_dao.service.ServiceDAO;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerDAO {

    private ServiceDAO service;

    public ControllerDAO(ServiceDAO service) {
        this.service = service;
    }

    @GetMapping("/fetch-product")
    public List<String> fetchProduct(@RequestParam("name") String nameCustomer) {
        return service.fetchProduct(nameCustomer);
    }
}
