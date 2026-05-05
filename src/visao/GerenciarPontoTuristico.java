package visao;

import controle.CidadeControle;
import controle.PontoTuristicoControle;
import modelo.PontoTuristico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GerenciarPontoTuristico extends JFrame {
    private PontoTuristicoControle controle = new PontoTuristicoControle();
    private JTextField txtCod, txtDesc, txtEnd, txtCodCidade;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public GerenciarPontoTuristico() {
        setTitle("SkyMilles - Pontos Turísticos");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Formulário
        JPanel pCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        pCampos.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        pCampos.add(new JLabel("Código:")); txtCod = new JTextField(); pCampos.add(txtCod);
        pCampos.add(new JLabel("Descrição:")); txtDesc = new JTextField(); pCampos.add(txtDesc);
        pCampos.add(new JLabel("Endereço:")); txtEnd = new JTextField(); pCampos.add(txtEnd);
        pCampos.add(new JLabel("Cód. Cidade:")); txtCodCidade = new JTextField(); pCampos.add(txtCodCidade);

        // Botões
        JPanel pBotoes = new JPanel();
        JButton btnAdd = new JButton("Inserir");
        JButton btnDel = new JButton("Remover");
        pBotoes.add(btnAdd); pBotoes.add(btnDel);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Descrição", "Endereço", "Cidade"}, 0);
        tabela = new JTable(modeloTabela);

        // Eventos
        btnAdd.addActionListener(e -> {
            CidadeControle cc = new CidadeControle();
            PontoTuristico p = new PontoTuristico(
                Integer.parseInt(txtCod.getText()), 
                txtDesc.getText(), 
                txtEnd.getText(), 
                cc.consultarCidadeCodigo(Integer.parseInt(txtCodCidade.getText()))
            );
            controle.inserirPonto(p);
            carregarTabela();
        });

        add(pCampos, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);
        carregarTabela();
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (PontoTuristico p : controle.consultarPontos()) {
            modeloTabela.addRow(new Object[]{p.getCodPonto(), p.getDescricao(), p.getEndereco(), p.getCodCidade()});
        }
    }

    public static void main(String[] args) {
        new GerenciarPontoTuristico().setVisible(true);
    }
}