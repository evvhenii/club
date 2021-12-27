package com.example.club.controller;

import com.example.club.dto.ClubMemberCreationDto;
import com.example.club.service.member.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static lombok.AccessLevel.PRIVATE;

@Controller
@RequestMapping("members")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ClubMemberController {
    ClubService clubService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute(
                "allMembers",
                clubService.findAll()

        );

        return "members-records";
    }

    @PostMapping
    public String post(@Validated ClubMemberCreationDto clubMemberDto) {
        clubService.save(clubMemberDto);

        return "redirect:/members";
    }
}
