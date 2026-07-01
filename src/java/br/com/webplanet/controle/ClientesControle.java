/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import br.com.webplanet.daos.Clientes;
import br.com.webplanet.modelo.ClientesModelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.portlet.ModelAndView;
  import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author aluno
 */
@Controller
public class ClientesControle {
    @RequestMapping(value = "/adicionarCliente", method = RequestMethod.GET)
    public ModelAndView adicionarCliente() {
        return new ModelAndView("adicionarCliente", "cliente", new Clientes());
    }
    
    @RequestMapping(value = "/consultarCliente", method = RequestMethod.GET)
    public ModelAndView consultarCliente() {
        return new ModelAndView("consultarCliente", "cliente", new Clientes());
    }
    
    @ModelAttribute("cliente")
    public Clientes criarClienteModelo() {
        return new Clientes();
    }
    @ModelAttribute("webConsultaClientes")
    public Map<Integer, String> consultarClientes(){
        Map<Integer, String> fds = new HashMap<>();
        ClientesModelo con = new ClientesModelo(); 
        ArrayList<Clientes> lista = con.consultarClientes();
        
        for(int i = 0; i < lista.size(); i++){
            fds.put(lista.get(i).getCliCodigo(), lista.get(i).getCliNome());
        }
        return fds;
    }
    @RequestMapping(value = "/adicionarCliente", method = RequestMethod.POST)
    public String adicionarCliente(@ModelAttribute("cliente") Clientes est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarCliente";
        }
       
        // pegar os dados da interface gráfica e mandar para o modelo.
        // inserir no banco chamando o modelo.
        
        
        return "resultadoCliente";
    }
    
    @RequestMapping(value = "/consultarCliente", method = RequestMethod.POST)
    public String consultarCliente(@ModelAttribute("cliente") Clientes est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarCliente";
        }
        ClientesModelo con = new ClientesModelo();
        Clientes cli = con.consultarClienteCodigo(est.getCliCodigo());
        modelo.addAttribute("cliNome", cli.getCliNome());
        modelo.addAttribute("cliEndereco", cli.getCliEndereco());
        modelo.addAttribute("cliCPF", cli.getCliCPF());
        modelo.addAttribute("cliTelefone", cli.getCliTelefone());
        modelo.addAttribute("cliDataNasc", cli.getCliDataNasc());
        modelo.addAttribute("cliSexo", cli.getCliSexo());
            
        return "consultarCliente";
    }
}
