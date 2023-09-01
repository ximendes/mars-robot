package com.robot.mart.validations;

import com.robot.mart.service.Robot;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Component
public class PositionValidations {

    public void validate(Robot robot){
        if(robot.isInvalidPosition()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
        }
    }
}
