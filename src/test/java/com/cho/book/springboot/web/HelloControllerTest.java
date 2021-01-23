package com.cho.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)   //스프링부트와 JUint 사이에 연결자 역할
@WebMvcTest  //Controller, Advice 사용 가능
public class HelloControllerTest {

    @Autowired   // 스프링이 관리하는 Bean을 생성
    private MockMvc mvc;   // 웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴되다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))   // HTTP Get요청
                .andExpect(status().isOk())   // 결과 상태를 검증
                .andExpect(content().string(hello));   // 결과를 검증
    }

    @Test
    public void helloDto가_리턴되다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)   // API 테스트할 떄 사용될 요청 파라미터 설정
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))   // $필드명 표시
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
