
package com.example.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/compute")
    public double compute(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {

        return switch (operation) {
            case "add" -> num1 + num2;
            case "subtract" -> num1 - num2;
            case "multiply" -> num1 * num2;
            case "divide" -> num2 != 0 ? num1 / num2 : 0;
            default -> 0;
        };
    }
}
