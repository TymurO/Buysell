package com.example.buysell.dto;

import com.example.buysell.module.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class RegistrationUserDto {

    private String username;

    private String password;

    private String confirmPassword;
}
