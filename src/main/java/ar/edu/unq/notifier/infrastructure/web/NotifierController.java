package ar.edu.unq.notifier.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotifierController {

    @PostMapping
    public ResponseEntity<String> createUser() {
        return ResponseEntity.ok("OK");
    }

}
