/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.controle;

import br.com.webplanet.daos.Hotel;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aluno
 */
@Controller
public class HotelControle {
    
      @RequestMapping(value = "/adicionarHotel", method = RequestMethod.GET)
    public ModelAndView adicionarHotel() {
        return new ModelAndView("adicionarHotel", "Hotel", new Hotel());
    }
     @GetMapping("/menuHotel")
    public String menuHotel() {
        return "menuHotel";
    }
    
    @GetMapping("/removerHotel")
    public String removerHotel(){
      return "removerHotel";
    }
    @RequestMapping(value = "/consultarHotel", method = RequestMethod.GET)
    public ModelAndView consultarHotel() {
        return new ModelAndView("consultarHotel", "Hotel", new Hotel());
    }

    @RequestMapping(value = "/alterarHotel", method = RequestMethod.GET)
    public ModelAndView alterarHotel() {
        return new ModelAndView("alterarHotel", "Hotel", new Hotel());
    }

    @RequestMapping(value = "/listarTodosHotel", method = RequestMethod.GET)
    public ModelAndView listarTodosHotel() {
        HotelModelo HotelM = new HotelModelo();
      
        ArrayList<Hotel> listaC = HotelM.consultarHoteis();
        ModelAndView mv = new ModelAndView("listarTodosHotel");
        mv.addObject("hotel", listaC);
        return mv;
    }
    
    @ModelAttribute("Hotel")
    public Hotel criarModeloHotel(){
     return new Hotel();
    }

    @ModelAttribute("webConsultarHoteis")
    public Map<Integer, String> consultarHoteis() {
        Map<Integer, String> map = new HashMap<>();
        HotelModelo HotelM = new HotelModelo();
        ArrayList<Hotel> listaC = HotelM.consultarHoteis();

        for (int i = 0; i < listaC.size(); i++) {
            map.put(listaC.get(i).getCodHotel(), listaC.get(i).getLocal());
        }
        return map;
    }
    
    @RequestMapping(value = "/adicionarHotel", method = RequestMethod.POST)
    public String adicionarHotel(@ModelAttribute("Hotel") Hotel est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarHotel";
        }
        HotelModelo HotelM = new HotelModelo();
        
        if (est.getLocal() != null && !est.getLocal().trim().isEmpty()
                && est.getCNPJ() != null && !est.getCNPJ().trim().isEmpty()
                && est.getEndereco() != null && !est.getEndereco().trim().isEmpty()) {
            HotelM.inserirHotel(est);
            modelo.addAttribute("mensagem", "Hotel Adicionado com Sucesso!");
        }
        else{
            modelo.addAttribute("mensagem", "Erro ao cadastrar Hotel");
        }
        return "adicionarHotel";
    }

    /**
     *
     * @param est
     * @param bindingResult
     * @param modelo
     * @return
     */
    @RequestMapping(value = "/consultarHotel", method = RequestMethod.POST)
    public String consultarHotel(@ModelAttribute("hotel") Hotel est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarHotel";
        }
        HotelModelo HotelM = new HotelModelo();
        Hotel Hotel = HotelM.consultarHotelCodigo(est.getCodHotel());
        modelo.addAttribute("HotelLocal", Hotel.getLocal());
        modelo.addAttribute("HotelEndereço", Hotel.getEndereco());
        modelo.addAttribute("HotelCNPJ", Hotel.getCNPJ());
        return "consultarHotel";
    }

    /**
     * Trabalhando(pqp que saco isso, ter que estudar mais pra mexer nisso)*
     */
    @RequestMapping(value = "/alterarHotel", method = RequestMethod.POST)
    public String alterarHotel(@ModelAttribute("hotel") Hotel est, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarHotel";
        }

        HotelModelo HotelM = new HotelModelo();
        Hotel HotelSelect = HotelM.consultarHotelCodigo(est.getCodHotel());

        if (est.getLocal() != null && !est.getLocal().trim().isEmpty()
                && est.getEndereco() != null && !est.getEndereco().trim().isEmpty()
                && est.getCNPJ() != null && !est.getCNPJ().trim().isEmpty()) {

            HotelM.alterarHotel(est);

            // salvou com sucesso -> devolve form limpo, não repopulado
            modelo.addAttribute("hotel", new Hotel());
            modelo.addAttribute("mensagem", "Hotel alterada com sucesso!");
        } else {
            // foi só a troca do select (onchange) -> aqui sim repopula
            modelo.addAttribute("hotel", HotelSelect);
        }

        return "alterarHotel";
    }
    
}
