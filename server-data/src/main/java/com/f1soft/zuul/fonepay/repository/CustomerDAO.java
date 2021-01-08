package com.f1soft.zuul.fonepay.repository;

import com.f1soft.zuul.fonepay.entities.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer findByCustomerId(long id) {
        Query query = entityManager.createQuery("select t from Customer t where t.id =:id");
        query.setParameter("id", id);
        query.setHint("org.hibernate.cacheable", true);

        return (Customer) query.getSingleResult();
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }


}