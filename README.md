# 스프링 RequestMapping 어노테이션이 부모 클레스 및 인터페이스에 있을때 어떤 어노테이션이 적용될까요?

이런 생각 해본적 없으신가요? <br>
스프링 RequestMapping 어노테이션이 상속받는 부모 클레스나 인터페이스에 있으면 어떻게 동작하지?

아래와 같은 코드가 있을때 어떤 어노테이션이 유효할까요?
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
결과는 /controller/hello 만 유효했습니다.

<br>
<br>

그러면 Controller에 @RequestMapping 어노테이션을 제거하면 어떤 어노테이션이 작동할까요?
```java
@RestController
public class ExtendImplController extends RequestMappingSuperClass implements MyInterface{
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```
결과는 /super-interface/hello가 유효했습니다.

<br>
<br>

상속만 진행한 경우에는
```java
@RestController
public class ExtendController extends RequestMappingSuperClass {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```
/super-controller/hello 로 정상적으로 호출이 가능했습니다.

위와 같이 어노테이션을 적용한 클래스나 인터페이스를 상속받는 경우에는, 
컴파일러가 경고하지 않으니 휴먼에러에 주의를 해야합니다.
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