package org.lessons.java.pizzeria.controller;

import org.lessons.java.pizzeria.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferRepository offerRepository;

    @GetMapping("/create")
    public String create(@RequestParam(name = "pizzaId") Optional<Integer> id) {
        return "/offers/create";
    }
}
