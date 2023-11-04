package share.share.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping(path = "")
    @ResponseBody
    public String showHelloWorld() {
        return "Hello World";
    }
}
