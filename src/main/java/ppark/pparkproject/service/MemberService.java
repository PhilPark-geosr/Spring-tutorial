package ppark.pparkproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ppark.pparkproject.domain.Member;
import ppark.pparkproject.repository.MemberRepository;
import ppark.pparkproject.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //외부에서 주입되도록 !!!
//
////    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 회원가입
    public Long join(Member member) {
        // 같은이름들어가면 안된다!
        // command + alt + v 하면 결과 만들어줌
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다")
//        })


        validateDuplicatedMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    //전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById((memberId));
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다");
                        });
    }
}
