package visao;

import com.formdev.flatlaf.FlatDarkLaf;
import controle.AeroportoControle;
import controle.CidadeControle;
import modelo.Aeroporto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import modelo.Cidade;

public class GerenciarAeroporto extends JFrame {

    private AeroportoControle controle = new AeroportoControle();
    private JTextField txtCod, txtNome;
    private JComboBox<Cidade> comboCidade;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public GerenciarAeroporto() {
        initComponents();
        carregarCidade();
        carregarTabela();
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                txtCod.setText(tabela.getValueAt(linha, 0).toString());
                txtNome.setText(tabela.getValueAt(linha, 1).toString());
                Cidade c = (Cidade) tabela.getValueAt(linha, 2);
                comboCidade.setSelectedItem(c);
            }
        }
    });
        
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

       

        pCampos.add(new JLabel("Nome Aeroporto:"));
        txtNome = new JTextField();
        pCampos.add(txtNome);

        pCampos.add(new JLabel("Cidade:"));
        comboCidade = new JComboBox();
        pCampos.add(comboCidade);
        txtCod = new JTextField();
        pCampos.add(txtCod);
        txtCod.setVisible(false);
        // Painel de Botões
        JPanel pBotoes = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Inserir");
        JButton btnAlt = new JButton("Alterar");
        JButton btnDel = new JButton("Remover");

        pBotoes.add(btnAdd);
        pBotoes.add(btnAlt);
        pBotoes.add(btnDel);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Nome", "Cidade"}, 0);
        tabela = new JTable(modeloTabela);

        // Ações
        btnAdd.addActionListener(e -> {
            Cidade c = (Cidade) comboCidade.getSelectedItem();
            Aeroporto a = new Aeroporto(Integer.parseInt(txtCod.getText()), txtNome.getText(), c);
            controle.inserirAeroporto(a);
            carregarTabela();
        });
        btnAlt.addActionListener(e -> {
            int linha = tabela.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto na tabela.");
                return;
            }
            Cidade c = (Cidade) comboCidade.getSelectedItem();

            Aeroporto a = new Aeroporto(Integer.parseInt(txtCod.getText()), txtNome.getText(), c);
            AeroportoControle ac = new AeroportoControle();
            ac.alterarAeroporto(a);

            
            carregarTabela();
            limparCampos();

            comboCidade.setSelectedIndex(-1);
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
            modeloTabela.addRow(new Object[]{a.getCodAeroporto(), a.getNomeAero(), a.getCidade()});
        }
    }

    public static void main(String args[]) {

        try {
            FlatDarkLaf.setup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new GerenciarAeroporto().setVisible(true));
    }

    private void carregarCidade() {
        comboCidade.removeAllItems();

        CidadeControle controle = new CidadeControle();

        ArrayList<Cidade> lista = controle.consultarCidades();

        for (Cidade c : lista) {

            comboCidade.addItem(c);
        }

        comboCidade.setSelectedIndex(-1);
    }
    public void limparCampos() {

        txtCod.setText("");

        txtNome.setText("");

        comboCidade.setSelectedIndex(-1);
    }
}
