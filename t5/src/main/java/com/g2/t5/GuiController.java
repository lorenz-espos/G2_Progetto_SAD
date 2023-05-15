package com.g2.t5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GuiController {
    @GetMapping("/main")
    public String GUIController(Model model) {

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> hashMap2 = new HashMap<>();
String[]nome = new String [9];
String[]robot = new String [9];
        nome[0] ="Arctic Network";
        nome[1] = "N Queen";
        nome[2] = "Building Bridge";
        nome[3] = "Sultan Problem";
        nome[4] = "Rat Attack";
        nome[5] = "Sudoku";
        nome[6] = "Rubik Cube";
        nome[7] = "Knapsack";
        nome[8] = "Fibonacci";

        for(int i=0;i<9;i++){
        hashMap.put(i, nome[i]);
        }
        

        List<String> classi = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            classi.add(hashMap.get(i));
        }
        model.addAttribute("hashMap", hashMap);

        robot[0]= "Hulk";
        robot[1] = "Ironman";
        robot[2] = "Batman";
        robot[3] = "Superman";
        robot[4] = "ARMANDO";
        robot[5] = "Wolverine";
        robot[6] = "Deadpool";
        robot[7] = "Thor";
        robot[8] = "Captain America";

        for(int i=0;i<9;i++){
        hashMap2.put(i, robot[i]);
        }

        model.addAttribute("robot", hashMap2);
        return "main";
    }
    @GetMapping("/report")
    public String reportPage() {
        return "report"; // Nome del template Thymeleaf per la pagina2.html
    }
}
