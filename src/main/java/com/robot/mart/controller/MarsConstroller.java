package com.robot.mart.controller;

import com.robot.mart.service.RobotService;
import com.robot.mart.validations.InputValidations;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
@NoArgsConstructor
public class MarsConstroller {

    @Autowired
    private RobotService robotService;
    @Autowired
    private InputValidations inputValidations;

    @GetMapping("/mars/{input}")
    public ResponseEntity<String> teste(@PathVariable("input") String input) {
        inputValidations.validate(input);
        String result = robotService.solution(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }





}
