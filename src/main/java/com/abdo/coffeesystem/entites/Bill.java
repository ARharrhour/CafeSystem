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
       @NamedQuery(name = "Bill.getAllBills" , query = "select b from Bill b order by b.id desc"),
        @NamedQuery(name = "Bill.getBillByUserName" , query = "select b from Bill b where b.createdBy=:username order by b.id desc")
})


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate

public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String uuid;


    private String name;


    private String email;


    private String phoneNumber;


    private String paymentMethod;


    private Integer total;

    @Column(columnDefinition = "json")
    private String productDetails;


    private String createdBy;

}