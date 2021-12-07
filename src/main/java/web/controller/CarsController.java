package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final List<Car> cars = Arrays.asList(
            new Car("Mazda",1772,(short) 2015),
            new Car("Nissan",1211,(short) 2018),
            new Car("Mitsubishi",2089,(short) 2019),
            new Car("Lexus",5000,(short) 2021),
            new Car("Ford",350,(short) 1998));

    @Autowired
    private CarService carService;

    @GetMapping
    public String printAllCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> listCars = carService.getCars(cars, count);
        model.addAttribute("listCars",listCars);
        return "cars";
    }
}
