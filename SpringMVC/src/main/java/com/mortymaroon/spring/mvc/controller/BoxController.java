package com.mortymaroon.spring.mvc.controller;

import com.mortymaroon.spring.mvc.model.Box;
import com.mortymaroon.spring.mvc.services.BoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("boxes")
public class BoxController {
    private BoxService boxService;

    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping("/all")
    public String gelAllBoxes(Model model) {
        model.addAttribute("frontBoxes", boxService.getAllBox());
        return "all_boxes";
    }

    @PostMapping("/add")
    public String addNewBox(@ModelAttribute Box box) {
        boxService.save(box);
        return "redirect:/boxes/all";
    }

    @GetMapping("/remove/{id}")
    public String deleteBoxById(@PathVariable Long id) {
        boxService.deleteById(id);
        return "redirect:/boxes/all";
    }
}
