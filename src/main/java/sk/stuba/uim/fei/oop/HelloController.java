package sk.stuba.uim.fei.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private IGreetingsService service;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/helloCount")
    public String helloCount() {
        return "hello world";
    }

    @GetMapping("/path/{name}")
    public String helloPath(@PathVariable(name = "name") String name) {
        return "hello " + name;
    }

    @GetMapping("/param")
    public String helloParam(@RequestParam(name = "name", defaultValue = "world") String name) {
        return "hello " + name;
    }

    @PostMapping("/body")
    public HelloResponse helloBody(@RequestBody HelloRequestBody body) {
        return this.service.createResponse(body);
    }

    @PostMapping("/responseEntity")
    public ResponseEntity<HelloResponse> helloResponse(@RequestBody HelloRequestBody body) {
        return new ResponseEntity<>(this.service.createResponse(body), HttpStatus.CREATED);
    }
}

