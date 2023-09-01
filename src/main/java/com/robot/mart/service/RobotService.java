package com.robot.mart.service;


import com.robot.mart.validations.PositionValidations;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RobotService {

    @Autowired
    private PositionValidations positionValidations;
    public String solution(String input) {
        var robot = new Robot(0, 0, "N");

        for (String command : input.split("")) {
            robot.move(command)
                 .recalculateDirection(command);
        }
        positionValidations.validate(robot);
        return robot.printPosition();
    }
}
