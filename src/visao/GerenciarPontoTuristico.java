package visao;

import com.formdev.flatlaf.FlatDarkLaf;
import controle.CidadeControle;
import controle.PontoTuristicoControle;
import modelo.PontoTuristico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import modelo.Cidade;

public class GerenciarPontoTuristico extends JFrame {

    private PontoTuristicoControle controle = new PontoTuristicoControle();
    private JTextField txtCod, txtDesc, txtEnd;
    private JComboBox<Cidade> comboCidade;
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
        pCampos.add(new JLabel("Código:"));
        txtCod = new JTextField();
        pCampos.add(txtCod);
        pCampos.add(new JLabel("Descrição:"));
        txtDesc = new JTextField();
        pCampos.add(txtDesc);
        pCampos.add(new JLabel("Endereço:"));
        txtEnd = new JTextField();
        pCampos.add(txtEnd);
        pCampos.add(new JLabel("Cidade:"));
        comboCidade = new JComboBox();
        pCampos.add(comboCidade);

        // Botões
        JPanel pBotoes = new JPanel();
        JButton btnAdd = new JButton("Inserir");
        JButton btnAlt = new JButton("Alterar");
        JButton btnDel = new JButton("Remover");
        pBotoes.add(btnAdd);
        pBotoes.add(btnAlt);
        pBotoes.add(btnDel);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Descrição", "Endereço", "Cidade"}, 0);
        tabela = new JTable(modeloTabela);

        // Eventos
        btnAdd.addActionListener(e -> {

            PontoTuristicoControle ptc = new PontoTuristicoControle();
            //pega cidade do comboBox
            Cidade c = (Cidade) comboCidade.getSelectedItem();
            if (comboCidade.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecione uma cidade");
                return;
            }
            //preenche o construtor
            PontoTuristico p = new PontoTuristico(txtDesc.getText(), txtEnd.getText(), c);
            ptc.inserirPonto(p);
            carregarTabela();
        });
        btnAlt.addActionListener(e -> {
            int linha = tabela.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto na tabela.");
                return;
            }
            Cidade c = (Cidade) comboCidade.getSelectedItem();

            PontoTuristico pt = new PontoTuristico(Integer.parseInt(txtCod.getText()), txtDesc.getText(), txtEnd.getText(), c);
            PontoTuristicoControle ptc = new PontoTuristicoControle();
            ptc.alterarPonto(pt);

            
            carregarTabela();
            limparCampos();

            comboCidade.setSelectedIndex(-1);
        });

        btnDel.addActionListener(e -> {
            PontoTuristicoControle ptc = new PontoTuristicoControle();
            ptc.removerPonto(Integer.parseInt(txtCod.getText()));
            carregarTabela();
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int linha = tabela.getSelectedRow();
                txtCod.setText(tabela.getValueAt(linha, 0).toString());
                txtDesc.setText(tabela.getValueAt(linha, 1).toString());
                txtEnd.setText(tabela.getValueAt(linha, 2).toString());
                Cidade c = (Cidade) tabela.getValueAt(linha, 3);
                comboCidade.setSelectedItem(c);
            }
        });

        add(pCampos, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);
        carregarCidade();
        carregarTabela();
    }

    //metodos
    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (PontoTuristico p : controle.consultarPontos()) {
            modeloTabela.addRow(new Object[]{p.getCodPonto(), p.getDescricao(), p.getEndereco(), p.getCidade()});
        }
    }

    public void carregarCidade() {

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

        txtDesc.setText("");

        txtEnd.setText("");

        comboCidade.setSelectedIndex(-1);
    }

    private void formWindowActivated(
            java.awt.event.WindowEvent evt
    ) {
        carregarCidade();
    }

    public static void main(String args[]) {

        try {
            FlatDarkLaf.setup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new GerenciarPontoTuristico().setVisible(true));
    }
}
