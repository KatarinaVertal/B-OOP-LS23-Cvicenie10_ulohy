package sk.stuba.uim.fei.oop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/path/{name}")
    public HelloResponse helloPath(@PathVariable(name = "name") String name) {
        return new HelloResponse(this.counter++, "hello " + name);
    }

    @GetMapping("/param")
    public HelloResponse helloParam(@RequestParam(name = "name", defaultValue = "world") String name) {
        return new HelloResponse(this.counter++, "hello " + name);
    }
}

