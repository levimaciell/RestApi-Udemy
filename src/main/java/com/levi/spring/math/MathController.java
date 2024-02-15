package com.levi.spring.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    
    @RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2) throws Exception{

        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new Exception();
        }
        return convertToDouble(num1) + convertToDouble(num2);
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
