package com.lielion.PBL.member.config;

import com.lielion.PBL.member.repository.MemberRepository;
import com.lielion.PBL.member.repository.MemoryMemberRepository;
import com.lielion.PBL.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Step 2에서 자동 주입으로 전환할 때 주석 처리
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
