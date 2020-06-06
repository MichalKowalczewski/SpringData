package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`order`")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private int id;
    @Column(name = "ORD_PRICE")
    private double price;
    @Column(name = "ORD_TITLE")
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORD_PU_ID", referencedColumnName = "PU_ID")
    private PortalUser portalUser;

}
