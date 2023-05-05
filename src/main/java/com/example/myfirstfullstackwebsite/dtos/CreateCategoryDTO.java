package com.example.myfirstfullstackwebsite.dtos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCategoryDTO {

    private Long id;
    private String name;
    private Long parentId;

}
