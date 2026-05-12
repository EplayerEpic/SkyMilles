package visao;

import controle.PacoteControle;
import controle.PacoteQuartoControle;
import controle.QuartoControle;
import modelo.PacoteQuarto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import modelo.Pacote;
import modelo.Quarto;

public class GerenciarPacoteQuarto extends JFrame {

    private PacoteQuartoControle controle = new PacoteQuartoControle();
    private JTextField txtCod;
    private JComboBox<Pacote> comboPacote;
    private JComboBox<Quarto> comboQuarto;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public GerenciarPacoteQuarto() {
        setTitle("SkyMilles - Pacote Quarto");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Formulário
        JPanel pCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        pCampos.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        pCampos.add(new JLabel("Pacote"));
        comboPacote = new JComboBox();
        pCampos.add(comboPacote);
        pCampos.add(new JLabel("Quarto"));
        comboQuarto = new JComboBox();
        pCampos.add(comboQuarto);
        

        // Botões
        JPanel pBotoes = new JPanel();
        JButton btnAdd = new JButton("Inserir");
        JButton btnAlt = new JButton("Alterar");
        JButton btnDel = new JButton("Remover");
        pBotoes.add(btnAdd);
        pBotoes.add(btnAlt);
        pBotoes.add(btnDel);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"Código", "Pacote"}, 0);
        tabela = new JTable(modeloTabela);

        // Eventos
        btnAdd.addActionListener(e -> {

            PacoteQuartoControle pqc = new PacoteQuartoControle();
            //pega cidade do comboBox
            Pacote pkt = (Pacote) comboPacote.getSelectedItem();
            Quarto q = (Quarto) comboQuarto.getSelectedItem();
            if (comboPacote.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecione um pacote");
                return;
            }
            if (comboQuarto.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecione um quarto");
                return;
            }
            //preenche o construtor
            PacoteQuarto p = new PacoteQuarto(pkt, q);
            pqc.inserirPacoteQuarto(p);
            carregarTabela();
        });
        btnAlt.addActionListener(e -> {
            int linha = tabela.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um pacote e um quarto na tabela.");
                return;
            }
            Pacote p = (Pacote) comboPacote.getSelectedItem();
            Quarto q = (Quarto) comboQuarto.getSelectedItem();

            PacoteQuarto pq = new PacoteQuarto(p, q);
            PacoteQuartoControle pqc = new PacoteQuartoControle();
            pqc.alterarPacoteQuarto(pq);

            
            carregarTabela();
            limparCampos();

            comboPacote.setSelectedIndex(-1);
            comboQuarto.setSelectedIndex(-1);
        });

        btnDel.addActionListener(e -> {
            PacoteQuartoControle pqc = new PacoteQuartoControle();
            Pacote p = (Pacote) comboPacote.getSelectedItem();
            Quarto q = (Quarto) comboQuarto.getSelectedItem();
            pqc.removerPacoteQuarto(p.getCodPacote(), q.getCodQuarto());
            carregarTabela();
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int linha = tabela.getSelectedRow();
                Pacote p = (Pacote) tabela.getValueAt(linha, 0);
                Quarto q = (Quarto) tabela.getValueAt(linha, 1);
                
                comboPacote.setSelectedItem(p);
                comboQuarto.setSelectedItem(q);
            }
        });

        add(pCampos, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);
        carregarPacote();
        carregarQuarto();
        carregarTabela();
    }

    //metodos
    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (PacoteQuarto pq : controle.consultarPacoteQuartos()) {
            modeloTabela.addRow(new Object[]{pq.getPacote(), pq.getQuarto()});
        }
    }

    public void carregarPacote() {

        comboPacote.removeAllItems();

        PacoteControle controle = new PacoteControle();

        ArrayList<Pacote> lista = controle.consultarPacotes();

        for (Pacote p : lista) {

            comboPacote.addItem(p);
        }

        comboPacote.setSelectedIndex(-1);
    }
    public void carregarQuarto() {

        comboQuarto.removeAllItems();

        QuartoControle controle = new QuartoControle();

        ArrayList<Quarto> lista = controle.consultarQuartos();

        for (Quarto q : lista) {

            comboQuarto.addItem(q);
        }

        comboQuarto.setSelectedIndex(-1);
    }

    public void limparCampos() {

        comboPacote.setSelectedIndex(-1);
        comboQuarto.setSelectedIndex(-1);
    }

    private void formWindowActivated(
            java.awt.event.WindowEvent evt
    ) {
        carregarPacote();
        carregarQuarto();
    }

    public static void main(String[] args) {
        new GerenciarPacoteQuarto().setVisible(true);
    }
}
