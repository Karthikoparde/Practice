package com.wipro.bus.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BusOperatorDTO {

    @NotNull(message = "Operator ID cannot be null")
    private Long operatorId;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    // Default constructor
    public BusOperatorDTO() {
    }

    // Parameterized constructor
    public BusOperatorDTO(Long operatorId, String name, String email, String password, String phoneNumber) {
        this.operatorId = operatorId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}