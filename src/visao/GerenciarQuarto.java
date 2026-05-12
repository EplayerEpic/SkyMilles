package visao;

import controle.HotelControle;
import controle.PacoteControle;
import controle.QuartoControle;
import modelo.Quarto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import modelo.Hotel;
import modelo.Pacote;

public class GerenciarQuarto extends JFrame {

    private QuartoControle controle = new QuartoControle();
    private JTextField txtValor, txtSaida, txtChegada, txtData, txtDiarias, txtCod;
    private JComboBox<Hotel> hotelCombo;
    private JComboBox<Pacote> pacoteCombo;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public GerenciarQuarto() {
        setTitle("Gerenciar Quartos - SkyMilles");
        setSize(900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de entrada de dados (GridBagLayout para organização)
        JPanel pDados = new JPanel(new GridLayout(4, 4, 10, 10));
        pDados.setBorder(BorderFactory.createTitledBorder("Informações do Quarto"));

        pDados.add(new JLabel("Valor Reserva:"));
        txtValor = new JTextField();
        pDados.add(txtValor);
        pDados.add(new JLabel("Local Saída:"));
        txtSaida = new JTextField();
        pDados.add(txtSaida);
        pDados.add(new JLabel("Local Chegada:"));
        txtChegada = new JTextField();
        pDados.add(txtChegada);
        pDados.add(new JLabel("Data Início:"));
        txtData = new JTextField();
        pDados.add(txtData);
        pDados.add(new JLabel("Diárias:"));
        txtDiarias = new JTextField();
        pDados.add(txtDiarias);
        pDados.add(new JLabel("Pacote:"));
        pacoteCombo = new JComboBox<Pacote>();
        pDados.add(pacoteCombo);
        pDados.add(new JLabel("Hotel:"));
        hotelCombo = new JComboBox<Hotel>();
        pDados.add(hotelCombo);
        txtCod = new JTextField();
        pDados.add(txtCod);
        txtCod.setVisible(false);

        // Tabela
        String[] colunas = {"Cód", "Valor", "Saída", "Chegada", "Início", "Diárias", "Pacote", "Hotel"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);

        // Botões
        JPanel pBotoes = new JPanel();
        JButton btnAdd = new JButton("Inserir");
        JButton btnAlt = new JButton("Alterar");
        JButton btnDel = new JButton("Remover");
        pBotoes.add(btnAdd);
        pBotoes.add(btnDel);
        pBotoes.add(btnAlt);

        btnAdd.addActionListener(e -> {
            PacoteControle pc = new PacoteControle();
            HotelControle hc = new HotelControle();
            Hotel h = (Hotel) hotelCombo.getSelectedItem();
            Pacote p = (Pacote) pacoteCombo.getSelectedItem();
            if (hotelCombo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecione um hotel");
                return;
            }
            Quarto q = new Quarto();
            q.setValorReserva(Double.parseDouble(txtValor.getText()));
            q.setLocalSaida(txtSaida.getText());
            q.setLocalChegada(txtChegada.getText());
            q.setDataInicio(txtData.getText());
            q.setQntdDiarias(Integer.parseInt(txtDiarias.getText()));
            q.setPacote(p);
            q.setHotel(h);
            controle.inserirQuarto(q);
            carregarTabela();
        });
        btnDel.addActionListener(e -> {
            QuartoControle qc = new QuartoControle();

            qc.removerQuarto(Integer.parseInt(txtCod.getText()));
            carregarTabela();
        });
        btnAlt.addActionListener(e -> {
            int linha = tabela.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um quarto na tabela.");
                return;
            }

            if (txtCod.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Código do quarto não encontrado.");
                return;
            }

            Pacote p = (Pacote) pacoteCombo.getSelectedItem();
            Hotel h = (Hotel) hotelCombo.getSelectedItem();

            if (h == null || p == null) {
                JOptionPane.showMessageDialog(null, "Selecione um hotel e um pacote.");
                return;
            }

            Quarto q = new Quarto();
            q.setCodQuarto(Integer.parseInt(txtCod.getText().trim()));
            q.setValorReserva(Double.parseDouble(txtValor.getText().trim()));
            q.setLocalSaida(txtSaida.getText().trim());         // ← você esqueceu isso
            q.setLocalChegada(txtChegada.getText().trim());     // ← e isso
            q.setDataInicio(txtData.getText().trim());          // ← e isso
            q.setQntdDiarias(Integer.parseInt(txtDiarias.getText().trim()));
            q.setPacote(p);
            q.setHotel(h);

            QuartoControle qc = new QuartoControle();
            qc.alterarQuarto(q);

            carregarTabela();
            carregarHotel();
            carregarPacote();
            limparCampos();
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int linha = tabela.getSelectedRow();

                if (linha != -1) {
                    txtCod.setText(tabela.getValueAt(linha, 0).toString());
                    txtValor.setText(tabela.getValueAt(linha, 1).toString());
                    txtSaida.setText(tabela.getValueAt(linha, 2).toString());
                    txtChegada.setText(tabela.getValueAt(linha, 3).toString());
                    txtData.setText(tabela.getValueAt(linha, 4).toString());
                    txtDiarias.setText(tabela.getValueAt(linha, 5).toString());
                    Pacote p = (Pacote) tabela.getValueAt(linha, 6);
                    System.out.println(tabela.getValueAt(linha, 7).getClass());
                    Hotel h = (Hotel) tabela.getValueAt(linha, 7);
                    int codHotel = h.getCodHotel();
                    for (int i = 0; i < hotelCombo.getItemCount(); i++) {

                        Hotel item = hotelCombo.getItemAt(i);

                        if (item.getCodHotel() == codHotel) {
                            hotelCombo.setSelectedIndex(i);
                            break;
                        }
                    }
                    int codPacote = p.getCodPacote();
                    for (int i = 0; i < pacoteCombo.getItemCount(); i++) {

                        Pacote item = pacoteCombo.getItemAt(i);

                        if (item.getCodPacote() == codPacote) {
                            pacoteCombo.setSelectedIndex(i);
                            break;
                        }
                    }

                }
            }
        });

        add(pDados, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);

        carregarTabela();
        carregarHotel();
        carregarPacote();
        hotelCombo.setSelectedIndex(-1);
        pacoteCombo.setSelectedIndex(-1);
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        ArrayList<Quarto> lista = controle.consultarQuartos();
        for (Quarto q : lista) {
            System.out.println(q.getValorReserva());
            modeloTabela.addRow(new Object[]{
                q.getCodQuarto(), q.getValorReserva(), q.getLocalSaida(),
                q.getLocalChegada(), q.getDataInicio(), q.getQntdDiarias(),
                q.getPacote(), q.getHotel()
            });
        }
    }

    public void carregarHotel() {

        hotelCombo.removeAllItems();

        HotelControle controle = new HotelControle();

        ArrayList<Hotel> lista = controle.consultarHoteis();

        for (Hotel h : lista) {
            hotelCombo.addItem(h);
        }

        hotelCombo.setSelectedIndex(-1);
    }

    public void carregarPacote() {

        pacoteCombo.removeAllItems();

        PacoteControle controle = new PacoteControle();

        ArrayList<Pacote> lista = controle.consultarPacotes();

        for (Pacote p : lista) {

            pacoteCombo.addItem(p);
        }

        pacoteCombo.setSelectedIndex(-1);
    }

    public void limparCampos() {
        
        txtCod.setText("");
        
        txtValor.setText("");

        txtSaida.setText("");

        txtChegada.setText("");

        txtData.setText("");

        txtDiarias.setText("");

        pacoteCombo.setSelectedIndex(-1);

        hotelCombo.setSelectedIndex(-1);

    }

    private void formWindowActivated(
            java.awt.event.WindowEvent evt
    ) {

        carregarHotel();
        carregarPacote();
    }

    public static void main(String[] args) {
        new GerenciarQuarto().setVisible(true);
    }
}
