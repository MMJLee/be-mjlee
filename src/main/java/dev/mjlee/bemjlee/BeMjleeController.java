package dev.mjlee.bemjlee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeMjleeController {

  @CrossOrigin(value = "*")
  @GetMapping(value = "/health")
  public ResponseEntity<?> health() throws Exception {
    try {
      return ResponseEntity.status(200).body("Ok");
    } catch (Exception e) {
      return (ResponseEntity<?>) ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
}