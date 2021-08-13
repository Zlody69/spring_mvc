package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/cars")
    public String carController(@RequestParam(value = "count",required = false)Integer count, ModelMap model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("nissan","note",2012));
        carList.add(new Car("opel", "omega",1996));
        carList.add(new Car("toyota", "fielder",2005));
        carList.add(new Car("tesla", "model s",2020));
        carList.add(new Car("honda", "vezel",2012));
        CarService carService = new CarService(carList);
        if (count==null){
            model.addAttribute("carLists", carList);
        }else{
            model.addAttribute("carLists", carService.getNumbCarList(count));
        }
        return "cars";
    }

}