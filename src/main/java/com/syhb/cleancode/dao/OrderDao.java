package com.syhb.cleancode.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`order`")
public class OrderDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private int tax;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order", cascade = CascadeType.ALL)
    @Valid
    private List<OrderItemDao> orderItemDaoList = new ArrayList<>();

    public OrderDao() { }

    public OrderDao(int tax) {
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getTax() {
        return tax;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

}
