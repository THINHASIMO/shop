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
@Table(name = "TRANSACTION")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer type;
    private Integer mode;
    private Integer status;

    private String code;
    private String content;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateAt;

    //    khóa ngoại: userId, orderId
    @ManyToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity userEntity;

    @ManyToOne(targetEntity = OrderEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private OrderEntity orderEntity;
}
