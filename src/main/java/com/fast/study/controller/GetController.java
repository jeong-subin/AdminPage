package com.fast.study.controller;

import com.fast.study.model.SearchParam;
import com.fast.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController // 이곳을 컨트롤러로 사용할 거라고 알려줌
@RequestMapping("/api") //localhost:8081/api

public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")//localhost:8081/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }
    @GetMapping("/getParameter")//localhost:8081/api/getParameter?id=abcd&pass=1234
    public String getParameter(@RequestParam String id, @RequestParam(name="pass") String pwd){
        String pass ="bbbb";
        System.out.println("id : "+id);
        System.out.println("pwd :"+pwd);
        return id+pwd;
    }

    //localhost:8081/api/multiparameter?account=abcd&email=study@gmail.com%page=10
    //객체를 통한 검색파라미터 받기
 /*   @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }*/
    //localhost:8081/api/multiparameter?account=abcd&email=study@gmail.com%page=10
    //객체를 통한 검색파라미터 받기
    //객체를 리턴한다는 이야기는 json 형태로 바꿔달라는 이야기다

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
//    {"account" : "", "email" : "", "page" : 0}
      return searchParam;
   }
    @GetMapping("/header")
    public Header getHeader(){
        //{"resultCode:"Ok", "description" : "Ok"}
        return Header.builder().resultCode("OK").description("OK").build();
   }
}
