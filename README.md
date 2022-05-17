# 스프링 RequestMapping 어노테이션 상속에 따른 우선순위 확인


```java
@RestController
@RequestMapping("/controller")
public class MyController extends RequestMappingSuperClass implements MyInterface {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}

@RequestMapping("/super-controller")
public abstract class RequestMappingSuperClass { }

@RequestMapping("/interface")
public interface MyInterface extends SuperInterface { }

@RequestMapping("super-interface")
public interface SuperInterface { }
```
/controller/hello 유효

<br>
<br>

Controller에 @RequestMapping 어노테이션을 제거 후
```java
@RestController
public class ExtendImplController extends RequestMappingSuperClass implements MyInterface{
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```
/super-interface/hello 유효

<br>
<br>

implements 없이 상속만 진행한 경우에는
```java
@RestController
public class ExtendController extends RequestMappingSuperClass {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```
/super-controller/hello 유효

RequestMapping과 같이 어노테이션에 value가 있는 경우 extends, implements 주의 필요 
<br>
<br>
<br> 
<br> 
<br>

해당 테스트는 <br>
open-jdk 11 <br>
spring boot 2.6.7 환경에서 테스트 진행하였습니다. 
<br>
<br>
<br>
<br>
<br>
**Oracle Code Seoul 2017 - Java 9과 Spring 5로 바라보는 Java의 변화와 도전**의 내용을 참고하였습니다.
