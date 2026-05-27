package com.lielion.PBL.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 보너스 3: @Controller vs @RestController 비교
// 이 파일은 비교용 예시입니다. 실제 사용 시 HelloController와 충돌하므로 하나만 활성화하세요.

// @Controller  // 주석 해제하면 활성화
public class HelloControllerWithController {

    // @Controller만 사용하면 뷰 이름을 반환한다고 간주함
    // 문자열을 그대로 반환하려면 @ResponseBody가 필요함
    @GetMapping("/hello2")
    @ResponseBody
    public String hello() {
        return "Hello, Likelion!";
    }

    // @ResponseBody 없이 사용하면?
    // "hello-view"라는 이름의 템플릿 파일을 찾으려고 시도함
    // @GetMapping("/hello-view")
    // public String helloView() {
    //     return "hello-view";  // templates/hello-view.html 을 찾음
    // }
}

/*
정리:
- @RestController = @Controller + @ResponseBody
- @Controller: 뷰 이름을 반환 (템플릿 엔진 사용 시)
- @RestController: 데이터를 그대로 반환 (REST API 용)
*/
