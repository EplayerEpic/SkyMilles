/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import br.com.webplanet.daos.Aeroporto;
import br.com.webplanet.modelo.AeroportoModelo;
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
public class AeroportoControle {

    @RequestMapping(value = "/adicionarAeroporto", method = RequestMethod.GET)
    public ModelAndView adicionarAeroporto() {
        return new ModelAndView("adicionarAeroporto", "aeroporto", new Aeroporto());
    }

    @RequestMapping(value = "/ConsultarAeroporto", method = RequestMethod.GET)
    public ModelAndView consultarAeroporto() {
        return new ModelAndView("ConsultarAeroporto", "aeroporto", new Aeroporto());
    }

    @RequestMapping(value = "/AlterarAeroporto", method = RequestMethod.GET)
    public ModelAndView AlterarAeroporto() {
        return new ModelAndView("AlterarAeroporto", "aeroporto", new Aeroporto());
    }

    @RequestMapping(value = "/listarTodasAero", method = RequestMethod.GET)
    public ModelAndView listarTodasAero() {
        AeroportoModelo Cidm = new AeroportoModelo();

        ArrayList<Aeroporto> listaC = Cidm.consultarAeroportos();
        ModelAndView mv = new ModelAndView("listarTodasAero");
        mv.addObject("aeroportos", listaC);
        return mv;
    }

    @ModelAttribute("aeroporto")
    public Aeroporto criarCidadeModelo() {
        return new Aeroporto();
    }

    @ModelAttribute("webConsultarAeroporto")
    public Map<Integer, String> consultarCidades() {
        Map<Integer, String> map = new HashMap<>();
        AeroportoModelo CidM = new AeroportoModelo();
        ArrayList<Aeroporto> listaC = CidM.consultarAeroportos();

        for (int i = 0; i < listaC.size(); i++) {
            map.put(listaC.get(i).getCodAeroporto(), listaC.get(i).getNomeAero());
        }
        return map;
    }

    @RequestMapping(value = "/adicionarAeroporto", method = RequestMethod.POST)
    public String adicionarAeroporto(@ModelAttribute("aeroporto") Aeroporto est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarAeroporto";
        }
        AeroportoModelo cidM = new AeroportoModelo();

        if (est.getNomeAero() != null && !est.getNomeAero().trim().isEmpty()
                && est.getCidade() != null && est.getCidade().getCodCidade() > 0) {
            cidM.adicionarAeroporto(est);
            modelo.addAttribute("mensagem", "Aeroporto cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar aeroporto");
        }
        return "adicionarAeroporto";
    }

    /**
     *
     * @param est
     * @param bindingResult
     * @param modelo
     * @return
     */
    @RequestMapping(value = "/ConsultarAeroporto", method = RequestMethod.POST)
    public String ConsultarAeroporto(@ModelAttribute("aeroporto") Aeroporto est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "ConsultarAeroporto";
        }
        AeroportoModelo cidM = new AeroportoModelo();
        Aeroporto cid = cidM.consultarAeroportoCodigo(est.getCodAeroporto());
        modelo.addAttribute("nomeAero", cid.getNomeAero());
        modelo.addAttribute("cidade", cid.getCidade());
        modelo.addAttribute("status", cid.getStatus());
        return "ConsultarAeroporto";
    }

    /**
     * Trabalhando(pqp que saco isso, ter que estudar mais pra mexer nisso)*
     */
    @RequestMapping(value = "/AlterarAeroporto", method = RequestMethod.POST)
    public String AlterarAeroporto(@ModelAttribute("aeroporto") Aeroporto est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "AlterarAeroporto";
        }

        AeroportoModelo cidM = new AeroportoModelo();
        Aeroporto aeroSelect = cidM.consultarAeroportoCodigo(est.getCodAeroporto());

        if (est.getNomeAero() != null && !est.getNomeAero().trim().isEmpty()
                && est.getCidade() != null && est.getCidade().getCodCidade() > 0
                && est.getStatus() >= 0) {

            cidM.alterarAeroporto(est);

            // salvou com sucesso -> devolve form limpo, não repopulado
            modelo.addAttribute("aeroporto", new Aeroporto());
            modelo.addAttribute("mensagem", "Aeroporto alterado com sucesso!");
        } else {
            // foi só a troca do select (onchange) -> aqui sim repopula
            modelo.addAttribute("aeroporto", aeroSelect);
        }

        return "AlterarAeroporto";
    }
}