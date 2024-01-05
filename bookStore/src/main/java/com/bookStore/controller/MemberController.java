package com.bookStore.controller;

// MemberController.java

import com.bookStore.entity.Member;
import com.bookStore.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String listMembers(Model model) {
        List<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        return "members-list";
    }

    @GetMapping("/add")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "add-member";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "add-member";
        }

        memberService.addMember(member);
        return "redirect:/members";
    }

    @GetMapping("/{id}")
    public String showMemberDetails(@PathVariable int id, Model model) {
        Optional<Member> optionalMember = memberService.getMemberById(id);

        if (optionalMember.isPresent()) {
            model.addAttribute("member", optionalMember.get());
            return "member-details";
        } else {
            return "redirect:/members";
        }
    }
}
