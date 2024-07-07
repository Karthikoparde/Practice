package com.wipro.bus.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {

    private Long userId;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotNull(message = "Address cannot be null")
    @Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters")
    private String address;

    // Default constructor
    public UserDTO() {
    }

    // Parameterized constructor
    public UserDTO(String name, String email, String password, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
