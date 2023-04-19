package sk.stuba.uim.fei.oop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private int counter;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/helloCount")
    public HelloResponse helloCount() {
        return new HelloResponse(this.counter++, "hello world");
    }
}

