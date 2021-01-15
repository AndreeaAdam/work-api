package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String address;
    private Boolean administrator;
    private Boolean active;
    private Long listOfPurchasesId;
}
