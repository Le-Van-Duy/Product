package com.example.manageproduct2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sub_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sub_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sub_cate_code")
    private String sub_cate_code;

    @Column(name = "sub_cate_name")
    private String sub_cate_name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Category category;

}
