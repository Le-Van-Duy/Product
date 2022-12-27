package com.example.manageproduct2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String produce_name;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "sell_price")
    private Double sell_price;

    @Column(name = "origin_price")
    private Double origin_price;

    @Column(name = "description")
    private String description;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "sub_cate_id", referencedColumnName = "id")
    private Sub_Category sub_category;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToMany(mappedBy = "products")
    private Set<Brand> brands = new LinkedHashSet<>();

    public void addBrand(Brand br) {
        brands.add(br);
        br.getProducts().add(this);
    }
    public void removeBrand(Brand br) {
        brands.remove(br);
        br.getProducts().remove(this);
    }

}
