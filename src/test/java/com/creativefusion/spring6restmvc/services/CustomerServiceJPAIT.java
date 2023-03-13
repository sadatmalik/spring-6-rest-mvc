package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.controllers.CustomerController;
import com.creativefusion.spring6restmvc.controllers.NotFoundException;
import com.creativefusion.spring6restmvc.entities.Customer;
import com.creativefusion.spring6restmvc.model.CustomerDTO;
import com.creativefusion.spring6restmvc.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerIT {

    @Autowired CustomerRepository customerRepository;
    @Autowired CustomerController customerController;

    @Test
    @Rollback
    @Transactional
    void testListAllEmptyList() {
        customerRepository.deleteAll();
        List<CustomerDTO> dtos = customerController.listAllCustomers();
        assertThat(dtos.size()).isEqualTo(0);
    }

    @Test
    void testListAll() {
        List<CustomerDTO> dtos = customerController.listAllCustomers();
        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void testGetByIdNotFound() {
        assertThrows(
                NotFoundException.class,
                () -> customerController.getCustomerById(UUID.randomUUID())
        );
    }

    @Test
    void testGetById() {
        Customer customer = customerRepository.findAll().get(0);
        CustomerDTO customerDTO = customerController.getCustomerById(customer.getId());
        assertThat(customerDTO).isNotNull();
    }

}
