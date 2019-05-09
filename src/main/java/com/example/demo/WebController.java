package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final LinkService linkService;

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
}
