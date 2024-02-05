package com.abdo.coffeesystem.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "Product.getAllProduct", query = "select new com.abdo.coffeesystem.wrapper.ProductWrapper(u.id , u.name , u.description , u.price , u.category.id , u.category.name , u.status) from Product u"),

        @NamedQuery(name = "Product.updateProductStatus" , query = "update Product u set u.status =:status where u.id =:id"),

        @NamedQuery(name = "Product.getByCategory", query = "select new com.abdo.coffeesystem.wrapper.ProductWrapper(u.id , u.name , u.description , u.price , u.category.id , u.category.name , u.status  ) from Product u where u.category.id=:id and u.status='true'"),

        @NamedQuery(name = "Product.getProductById", query = "select new com.abdo.coffeesystem.wrapper.ProductWrapper(u.id , u.name , u.description , u.price) from Product u where u.id=:id")

})


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Integer price;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk", nullable = false)
    private Category category;

}