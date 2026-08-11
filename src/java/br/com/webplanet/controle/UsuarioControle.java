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
public class UsuarioControle {
    @GetMapping("/menuUsuario")
    public String menuUsuario() {
        return "menuUsuario";
    }
    
    @GetMapping("/adicionarUsuario")
    public String adicionarQuarto() {
        return "adicionarUsuario";
    }

    @GetMapping("/alterarUsuario")
    public String alterarQuarto() {
        return "alterarUsuario";
    }

    @GetMapping("/removerUsuario")
    public String removerQuarti() {
        return "removerUsuario";
    }

    @GetMapping("/consultarUsuario")
    public String consultarQuarto() {
        return "consultarUsuario";
    }

    @GetMapping("/listarTodosUsuario")
    public String listarQuartos() {
        return "listarTodosUsuario";
    }
}
