package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();
    static String test;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, String cheeseDesc) {
        //Spring will look for a request parameter based on name of
        //x in @RequestParam String x, and x must match y in
        //<input type="text" name=y /> in add.html

        cheeses.add(new Cheese(cheeseName, cheeseDesc));

        //Redirect to /cheese because of @RequestMapping("cheese") above
        //public class CheeseController
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String removeCheese) {

        ArrayList<Cheese> toRemove = new ArrayList<>();
        for (Cheese i : cheeses) {
            if (i.getName().equals(removeCheese)){
            toRemove.add(i);
            }
        }
        cheeses.removeAll(toRemove);


        //cheeses.remove(aCheese);
        //String test = removeCheese.toString();
        System.out.println(removeCheese);

        return "redirect:";
    }

//    @RequestMapping(value = "print", method = RequestMethod.GET)
//    public String displayPrint(Model model) {
//
//    }
}
