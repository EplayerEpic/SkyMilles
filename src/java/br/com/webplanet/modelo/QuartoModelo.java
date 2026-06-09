package br.com.webplanet.modelo;

import br.com.webplanet.daos.Quarto;
import br.com.webplanet.conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.webplanet.daos.Hotel;
import br.com.webplanet.daos.Pacote;

public class QuartoModelo {

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

                Hotel hot = new Hotel();
                hot.setCodHotel(rs.getInt("cod_hotel"));
                q.setHotel(hot);

                lista.add(q);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuartoModelo.class.getName()).log(Level.SEVERE, null, ex);
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


                Hotel hot = new Hotel();
                hot.setCodHotel(rs.getInt("cod_hotel"));
                q.setHotel(hot);

                lista.add(q);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuartoModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public String inserirQuarto(Quarto q) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO quarto (valor_reserva, local_saida, local_chegada, data_inicio, qntd_diarias, cod_hotel) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setDouble(1, q.getValorReserva());
            stm.setString(2, q.getLocalSaida());
            stm.setString(3, q.getLocalChegada());
            stm.setString(4, q.getDataInicio());
            stm.setInt(5, q.getQntdDiarias());
            stm.setInt(6, q.getHotel().getCodHotel());

            stm.executeUpdate();
            return "inserido";

        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public String alterarQuarto(Quarto q) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE quarto SET valor_reserva = ?, local_saida = ?, local_chegada =?, data_inicio = ?, qntd_diarias = ?, cod_hotel = ? WHERE cod_quarto=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setDouble(1, q.getValorReserva());
            stm.setString(2, q.getLocalSaida());
            stm.setString(3, q.getLocalChegada());
            stm.setString(4, q.getDataInicio());
            stm.setInt(5, q.getQntdDiarias());
            stm.setInt(6, q.getHotel().getCodHotel());
            stm.setInt(7, q.getCodQuarto());

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

    }
}
