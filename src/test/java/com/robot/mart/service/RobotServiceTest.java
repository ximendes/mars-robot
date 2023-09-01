package com.robot.mart.service;

import com.robot.mart.validations.PositionValidations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotServiceTest {

    private RobotService robotService;

    @BeforeEach
    public void setup() {
        var validation = new PositionValidations();
        this.robotService = new RobotService(validation);
    }

    @Test
    @Description("Should return (0, 2, W) when value is MML")
    public void testCase1() {
        String result = robotService.solution("MML");
        assertEquals("(0, 2, W)", result);
    }

    @Test
    @Description("Should return (2, 0, S) when value is MMRMMRMM")
    public void testCase2() {
        String result = robotService.solution("MMRMMRMM");
        assertEquals("(2, 0, S)", result);
    }

    @Test
    @Description("Should return (1, 1, E) when value is MMMRRMMLM")
    public void testCase3() {
        String result = robotService.solution("MMMRRMMLM");
        assertEquals("(1, 1, E)", result);
    }

    @Test
    public void testCase4() {
        String result = robotService.solution("RRRRRRRRRRRRR");
        assertEquals("(0, 0, E)", result);
    }

    @Test
    public void testCase5() {
        String result = robotService.solution("LLLLL");
        assertEquals("(0, 0, W)", result);
    }


}