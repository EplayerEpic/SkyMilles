/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author aluno
 */
@Controller
public class QuartoControle {

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */

    /**
     *
     * @author aluno
     */
    
    @GetMapping("/menuQuarto")
    public String menuQuarto() {
        return "menuQuarto";
    }
    
    @GetMapping("/adicionarQuarto")
    public String adicionarQuarto() {
        return "adicionarQuarto";
    }

    @GetMapping("/alterarQuarto")
    public String alterarQuarto() {
        return "alterarQuarto";
    }

    @GetMapping("/removerQuarto")
    public String removerQuarti() {
        return "removerQuarto";
    }

    @GetMapping("/consultarQuarto")
    public String consultarQuarto() {
        return "consultarQuarto";
    }

    @GetMapping("/listarQuartos")
    public String listarQuartos() {
        return "listarTodosQuartos";
    }
}
