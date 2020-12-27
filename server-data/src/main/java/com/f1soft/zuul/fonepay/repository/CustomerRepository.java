package com.f1soft.zuul.fonepay.repository;

import com.f1soft.zuul.fonepay.entities.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer> {

    @Query("select t from Customer t where t.id = :id")
    Customer findByCustomerId(long id);

}