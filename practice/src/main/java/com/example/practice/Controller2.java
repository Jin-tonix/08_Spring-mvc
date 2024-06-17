package com.example.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*")

public class Controller2 {

    // 루트 경로 또는 /index2 경로로 GET 요청이 들어왔을 때 index2.html을 보여줌
    @GetMapping(value={"/", "/index2"})
    public String showIndexPage() { return "index2";
    }

    @GetMapping("/mission1")
    //pathValue라는 이름의 쿼리 파라미터를 받음 required = false로 설정하여 이 파라미터가 필수가 아님을 명시
    public ModelAndView mission1(ModelAndView mv, @RequestParam("pathValue") String value) {

        //만약 pathValue 파라미터가 있으면, message라는 이름으로 해당 값을 모델에 추가
        mv.addObject("message", value);

        mv.setViewName("mission1");
        return mv;
    }


}
