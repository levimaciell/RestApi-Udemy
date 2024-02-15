package com.levi.spring.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.levi.spring.math.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
    
    @RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2) throws Exception{

        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(num1) + convertToDouble(num2);
    }

    @RequestMapping(value = "/subtraction/{num1}/{num2}", method = RequestMethod.GET)
    public Double subtraction(
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2) throws Exception{

        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(num1) - convertToDouble(num2);
    }

    @RequestMapping(value = "/multiply/{num1}/{num2}", method = RequestMethod.GET)
    public Double multiply(
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2) throws Exception{

        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(num1) * convertToDouble(num2);
    }

    @RequestMapping(value = "/divide/{num1}/{num2}", method = RequestMethod.GET)
    public Double divide(
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2) throws Exception{

        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(num1) / convertToDouble(num2);
    }

    @RequestMapping(value = "/avg/{num1}/{num2}", method = RequestMethod.GET)
    public Double avg(
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2) throws Exception{

        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(num1) + convertToDouble(num2)) / 2;
    }

    @RequestMapping(value = "/sqrt/{num1}", method = RequestMethod.GET)
    public Double sqrt(
        @PathVariable(value = "num1") String num1) throws Exception{

        if(!isNumeric(num1)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(num1));
    }

    private Double convertToDouble(String num) throws Exception {
        if(num == null) throw new Exception();
        String number = num.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        else throw new Exception();
    }

    private boolean isNumeric(String num) throws Exception {
        if(num == null) throw new Exception();
        String number = num.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
