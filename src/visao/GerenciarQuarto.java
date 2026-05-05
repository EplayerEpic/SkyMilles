 package visao;

import controle.HotelControle;
import controle.PacoteControle;
import controle.QuartoControle;
import modelo.Quarto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GerenciarQuarto extends JFrame {
    private QuartoControle controle = new QuartoControle();
    private JTextField txtCod, txtValor, txtSaida, txtChegada, txtData, txtDiarias, txtPacote, txtHotel;
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
        
        pDados.add(new JLabel("Cód Quarto:")); txtCod = new JTextField(); pDados.add(txtCod);
        pDados.add(new JLabel("Valor Reserva:")); txtValor = new JTextField(); pDados.add(txtValor);
        pDados.add(new JLabel("Local Saída:")); txtSaida = new JTextField(); pDados.add(txtSaida);
        pDados.add(new JLabel("Local Chegada:")); txtChegada = new JTextField(); pDados.add(txtChegada);
        pDados.add(new JLabel("Data Início:")); txtData = new JTextField(); pDados.add(txtData);
        pDados.add(new JLabel("Diárias:")); txtDiarias = new JTextField(); pDados.add(txtDiarias);
        pDados.add(new JLabel("Cód Pacote:")); txtPacote = new JTextField(); pDados.add(txtPacote);
        pDados.add(new JLabel("Cód Hotel:")); txtHotel = new JTextField(); pDados.add(txtHotel);

        // Tabela
        String[] colunas = {"Cód", "Valor", "Saída", "Chegada", "Início", "Diárias", "Pacote", "Hotel"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);

        // Botões
        JPanel pBotoes = new JPanel();
        JButton btnAdd = new JButton("Inserir");
        JButton btnDel = new JButton("Remover");
        pBotoes.add(btnAdd); pBotoes.add(btnDel);

        btnAdd.addActionListener(e -> {
            PacoteControle pc = new PacoteControle();
            HotelControle hc = new HotelControle();
            Quarto q = new Quarto();
            q.setValorReserva(Double.parseDouble(txtValor.getText()));
            q.setLocalSaida(txtSaida.getText());
            q.setLocalChegada(txtChegada.getText());
            q.setDataInicio(txtData.getText());
            q.setQntdDiarias(Integer.parseInt(txtDiarias.getText()));
            q.setCodPacote(pc.consultarPacoteCodigo(Integer.parseInt(txtPacote.getText())));
            q.setCodHotel(hc.consultarHotelCodigo(Integer.parseInt(txtHotel.getText())));
            controle.inserirQuarto(q);
            carregarTabela();
        });

        add(pDados, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);
        
        carregarTabela();
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        ArrayList<Quarto> lista = controle.consultarQuartos();
        for (Quarto q : lista) {
            modeloTabela.addRow(new Object[]{
                q.getCodQuarto(), q.getValorReserva(), q.getLocalSaida(), 
                q.getLocalChegada(), q.getDataInicio(), q.getQntdDiarias(), 
                q.getCodPacote(), q.getCodHotel()
            });
        }
    }
    public static void main(String[] args) {
        new GerenciarQuarto().setVisible(true);
    }
}