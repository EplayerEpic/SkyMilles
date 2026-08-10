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
public class VooControle {

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */

    /**
     *
     * @author aluno
     */
    @GetMapping("/adicionarVoo")
    public String adicionarVoo() {
        return "adicionarVoo";
    }

    @GetMapping("/alterarVoo")
    public String alterarVoo() {
        return "alterarVoo";
    }

    @GetMapping("/removerVoo")
    public String removerQuarti() {
        return "removerVoo";
    }

    @GetMapping("/consultarVoo")
    public String consultarVoo() {
        return "consultarVoo";
    }

    @GetMapping("/listarVoos")
    public String listarVoos() {
        return "listarTodosVoos";
    }
}
