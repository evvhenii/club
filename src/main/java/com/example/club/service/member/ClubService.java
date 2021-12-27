package com.example.club.service.member;

import com.example.club.dto.ClubMemberCreationDto;
import com.example.club.entity.ClubMember;

import java.util.List;

public interface ClubService {
    List<ClubMember> findAll();

    void save(ClubMemberCreationDto member);
}
