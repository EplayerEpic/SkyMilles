/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import br.com.webplanet.daos.Cidade;
import br.com.webplanet.modelo.CidadeModelo;
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
public class CidadeControle {

    @RequestMapping(value = "/adicionarCidade", method = RequestMethod.GET)
    public ModelAndView adicionarCidade() {
        return new ModelAndView("adicionarCidade", "cidade", new Cidade());
    }

    @RequestMapping(value = "/ConsultarCidade", method = RequestMethod.GET)
    public ModelAndView consultarCidade() {
        return new ModelAndView("ConsultarCidade", "cidade", new Cidade());
    }

    @RequestMapping(value = "/AlterarCidade", method = RequestMethod.GET)
    public ModelAndView AlterarCidade() {
        return new ModelAndView("AlterarCidade", "cidade", new Cidade());
    }

    @RequestMapping(value = "/listarTodasC", method = RequestMethod.GET)
    public ModelAndView listarTodasC() {
        CidadeModelo Cidm = new CidadeModelo();
        System.out.println("AQUI");
        ArrayList<Cidade> listaC = Cidm.consultarCidades();
        ModelAndView mv = new ModelAndView("listarTodasC");
        mv.addObject("cidades", listaC);
        return mv;
    }

    @ModelAttribute("cidade")
    public Cidade criarCidadeModelo() {
        return new Cidade();
    }

    @ModelAttribute("webConsultarCidades")
    public Map<Integer, String> consultarCidades() {
        Map<Integer, String> map = new HashMap<>();
        CidadeModelo CidM = new CidadeModelo();
        ArrayList<Cidade> listaC = CidM.consultarCidades();

        for (int i = 0; i < listaC.size(); i++) {
            map.put(listaC.get(i).getCodCidade(), listaC.get(i).getNomeCidade());
        }
        return map;

    }

    @RequestMapping(value = "/adicionarCidade", method = RequestMethod.POST)
    public String adicionarCidade(@ModelAttribute("cidade") Cidade est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarCidade";
        }
        CidadeModelo cidM = new CidadeModelo();
        
        if (est.getNomeCidade() != null && !est.getNomeCidade().trim().isEmpty()
                && est.getDdd() != null && !est.getDdd().trim().isEmpty()
                && est.getEstado() != null && !est.getEstado().trim().isEmpty()) {
            cidM.inserirCidade(est);
            modelo.addAttribute("mensagem", "Cidade cadastrada com sucesso");
        }
        else{
            modelo.addAttribute("mensagem", "Erro ao cadastrar cidade");
        }
        return "adicionarCidade";
    }

    /**
     *
     * @param est
     * @param bindingResult
     * @param modelo
     * @return
     */
    @RequestMapping(value = "/ConsultarCidade", method = RequestMethod.POST)
    public String ConsultarCidade(@ModelAttribute("cidade") Cidade est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "ConsultarCidade";
        }
        CidadeModelo cidM = new CidadeModelo();
        Cidade cid = cidM.consultarCidadeCodigo(est.getCodCidade());
        modelo.addAttribute("CidadeNome", cid.getNomeCidade());
        modelo.addAttribute("CidadeDDD", cid.getDdd());
        modelo.addAttribute("CidadeEstado", cid.getEstado());
        return "ConsultarCidade";
    }

    /**
     * Trabalhando(pqp que saco isso, ter que estudar mais pra mexer nisso)*
     */
    @RequestMapping(value = "/AlterarCidade", method = RequestMethod.POST)
    public String AlterarCidade(@ModelAttribute("cidade") Cidade est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "AlterarCidade";
        }

        CidadeModelo cidM = new CidadeModelo();
        Cidade cidadeSelect = cidM.consultarCidadeCodigo(est.getCodCidade());

        if (est.getNomeCidade() != null && !est.getNomeCidade().trim().isEmpty()
                && est.getDdd() != null && !est.getDdd().trim().isEmpty()
                && est.getEstado() != null && !est.getEstado().trim().isEmpty()) {

            cidM.alterarCidade(est);

            // salvou com sucesso -> devolve form limpo, não repopulado
            modelo.addAttribute("cidade", new Cidade());
            modelo.addAttribute("mensagem", "Cidade alterada com sucesso!");
        } else {
            // foi só a troca do select (onchange) -> aqui sim repopula
            modelo.addAttribute("cidade", cidadeSelect);
        }

        return "AlterarCidade";
    }
}
