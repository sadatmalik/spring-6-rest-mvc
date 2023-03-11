package com.creativefusion.spring6restmvc.controllers;

import com.creativefusion.spring6restmvc.model.Customer;
import com.creativefusion.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
@RequiredArgsConstructor
@RestController
public class CustomerController {
    public static final String CUSTOMER_PATH = "/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    private final CustomerService customerService;

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity<Void> handlePost(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(CUSTOMER_PATH)
    public List<Customer> listAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(CUSTOMER_PATH_ID)
    public Customer getCustomerById(@PathVariable("customerId") UUID id){
        return customerService.getCustomerById(id)
                              .orElseThrow(NotFoundException::new);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<Void> updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                             @RequestBody Customer customer){
        customerService.updateCustomerById(customerId, customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<Void> patchCustomerById(@PathVariable("customerId") UUID customerId,
                                            @RequestBody Customer customer){
        customerService.patchCustomerById(customerId, customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("customerId") UUID customerId){

        customerService.deleteCustomerById(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
