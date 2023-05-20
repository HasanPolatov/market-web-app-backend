package com.example.myfirstfullstackwebsite.dtos;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Long categoryId;

    public ProductDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }


}
