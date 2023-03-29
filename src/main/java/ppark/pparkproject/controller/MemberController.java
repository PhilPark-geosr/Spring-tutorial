package ppark.pparkproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ppark.pparkproject.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 이건 어쩔수 없이 컴포넌트 스캔으로 해줘야함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
