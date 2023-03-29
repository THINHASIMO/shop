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
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer admin;
    private Integer vendor;

    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String passwordHash;
    private String intro;
    private String profile;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date registeredAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date lastLogin;
}
