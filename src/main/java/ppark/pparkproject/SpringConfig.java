package ppark.pparkproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppark.pparkproject.repository.JdbcMemberRepository;
import ppark.pparkproject.repository.JdbcTemplateMemberRepository;
import ppark.pparkproject.repository.MemberRepository;
import ppark.pparkproject.repository.MemoryMemberRepository;
import ppark.pparkproject.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean //스프링 빈에 등록해라!
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository(); // Mememory에 데이터를 올릴경우 로직
//        return new JdbcMemberRepository(dataSource); // 순수 jdbc
        return new JdbcTemplateMemberRepository(dataSource);
    }


}
