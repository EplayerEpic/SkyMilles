/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import br.com.webplanet.daos.Assentos;
import br.com.webplanet.daos.Voo;
import br.com.webplanet.modelo.AssentosModelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aluno
 */
@Controller
public class AssentosControle {

    @RequestMapping(value = "/adicionarAssento", method = RequestMethod.GET)
    public ModelAndView adicionarAssento() {
        return new ModelAndView("adicionarAssento", "assento", new Assentos());
    }

    @RequestMapping(value = "/consultarAssento", method = RequestMethod.GET)
    public ModelAndView consultarAssento() {
        return new ModelAndView("consultarAssento", "assento", new Assentos());
    }

    @RequestMapping(value = "/alterarAssento", method = RequestMethod.GET)
    public ModelAndView AlterarAssento() {
        return new ModelAndView("alterarAssento", "assento", new Assentos());
    }

    @RequestMapping(value = "/listarTodosAssentos", method = RequestMethod.GET)
    public ModelAndView listarTodosAssentos() {
        AssentosModelo assM = new AssentosModelo();

        ArrayList<Assentos> listaA = assM.consultarAssentos();
        ModelAndView mv = new ModelAndView("listarTodosAssentos");
        mv.addObject("assentos", listaA);
        return mv;
    }

    @ModelAttribute("assento")
    public Assentos criarAssentosModelo() {
        return new Assentos();
    }

    @ModelAttribute("webConsultarAssento")
    public Map<Integer, String> consultarAssentosMap() {
        Map<Integer, String> map = new HashMap<>();
        AssentosModelo assM = new AssentosModelo();
        ArrayList<Assentos> listaA = assM.consultarAssentos();

        for (int i = 0; i < listaA.size(); i++) {
            map.put(listaA.get(i).getCodAssento(), listaA.get(i).getClasse());
        }
        return map;
    }

    @RequestMapping(value = "/adicionarAssento", method = RequestMethod.POST)
    public String adicionarAssento(@ModelAttribute("assento") Assentos est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarAssento";
        }
        AssentosModelo assM = new AssentosModelo();

        if (est.getDataEmissao() != null && !est.getDataEmissao().trim().isEmpty()
                && est.getClasse() != null && !est.getClasse().trim().isEmpty()
                && est.getValorAss() > 0
                && est.getCodDestino() > 0
                && est.getCodLocalPartida() > 0
                && est.getVoo() != null && est.getVoo().getCodVoo() > 0) {
            assM.inserirAssento(est);
            modelo.addAttribute("mensagem", "Assento cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar assento");
        }
        return "adicionarAssento";
    }

    /**
     *
     * @param est
     * @param bindingResult
     * @param modelo
     * @return
     */
    @RequestMapping(value = "/consultarAssento", method = RequestMethod.POST)
    public String ConsultarAssento(@ModelAttribute("assento") Assentos est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarAssento";
        }
        AssentosModelo assM = new AssentosModelo();
        Assentos assen = assM.consultarCodAssento(est.getCodAssento());
        modelo.addAttribute("numBilhete", assen.getNumBilhete());
        modelo.addAttribute("dataEmissao", assen.getDataEmissao());
        modelo.addAttribute("classe", assen.getClasse());
        modelo.addAttribute("valorAss", assen.getValorAss());
        modelo.addAttribute("status", assen.getStatus());
        modelo.addAttribute("codDestino", assen.getCodDestino());
        modelo.addAttribute("codLocalPartida", assen.getCodLocalPartida());
        modelo.addAttribute("voo", assen.getVoo());
        return "consultarAssento";
    }

    @RequestMapping(value = "/alterarAssento", method = RequestMethod.POST)
    public String AlterarAssento(@ModelAttribute("assento") Assentos est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarAssento";
        }

        AssentosModelo assM = new AssentosModelo();
        Assentos assentoSelect = assM.consultarCodAssento(est.getCodAssento());

        if (est.getDataEmissao() != null && !est.getDataEmissao().trim().isEmpty()
                && est.getClasse() != null && !est.getClasse().trim().isEmpty()
                && est.getValorAss() > 0
                && est.getCodDestino() > 0
                && est.getCodLocalPartida() > 0
                && est.getVoo() != null && est.getVoo().getCodVoo() > 0) {

            assM.alterarAssento(est);

            // salvou com sucesso -> devolve form limpo, não repopulado
            modelo.addAttribute("assento", new Assentos());
            modelo.addAttribute("mensagem", "Assento alterado com sucesso!");
        } else {
            // foi só a troca do select (onchange) -> aqui sim repopula
            modelo.addAttribute("assento", assentoSelect);
        }

        return "alterarAssento";
    }
}