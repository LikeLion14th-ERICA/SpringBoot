package com.lielion.PBL;

import com.lielion.PBL.member.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PblApplication.class, args);

		// Bean 가져오기 테스트
		MemberService service = context.getBean(MemberService.class);
		System.out.println("서비스 가져오기 성공: " + service);

		// 보너스 2: 등록된 Bean 목록 출력
		 String[] beanNames = context.getBeanDefinitionNames();
		 System.out.println("=== 등록된 Bean 목록 ===");
		 for (String name : beanNames) {
		     System.out.println("Bean: " + name);
		 }
	}
}
