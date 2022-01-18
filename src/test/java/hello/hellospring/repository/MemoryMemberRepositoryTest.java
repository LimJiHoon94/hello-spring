package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트가 끝날때마다 repository를 지워준다.
    @AfterEach   //메소드가 끝날때마다 실행하는 어노테이션
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);


        Member result =  repository.findByName(member.getName()).get();

       System.out.println("result = " + (result == member));
       //문법확인 필요
        //Assertions.assertEquals(member , result);
        //문법확인 필요
        //Assertions.assertThat(member).isEqualTo(result);
        Assertions.assertThat(member).isEqualTo(result);

    }


    @Test
    public void findByMember(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("spring3");
        repository.save(member3);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(3);

    }

}
