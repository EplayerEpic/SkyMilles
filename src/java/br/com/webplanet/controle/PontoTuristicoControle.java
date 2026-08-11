package br.com.webplanet.controle;

import br.com.webplanet.daos.Cidade;
import br.com.webplanet.daos.PontoTuristico;
import br.com.webplanet.modelo.CidadeModelo;
import br.com.webplanet.modelo.PontoTuristicoModelo;
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
public class PontoTuristicoControle {

    @GetMapping("/menuPonto")
    public String menuPonto() {
        return "menuPonto";
    }

    @ModelAttribute("ponto")
    public PontoTuristico criarPontoModelo() {
        PontoTuristico p = new PontoTuristico();
        p.setCidade(new Cidade());
        return p;
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

    @ModelAttribute("webConsultarPontos")
    public Map<Integer, String> consultarPontosMap() {
        Map<Integer, String> map = new HashMap<>();
        PontoTuristicoModelo ptM = new PontoTuristicoModelo();
        ArrayList<PontoTuristico> lista = ptM.consultarPontos();
        for (PontoTuristico p : lista) {
            map.put(p.getCodPonto(), "Ponto " + p.getCodPonto() + " - " + p.getDescricao());
        }
        return map;
    }

    @RequestMapping(value = "/listarPontos", method = RequestMethod.GET)
    public ModelAndView listarPontos() {
        PontoTuristicoModelo ptM = new PontoTuristicoModelo();
        ArrayList<PontoTuristico> listaP = ptM.consultarPontos();
        ModelAndView mv = new ModelAndView("listarTodosPontos");
        mv.addObject("pontos", listaP);
        return mv;
    }

    @RequestMapping(value = "/adicionarPonto", method = RequestMethod.GET)
    public String adicionarPonto() {
        return "adicionarPonto";
    }

    @RequestMapping(value = "/adicionarPonto", method = RequestMethod.POST)
    public String adicionarPonto(@ModelAttribute("ponto") PontoTuristico p, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarPonto";
        }

        if (p.getCodPonto() > 0
                && p.getDescricao() != null && !p.getDescricao().trim().isEmpty()
                && p.getEndereco() != null && !p.getEndereco().trim().isEmpty()
                && p.getCidade() != null && p.getCidade().getCodCidade() > 0) {

            p.setStatus(1);
            PontoTuristicoModelo ptM = new PontoTuristicoModelo();
            ptM.inserirPonto(p);
            modelo.addAttribute("mensagem", "Ponto turístico cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar ponto turístico");
        }
        return "adicionarPonto";
    }

    @RequestMapping(value = "/consultarPonto", method = RequestMethod.GET)
    public String consultarPonto() {
        return "consultarPonto";
    }

    @RequestMapping(value = "/consultarPonto", method = RequestMethod.POST)
    public String consultarPonto(@ModelAttribute("ponto") PontoTuristico p, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarPonto";
        }

        PontoTuristicoModelo ptM = new PontoTuristicoModelo();
        PontoTuristico encontrado = ptM.consultarPontoCodigo(p.getCodPonto());

        if (encontrado != null) {
            modelo.addAttribute("PontoDescricao", encontrado.getDescricao());
            modelo.addAttribute("PontoEndereco", encontrado.getEndereco());
            modelo.addAttribute("PontoCidade", encontrado.getCidade() != null ? encontrado.getCidade().getCodCidade() : "");
        } else {
            modelo.addAttribute("mensagem", "Ponto turístico não encontrado");
        }
        return "consultarPonto";
    }

    @RequestMapping(value = "/alterarPonto", method = RequestMethod.GET)
    public String alterarPonto() {
        return "alterarPonto";
    }

    @RequestMapping(value = "/alterarPonto", method = RequestMethod.POST)
    public String alterarPonto(@ModelAttribute("ponto") PontoTuristico p, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarPonto";
        }

        PontoTuristicoModelo ptM = new PontoTuristicoModelo();
        PontoTuristico pontoSelecionado = ptM.consultarPontoCodigo(p.getCodPonto());

        if (p.getDescricao() != null && !p.getDescricao().trim().isEmpty()
                && p.getEndereco() != null && !p.getEndereco().trim().isEmpty()
                && p.getCidade() != null && p.getCidade().getCodCidade() > 0) {

            p.setStatus(1);
            ptM.alterarPonto(p);

            PontoTuristico vazio = new PontoTuristico();
            vazio.setCidade(new Cidade());
            modelo.addAttribute("ponto", vazio);
            modelo.addAttribute("mensagem", "Ponto turístico alterado com sucesso!");
        } else {
            modelo.addAttribute("ponto", pontoSelecionado != null ? pontoSelecionado : p);
        }

        return "alterarPonto";
    }

    @RequestMapping(value = "/removerPonto", method = RequestMethod.GET)
    public String removerPonto() {
        return "removerPonto";
    }

    @RequestMapping(value = "/removerPonto", method = RequestMethod.POST)
    public String removerPonto(@RequestParam("codPonto") int codPonto, Model modelo) {
        return "removerPonto";
    }
}