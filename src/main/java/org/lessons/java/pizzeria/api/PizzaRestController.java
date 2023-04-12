package org.lessons.java.pizzeria.api;

import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/pizzas")
public class PizzaRestController {
    @Autowired
    private PizzaService pizzaService;
    //lista tutte le pizze
    @GetMapping
    public List<Pizza> list(@RequestParam(name = "q")Optional<String> search){
        if (search.isPresent()){
            return pizzaService.getFilteredPizzas(search.get());
        }
        return pizzaService.getAllPizzas();
    }
    //singola pizza
    @GetMapping("/{id}")
    public Pizza getById(@PathVariable Integer id){
        try {
            return pizzaService.getById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    //create pizza
    //update pizza
    //delete pizza
}
