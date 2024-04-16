package com.hello.PetCare.user;

import com.hello.PetCare.Entity.pet_type;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateForm {
    @Size(min = 2, max = 30)
    @NotEmpty(message = "사용자ID는 필수 항목입니다.")
    private String member_id;

    @Size(min = 2, max = 20)
    @NotEmpty(message = "닉네임 필수 항목입니다.")
    private String nickname;

    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
    private String password2;

    @NotEmpty(message = "이름 필수 항목입니다.")
    private String name;

    @NotNull(message = "애완견 종류 필수 항목입니다.")
    private pet_type pet;
    //private String pet;


    @NotEmpty(message = "이메일은 필수 항목입니다.")
    @Email
    private String email;


}
