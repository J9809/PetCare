package com.hello.PetCare.service;


import com.hello.PetCare.Entity.Member;
import com.hello.PetCare.Entity.pet_type;
import com.hello.PetCare.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class                                                                                                                                                                                                                                                        MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    // member_id, nickname, password, name, email, pet
    public Member createMember(String member_id, String nickname, String password, String name, String email, pet_type Pet){
        Member member = new Member();
        member.setMember_id(member_id);
        member.setNickname(nickname);
        member.setPassword(passwordEncoder.encode(password));
        member.setName(name);
        member.setEmail(email);
        member.setPet(pet_type.jindo);
        this.memberRepository.save(member);
        return member;
    }

}

