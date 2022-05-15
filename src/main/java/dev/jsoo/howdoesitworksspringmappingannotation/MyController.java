package dev.jsoo.howdoesitworksspringmappingannotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class MyController extends SuperController implements MyInterface{
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
