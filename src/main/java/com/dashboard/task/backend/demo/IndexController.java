package com.dashboard.task.backend.demo;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Hidden
@Controller
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> index() {
        return ResponseEntity.ok(String.format("API Server is up. %s", LocalDateTime.now()));
    }

    @GetMapping("/docs")
    public String getDocs() {
        return "redirect:/swagger-ui.html";
    }

}
