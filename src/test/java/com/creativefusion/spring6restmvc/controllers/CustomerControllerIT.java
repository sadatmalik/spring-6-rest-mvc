package com.creativefusion.spring6restmvc.controllers;

import com.creativefusion.spring6restmvc.entities.Customer;
import com.creativefusion.spring6restmvc.mappers.CustomerMapper;
import com.creativefusion.spring6restmvc.model.CustomerDTO;
import com.creativefusion.spring6restmvc.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerIT {

    @Autowired CustomerRepository customerRepository;
    @Autowired CustomerController customerController;
    @Autowired CustomerMapper customerMapper;

    @Rollback
    @Transactional
    @Test
    void saveNewBeerTest() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("TEST")
                .build();

        ResponseEntity<Void> responseEntity = customerController.handlePost(customerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[4]);

        assertTrue(customerRepository.findById(savedUUID).isPresent());
    }

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

    @Test
    void testUpdateNotFound() {
        assertThrows(
                NotFoundException.class,
                () -> customerController.updateCustomerByID(UUID.randomUUID(), CustomerDTO.builder().build())
        );
    }

    @Test
    @Rollback
    @Transactional
    void updateExistingBeer() {
        Customer customer = customerRepository.findAll().get(0);
        CustomerDTO customerDTO = customerMapper.customerToCustomerDto(customer);
        customerDTO.setId(null);
        customerDTO.setVersion(null);
        final String customerName = "UPDATED";
        customerDTO.setName(customerName);

        ResponseEntity<Void> responseEntity = customerController.updateCustomerByID(customer.getId(), customerDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
        assertTrue(optionalCustomer.isPresent());
        Customer updatedCustomer = optionalCustomer.get();
        assertThat(updatedCustomer.getName()).isEqualTo(customerName);
    }

    @Test
    @Rollback
    @Transactional
    void deleteByIdFound() {
        Customer customer = customerRepository.findAll().get(0);

        ResponseEntity<Void> responseEntity = customerController.deleteCustomerById(customer.getId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        assertTrue(customerRepository.findById(customer.getId()).isEmpty());
    }

    @Test
    void testDeleteNotFound() {
        assertThrows(
                NotFoundException.class,
                () -> customerController.deleteCustomerById(UUID.randomUUID())
        );
    }
}
