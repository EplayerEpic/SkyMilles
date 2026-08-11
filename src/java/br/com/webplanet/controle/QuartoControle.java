package br.com.webplanet.controle;

import br.com.webplanet.daos.Hotel;
import br.com.webplanet.daos.Quarto;
import br.com.webplanet.modelo.HotelModelo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuartoControle {

    @GetMapping("/menuQuarto")
    public String menuQuarto() {
        return "menuQuarto";
    }

    @ModelAttribute("quarto")
    public Quarto criarQuartoModelo() {
        Quarto q = new Quarto();
        q.setHotel(new Hotel());
        return q;
    }

    @ModelAttribute("webConsultarHoteis")
    public Map<Integer, String> consultarHoteisMap() {
        Map<Integer, String> map = new HashMap<>();
        HotelModelo hotM = new HotelModelo();
        ArrayList<Hotel> lista = hotM.consultarHoteis();
        for (Hotel h : lista) {
            map.put(h.getCodHotel(), h.getLocal());
        }
        return map;
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

    @RequestMapping(value = "/listarQuartos", method = RequestMethod.GET)
    public ModelAndView listarQuartos() {
        QuartoModelo qM = new QuartoModelo();
        ArrayList<Quarto> listaQ = qM.consultarQuartos();
        ModelAndView mv = new ModelAndView("listarTodosQuartos");
        mv.addObject("quartos", listaQ);
        return mv;
    }

    @RequestMapping(value = "/adicionarQuarto", method = RequestMethod.GET)
    public String adicionarQuarto() {
        return "adicionarQuarto";
    }

    @RequestMapping(value = "/adicionarQuarto", method = RequestMethod.POST)
    public String adicionarQuarto(@ModelAttribute("quarto") Quarto q, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarQuarto";
        }

        if (q.getValorReserva() > 0
                && q.getLocalSaida() != null && !q.getLocalSaida().trim().isEmpty()
                && q.getLocalChegada() != null && !q.getLocalChegada().trim().isEmpty()
                && q.getDataInicio() != null && !q.getDataInicio().trim().isEmpty()
                && q.getQntdDiarias() > 0
                && q.getHotel() != null && q.getHotel().getCodHotel() > 0) {

            q.setStatus(1);
            QuartoModelo qM = new QuartoModelo();
            qM.inserirQuarto(q);
            modelo.addAttribute("mensagem", "Quarto cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar quarto");
        }
        return "adicionarQuarto";
    }

    @RequestMapping(value = "/consultarQuarto", method = RequestMethod.GET)
    public String consultarQuarto() {
        return "consultarQuarto";
    }

    @RequestMapping(value = "/consultarQuarto", method = RequestMethod.POST)
    public String consultarQuarto(@ModelAttribute("quarto") Quarto q, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarQuarto";
        }

        QuartoModelo qM = new QuartoModelo();
        Quarto encontrado = qM.consultarQuartoCodigo(q.getCodQuarto());

        if (encontrado != null) {
            modelo.addAttribute("QuartoValor", encontrado.getValorReserva());
            modelo.addAttribute("QuartoSaida", encontrado.getLocalSaida());
            modelo.addAttribute("QuartoChegada", encontrado.getLocalChegada());
            modelo.addAttribute("QuartoDataInicio", encontrado.getDataInicio());
            modelo.addAttribute("QuartoDiarias", encontrado.getQntdDiarias());
            modelo.addAttribute("QuartoHotel", encontrado.getHotel() != null ? encontrado.getHotel().getCodHotel() : "");
        } else {
            modelo.addAttribute("mensagem", "Quarto não encontrado");
        }
        return "consultarQuarto";
    }

    @RequestMapping(value = "/alterarQuarto", method = RequestMethod.GET)
    public String alterarQuarto() {
        return "alterarQuarto";
    }

    @RequestMapping(value = "/alterarQuarto", method = RequestMethod.POST)
    public String alterarQuarto(@ModelAttribute("quarto") Quarto q, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarQuarto";
        }

        QuartoModelo qM = new QuartoModelo();
        Quarto quartoSelecionado = qM.consultarQuartoCodigo(q.getCodQuarto());

        if (q.getValorReserva() > 0
                && q.getLocalSaida() != null && !q.getLocalSaida().trim().isEmpty()
                && q.getLocalChegada() != null && !q.getLocalChegada().trim().isEmpty()
                && q.getDataInicio() != null && !q.getDataInicio().trim().isEmpty()
                && q.getQntdDiarias() > 0
                && q.getHotel() != null && q.getHotel().getCodHotel() > 0) {

            q.setStatus(1);
            qM.alterarQuarto(q);

            Quarto vazio = new Quarto();
            vazio.setHotel(new Hotel());
            modelo.addAttribute("quarto", vazio);
            modelo.addAttribute("mensagem", "Quarto alterado com sucesso!");
        } else {
            modelo.addAttribute("quarto", quartoSelecionado != null ? quartoSelecionado : q);
        }

        return "alterarQuarto";
    }

    @RequestMapping(value = "/removerQuarto", method = RequestMethod.GET)
    public String removerQuarto() {
        return "removerQuarto";
    }

    @RequestMapping(value = "/removerQuarto", method = RequestMethod.POST)
    public String removerQuarto(@RequestParam("codQuarto") int codQuarto, Model modelo) {
        return "removerQuarto";
    }
}