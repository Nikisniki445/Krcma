package com.example.demo.controller;


import com.example.demo.application.AppendService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomController {

    private final AppendService appendService;

    public CustomController(AppendService appendService) {
        this.appendService = appendService;
    }

    @GetMapping("/hello")
    public String testWorld() {
        return "Hello Mommy!!!";
    }

    @GetMapping("/appe")
    public String appendValue() {
        return appendService.appendTextValue("value");
    }

    @GetMapping("/append")
    public String appendValue(@RequestParam(name = "value") String value) {
        return appendService.appendTextValue(value);
    }
    @GetMapping("/append/{text}") public String sayHello(@PathVariable(value = "text")String text)
    { return "Servus " + appendService.append(text); }


}
