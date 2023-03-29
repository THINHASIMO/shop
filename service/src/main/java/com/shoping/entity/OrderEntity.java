package com.shoping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer status;

    private Double subTotal;
    private Double itemDiscount;
    private Double tax;
    private Double shipping;
    private Double total;
    private Double discount;
    private Double grandTotal;

    private String sessionId;
    private String token;
    private String promo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String address;
    private String content;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateAt;

    //    khóa ngoại: userId
    @ManyToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity userEntity;
}
