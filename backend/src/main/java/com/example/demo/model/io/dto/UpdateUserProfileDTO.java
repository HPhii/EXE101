package com.example.demo.model.io.dto;

import com.example.demo.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserProfileDTO {
    private String fullName;
    private String phoneNumber;
    private LocalDate birthdate;
    private Gender gender;
    private String username;
    private String email;
    private String avatarUrl;
}
