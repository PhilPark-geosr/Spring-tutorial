package ppark.pparkproject.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ppark.pparkproject.domain.Member;
import ppark.pparkproject.repository.MemberRepository;
import ppark.pparkproject.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 부트 테스트
@Transactional // 테스트가 끝나면 테스트를 위해 넣었던 데이터를 넣었다고 롤백해준다
class MemberServiceIntegrationTest {


//    MemberService memberService= new MemberService();
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository(); //이렇게 하면 다른 DB가 2개 생기는 것임

    //해결책 --> DI(Dependency injection)
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    // @Transactional 덕분에 필요 없어짐
    //    @AfterEach // 메소드가 실행되고 나서 한번씩 꼭 호출되는 함수
//    public void afterEach() {
//        memberRepository.clearStore();
//    }
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring2");

        //when
        Long saveId = memberService.join(member);

        // 저장한게 리포지토리에 있는게 맞아? 를 확인해야 함

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원검증() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        // v1
//        try {
//            memberService.join(member2); //이러면 예외가 터져야됨
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        } 
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}