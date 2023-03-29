package ppark.pparkproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ppark.pparkproject.domain.Member;
import ppark.pparkproject.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 이건 어쩔수 없이 컴포넌트 스캔으로 해줘야함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        System.out.println(form.getName());
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
