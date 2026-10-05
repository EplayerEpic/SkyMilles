package br.com.webplanet.utils;

import org.springframework.ui.Model;

/**
 * Monta as mensagens da tela de remoção. No sistema nada é deletado de
 * verdade: o registro é desativado (status = 0) e os triggers do banco
 * desativam os dependentes em cascata.
 */
public class RemocaoUtils {

    public static void preencher(Model modelo, String resultado, String entidade, int codigo) {
        if ("removido".equals(resultado)) {
            modelo.addAttribute("aviso", "Não é possível deletar registros do sistema. "
                    + entidade + " nº " + codigo + " foi apenas desativado (status = 0), "
                    + "e os registros dependentes foram desativados em cascata.");
        } else if ("inexistente".equals(resultado)) {
            modelo.addAttribute("erro", entidade + " nº " + codigo
                    + " não foi encontrado ou já está desativado.");
        } else {
            modelo.addAttribute("erro", "Não foi possível remover " + entidade
                    + " nº " + codigo + " (erro SQL " + resultado + ").");
        }
    }
}