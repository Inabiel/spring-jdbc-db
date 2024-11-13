package com.example.springjdbcdb.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
public class CustomerDTO {
    @NotBlank(message = "First Name is Required!")
    String firstName;

    @NotBlank(message = "Last Name is Required!")
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
