package com.example.cab_book_driver.controller;

import com.example.cab_book_driver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/cab-location")
@RestController
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity updateLocation() {
        int range = 100;
        while(range > 0){
            //System.out.println(Math.random()+","+Math.random());
            cabLocationService.updateLocation(Math.random()+","+Math.random());
            range--;
        }
        return  new ResponseEntity<>(Map.of("message","Updated location"),HttpStatus.OK);
    }

}
