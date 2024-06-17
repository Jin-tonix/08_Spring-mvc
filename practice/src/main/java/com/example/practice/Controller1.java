package com.example.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

    // 루트 경로 또는 /index 경로로 GET 요청이 들어왔을 때 index1.jsp를 보여줌
    @RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
    public String showIndexPage() {
        return "index1"; // view의 이름을 리턴
    }

    // /submitForm 경로로 POST 요청이 들어왔을 때 실행됨
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    public ModelAndView handleSubmitForm(@RequestParam("inputData") String inputData) {
        System.out.println("전송된 데이터: " + inputData);

        // ModelAndView 객체 생성
        ModelAndView modelAndView = new ModelAndView();

        // 뷰의 이름을 설정 (WEB-INF/views/index1-1.jsp로 리다이렉트)
        modelAndView.setViewName("index1-1");

        // 전송된 데이터를 모델에 추가
        modelAndView.addObject("inputData", inputData);

        // ModelAndView 객체 반환
        return modelAndView;
    }

}
