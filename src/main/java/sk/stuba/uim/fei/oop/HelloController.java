package sk.stuba.uim.fei.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService service;

    @GetMapping("/{name}")
    public HelloResponse helloName(@PathVariable(name = "name") String name) {
        HelloRequestBody body = new HelloRequestBody(name);
        return this.service.createResponse(body);
    }

    @GetMapping("/param")
    public HelloResponse helloParam(@RequestParam(name = "name", defaultValue = "world") String name) {
        HelloRequestBody body = new HelloRequestBody(name);
        return this.service.createResponse(body);
    }

    @PostMapping("/body")
    public HelloResponse helloBody(@RequestBody HelloRequestBody body) {
        return this.service.createResponse(body);
    }

}
