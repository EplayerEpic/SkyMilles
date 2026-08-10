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
public class PontoTuristicoControle {
    @GetMapping("/adicionarPonto")
public String adicionarPonto() {
    return "adicionarPonto";
}
@GetMapping("/alterarPonto")
public String alterarPonto() {
    return "alterarPonto";
}
@GetMapping("/removerPonto")
public String removerPonto() {
    return "removerPonto";
}
@GetMapping("/consultarPonto")
public String consultarPonto() {
    return "consultarPonto";
}
@GetMapping("/listarPontos")
public String listarPontos() {
    return "listarTodosPontos";
}
}
