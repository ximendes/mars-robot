package com.robot.mart.validations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidationsTest {

    private InputValidations inputValidations;

    @BeforeEach
    public void setup() {
        this.inputValidations = new InputValidations();
    }

    @Test
    @Description("Should validate when value is null")
    public void testCase1() {
        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> inputValidations.validate(null),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should validate when value is blank")
    public void testCase2() {
        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> inputValidations.validate(""),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should validate when value is AAAAAA")
    public void testCase3() {
        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> inputValidations.validate("AAAAAA"),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should validate when value is MMAAL")
    public void testCase4() {
        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> inputValidations.validate("MMAAL"),
                "Expected error to throw, but it didn't"
        );

        assertTrue(Objects.requireNonNull(thrown.getMessage()).contains("Invalid request"));
    }

    @Test
    @Description("Should not throw validate when value is MML")
    public void testCase5() {
        assertDoesNotThrow(() -> inputValidations.validate("MML"), "Doesn't expected error to throw, but it didn't!");
    }

    @Test
    @Description("Should not throw validate when value is MMRMMRMM")
    public void testCase6() {
        assertDoesNotThrow(() -> inputValidations.validate("MMRMMRMM"), "Doesn't expected error to throw, but it didn't!");
    }

}