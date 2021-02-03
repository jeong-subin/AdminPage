package com.fast.study.controller;

import com.fast.study.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {
    //html <form>
    //ajax 검색
    //http post body => data
    //json,xml,multipart-form /text-plain
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
             return searchParam;
        }
}
