package com.example.myfirstfullstackwebsite.dtos;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductDTOResponse {

    private Long id;
    private String name;
    private BigDecimal price;
    private String categoryName;

}
