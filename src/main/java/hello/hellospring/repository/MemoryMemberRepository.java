package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
//의존성 주입
//@Repository
public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long , Member> store = new HashMap<>();
    private static long sequence = 0L;

    //의존성 주입
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { //문법확인 필요

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //문법확인 필요
        return  store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }


}
