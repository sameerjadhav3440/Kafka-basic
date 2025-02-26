package com.deliveryboy.Controller;

import com.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class KafkaController {

    @Autowired
    private KafkaService service;
    @PostMapping("/update")
    public ResponseEntity<?> updatelocation(){

        for(int i=1; i<100000;i++) {
            service.updateLocation("(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + ")");
        }
        return new ResponseEntity<>(Map.of("Message","update location successfully"), HttpStatus.OK);
    }
}
