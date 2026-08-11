package br.com.webplanet.controle;

import br.com.webplanet.daos.Cidade;
import br.com.webplanet.daos.Hotel;
import br.com.webplanet.modelo.CidadeModelo;
import br.com.webplanet.modelo.HotelModelo;
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
public class HotelControle {

    @GetMapping("/menuHotel")
    public String menuHotel() {
        return "menuHotel";
    }

    @ModelAttribute("hotel")
    public Hotel criarModeloHotel() {
        Hotel h = new Hotel();
        h.setCidade(new Cidade());
        return h;
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

    @RequestMapping(value = "/listarTodosHotel", method = RequestMethod.GET)
    public ModelAndView listarTodosHotel() {
        HotelModelo hotM = new HotelModelo();
        ArrayList<Hotel> listaH = hotM.consultarHoteis();
        ModelAndView mv = new ModelAndView("listarTodosHotel");
        mv.addObject("hoteis", listaH);
        return mv;
    }

    @RequestMapping(value = "/adicionarHotel", method = RequestMethod.GET)
    public String adicionarHotel() {
        return "adicionarHotel";
    }

    @RequestMapping(value = "/adicionarHotel", method = RequestMethod.POST)
    public String adicionarHotel(@ModelAttribute("hotel") Hotel h, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarHotel";
        }

        if (h.getLocal() != null && !h.getLocal().trim().isEmpty()
                && h.getCNPJ() != null && !h.getCNPJ().trim().isEmpty()
                && h.getEndereco() != null && !h.getEndereco().trim().isEmpty()
                && h.getCidade() != null && h.getCidade().getCodCidade() > 0) {

            h.setStatus(1);
            HotelModelo hotM = new HotelModelo();
            hotM.inserirHotel(h);
            modelo.addAttribute("mensagem", "Hotel cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar Hotel");
        }
        return "adicionarHotel";
    }

    @RequestMapping(value = "/consultarHotel", method = RequestMethod.GET)
    public String consultarHotel() {
        return "consultarHotel";
    }

    @RequestMapping(value = "/consultarHotel", method = RequestMethod.POST)
    public String consultarHotel(@ModelAttribute("hotel") Hotel h, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarHotel";
        }

        HotelModelo hotM = new HotelModelo();
        Hotel encontrado = hotM.consultarHotelCodigo(h.getCodHotel());

        if (encontrado != null) {
            modelo.addAttribute("HotelLocal", encontrado.getLocal());
            modelo.addAttribute("HotelEndereco", encontrado.getEndereco());
            modelo.addAttribute("HotelCNPJ", encontrado.getCNPJ());
            modelo.addAttribute("HotelCheckIn", encontrado.getCheckIn());
            modelo.addAttribute("HotelCheckOut", encontrado.getCheckOut());
            modelo.addAttribute("HotelCidade", encontrado.getCidade() != null ? encontrado.getCidade().getCodCidade() : "");
        } else {
            modelo.addAttribute("mensagem", "Hotel não encontrado");
        }
        return "consultarHotel";
    }

    @RequestMapping(value = "/alterarHotel", method = RequestMethod.GET)
    public String alterarHotel() {
        return "alterarHotel";
    }

    @RequestMapping(value = "/alterarHotel", method = RequestMethod.POST)
    public String alterarHotel(@ModelAttribute("hotel") Hotel h, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarHotel";
        }

        HotelModelo hotM = new HotelModelo();
        Hotel hotelSelecionado = hotM.consultarHotelCodigo(h.getCodHotel());

        if (h.getLocal() != null && !h.getLocal().trim().isEmpty()
                && h.getEndereco() != null && !h.getEndereco().trim().isEmpty()
                && h.getCNPJ() != null && !h.getCNPJ().trim().isEmpty()
                && h.getCidade() != null && h.getCidade().getCodCidade() > 0) {

            h.setStatus(1);
            hotM.alterarHotel(h);

            Hotel vazio = new Hotel();
            vazio.setCidade(new Cidade());
            modelo.addAttribute("hotel", vazio);
            modelo.addAttribute("mensagem", "Hotel alterado com sucesso!");
        } else {
            modelo.addAttribute("hotel", hotelSelecionado != null ? hotelSelecionado : h);
        }

        return "alterarHotel";
    }

    @RequestMapping(value = "/removerHotel", method = RequestMethod.GET)
    public String removerHotel() {
        return "removerHotel";
    }

    @RequestMapping(value = "/removerHotel", method = RequestMethod.POST)
    public String removerHotel(@RequestParam("codHotel") int codHotel, Model modelo) {
        return "removerHotel";
    }
}