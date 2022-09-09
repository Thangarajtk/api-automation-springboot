package com.example.api.automation.mathservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/add/{n1}/{n2}")
    public Response add(@PathVariable int n1, @PathVariable int n2) {
        return new Response(n1, n2, n1 + n2);
    }
}
