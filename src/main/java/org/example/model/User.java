package org.example.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;
    private Date dateOfBirth;
    private String phone;
    @Email
    private String email;
    private String address;
    private Boolean administrator;
    private Boolean active;


    @ManyToOne
    @JoinColumn(name = "list_of_purchases_id", foreignKey = @ForeignKey(name = "LIST_OF_PURCHASES_ID_FK"))
    private ListOfPurchases listOfPurchases;


}
