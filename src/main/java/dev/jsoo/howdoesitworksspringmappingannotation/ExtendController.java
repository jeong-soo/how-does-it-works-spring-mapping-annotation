package dev.jsoo.howdoesitworksspringmappingannotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtendController extends RequestMappingSuperClass {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
