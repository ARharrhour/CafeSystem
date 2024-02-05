package com.abdo.coffeesystem.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
        @NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email"),

        @NamedQuery(name = "User.getAllUser" , query = "select new com.abdo.coffeesystem.wrapper.UserWrapper(u.id , u.name , u.email , u.phoneNumber , u.status) from User u where u.role = 'user'"),

        @NamedQuery(name = "User.getAllAdmin" , query = "select u.email from User u where u.role = 'admin'"),

        @NamedQuery(name = "User.updateStatus" , query = "update User u set u.status=:status where u.id =:id")
})


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;


    private String name;


    private String phoneNumber;


    private String email;


    private String password;

    private String status;


    private String role;
}