package com.g2.t5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.g2.Model.Player;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GuiController {
    private Integer myClass = null;
    private Integer myRobot = null;
    private Map<Integer, String> hashMap = new HashMap<>();
    private Map<Integer, String> hashMap2 = new HashMap<>();
    private final FileController fileController;

    public GuiController(FileController fileController) {
        this.fileController = fileController;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Nome del template Thymeleaf per la pagina1.html
    }

    @GetMapping("/main")
    public String GUIController(Model model) {

        fileController.listFilesInFolder("classpath:FolderTree/AUTName/AUTSourceCode");
        int size = fileController.getClassSize();

        for (int i = 0; i < size; i++) {
            String valore = fileController.getClass(i);
            hashMap.put(i, valore);
        }

        /*
         * String[] nome = new String[9];
         * nome[0] = "Arctic Network";
         * nome[1] = "N Queen";
         * nome[2] = "Building Bridge";
         * nome[3] = "Sultan Problem";
         * nome[4] = "Rat Attack";
         * nome[5] = "Sudoku";
         * nome[6] = "Rubik Cube";
         * nome[7] = "Knapsack";
         * nome[8] = "Fibonacci";
         * 
         * for (int i = 0; i < 9; i++) {
         * hashMap.put(i, nome[i]);
         * }
         */

        model.addAttribute("hashMap", hashMap);

        String[] robot = new String[9];

        robot[0] = "Hulk";
        robot[1] = "Ironman";
        robot[2] = "Batman";
        robot[3] = "Superman";
        robot[4] = "ARMANDO";
        robot[5] = "Wolverine";
        robot[6] = "Deadpool";
        robot[7] = "Thor";
        robot[8] = "Captain America";

        for (int i = 0; i < 9; i++) {
            hashMap2.put(i, robot[i]);
        }

        model.addAttribute("hashMap2", hashMap2);
        return "main";
    }

    @PostMapping("/sendVariable")
    public ResponseEntity<String> receiveVariableClasse(@RequestParam("myVariable") Integer myClassa,
            @RequestParam("myVariable2") Integer myRobota) {
        // Fai qualcosa con la variabile ricevuta
        System.out.println("Variabile ricevuta: " + myClassa);
        System.out.println("Variabile ricevuta: " + myRobota);
        myClass = myClassa;
        myRobot = myRobota;
        // Restituisci una risposta al client (se necessario)
        return ResponseEntity.ok("Dati ricevuti con successo");
    }

    @GetMapping("/report")
    public String reportPage(Model model) {
        String valueclass = "NULL";
        String valuerobot = "NULL";
        valueclass = hashMap.get(myClass);
        valuerobot = hashMap2.get(myRobot);
        System.out.println("IL VALORE DEL ROBOT " + valuerobot + " " + myRobot);
        System.out.println("Il VALORE DELLA CLASSE " + valueclass + " " + myClass);
        model.addAttribute("classe", valueclass);
        model.addAttribute("robot", valuerobot);
        return "report";
    }

    @GetMapping("/editor")
    public String editorPage() {
        return "editor";
    }

    @PostMapping("/login-variabiles")
    public ResponseEntity<String> receiveLoginData(@RequestParam("var1") String username,
            @RequestParam("var2") String password) {

        System.out.println("username : " + username);
        System.out.println("password : " + password);

        // Salva i valori in una variabile o esegui altre operazioni necessarie

        return ResponseEntity.ok("Dati ricevuti con successo");

    }

}
