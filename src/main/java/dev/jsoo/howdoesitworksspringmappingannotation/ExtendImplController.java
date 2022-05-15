package dev.jsoo.howdoesitworksspringmappingannotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtendImplController extends RequestMappingSuperClass implements MyInterface{
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
