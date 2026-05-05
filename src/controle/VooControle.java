package controle;
import modelo.Voo;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VooControle {

    public ArrayList<Voo> consultarVoos() {
        ArrayList<Voo> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM voo";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Voo v = new Voo();
                v.setCodVoo(rs.getInt("cod_voo"));
                v.setNumVoo(rs.getString("num_voo"));
                v.setDataHoraChegada(rs.getString("data_hora_chegada"));
                v.setDataHoraPartida(rs.getString("data_hora_partida"));
                v.setAviao(rs.getString("aviao"));
                v.setCompanhia(rs.getString("companhia"));
                v.setCodDestino(rs.getInt("cod_destino"));
                v.setCodLocalPartida(rs.getInt("cod_local_partida"));
                lista.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VooControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public String inserirVoo(Voo v) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO voo (cod_voo, num_voo, data_hora_chegada, data_hora_partida, aviao, companhia, cod_destino, cod_local_partida) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, v.getCodVoo());
            stm.setString(2, v.getNumVoo());
            stm.setString(3, v.getDataHoraChegada());
            stm.setString(4, v.getDataHoraPartida());
            stm.setString(5, v.getAviao());
            stm.setString(6, v.getCompanhia());
            stm.setInt(7, v.getCodDestino());
            stm.setInt(8, v.getCodLocalPartida());
            stm.executeUpdate();
            return "inserido";
        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public String removerVoo(int cod) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM voo WHERE cod_voo = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, cod);
            stm.executeUpdate();
            return "removido";
        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }
    public static void main(String[] args) {

        VooControle vc = new VooControle();

        // ===== CREATE (2 VOOS) =====
        Voo v1 = new Voo();
        v1.setNumVoo("AZ123");
        v1.setDataHoraChegada("2026-05-01 10:00:00");
        v1.setDataHoraPartida("2026-05-01 08:00:00");
        v1.setAviao("Boeing 737");
        v1.setCompanhia("Azul");
        v1.setCodDestino(1);
        v1.setCodLocalPartida(2);

        Voo v2 = new Voo();
        v2.setNumVoo("LA456");
        v2.setDataHoraChegada("2026-05-02 15:00:00");
        v2.setDataHoraPartida("2026-05-02 13:00:00");
        v2.setAviao("Airbus A320");
        v2.setCompanhia("Latam");
        v2.setCodDestino(2);
        v2.setCodLocalPartida(1);

        System.out.println("Inserir Voo 1: " + vc.inserirVoo(v1));
        System.out.println("Inserir Voo 2: " + vc.inserirVoo(v2));

        // ===== READ =====
        ArrayList<Voo> lista = vc.consultarVoos();
        System.out.println("\n=== LISTA DE VOOS (APÓS INSERT) ===");
        for (Voo v : lista) {
            System.out.println(v);
        }

        if (lista.size() < 2) {
            System.out.println("\nErro: menos de 2 voos inseridos.");
            return;
        }

        // ===== DELETE (remove o primeiro) =====
        int idRemover = lista.get(0).getCodVoo();
        System.out.println("\nRemovendo voo ID: " + idRemover);
        System.out.println("Resultado: " + vc.removerVoo(idRemover));

        // ===== READ FINAL =====
        ArrayList<Voo> listaFinal = vc.consultarVoos();
        System.out.println("\n=== LISTA FINAL (APÓS DELETE) ===");
        for (Voo v : listaFinal) {
            System.out.println(v);
        }
    }
}