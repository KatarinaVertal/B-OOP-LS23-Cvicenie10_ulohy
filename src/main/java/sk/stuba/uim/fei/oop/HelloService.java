package sk.stuba.uim.fei.oop;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Getter
    private int counter;

    public HelloResponse createResponse(HelloRequestBody body) {
        return new HelloResponse(this.counter++, "hello " + body.getMeno());
    }
}
