package com.example.club.service.member;

import com.example.club.entity.ClubMember;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Value
@Component
public class MemberList {
    Map<String, ClubMember> clubMemberToEmail = new ConcurrentHashMap<>();
}