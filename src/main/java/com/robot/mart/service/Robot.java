package com.robot.mart.service;

import lombok.Data;

@Data
public class Robot {

    private int x;
    private int y;
    private String orientation;
    private RobotOrientation robotOrientation;

    public Robot(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.robotOrientation = new RobotOrientation(0);
    }

    public Robot move(String command) {
        if (command.equals("M")) {
            if ("N".equals(this.orientation)) this.y++;
            if ("E".equals(this.orientation)) this.x++;
            if ("S".equals(this.orientation)) this.y--;
            if ("W".equals(this.orientation)) this.y--;
        }
        return this;
    }

    public void recalculateDirection(String command){
        this.orientation = robotOrientation.recalculatePosition(command);
    }

    public boolean isInvalidPosition(){
        return this.x < 0 || this.x > 4 || this.y < 0 || this.y > 4;
    }

    public String printPosition() {
        return "(" + this.x + ", " + this.y + ", " + this.orientation + ")";
    }


}
