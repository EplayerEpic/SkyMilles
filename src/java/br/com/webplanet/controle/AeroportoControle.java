package br.com.webplanet.controle;

import br.com.webplanet.daos.Aeroporto;
import br.com.webplanet.daos.Cidade;
import br.com.webplanet.modelo.AeroportoModelo;
import br.com.webplanet.modelo.CidadeModelo;
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
public class AeroportoControle {

    @GetMapping("/menuAeroporto")
    public String menuAeroporto() {
        return "menuAeroporto";
    }

    // Objeto base do formulário, com o relacionamento já inicializado
    // para não quebrar o binding aninhado (form:select cidade.codCidade)
    @ModelAttribute("aeroporto")
    public Aeroporto criarAeroportoModelo() {
        Aeroporto a = new Aeroporto();
        a.setCidade(new Cidade());
        return a;
    }

    @ModelAttribute("webConsultarCidades")
    public Map<Integer, String> consultarCidadesMap() {
        Map<Integer, String> map = new HashMap<>();
        CidadeModelo cidM = new CidadeModelo();
        ArrayList<Cidade> lista = cidM.consultarCidades();
        for (Cidade c : lista) {
            map.put(c.getCodCidade(), c.getNomeCidade());
        }
        return map;
    }

    @ModelAttribute("webConsultarAeroportos")
    public Map<Integer, String> consultarAeroportosMap() {
        Map<Integer, String> map = new HashMap<>();
        AeroportoModelo aM = new AeroportoModelo();
        ArrayList<Aeroporto> lista = aM.consultarAeroportos();
        for (Aeroporto a : lista) {
            map.put(a.getCodAeroporto(), a.getNomeAero());
        }
        return map;
    }

    @RequestMapping(value = "/listarTodasAero", method = RequestMethod.GET)
    public ModelAndView listarTodasAero() {
        AeroportoModelo aM = new AeroportoModelo();
        ArrayList<Aeroporto> listaA = aM.consultarAeroportos();
        ModelAndView mv = new ModelAndView("listarTodasAero");
        mv.addObject("aeroportos", listaA);
        return mv;
    }

    @RequestMapping(value = "/adicionarAeroporto", method = RequestMethod.GET)
    public String adicionarAeroporto() {
        return "adicionarAeroporto";
    }

    @RequestMapping(value = "/adicionarAeroporto", method = RequestMethod.POST)
    public String adicionarAeroporto(@ModelAttribute("aeroporto") Aeroporto a, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarAeroporto";
        }

        if (a.getNomeAero() != null && !a.getNomeAero().trim().isEmpty()
                && a.getCidade() != null && a.getCidade().getCodCidade() > 0) {

            a.setStatus(1);
            AeroportoModelo aM = new AeroportoModelo();
            aM.adicionarAeroporto(a);
            modelo.addAttribute("mensagem", "Aeroporto cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar aeroporto");
        }
        return "adicionarAeroporto";
    }

    @RequestMapping(value = "/ConsultarAeroporto", method = RequestMethod.GET)
    public String consultarAeroporto() {
        return "ConsultarAeroporto";
    }

    @RequestMapping(value = "/ConsultarAeroporto", method = RequestMethod.POST)
    public String consultarAeroporto(@ModelAttribute("aeroporto") Aeroporto a, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "ConsultarAeroporto";
        }

        AeroportoModelo aM = new AeroportoModelo();
        Aeroporto encontrado = aM.consultarAeroportoCodigo(a.getCodAeroporto());

        if (encontrado != null) {
            modelo.addAttribute("AeroportoNome", encontrado.getNomeAero());
            modelo.addAttribute("AeroportoCidade", encontrado.getCidade());
        } else {
            modelo.addAttribute("mensagem", "Aeroporto não encontrado");
        }
        return "ConsultarAeroporto";
    }

    @RequestMapping(value = "/AlterarAeroporto", method = RequestMethod.GET)
    public String alterarAeroporto() {
        return "AlterarAeroporto";
    }

    @RequestMapping(value = "/AlterarAeroporto", method = RequestMethod.POST)
    public String alterarAeroporto(@ModelAttribute("aeroporto") Aeroporto a, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "AlterarAeroporto";
        }

        AeroportoModelo aM = new AeroportoModelo();
        Aeroporto aeroportoSelecionado = aM.consultarAeroportoCodigo(a.getCodAeroporto());

        if (a.getNomeAero() != null && !a.getNomeAero().trim().isEmpty()
                && a.getCidade() != null && a.getCidade().getCodCidade() > 0) {

            a.setStatus(1);
            aM.alterarAeroporto(a);

            Aeroporto vazio = new Aeroporto();
            vazio.setCidade(new Cidade());
            modelo.addAttribute("aeroporto", vazio);
            modelo.addAttribute("mensagem", "Aeroporto alterado com sucesso!");
        } else {
            modelo.addAttribute("aeroporto", aeroportoSelecionado != null ? aeroportoSelecionado : a);
        }

        return "AlterarAeroporto";
    }
    @GetMapping("/removerAeroporto")
    public String removerAeroporto() {
        return "removerAeroporto";
    }
}