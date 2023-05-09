package ppark.pparkproject;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppark.pparkproject.repository.JpaMemberRepository;
import ppark.pparkproject.repository.MemberRepository;
import ppark.pparkproject.repository.MemoryMemberRepository;
import ppark.pparkproject.service.MemberService;

@Configuration
public class SpringConfig {

    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean //스프링 빈에 등록해라!
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }


}
