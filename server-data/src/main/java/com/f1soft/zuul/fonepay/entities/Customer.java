package com.f1soft.zuul.fonepay.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "customer")
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 22)
    private Long id;
    @Basic(optional = false)
    @Column(name = "NAME", length = 150)
    private String name;
    @Basic(optional = false)
    @Column(name = "ADDRESS", length = 150)
    private String address;
    @Basic(optional = false)
    @Column(name = "ACTIVE", length = 1)
    private char active;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "customer_login")
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<CustomerLogin> customerLoginList;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", active=" + active +
                '}';
    }
}