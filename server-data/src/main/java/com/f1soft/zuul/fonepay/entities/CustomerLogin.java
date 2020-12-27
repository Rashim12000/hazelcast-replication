package com.f1soft.zuul.fonepay.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "customer_login")
@Table(name = "CUSTOMER_LOGIN")
public class CustomerLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 22)
    private Long id;
    @Basic(optional = false)
    @Column(name = "USERNAME", length = 150)
    private String username;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "customer")
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne()
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerLogin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", customer=" + customer +
                '}';
    }
}
