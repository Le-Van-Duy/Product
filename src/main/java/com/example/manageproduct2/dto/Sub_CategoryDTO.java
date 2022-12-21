package com.example.manageproduct2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sub_CategoryDTO {
    private Long id;
    private String sub_cate_code;
    private String sub_cate_name;
}
