/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import br.com.webplanet.daos.Clientes;
import br.com.webplanet.daos.Compra;
import br.com.webplanet.daos.Pacote;
import br.com.webplanet.modelo.ClientesModelo;
import br.com.webplanet.modelo.CompraModelo;
import br.com.webplanet.modelo.PacoteModelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author aluno
 */
@Controller
public class CompraControle {

    @GetMapping("/menuCompra")
    public String menuCompra() {
        return "menuCompra";
    }

    // Objeto base do formulário, com os relacionamentos já inicializados
    // para não quebrar o binding aninhado (form:select codCliente.cliCodigo etc.)
    @ModelAttribute("compra")
    public Compra criarCompraModelo() {
        Compra c = new Compra();
        c.setCodCliente(new Clientes());
        c.setCodPacote(new Pacote());
        return c;
    }

    @ModelAttribute("webConsultarClientes")
    public Map<Integer, String> consultarClientesMap() {
        Map<Integer, String> map = new HashMap<>();
        ClientesModelo cliM = new ClientesModelo();
        ArrayList<Clientes> lista = cliM.consultarClientes();
        for (Clientes c : lista) {
            map.put(c.getCliCodigo(), c.getCliNome());
        }
        return map;
    }

    @ModelAttribute("webConsultarPacotes")
    public Map<Integer, String> consultarPacotesMap() {
        Map<Integer, String> map = new HashMap<>();
        PacoteModelo pacM = new PacoteModelo();
        ArrayList<Pacote> lista = pacM.consultarPacotes();
        for (Pacote p : lista) {
            map.put(p.getCodPacote(), "Pacote " + p.getCodPacote() + " - R$" + p.getValorPacote());
        }
        return map;
    }

    @ModelAttribute("webConsultarCompras")
    public Map<Integer, String> consultarComprasMap() {
        Map<Integer, String> map = new HashMap<>();
        CompraModelo comM = new CompraModelo();
        ArrayList<Compra> lista = comM.consultarCompra();
        for (Compra c : lista) {
            map.put(c.getCodCompra(), "Compra " + c.getCodCompra() + " - " + c.getDataCompra());
        }
        return map;
    }

    // ===================== LISTAR TODOS =====================
    @RequestMapping(value = "/listarTodasCompras", method = RequestMethod.GET)
    public ModelAndView listarTodasCompras() {
        CompraModelo comM = new CompraModelo();
        ArrayList<Compra> listaCompras = comM.consultarCompra();
        ModelAndView mv = new ModelAndView("listarTodasCompras");
        mv.addObject("compras", listaCompras);
        return mv;
    }

    // ===================== ADICIONAR =====================
    @RequestMapping(value = "/adicionarCompra", method = RequestMethod.GET)
    public String adicionarCompra() {
        return "adicionarCompra";
    }

    @RequestMapping(value = "/adicionarCompra", method = RequestMethod.POST)
    public String adicionarCompra(@ModelAttribute("compra") Compra com, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarCompra";
        }

        if (com.getFormaPagamento() != null && !com.getFormaPagamento().trim().isEmpty()
                && com.getDataCompra() != null && !com.getDataCompra().trim().isEmpty()
                && com.getCodCliente() != null && com.getCodCliente().getCliCodigo() > 0
                && com.getCodPacote() != null && com.getCodPacote().getCodPacote() > 0) {

            com.setStatus(1);
            CompraModelo comM = new CompraModelo();
            comM.inserirCompra(com);
            modelo.addAttribute("mensagem", "Compra cadastrada com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar compra");
        }
        return "adicionarCompra";
    }

    // ===================== CONSULTAR =====================
    @RequestMapping(value = "/consultarCompra", method = RequestMethod.GET)
    public String consultarCompra() {
        return "consultarCompra";
    }

    @RequestMapping(value = "/consultarCompra", method = RequestMethod.POST)
    public String consultarCompra(@ModelAttribute("compra") Compra com, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarCompra";
        }

        CompraModelo comM = new CompraModelo();
        Compra encontrada = comM.consultarCompraCodigo(com.getCodCompra());

        if (encontrada != null) {
            modelo.addAttribute("CompraForma", encontrada.getFormaPagamento());
            modelo.addAttribute("CompraValor", encontrada.getValor());
            modelo.addAttribute("CompraData", encontrada.getDataCompra());
            modelo.addAttribute("CompraCliente", encontrada.getCodCliente() != null ? encontrada.getCodCliente().getCliCodigo() : "");
            modelo.addAttribute("CompraPacote", encontrada.getCodPacote() != null ? encontrada.getCodPacote().getCodPacote() : "");
        } else {
            modelo.addAttribute("mensagem", "Compra não encontrada");
        }
        return "consultarCompra";
    }

    // ===================== ALTERAR =====================
    @RequestMapping(value = "/alterarCompra", method = RequestMethod.GET)
    public String alterarCompra() {
        return "alterarCompra";
    }

    @RequestMapping(value = "/alterarCompra", method = RequestMethod.POST)
    public String alterarCompra(@ModelAttribute("compra") Compra com, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarCompra";
        }

        CompraModelo comM = new CompraModelo();
        Compra compraSelecionada = comM.consultarCompraCodigo(com.getCodCompra());

        if (com.getFormaPagamento() != null && !com.getFormaPagamento().trim().isEmpty()
                && com.getDataCompra() != null && !com.getDataCompra().trim().isEmpty()) {

            // salvou de fato -> devolve form limpo
            com.setStatus(1);
            comM.alterarCompra(com);

            Compra vazia = new Compra();
            vazia.setCodCliente(new Clientes());
            vazia.setCodPacote(new Pacote());
            modelo.addAttribute("compra", vazia);
            modelo.addAttribute("mensagem", "Compra alterada com sucesso!");
        } else {
            // foi só a troca do select (onchange) -> repopula os campos
            modelo.addAttribute("compra", compraSelecionada != null ? compraSelecionada : com);
        }

        return "alterarCompra";
    }
    @GetMapping("/removerCompra")
    public String removerCompra() {
        return "removerCompra";
    }
}