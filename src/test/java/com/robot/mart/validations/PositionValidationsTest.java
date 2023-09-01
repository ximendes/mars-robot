package com.robot.mart.validations;

import com.robot.mart.service.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class PositionValidationsTest {


    private PositionValidations positionValidations;

    @BeforeEach
    public void setup() {
        this.positionValidations = new PositionValidations();
    }

    @Test
    @Description("Should validate when position x is negative")
    public void testCase1() {
        var robot = new Robot(-1, 0, "N");

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> positionValidations.validate(robot),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should validate when position x is greater then 4")
    public void testCase2() {
        var robot = new Robot(5, 0, "N");

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> positionValidations.validate(robot),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should validate when position y is negative")
    public void testCase3() {
        var robot = new Robot(0, -1, "N");

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> positionValidations.validate(robot),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should validate when position y is greater then 4")
    public void testCase4() {
        var robot = new Robot(0, 5, "N");

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> positionValidations.validate(robot),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should not validate")
    public void testCase5() {
        var robot = new Robot(0, 2, "W");
        assertDoesNotThrow(() -> positionValidations.validate(robot), "Doesn't expected error to throw, but it didn't!");
    }



}