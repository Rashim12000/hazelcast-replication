package com.f1soft.zuul.proxy.two;


import com.f1soft.zuul.fonepay.entities.Customer;
import com.f1soft.zuul.fonepay.entities.CustomerLogin;
import com.f1soft.zuul.fonepay.repository.CustomerDAO;
import com.f1soft.zuul.fonepay.repository.CustomerLoginRepository;
import com.f1soft.zuul.proxy.two.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rashim Dhaubanjar
 */
@Slf4j
@RestController
public class ServerTwoController {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerLoginRepository customerLoginRepository;

    @GetMapping("/cache/get")
    public Result findById(HttpServletRequest req, HttpServletResponse res) {

//        String value = (String) cacheManager.getCache("events").get("test").get();
        return new Result(1L, "value");
    }

    @GetMapping("/cache/set/{value}")
    public Result findById(@PathVariable String value, HttpServletRequest req, HttpServletResponse res) {
        log.info("received get merchants");

        return new Result(1L, "Esewa");
    }

    @GetMapping("/customer/get")
    public com.f1soft.zuul.fonepay.dto.Result findByCustomerId(HttpServletRequest req, HttpServletResponse res) {

        Customer customer = customerDAO.findByCustomerId(1L);
        log.info("Customer get: {}", customer);
        return new com.f1soft.zuul.fonepay.dto.Result(1L, customer.toString());
    }

    @GetMapping("/customer/update")
    public com.f1soft.zuul.fonepay.dto.Result updateCustomer(HttpServletRequest req, HttpServletResponse res) {

        Customer customer = customerDAO.findByCustomerId(1L);
        log.info("Customer get for update: {}", customer.toString());

        customer.setName("ServerTwo");

        customerDAO.updateCustomer(customer);

        log.info("Customer after update: {}", customer.toString());
        return new com.f1soft.zuul.fonepay.dto.Result(1L, customer.toString());
    }

    @GetMapping("/customer-login/get")
    public Result findByCustomerLoginId(HttpServletRequest req, HttpServletResponse res) {

        CustomerLogin customerLogin = customerLoginRepository.findById(1L).get();
        log.info("Customer login get: {}", customerLogin);
        return new Result(1L, customerLogin.toString());
    }

    @GetMapping("/customer-login/update")
    public Result updateCustomerLogin(HttpServletRequest req, HttpServletResponse res) {

        CustomerLogin customerLogin = customerLoginRepository.findById(1L).get();
        log.info("Customer get for update: {}", customerLogin.toString());

        customerLogin.setUsername("CustomerLoginServerTwo");

        customerLoginRepository.save(customerLogin);

        log.info("Customer after update: {}", customerLogin.toString());
        return new Result(1L, customerLogin.toString());
    }
}
