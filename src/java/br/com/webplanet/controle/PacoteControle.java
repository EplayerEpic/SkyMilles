/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import br.com.webplanet.daos.Assentos;
import br.com.webplanet.daos.Pacote;
import br.com.webplanet.daos.Quarto;
import br.com.webplanet.modelo.AssentosModelo;
import br.com.webplanet.modelo.PacoteModelo;
import br.com.webplanet.modelo.QuartoModelo;
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
public class PacoteControle {

    @GetMapping("/menuPacote")
    public String menuPacote() {
        return "menuPacote";
    }
    @ModelAttribute("pacote")
    public Pacote criarPacoteModelo() {
        Pacote p = new Pacote();
        p.setQuarto(new Quarto());
        p.setAssento(new Assentos());
        return p;
    }

    @ModelAttribute("webConsultarQuartos")
    public Map<Integer, String> consultarQuartosMap() {
        Map<Integer, String> map = new HashMap<>();
        QuartoModelo qM = new QuartoModelo();
        ArrayList<Quarto> lista = qM.consultarQuartos();
        for (Quarto q : lista) {
            map.put(q.getCodQuarto(), "Quarto " + q.getCodQuarto() + " - " + q.getLocalSaida() + " > " + q.getLocalChegada());
        }
        return map;
    }

    @ModelAttribute("webConsultarAssentos")
    public Map<Integer, String> consultarAssentosMap() {
        Map<Integer, String> map = new HashMap<>();
        AssentosModelo aM = new AssentosModelo();
        ArrayList<Assentos> lista = aM.consultarAssentos();
        for (Assentos a : lista) {
            map.put(a.getCodAssento(), "Assento " + a.getCodAssento() + " - " + a.getClasse());
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

    // ===================== LISTAR TODOS =====================
    @RequestMapping(value = "/listarTodasP", method = RequestMethod.GET)
    public ModelAndView listarTodasP() {
        PacoteModelo pacM = new PacoteModelo();
        ArrayList<Pacote> listaP = pacM.consultarPacotes();
        ModelAndView mv = new ModelAndView("listarTodasP");
        mv.addObject("pacotes", listaP);
        return mv;
    }

    // ===================== ADICIONAR =====================
    @RequestMapping(value = "/adicionarPacote", method = RequestMethod.GET)
    public String adicionarPacote() {
        return "adicionarPacote";
    }

    @RequestMapping(value = "/adicionarPacote", method = RequestMethod.POST)
    public String adicionarPacote(@ModelAttribute("pacote") Pacote pack, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarPacote";
        }

        if (pack.getCodPacote() > 0
                && pack.getValorPacote() > 0
                && pack.getQuarto() != null && pack.getQuarto().getCodQuarto() > 0
                && pack.getAssento() != null && pack.getAssento().getCodAssento() > 0) {

            pack.setStatus(1);
            PacoteModelo pacM = new PacoteModelo();
            pacM.inserirPacote(pack);
            modelo.addAttribute("mensagem", "Pacote cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar pacote");
        }
        return "adicionarPacote";
    }

    // ===================== CONSULTAR =====================
    @RequestMapping(value = "/consultarPacote", method = RequestMethod.GET)
    public String consultarPacote() {
        return "consultarPacote";
    }

    @RequestMapping(value = "/consultarPacote", method = RequestMethod.POST)
    public String consultarPacote(@ModelAttribute("pacote") Pacote pack, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarPacote";
        }

        PacoteModelo pacM = new PacoteModelo();
        Pacote encontrado = pacM.consultarPacoteCodigo(pack.getCodPacote());

        if (encontrado != null) {
            modelo.addAttribute("PacoteValor", encontrado.getValorPacote());
            modelo.addAttribute("PacoteQuarto", encontrado.getQuarto() != null ? encontrado.getQuarto().getCodQuarto() : "");
            modelo.addAttribute("PacoteAssento", encontrado.getAssento() != null ? encontrado.getAssento().getCodAssento() : "");
        } else {
            modelo.addAttribute("mensagem", "Pacote não encontrado");
        }
        return "consultarPacote";
    }

    // ===================== ALTERAR =====================
    @RequestMapping(value = "/alterarPacote", method = RequestMethod.GET)
    public String alterarPacote() {
        return "alterarPacote";
    }

    @RequestMapping(value = "/alterarPacote", method = RequestMethod.POST)
    public String alterarPacote(@ModelAttribute("pacote") Pacote pack, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarPacote";
        }

        PacoteModelo pacM = new PacoteModelo();
        Pacote pacoteSelecionado = pacM.consultarPacoteCodigo(pack.getCodPacote());

        if (pack.getValorPacote() > 0
                && pack.getQuarto() != null && pack.getQuarto().getCodQuarto() > 0
                && pack.getAssento() != null && pack.getAssento().getCodAssento() > 0) {

            // salvou de fato -> devolve form limpo
            pack.setStatus(1);
            pacM.alterarPacote(pack);

            Pacote vazio = new Pacote();
            vazio.setQuarto(new Quarto());
            vazio.setAssento(new Assentos());
            modelo.addAttribute("pacote", vazio);
            modelo.addAttribute("mensagem", "Pacote alterado com sucesso!");
        } else {
            // foi só a troca do select (onchange) -> repopula os campos
            modelo.addAttribute("pacote", pacoteSelecionado != null ? pacoteSelecionado : pack);
        }

        return "alterarPacote";
    }

    @GetMapping("/removerPacote")
    public String removerPacote() {
        return "removerPacote";
    }
}