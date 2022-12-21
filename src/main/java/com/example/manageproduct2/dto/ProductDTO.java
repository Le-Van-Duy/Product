package com.example.manageproduct2.dto;

import com.example.manageproduct2.model.Brand;
import com.example.manageproduct2.model.Status;
import com.example.manageproduct2.model.Sub_Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min=2, max=30 )
    private String produce_name;

    @NotBlank(message = "Color is mandatory")
    private String color;

    @NotBlank(message = "Quantity is mandatory")
    private Long quantity;

    @NotBlank(message = "SellPrice is mandatory")
    private Double sell_price;

    @NotBlank(message = "brands is mandatory")
    @JsonIgnoreProperties("products")
    private Set<Brand> brands;

    @NotBlank(message = "SubCate is mandatory")
    @JsonManagedReference
    private Sub_Category sub_category;

    @NotBlank(message = "OriginPrice is mandatory")
    private Double origin_price;

    @JsonManagedReference
    private Status status;
}
