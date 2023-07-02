package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class index {

    private List<String> produkty = new ArrayList<>();

    @GetMapping("/")
    public String pokazFormularz(Model model) {
        model.addAttribute("produkty", produkty);
        return "index";
    }

    @PostMapping("/dodajProdukt")
    public String dodajProdukt(@RequestParam("produkt") String produkt, Model model) {
        if (!produkt.trim().isEmpty()) {
            produkty.add(produkt);
        }
        return "redirect:/";
    }

    @GetMapping("/usunProdukt/{produkt}")
    public String usunProdukt(@PathVariable("produkt") String produkt, Model model) {
        produkty.remove(produkt);
        return "redirect:/";
    }
}
