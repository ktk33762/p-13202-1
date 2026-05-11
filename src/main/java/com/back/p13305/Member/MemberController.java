package com.back.p13305.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String registerForm() {
        return "member/register";
    }

    @PostMapping("/member/register")
    public String register(@RequestParam String userId,
                           @RequestParam String password,
                           @RequestParam String passwordConfirm) {
        memberService.register(userId, password, passwordConfirm);
        return "redirect:/article/list";
    }
}