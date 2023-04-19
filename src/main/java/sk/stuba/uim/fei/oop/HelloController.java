package sk.stuba.uim.fei.oop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/body")
    public HelloResponse helloBody(@RequestBody HelloRequestBody body) {
        return new HelloResponse(this.counter++, "hello " + body.getMeno());
    }

    @PostMapping("/responseEntity")
    public ResponseEntity<HelloResponse> helloResponse(@RequestBody HelloRequestBody body) {
        return new ResponseEntity<>(
                new HelloResponse(this.counter++, "hello " + body.getMeno()), HttpStatus.CREATED);
    }
}

