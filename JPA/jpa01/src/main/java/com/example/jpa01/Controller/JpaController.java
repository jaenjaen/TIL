package com.example.jpa01.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JpaController {

    @GetMapping("/")
    public ResponseEntity Sample(){
        return new ResponseEntity("Hello,World!", HttpStatus.OK);
    }
}
