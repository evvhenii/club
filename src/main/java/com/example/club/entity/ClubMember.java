package com.example.club.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubMember {
    String name;

    String email;

    LocalDate creationDate;
}
