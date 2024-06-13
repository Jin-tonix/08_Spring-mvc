package com.example.chapt01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/*
* 클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다.
* 클래스레벨에 url을 공통 부분을 이용해 설정하고 나면 매번 핸들러 메소드에 url의 중복되는 내용은 작성하지 않아도 된다.
* 이 때 와일드 카드를 이용해서 조금 더 포괄적인 url패턴을 설정할 수 있다
 */
@Controller
@RequestMapping("/orders/*")
public class ClassMappingTestController {

    // Class 레벨 매핑
    @GetMapping("/")
    public String regist(Model model) {
        model.addAttribute("message", "get 방식의 주문 등록용 핸들러 메소드를 호출함");
        return "mappingResult";
    }

    // 여러 개의 패턴 매핑
    // value 속성에 중괄호를 이용해 매핑할 url을 나열한다.
    @RequestMapping(value={"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {
        model.addAttribute("message", "post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함");
        return "mappingResult";
    }
}