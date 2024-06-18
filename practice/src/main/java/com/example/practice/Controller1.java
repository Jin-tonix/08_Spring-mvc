package com.example.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

    // 루트 경로 또는 /index 경로로 GET 요청이 들어왔을 때 index1.html을 보여줌
    @GetMapping(value={"/", "/index"})
    public String showIndexPage() {
        return "index1"; // view의 이름을 리턴
    }

    // /submitForm 경로로 POST 요청이 들어왔을 때 실행됨
    @PostMapping("/submitForm")
    public ModelAndView handleSubmitForm(@RequestParam("inputData") String inputData) {
        System.out.println("전송된 데이터: " + inputData);

        // ModelAndView 객체 생성
        ModelAndView modelAndView = new ModelAndView();

        // 뷰의 이름을 설정 (index1-1.html로 리다이렉트)
        modelAndView.setViewName("redirect:/index1-1");

        // 전송된 데이터를 모델에 추가
        modelAndView.addObject("userInput", inputData);

        // ModelAndView 객체 반환
        return modelAndView;
    }

    // index1-1.html를 보여주기 위한 메서드
    @GetMapping("/index1-1")
    public String showIndex1_1Page(@RequestParam(value = "userInput", required = false) String userInput, Model model) {
        // 모델에 데이터 추가
        model.addAttribute("userInput", userInput);
        return "index1-1"; // view의 이름을 리턴
    }
}
