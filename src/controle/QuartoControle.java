package controle;

import modelo.Quarto;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hotel;
import modelo.Pacote;

public class QuartoControle {

    public ArrayList<Quarto> consultarQuartos() {
        ArrayList<Quarto> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM quarto";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Quarto q = new Quarto();
                q.setCodQuarto(rs.getInt("cod_quarto"));
                q.setValorReserva(rs.getDouble("valor_reserva"));
                q.setLocalSaida(rs.getString("local_saida"));
                q.setLocalChegada(rs.getString("local_chegada"));
                q.setDataInicio(rs.getString("data_inicio"));
                q.setQntdDiarias(rs.getInt("qntd_diarias"));

                Pacote pac = new Pacote();
                pac.setCodPacote(rs.getInt("cod_pacote"));
                q.setPacote(pac);

                Hotel hot = new Hotel();
                hot.setCodHotel(rs.getInt("cod_hotel"));
                q.setHotel(hot);

                lista.add(q);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuartoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Quarto> consultarQuartoCodigo(int codQuarto) {
        ArrayList<Quarto> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM quarto WHERE cod_quarto = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codQuarto);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Quarto q = new Quarto();
                q.setCodQuarto(rs.getInt("cod_quarto"));
                q.setValorReserva(rs.getDouble("valor_reserva"));
                q.setLocalSaida(rs.getString("local_saida"));
                q.setLocalChegada(rs.getString("local_chegada"));
                q.setDataInicio(rs.getString("data_inicio"));
                q.setQntdDiarias(rs.getInt("qntd_diarias"));

                Pacote pac = new Pacote();
                pac.setCodPacote(rs.getInt("cod_pacote"));
                q.setPacote(pac);

                Hotel hot = new Hotel();
                hot.setCodHotel(rs.getInt("cod_hotel"));
                q.setHotel(hot);

                lista.add(q);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuartoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public String inserirQuarto(Quarto q) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO quarto (valor_reserva, local_saida, local_chegada, data_inicio, qntd_diarias, cod_pacote, cod_hotel) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setDouble(1, q.getValorReserva());
            stm.setString(2, q.getLocalSaida());
            stm.setString(3, q.getLocalChegada());
            stm.setString(4, q.getDataInicio());
            stm.setInt(5, q.getQntdDiarias());
            stm.setInt(6, q.getPacote().getCodPacote());
            stm.setInt(7, q.getHotel().getCodHotel());

            stm.executeUpdate();
            return "inserido";

        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public String alterarQuarto(Quarto q) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE quarto SET valor_reserva = ?, local_saida = ?, local_chegada =?, data_inicio = ?, qntd_diarias = ?, cod_pacote = ?, cod_hotel = ? WHERE cod_quarto=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setDouble(1, q.getValorReserva());
            stm.setString(2, q.getLocalSaida());
            stm.setString(3, q.getLocalChegada());
            stm.setString(4, q.getDataInicio());
            stm.setInt(5, q.getQntdDiarias());
            stm.setInt(6, q.getPacote().getCodPacote());
            stm.setInt(7, q.getHotel().getCodHotel());
            stm.setInt(8, q.getCodQuarto());

            stm.executeUpdate();
            return "Alterado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String removerQuarto(int cod) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM quarto WHERE cod_quarto = ?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, cod);
            stm.executeUpdate();
            return "removido";

        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public static void main(String[] args) {

        QuartoControle qCtrl = new QuartoControle();

        // ===== LISTAR =====
        System.out.println("=== TODOS OS QUARTOS ===");
        for (Quarto q : qCtrl.consultarQuartos()) {
            System.out.println(q);
        }

        // ===== INSERT =====
        System.out.println("\n=== INSERINDO ===");
        Quarto novo = new Quarto();
        novo.setValorReserva(350.00);
        novo.setLocalSaida("Uberlandia");
        novo.setLocalChegada("Sao Paulo");
        novo.setDataInicio("2026-05-10");
        novo.setQntdDiarias(4);

        Pacote pac = new Pacote();
        pac.setCodPacote(1); // precisa existir
        novo.setPacote(pac);

        Hotel hot = new Hotel();
        hot.setCodHotel(1); // precisa existir
        novo.setHotel(hot);

        System.out.println("Resultado: " + qCtrl.inserirQuarto(novo));

        // ===== LISTAR DEPOIS =====
        ArrayList<Quarto> lista = qCtrl.consultarQuartos();
        System.out.println("\n=== APÓS INSERT ===");
        for (Quarto q : lista) {
            System.out.println(q);
        }

        if (lista.isEmpty()) {
            return;
        }

        int id = lista.get(lista.size() - 1).getCodQuarto();

        // ===== CONSULTAR POR ID =====
        System.out.println("\n=== CONSULTAR POR ID ===");
        for (Quarto q : qCtrl.consultarQuartoCodigo(id)) {
            System.out.println(q);
        }

        // ===== DELETE =====
        System.out.println("\n=== REMOVENDO ===");
        System.out.println("Resultado: " + qCtrl.removerQuarto(id));

        // ===== FINAL =====
        System.out.println("\n=== LISTA FINAL ===");
        for (Quarto q : qCtrl.consultarQuartos()) {
            System.out.println(q);
        }
    }
}
