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
public class IndexControle {
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/passagens")
    public String pasagens() {
        return "passagens";
    }
    @GetMapping("/destaques")
    public String destaques() {
        return "destaques";
    }
    @GetMapping("/conheca")
    public String conheca() {
        return "conheca";
    }
    @GetMapping("/pacotes")
    public String pacotes() {
        return "pacotes";
    }
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
    @GetMapping("/pagamento")
    public String pagamento() {
        return "pagamento";
    }
    @GetMapping("/hoteis")
    public String hoteis(){
        return "hoteis";
    }
    @GetMapping("/privacidade")
    public String privacidade(){
        return "privacidade";
    }
    
    
    
}
