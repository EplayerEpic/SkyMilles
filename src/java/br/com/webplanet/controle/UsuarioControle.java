package br.com.webplanet.controle;

import br.com.webplanet.daos.Clientes;
import br.com.webplanet.daos.Usuario;
import br.com.webplanet.modelo.ClientesModelo;
import br.com.webplanet.modelo.UsuarioModelo;
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
public class UsuarioControle {

    @GetMapping("/menuUsuario")
    public String menuUsuario() {
        return "menuUsuario";
    }

    @ModelAttribute("usuario")
    public Usuario criarUsuarioModelo() {
        Usuario u = new Usuario();
        u.setUsuCliente(new Clientes());
        return u;
    }

    @ModelAttribute("webConsultarClientes")
    public Map<Integer, String> consultarClientesMap() {
        Map<Integer, String> map = new HashMap<>();
        ClientesModelo cliM = new ClientesModelo();
        ArrayList<Clientes> lista = cliM.consultarClientes();
        for (Clientes c : lista) {
            map.put(c.getCliCodigo(), c.getCliNome());
        }
        return map;
    }

    @ModelAttribute("webConsultarUsuarios")
    public Map<Integer, String> consultarUsuariosMap() {
        Map<Integer, String> map = new HashMap<>();
        UsuarioModelo usuM = new UsuarioModelo();
        ArrayList<Usuario> lista = usuM.consultarUsuarios();
        for (Usuario u : lista) {
            map.put(u.getUsuCodigo(), "Usuário " + u.getUsuCodigo() + " - " + u.getUsuLogin());
        }
        return map;
    }

    @RequestMapping(value = "/listarTodosUsuario", method = RequestMethod.GET)
    public ModelAndView listarTodosUsuario() {
        UsuarioModelo usuM = new UsuarioModelo();
        ArrayList<Usuario> listaU = usuM.consultarUsuarios();
        ModelAndView mv = new ModelAndView("listarTodosUsuario");
        mv.addObject("usuarios", listaU);
        return mv;
    }

    @RequestMapping(value = "/adicionarUsuario", method = RequestMethod.GET)
    public String adicionarUsuario() {
        return "adicionarUsuario";
    }

    @RequestMapping(value = "/adicionarUsuario", method = RequestMethod.POST)
    public String adicionarUsuario(@ModelAttribute("usuario") Usuario u, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "adicionarUsuario";
        }

        if (u.getUsuLogin() != null && !u.getUsuLogin().trim().isEmpty()
                && u.getUsuSenha() != null && !u.getUsuSenha().trim().isEmpty()
                && u.getUsuEmail() != null && !u.getUsuEmail().trim().isEmpty()
                && u.getUsuCliente() != null && u.getUsuCliente().getCliCodigo() > 0) {

            u.setStatus(1);
            UsuarioModelo usuM = new UsuarioModelo();
            usuM.inserirUsuario(u);
            modelo.addAttribute("mensagem", "Usuário cadastrado com sucesso");
        } else {
            modelo.addAttribute("mensagem", "Erro ao cadastrar usuário");
        }
        return "adicionarUsuario";
    }

    @RequestMapping(value = "/consultarUsuario", method = RequestMethod.GET)
    public String consultarUsuario() {
        return "consultarUsuario";
    }

    @RequestMapping(value = "/consultarUsuario", method = RequestMethod.POST)
    public String consultarUsuario(@ModelAttribute("usuario") Usuario u, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "consultarUsuario";
        }

        UsuarioModelo usuM = new UsuarioModelo();
        Usuario encontrado = usuM.consultarUsuarioCodigo(u.getUsuCodigo());

        if (encontrado != null) {
            modelo.addAttribute("UsuarioLogin", encontrado.getUsuLogin());
            modelo.addAttribute("UsuarioEmail", encontrado.getUsuEmail());
            modelo.addAttribute("UsuarioCliente", encontrado.getUsuCliente() != null ? encontrado.getUsuCliente().getCliCodigo() : "");
        } else {
            modelo.addAttribute("mensagem", "Usuário não encontrado");
        }
        return "consultarUsuario";
    }

    @RequestMapping(value = "/alterarUsuario", method = RequestMethod.GET)
    public String alterarUsuario() {
        return "alterarUsuario";
    }

    @RequestMapping(value = "/alterarUsuario", method = RequestMethod.POST)
    public String alterarUsuario(@ModelAttribute("usuario") Usuario u, BindingResult bindingResult, Model modelo) {
        if (bindingResult.hasErrors()) {
            return "alterarUsuario";
        }

        UsuarioModelo usuM = new UsuarioModelo();
        Usuario usuarioSelecionado = usuM.consultarUsuarioCodigo(u.getUsuCodigo());

        if (u.getUsuLogin() != null && !u.getUsuLogin().trim().isEmpty()
                && u.getUsuSenha() != null && !u.getUsuSenha().trim().isEmpty()
                && u.getUsuEmail() != null && !u.getUsuEmail().trim().isEmpty()
                && u.getUsuCliente() != null && u.getUsuCliente().getCliCodigo() > 0) {

            u.setStatus(1);
            usuM.alterarUsuario(u);

            Usuario vazio = new Usuario();
            vazio.setUsuCliente(new Clientes());
            modelo.addAttribute("usuario", vazio);
            modelo.addAttribute("mensagem", "Usuário alterado com sucesso!");
        } else {
            modelo.addAttribute("usuario", usuarioSelecionado != null ? usuarioSelecionado : u);
        }

        return "alterarUsuario";
    }

    @RequestMapping(value = "/removerUsuario", method = RequestMethod.GET)
    public String removerUsuario() {
        return "removerUsuario";
    }

    @RequestMapping(value = "/removerUsuario", method = RequestMethod.POST)
    public String removerUsuario(@RequestParam("usuCodigo") int usuCodigo, Model modelo) {
        return "removerUsuario";
    }
}