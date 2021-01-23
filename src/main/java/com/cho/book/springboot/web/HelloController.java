package com.cho.book.springboot.web;

import com.cho.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 변경
public class HelloController {

    @GetMapping("/hello")  // HTTP Method인 Get의 요청을 받을 수 있는 API를 제작
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,   // 외부에서 API로 넘긴 파라미터 가져오기
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
