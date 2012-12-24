package nl.codecentric.training.tdd.web;

import lombok.Getter;
import lombok.Setter;
import nl.codecentric.training.tdd.service.TriangleCalculatorService;
import nl.codecentric.training.tdd.web.form.TriangleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("/triangle")
public class TriangleController {


    @Getter
    @Setter
    private String triangleSide1,triangleSide2,triangleSide3;

    @Getter
    private final TriangleCalculatorService triangleCalculatorService;

    @Autowired
    public TriangleController(TriangleCalculatorService triangleCalculatorService){
        this.triangleCalculatorService = triangleCalculatorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model){
        model.addAttribute("triangleForm",getTriangleForm());
        return "triangle/index";
    }

    public TriangleForm getTriangleForm() {
        return new TriangleForm();
    }

    @RequestMapping(value = "/calculate",method = RequestMethod.POST)
    public String calculate(@ModelAttribute("triangleForm") @Valid TriangleForm triangleForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return "triangle/calculate";
        }
        triangleCalculatorService.calculateTriangleType(triangleForm.getTriangleSide1(),triangleForm.getTriangleSide2(),triangleForm.getTriangleSide3());
        return "redirect:/triangle";
    }




}
