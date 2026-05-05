package visao;

import controle.PacoteAssentoControle;
import modelo.PacoteAssento;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GerenciarPacoteAssento extends javax.swing.JFrame {

    private PacoteAssentoControle controle = new PacoteAssentoControle();

    private JTextField txtCodPacote, txtCodAssento;
    private JButton btnInserir, btnRemover, btnConsultar, btnLimpar;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public GerenciarPacoteAssento() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {
        setTitle("Gerenciar Pacote x Assento - SkyMilles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelCampos = new JPanel(new GridBagLayout());
        painelCampos.setBorder(BorderFactory.createTitledBorder("Associar Pacote e Assento"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.anchor = GridBagConstraints.WEST;

        txtCodPacote  = new JTextField(10);
        txtCodAssento = new JTextField(10);

        gbc.gridx = 0; gbc.gridy = 0; painelCampos.add(new JLabel("Cód. Pacote:"), gbc);
        gbc.gridx = 1; painelCampos.add(txtCodPacote, gbc);
        gbc.gridx = 0; gbc.gridy = 1; painelCampos.add(new JLabel("Cód. Assento:"), gbc);
        gbc.gridx = 1; painelCampos.add(txtCodAssento, gbc);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnInserir   = new JButton("Inserir");
        btnRemover   = new JButton("Remover");
        btnConsultar = new JButton("Consultar");
        btnLimpar    = new JButton("Limpar");

        btnInserir.setBackground(new Color(34, 139, 34));   btnInserir.setForeground(Color.WHITE);
        btnRemover.setBackground(new Color(220, 20, 60));   btnRemover.setForeground(Color.WHITE);
        btnConsultar.setBackground(new Color(255, 165, 0)); btnConsultar.setForeground(Color.WHITE);

        painelBotoes.add(btnInserir); painelBotoes.add(btnRemover);
        painelBotoes.add(btnConsultar); painelBotoes.add(btnLimpar);

        modeloTabela = new DefaultTableModel(new String[]{"Cód. Pacote", "Cód. Assento"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tabela = new JTable(modeloTabela);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() >= 0) {
                int l = tabela.getSelectedRow();
                txtCodPacote.setText(modeloTabela.getValueAt(l, 0).toString());
                txtCodAssento.setText(modeloTabela.getValueAt(l, 1).toString());
            }
        });

        btnInserir.addActionListener(e -> {
            try {
                PacoteAssento pa = new PacoteAssento(
                    Integer.parseInt(txtCodPacote.getText().trim()),
                    Integer.parseInt(txtCodAssento.getText().trim()));
                String res = controle.inserirPacoteAssento(pa);
                JOptionPane.showMessageDialog(this, "Registro " + res + " com sucesso!");
                carregarTabela(); limpar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnRemover.addActionListener(e -> {
            try {
                String res = controle.removerPacoteAssento(
                    Integer.parseInt(txtCodPacote.getText().trim()),
                    Integer.parseInt(txtCodAssento.getText().trim()));
                JOptionPane.showMessageDialog(this, "Registro " + res + " com sucesso!");
                carregarTabela(); limpar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnConsultar.addActionListener(e -> carregarTabela());
        btnLimpar.addActionListener(e -> limpar());

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(painelCampos, BorderLayout.CENTER);
        topo.add(painelBotoes, BorderLayout.SOUTH);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (PacoteAssento pa : controle.consultarPacoteAssentos()) {
            modeloTabela.addRow(new Object[]{pa.getCodPacote(), pa.getCodAssento()});
        }
    }

    private void limpar() {
        txtCodPacote.setText(""); txtCodAssento.setText(""); tabela.clearSelection();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new GerenciarPacoteAssento().setVisible(true));
    }
}
