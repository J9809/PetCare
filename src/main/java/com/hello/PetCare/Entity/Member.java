package com.hello.PetCare.Entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "member_id", unique = true, length = 255)
    private String member_id;

    @NonNull
    @Column(name = "nickname", unique = true, length = 20)
    private String nickname;

    //    @NonNull
//    @Column(name = "password", unique = true, length = 255)
    private String password;

    @NonNull
    @Column(name = "name", length = 10)
    private String name;

    @NonNull
    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "pet")
    private pet_type pet;


    @Override
    // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //사용자가 가지고 있는 권한 목록 반환
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    // 사용자의 id 반환(고유한값)
    public String getUsername() {
        // 사용자를 식별할 수 있는 사용자 이름 반환, 사용되는 값은 반드시 고유해야함
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        // 계정이 만료되었는지 확인
        return true; // true면 만료x
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 잠금되었는지 확인
        return true; // true:잠금x
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호과 만료되었는지 확인
        return true; // true:만료x
    }

    @Override
    public boolean isEnabled() {
        // 계정이 사용가능한지 확인
        return true; // true:사용 가능
    }
}

