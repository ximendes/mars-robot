package com.robot.mart.validations;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Component
public class InputValidations {

    public void validate(String input){
        input = input != null ? input : "";
        if(!input.matches("[MLR]+")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
        }
    }
}
