package ppark.pparkproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppark.pparkproject.repository.MemberRepository;
import ppark.pparkproject.repository.MemoryMemberRepository;
import ppark.pparkproject.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean //스프링 빈에 등록해라!
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


}
