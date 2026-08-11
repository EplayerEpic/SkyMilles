package br.com.webplanet.controle;

import br.com.webplanet.daos.Aeroporto;
import br.com.webplanet.daos.Assentos;
import br.com.webplanet.daos.Voo;
import br.com.webplanet.modelo.AeroportoModelo;
import br.com.webplanet.modelo.AssentosModelo;
import br.com.webplanet.modelo.VooModelo;
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
 * Controlador de Assento.
 * Adicionar / Consultar / Alterar / Listar estão funcionais (gravam e leem
 * do banco via AssentosModelo). Remover não está exposto no menu.
 *
 * @author aluno
 */
@Controller
public class AssentosControle {

    @GetMapping("/menuAssento")
    public String menuAssento() {
        return "menuAssento";
    }

    // Objeto base do formulário, com o relacionamento já inicializado
    // para não quebrar o binding aninhado (form:select voo.codVoo)
    @ModelAttribute("assento")
    public Assentos criarAssentosModelo() {
        Assentos a = new Assentos();
        a.setVoo(new Voo());
        return a;
    }

    @ModelAttribute("webConsultarAeroportos")
    public Map<Integer, String> consultarAeroportosMap() {
        Map<Integer, String> map = new HashMap<>();
        AeroportoModelo aeM = new AeroportoModelo();
        ArrayList<Aeroporto> lista = aeM.consultarAeroportos();
        for (Aeroporto a : lista) {
            map.put(a.getCodAeroporto(), a.getNomeAero());
        }
        return map;
    }

    @ModelAttribute("webConsultarVoos")
    public Map<Integer, String> consultarVoosMap() {
        Map<Integer, String> map = new HashMap<>();
        VooModelo vM = new VooModelo();
        ArrayList<Voo> lista = vM.consultarVoos();
        for (Voo v : lista) {
            map.put(v.getCodVoo(), "Voo " + v.getCodVoo() + " - " + v.getNumVoo());
        }
        return map;
    }

    @ModelAttribute("webConsultarAssentos")
    public Map<Integer, String> consultarAssentosMap() {
        Map<Integer, String> map = new HashMap<>();
        AssentosModelo assM = new AssentosModelo();
        ArrayList<Assentos> lista = assM.consultarAssentos();
        for (Assentos a : lista) {
            map.put(a.getCodAssento(), "Assento " + a.getCodAssento() + " - " + a.getClasse());
        }
        return map;
    }

    @RequestMapping(value = "/listarTodosAssentos", method = RequestMethod.GET)
    public ModelAndView listarTodosAssentos() {
        AssentosModelo assM = new AssentosModelo();
        ArrayList<Assentos> listaA = assM.consultarAssentos();
        ModelAndView mv = new ModelAndView("listarTodosAssentos");
        mv.addObject("assentos", listaA);
        return mv;
    }

    @RequestMapping(value = "/adicionarAssento", method = RequestMethod.GET)
    public String adicionarAssento() {
        return "adicionarAssento";
    }

    @RequestMapping(value = "/adicionarAssento", method = RequestMethod.POST)
    public String adicionarAssento(@ModelAttribute("assento") Assentos a, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarAssento";
        }

        if (a.getNumBilhete() > 0
                && a.getDataEmissao() != null && !a.getDataEmissao().trim().isEmpty()
                && a.getClasse() != null && !a.getClasse().trim().isEmpty()
                && a.getValorAss() > 0
                && a.getCodDestino() > 0
                && a.getCodLocalPartida() > 0
                && a.getVoo() != null && a.getVoo().getCodVoo() > 0) {

            a.setStatus(1);
            AssentosModelo assM = new AssentosModelo();
            assM.inserirAssento(a);
            modelo.addAttribute("mensagem", "Assento cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar assento");
        }
        return "adicionarAssento";
    }

    @RequestMapping(value = "/consultarAssento", method = RequestMethod.GET)
    public String consultarAssento() {
        return "consultarAssento";
    }

    @RequestMapping(value = "/consultarAssento", method = RequestMethod.POST)
    public String consultarAssento(@ModelAttribute("assento") Assentos a, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarAssento";
        }

        AssentosModelo assM = new AssentosModelo();
        Assentos encontrado = assM.consultarCodAssento(a.getCodAssento());

        if (encontrado != null && encontrado.getCodAssento() > 0) {
            modelo.addAttribute("AssentoNumBilhete", encontrado.getNumBilhete());
            modelo.addAttribute("AssentoDataEmissao", encontrado.getDataEmissao());
            modelo.addAttribute("AssentoClasse", encontrado.getClasse());
            modelo.addAttribute("AssentoValor", encontrado.getValorAss());
            modelo.addAttribute("AssentoDestino", encontrado.getCodDestino());
            modelo.addAttribute("AssentoLocalPartida", encontrado.getCodLocalPartida());
            modelo.addAttribute("AssentoVoo", encontrado.getVoo() != null ? encontrado.getVoo().getCodVoo() : "");
        } else {
            modelo.addAttribute("mensagem", "Assento não encontrado");
        }
        return "consultarAssento";
    }

    @RequestMapping(value = "/alterarAssento", method = RequestMethod.GET)
    public String alterarAssento() {
        return "alterarAssento";
    }

    @RequestMapping(value = "/alterarAssento", method = RequestMethod.POST)
    public String alterarAssento(@ModelAttribute("assento") Assentos a, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarAssento";
        }

        AssentosModelo assM = new AssentosModelo();
        Assentos assentoSelecionado = assM.consultarCodAssento(a.getCodAssento());

        if (a.getDataEmissao() != null && !a.getDataEmissao().trim().isEmpty()
                && a.getClasse() != null && !a.getClasse().trim().isEmpty()
                && a.getValorAss() > 0
                && a.getCodDestino() > 0
                && a.getCodLocalPartida() > 0
                && a.getVoo() != null && a.getVoo().getCodVoo() > 0) {

            a.setStatus(1);
            assM.alterarAssento(a);

            Assentos vazio = new Assentos();
            vazio.setVoo(new Voo());
            modelo.addAttribute("assento", vazio);
            modelo.addAttribute("mensagem", "Assento alterado com sucesso!");
        } else {
            if (assentoSelecionado != null && assentoSelecionado.getVoo() == null) {
                assentoSelecionado.setVoo(new Voo());
            }
            modelo.addAttribute("assento", assentoSelecionado != null ? assentoSelecionado : a);
        }

        return "alterarAssento";
    }
    @GetMapping("/removerAssento")
    public String removerAssento() {
        return "removerAssento";
    }
}