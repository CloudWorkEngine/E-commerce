package com.ecommerce.user.model;

import com.ecommerce.user.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @Column(name="user_id")
    private String id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String city;

    @Column(name="signup_date")
    private Date signupDate;

}
