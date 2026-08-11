package br.com.webplanet.controle;

import br.com.webplanet.daos.Aeroporto;
import br.com.webplanet.daos.Voo;
import br.com.webplanet.modelo.AeroportoModelo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VooControle {

    @GetMapping("/menuVoo")
    public String menuVoo() {
        return "menuVoo";
    }

    @ModelAttribute("voo")
    public Voo criarVooModelo() {
        Voo v = new Voo();
        v.setAeroPartida(new Aeroporto());
        v.setAeroDestino(new Aeroporto());
        return v;
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

    @RequestMapping(value = "/listarVoos", method = RequestMethod.GET)
    public ModelAndView listarVoos() {
        VooModelo vM = new VooModelo();
        ArrayList<Voo> listaV = vM.consultarVoos();
        ModelAndView mv = new ModelAndView("listarTodosVoos");
        mv.addObject("voos", listaV);
        return mv;
    }

    @RequestMapping(value = "/adicionarVoo", method = RequestMethod.GET)
    public String adicionarVoo() {
        return "adicionarVoo";
    }

    @RequestMapping(value = "/adicionarVoo", method = RequestMethod.POST)
    public String adicionarVoo(@ModelAttribute("voo") Voo v, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarVoo";
        }

        if (v.getCodVoo() > 0
                && v.getNumVoo() != null && !v.getNumVoo().trim().isEmpty()
                && v.getAviao() != null && !v.getAviao().trim().isEmpty()
                && v.getCompanhia() != null && !v.getCompanhia().trim().isEmpty()
                && v.getDataHoraPartida() != null && v.getDataHoraChegada() != null
                && v.getAeroPartida() != null && v.getAeroPartida().getCodAeroporto() > 0
                && v.getAeroDestino() != null && v.getAeroDestino().getCodAeroporto() > 0) {

            v.setStatus(1);
            VooModelo vM = new VooModelo();
            vM.inserirVoo(v);
            modelo.addAttribute("mensagem", "Voo cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar voo");
        }
        return "adicionarVoo";
    }

    @RequestMapping(value = "/consultarVoo", method = RequestMethod.GET)
    public String consultarVoo() {
        return "consultarVoo";
    }

    @RequestMapping(value = "/consultarVoo", method = RequestMethod.POST)
    public String consultarVoo(@ModelAttribute("voo") Voo v, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarVoo";
        }

        VooModelo vM = new VooModelo();
        Voo encontrado = vM.consultarVooCodigo(v.getCodVoo());

        if (encontrado != null) {
            modelo.addAttribute("VooNum", encontrado.getNumVoo());
            modelo.addAttribute("VooAviao", encontrado.getAviao());
            modelo.addAttribute("VooCompanhia", encontrado.getCompanhia());
            modelo.addAttribute("VooPartida", encontrado.getDataHoraPartida());
            modelo.addAttribute("VooChegada", encontrado.getDataHoraChegada());
            modelo.addAttribute("VooAeroPartida", encontrado.getAeroPartida() != null ? encontrado.getAeroPartida().getCodAeroporto() : "");
            modelo.addAttribute("VooAeroDestino", encontrado.getAeroDestino() != null ? encontrado.getAeroDestino().getCodAeroporto() : "");
        } else {
            modelo.addAttribute("mensagem", "Voo não encontrado");
        }
        return "consultarVoo";
    }

    @RequestMapping(value = "/alterarVoo", method = RequestMethod.GET)
    public String alterarVoo() {
        return "alterarVoo";
    }

    @RequestMapping(value = "/alterarVoo", method = RequestMethod.POST)
    public String alterarVoo(@ModelAttribute("voo") Voo v, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarVoo";
        }

        VooModelo vM = new VooModelo();
        Voo vooSelecionado = vM.consultarVooCodigo(v.getCodVoo());

        if (v.getNumVoo() != null && !v.getNumVoo().trim().isEmpty()
                && v.getAviao() != null && !v.getAviao().trim().isEmpty()
                && v.getCompanhia() != null && !v.getCompanhia().trim().isEmpty()
                && v.getDataHoraPartida() != null && v.getDataHoraChegada() != null
                && v.getAeroPartida() != null && v.getAeroPartida().getCodAeroporto() > 0
                && v.getAeroDestino() != null && v.getAeroDestino().getCodAeroporto() > 0) {

            v.setStatus(1);
            vM.alterarVoo(v);

            Voo vazio = new Voo();
            vazio.setAeroPartida(new Aeroporto());
            vazio.setAeroDestino(new Aeroporto());
            modelo.addAttribute("voo", vazio);
            modelo.addAttribute("mensagem", "Voo alterado com sucesso!");
        } else {
            modelo.addAttribute("voo", vooSelecionado != null ? vooSelecionado : v);
        }

        return "alterarVoo";
    }

    @RequestMapping(value = "/removerVoo", method = RequestMethod.GET)
    public String removerVoo() {
        return "removerVoo";
    }

    @RequestMapping(value = "/removerVoo", method = RequestMethod.POST)
    public String removerVoo(@RequestParam("codVoo") int codVoo, Model modelo) {
        return "removerVoo";
    }
}