package visao;

import controle.AssentosControle;
import modelo.Assentos;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddAssento extends javax.swing.JFrame {

    private AssentosControle controle = new AssentosControle();

    // ── Componentes ──────────────────────────────────────────────────────────
    private JLabel lblTitulo, lblCodAssento, lblNumBilhete, lblDataEmissao,
            lblClasse, lblValorAss, lblStatus, lblCodPacote,
            lblCodDestino, lblCodLocalPartida, lblCodVoo;

    private JTextField txtCodAssento, txtNumBilhete, txtDataEmissao,
            txtClasse, txtValorAss, txtCodPacote,
            txtCodDestino, txtCodLocalPartida, txtCodVoo;

    private JCheckBox chkStatus;

    private JButton btnInserir, btnAlterar, btnRemover, btnConsultar, btnLimpar;

    private JTable tabelaAssentos;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    // ── Construtor ───────────────────────────────────────────────────────────
    public AddAssento() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {
        setTitle("Gerenciar Assentos - SkyMilles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ── Painel superior: campos ──────────────────────────────────────────
        JPanel painelCampos = new JPanel(new GridBagLayout());
        painelCampos.setBorder(BorderFactory.createTitledBorder("Dados do Assento"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 8, 4, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Labels e campos
        String[] labels = {
            "Cód. Assento:", "Nº Bilhete:", "Data Emissão (AAAA-MM-DD):",
            "Classe:", "Valor (R$):", "Ativo:",
            "Cód. Pacote:", "Cód. Destino:", "Cód. Local Partida:", "Cód. Voo:"
        };

        txtCodAssento     = new JTextField(8);
        txtNumBilhete     = new JTextField(8);
        txtDataEmissao    = new JTextField(12);
        txtClasse         = new JTextField(10);
        txtValorAss       = new JTextField(10);
        chkStatus         = new JCheckBox();
        txtCodPacote      = new JTextField(8);
        txtCodDestino     = new JTextField(8);
        txtCodLocalPartida = new JTextField(8);
        txtCodVoo         = new JTextField(8);

        Component[] campos = {
            txtCodAssento, txtNumBilhete, txtDataEmissao,
            txtClasse, txtValorAss, chkStatus,
            txtCodPacote, txtCodDestino, txtCodLocalPartida, txtCodVoo
        };

        // Disposição em 2 colunas de pares label+campo
        int col = 0, row = 0;
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = col * 2;
            gbc.gridy = row;
            painelCampos.add(new JLabel(labels[i]), gbc);

            gbc.gridx = col * 2 + 1;
            painelCampos.add(campos[i], gbc);

            col++;
            if (col == 2) { col = 0; row++; }
        }

        // ── Painel de botões ─────────────────────────────────────────────────
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnInserir   = new JButton("Inserir");
        btnAlterar   = new JButton("Alterar");
        btnRemover   = new JButton("Remover");
        btnConsultar = new JButton("Consultar");
        btnLimpar    = new JButton("Limpar");

        btnInserir.setBackground(new Color(34, 139, 34));
        btnInserir.setForeground(Color.WHITE);
        btnAlterar.setBackground(new Color(30, 144, 255));
        btnAlterar.setForeground(Color.WHITE);
        btnRemover.setBackground(new Color(220, 20, 60));
        btnRemover.setForeground(Color.WHITE);
        btnConsultar.setBackground(new Color(255, 165, 0));
        btnConsultar.setForeground(Color.WHITE);

        painelBotoes.add(btnInserir);
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnConsultar);
        painelBotoes.add(btnLimpar);

        // ── Tabela ───────────────────────────────────────────────────────────
        String[] colunas = {
            "Cód", "Nº Bilhete", "Data Emissão", "Classe",
            "Valor", "Ativo", "Pacote", "Destino", "Partida", "Voo"
        };
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tabelaAssentos = new JTable(modeloTabela);
        tabelaAssentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(tabelaAssentos);

        // ── Clique na tabela preenche campos ─────────────────────────────────
        tabelaAssentos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabelaAssentos.getSelectedRow() >= 0) {
                int linha = tabelaAssentos.getSelectedRow();
                txtCodAssento.setText(modeloTabela.getValueAt(linha, 0).toString());
                txtNumBilhete.setText(modeloTabela.getValueAt(linha, 1).toString());
                txtDataEmissao.setText(modeloTabela.getValueAt(linha, 2).toString());
                txtClasse.setText(modeloTabela.getValueAt(linha, 3).toString());
                txtValorAss.setText(modeloTabela.getValueAt(linha, 4).toString());
                chkStatus.setSelected(Boolean.parseBoolean(modeloTabela.getValueAt(linha, 5).toString()));
                txtCodPacote.setText(modeloTabela.getValueAt(linha, 6).toString());
                txtCodDestino.setText(modeloTabela.getValueAt(linha, 7).toString());
                txtCodLocalPartida.setText(modeloTabela.getValueAt(linha, 8).toString());
                txtCodVoo.setText(modeloTabela.getValueAt(linha, 9).toString());
            }
        });

        // ── Ações dos botões ─────────────────────────────────────────────────
        btnInserir.addActionListener(e -> acaoInserir());
        btnAlterar.addActionListener(e -> acaoAlterar());
        btnRemover.addActionListener(e -> acaoRemover());
        btnConsultar.addActionListener(e -> carregarTabela());
        btnLimpar.addActionListener(e -> limparCampos());

        // ── Layout geral ─────────────────────────────────────────────────────
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.add(painelCampos, BorderLayout.CENTER);
        painelTopo.add(painelBotoes, BorderLayout.SOUTH);

        add(painelTopo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // ── Métodos de ação ──────────────────────────────────────────────────────
    private void acaoInserir() {
        try {
            Assentos a = obterAssentoDoCampos();
            String res = controle.inserirAssento(a);
            JOptionPane.showMessageDialog(this, "Assento " + res + " com sucesso!");
            carregarTabela();
            limparCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void acaoAlterar() {
        try {
            Assentos a = obterAssentoDoCampos();
            String res = controle.alterarAssento(a);
            JOptionPane.showMessageDialog(this, "Assento " + res + " com sucesso!");
            carregarTabela();
            limparCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void acaoRemover() {
        String cod = txtCodAssento.getText().trim();
        if (cod.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o Cód. Assento para remover.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Remover assento " + cod + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String res = controle.removerAssento(Integer.parseInt(cod));
            JOptionPane.showMessageDialog(this, "Assento " + res + " com sucesso!");
            carregarTabela();
            limparCampos();
        }
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        ArrayList<Assentos> lista = controle.consultarAssentos();
        for (Assentos a : lista) {
            modeloTabela.addRow(new Object[]{
                a.getCodAssento(), a.getNumBilhete(), a.getDataEmissao(),
                a.getClasse(), a.getValorAss(), a.isStatus(),
                a.getCodPacote(), a.getCodDestino(), a.getCodLocalPartida(), a.getCodVoo()
            });
        }
    }

    private Assentos obterAssentoDoCampos() {
        Assentos a = new Assentos();
        a.setCodAssento(Integer.parseInt(txtCodAssento.getText().trim()));
        a.setNumBilhete(Integer.parseInt(txtNumBilhete.getText().trim()));
        a.setDataEmissao(txtDataEmissao.getText().trim());
        a.setClasse(txtClasse.getText().trim());
        a.setValorAss(Double.parseDouble(txtValorAss.getText().trim().replace(",", ".")));
        a.setStatus(chkStatus.isSelected());
        a.setCodPacote(Integer.parseInt(txtCodPacote.getText().trim()));
        a.setCodDestino(Integer.parseInt(txtCodDestino.getText().trim()));
        a.setCodLocalPartida(Integer.parseInt(txtCodLocalPartida.getText().trim()));
        a.setCodVoo(Integer.parseInt(txtCodVoo.getText().trim()));
        return a;
    }

    private void limparCampos() {
        txtCodAssento.setText("");
        txtNumBilhete.setText("");
        txtDataEmissao.setText("");
        txtClasse.setText("");
        txtValorAss.setText("");
        chkStatus.setSelected(false);
        txtCodPacote.setText("");
        txtCodDestino.setText("");
        txtCodLocalPartida.setText("");
        txtCodVoo.setText("");
        tabelaAssentos.clearSelection();
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // continua com o look padrão
        }
        java.awt.EventQueue.invokeLater(() -> new AddAssento().setVisible(true));
    }
}
