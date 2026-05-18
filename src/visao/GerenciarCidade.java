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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Painel de Campos
        JPanel pCampos = new JPanel(new GridLayout(2, 4, 10, 10));
        pCampos.setBorder(BorderFactory.createTitledBorder("Dados da Cidade"));
        
        
        pCampos.add(new JLabel("DDD:"));
        txtDdd = new JTextField(); pCampos.add(txtDdd);
        pCampos.add(new JLabel("Estado:"));
        txtEstado = new JTextField(); pCampos.add(txtEstado);
        pCampos.add(new JLabel("Nome:"));
        txtNome = new JTextField(); pCampos.add(txtNome);
        txtCod = new JTextField(); pCampos.add(txtCod);
        txtCod.setVisible(false);

        // Painel de Botões
        JPanel pBotoes = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Inserir");
        JButton btnAlt = new JButton("Alterar");
        JButton btnDel = new JButton("Remover");
        
        pBotoes.add(btnAdd); pBotoes.add(btnAlt); pBotoes.add(btnDel);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"Cód", "DDD", "Estado", "Nome"}, 0);
        tabela = new JTable(modeloTabela);
        
        btnAdd.addActionListener(e -> {
            controle.inserirCidade(new Cidade(Integer.parseInt(txtCod.getText()), txtDdd.getText(), txtEstado.getText(), txtNome.getText()));
            carregarTabela();
            limparCampos();
        });
        btnAlt.addActionListener(e -> {
            int linha = tabela.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto na tabela.");
                return;
            }

            Cidade c = new Cidade(Integer.parseInt(txtCod.getText()), txtDdd.getText(), txtEstado.getText(), txtNome.getText());
            CidadeControle cc = new CidadeControle();
            cc.alterarCidade(c);

            carregarTabela();
            limparCampos();
        });
        btnDel.addActionListener(e -> {
            CidadeControle cc = new CidadeControle();
            cc.removerCidade(Integer.parseInt(txtCod.getText()));
            carregarTabela();
            limparCampos();
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int linha = tabela.getSelectedRow();
                txtCod.setText(tabela.getValueAt(linha, 0).toString());
                txtDdd.setText(tabela.getValueAt(linha, 1).toString());
                txtEstado.setText(tabela.getValueAt(linha, 2).toString());
                txtNome.setText(tabela.getValueAt(linha, 3).toString());
            }
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

    public void limparCampos() {

        txtCod.setText("");

        txtDdd.setText("");

        txtEstado.setText("");

        txtNome.setText("");
    }

}