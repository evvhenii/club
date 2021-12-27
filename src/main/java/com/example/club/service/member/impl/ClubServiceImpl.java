package com.example.club.service.member.impl;

import com.example.club.exception.BadRequestException;
import com.example.club.dto.ClubMemberCreationDto;
import com.example.club.entity.ClubMember;
import com.example.club.service.member.ClubService;
import com.example.club.service.member.MemberList;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClubServiceImpl implements ClubService {
    MemberList memberList;

    @Override
    public List<ClubMember> findAll() {
        return new ArrayList<>(
                memberList.getClubMemberToEmail().values()
        );
    }

    @Override
    public void save(ClubMemberCreationDto member) {
        if (memberList.getClubMemberToEmail().containsKey(member.getEmail())) {
            throw new BadRequestException("Email is being used already");
        }

        memberList.getClubMemberToEmail().put(
                member.getEmail(),
                ClubMember.builder()
                        .name(member.getName())
                        .email(member.getEmail())
                        .creationDate(LocalDate.now())
                        .build()
        );
    }
}
