package ppark.pparkproject.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ppark.pparkproject.domain.Member;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메소드가 실행되고 나서 한번씩 꼭 호출되는 함수
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member); //저장
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
        System.out.printf("%s, %s",result, member);
//        Assertions.assertEquals(result, member);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

//        Optional<Member> result = repository.findByName("spring1");
        Member result = repository.findByName("spring1").get(); // Optional을 꺼내줄 수 있다

        System.out.println(result.getName());
        Assertions.assertThat(result).isEqualTo(member1);

    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        System.out.println(result);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}
