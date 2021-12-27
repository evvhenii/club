package com.example.club.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class ClubMemberCreationDto {
    @Pattern(regexp = "[a-zA-Z. ]+", message = "should only consist of english letters, dots, spaces, cannot be empty")
    String name;

    @Email
    @NotEmpty
    String email;
}
