package com.example.myfirstfullstackwebsite.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category category;

    public Category id(Long id) {
        this.id = id;
        return this;
    }

    public Category name(String name) {
        this.name = name;
        return this;
    }

    public Category category(Category category) {
        this.category = category;
        return this;
    }

}
