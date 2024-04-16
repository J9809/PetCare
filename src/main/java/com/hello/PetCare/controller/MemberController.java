package com.hello.PetCare.controller;


import com.hello.PetCare.Entity.pet_type;
import com.hello.PetCare.service.MemberService;
import com.hello.PetCare.user.MemberCreateForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("MemberCreateForm", new MemberCreateForm());
        model.addAttribute("pets", pet_type.values());
        return "member_signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "member_signup_form";
        }

        if (!memberCreateForm.getPassword1().equals(memberCreateForm.getPassword2())){
            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            return "member_signup_form";
        }

        memberService.createMember(memberCreateForm.getMember_id(), memberCreateForm.getNickname(), memberCreateForm.getPassword1(), memberCreateForm.getName(), memberCreateForm.getEmail(), memberCreateForm.getPet());
        redirectAttributes.addFlashAttribute("signupSuccess", "회원가입에 성공했습니다.");;

        return "redirect:/";
    }
}

