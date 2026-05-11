package com.back.p13305.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;


    public void register(String userId, String password, String passwordConfirm) {
        if (memberRepository.existsByUserId(userId)) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        if (!password.equals(passwordConfirm)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        Member member = new Member(userId, password);

        memberRepository.save(member);
    }
}
