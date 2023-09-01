package com.robot.mart.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RobotOrientation {

    private static final String[] orientations = {"N", "E", "S", "W"};
    private int position;

    public String recalculatePosition(String command){
        if("R".equals(command)) this.position++;
        if("L".equals(command)) this.position--;
        return getNextPosition(position);
    }

    private String getNextPosition(int position){
        var index = calculateNegativePosition(position);
        index = calculatePositivePosition(index);
        return orientations[index];
    }
    private Integer calculateNegativePosition(int position) {
        var number = position < 0 ? position + 4 : position;
        return number < 0 ? calculateNegativePosition(number) : number;
    }

    private Integer calculatePositivePosition(int position) {
        var number = position > 3 ? position + -4 : position;
        return number > 3 ? calculatePositivePosition(number) : number;
    }
}
