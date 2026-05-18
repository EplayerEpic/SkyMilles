package visao;

import com.formdev.flatlaf.FlatDarkLaf;
import controle.CidadeControle;
import modelo.Cidade;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GerenciarCidade extends JFrame {
    private CidadeControle controle = new CidadeControle();
    private JTextField txtCod, txtDdd, txtEstado, txtNome;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public GerenciarCidade() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {
        setTitle("Gerenciar Cidades - SkyMilles");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel de Campos
        JPanel pCampos = new JPanel(new GridLayout(2, 4, 10, 10));
        pCampos.setBorder(BorderFactory.createTitledBorder("Dados da Cidade"));
        
        pCampos.add(new JLabel("Código:"));
        txtCod = new JTextField(); pCampos.add(txtCod);
        pCampos.add(new JLabel("DDD:"));
        txtDdd = new JTextField(); pCampos.add(txtDdd);
        pCampos.add(new JLabel("Estado:"));
        txtEstado = new JTextField(); pCampos.add(txtEstado);
        pCampos.add(new JLabel("Nome:"));
        txtNome = new JTextField(); pCampos.add(txtNome);

        // Painel de Botões
        JPanel pBotoes = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Inserir");
        JButton btnEdit = new JButton("Alterar");
        JButton btnDel = new JButton("Remover");
        
        pBotoes.add(btnAdd); pBotoes.add(btnEdit); pBotoes.add(btnDel);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"Cód", "DDD", "Estado", "Nome"}, 0);
        tabela = new JTable(modeloTabela);
        
        btnAdd.addActionListener(e -> {
            controle.inserirCidade(new Cidade(Integer.parseInt(txtCod.getText()), txtDdd.getText(), txtEstado.getText(), txtNome.getText()));
            carregarTabela();
        });

        add(pCampos, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (Cidade c : controle.consultarCidades()) {
            modeloTabela.addRow(new Object[]{c.getCodCidade(), c.getDdd(), c.getEstado(), c.getNomeCidade()});
        }
    }

    public static void main(String args[]) {

        try {
            FlatDarkLaf.setup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new GerenciarCidade().setVisible(true));
    }
}