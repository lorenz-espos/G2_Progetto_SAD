package com.g2.t5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;

@Controller
public class GuiController {
    @GetMapping("/main")
    public String GUIController(Model model) {

        
        String nome = "Arctic Network";
        String nome1 = "N Queen";
        String nome2 = "Building Bridge";
        String nome3 = "Sultan Problem";
        String nome4 = "Rat Attack";
        String nome5 = "Sudoku";
        String nome6 = "Rubik Cube";
        String nome7 = "Knapsack";
        String nome8 = "Fibonacci";

        

        List<String> classi = new ArrayList<String>();
        classi.add(nome);
        classi.add(nome1);
        classi.add(nome2);
        classi.add(nome3);
        classi.add(nome4);
        classi.add(nome5);
        classi.add(nome6);
        classi.add(nome7);
        classi.add(nome8);

        model.addAttribute("classi", classi);

        String robot1 = "Hulk";
        String robot2 = "Spiderman";
        String robot3 = "Khvicha";
        String robot4 = "Victor";
        String robot5 = "Armando";
        String robot6 = "D10S";
        String robot7 = "Lucianone";

        List<String> robot = new ArrayList<String>();

        robot.add(robot1);
        robot.add(robot2);
        robot.add(robot3);
        robot.add(robot4);
        robot.add(robot5);
        robot.add(robot6);
        robot.add(robot7);

        model.addAttribute("robot", robot);
        return "main";
    }

}
