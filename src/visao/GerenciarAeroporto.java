package visao;

import controle.AeroportoControle;
import modelo.Aeroporto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GerenciarAeroporto extends JFrame {
    private AeroportoControle controle = new AeroportoControle();
    private JTextField txtCod, txtNome, txtCodCidade;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public GerenciarAeroporto() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {
        setTitle("Gerenciar Aeroportos - SkyMilles");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel Superior: Formulário
        JPanel pCampos = new JPanel(new GridLayout(3, 2, 5, 5));
        pCampos.setBorder(BorderFactory.createTitledBorder("Dados do Aeroporto"));
        
        pCampos.add(new JLabel("Cód. Aeroporto:"));
        txtCod = new JTextField(); pCampos.add(txtCod);
        
        pCampos.add(new JLabel("Nome Aeroporto:"));
        txtNome = new JTextField(); pCampos.add(txtNome);
        
        pCampos.add(new JLabel("Cód. Cidade (FK):"));
        txtCodCidade = new JTextField(); pCampos.add(txtCodCidade);

        // Painel de Botões
        JPanel pBotoes = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Inserir");
        JButton btnEdit = new JButton("Alterar");
        JButton btnDel = new JButton("Remover");
        
        pBotoes.add(btnAdd); pBotoes.add(btnEdit); pBotoes.add(btnDel);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Nome", "Cód. Cidade"}, 0);
        tabela = new JTable(modeloTabela);

        // Ações
        btnAdd.addActionListener(e -> {
            Aeroporto a = new Aeroporto(Integer.parseInt(txtCod.getText()), txtNome.getText(), Integer.parseInt(txtCodCidade.getText()));
            controle.inserirAeroporto(a);
            carregarTabela();
        });

        btnDel.addActionListener(e -> {
            controle.removerAeroporto(Integer.parseInt(txtCod.getText()));
            carregarTabela();
        });

        add(pCampos, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (Aeroporto a : controle.consultarAeroportos()) {
            modeloTabela.addRow(new Object[]{a.getCodAeroporto(), a.getNomeAero(), a.getCodCidade()});
        }
    }

    public static void main(String[] args) {
        new GerenciarAeroporto().setVisible(true);
    }
}