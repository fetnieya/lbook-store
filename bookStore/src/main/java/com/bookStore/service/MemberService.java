package com.bookStore.service;


import com.bookStore.entity.Member;
import com.bookStore.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(int memberId) {
        return memberRepository.findById(memberId);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }




}
