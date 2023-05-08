package ppark.pparkproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ppark.pparkproject.domain.Member;
import ppark.pparkproject.service.MemberService;

import java.util.List;

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
    public String create(MemberForm form) { // MemberForm 객체에 /members/new/ 로 넘겨줬던 데이터가 넘어오고, 스프링이 , setName을 호출하여 자동 등록해준다!
        System.out.println(form.getName());
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); // 회원가입
        System.out.println("member = " + member.getName());

        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberlist";
    }
}
