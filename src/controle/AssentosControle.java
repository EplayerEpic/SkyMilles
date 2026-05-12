package controle;

import modelo.Assentos;
import java.sql.*;
import conexao.ConexaoMySQLSky;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import modelo.Voo;

public class AssentosControle {

    public AssentosControle() {}

    // ── CONSULTAR TODOS ──────────────────────────────────────────────────────
    public ArrayList<Assentos> consultarAssentos() {
        ArrayList<Assentos> vAssentos = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String consulta = "SELECT * FROM assento";
            ResultSet resultado = conn.createStatement().executeQuery(consulta);
            while (resultado.next()) {
                Assentos assen = new Assentos();
                assen.setCodAssento(resultado.getInt("cod_assento"));
                assen.setNumBilhete(resultado.getInt("num_bilhete"));
                assen.setDataEmissao(resultado.getString("data_emissao"));
                assen.setClasse(resultado.getString("_classe"));
                assen.setValorAss(resultado.getDouble("valor_ass"));
                assen.setStatus(resultado.getBoolean("_status"));
                assen.setCodDestino(resultado.getInt("cod_destino"));
                assen.setCodLocalPartida(resultado.getInt("cod_local_partida"));
                Voo v = new Voo();
                v.setCodVoo(resultado.getInt("cod_voo"));
                assen.setVoo(v);
                vAssentos.add(assen);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssentosControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vAssentos;
    }

    // ── CONSULTAR POR CÓDIGO ─────────────────────────────────────────────────
    public Assentos consultarCodAssento(int codAssento) {
        Assentos assen = new Assentos();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String consulta = "SELECT * FROM assento WHERE cod_assento = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, codAssento);
            ResultSet resultado = stm.executeQuery();
            if (resultado.next()) {
                assen.setCodAssento(resultado.getInt("cod_assento"));
                assen.setNumBilhete(resultado.getInt("num_bilhete"));
                assen.setDataEmissao(resultado.getString("data_emissao"));
                assen.setClasse(resultado.getString("_classe"));
                assen.setValorAss(resultado.getDouble("valor_ass"));
                assen.setStatus(resultado.getBoolean("_status"));
                assen.setCodDestino(resultado.getInt("cod_destino"));
                assen.setCodLocalPartida(resultado.getInt("cod_local_partida"));
                Voo v = new Voo();
                v.setCodVoo(resultado.getInt("cod_voo"));
                assen.setVoo(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssentosControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assen;
    }

    // ── INSERIR ──────────────────────────────────────────────────────────────
    public String inserirAssento(Assentos a) {
        String resultado = "";
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO assento "
                    + "(cod_assento, num_bilhete, data_emissao, _classe, "
                    + "valor_ass, _status, cod_destino, cod_local_partida, cod_voo) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, a.getCodAssento());
            stm.setInt(2, a.getNumBilhete());
            stm.setString(3, a.getDataEmissao());
            stm.setString(4, a.getClasse());
            stm.setDouble(5, a.getValorAss());
            stm.setBoolean(6, a.isStatus());
            stm.setInt(7, a.getCodDestino());
            stm.setInt(8, a.getCodLocalPartida());
            stm.setInt(9, a.getVoo().getCodVoo());
            stm.executeUpdate();
            resultado = "inserido";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            Logger.getLogger(AssentosControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    // ── ALTERAR ──────────────────────────────────────────────────────────────
    public String alterarAssento(Assentos a) {
        String resultado = "";
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE assento SET "
                    + "num_bilhete = ?, data_emissao = ?, _classe = ?, "
                    + "valor_ass = ?, _status = ?, "
                    + "cod_destino = ?, cod_local_partida = ?, cod_voo = ? "
                    + "WHERE cod_assento = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, a.getNumBilhete());
            stm.setString(2, a.getDataEmissao());
            stm.setString(3, a.getClasse());
            stm.setDouble(4, a.getValorAss());
            stm.setBoolean(5, a.isStatus());
            stm.setInt(6, a.getCodDestino());
            stm.setInt(7, a.getCodLocalPartida());
            stm.setInt(8, a.getVoo().getCodVoo());
            stm.setInt(9, a.getCodAssento());
            stm.executeUpdate();
            resultado = "alterado";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            Logger.getLogger(AssentosControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    // ── REMOVER ──────────────────────────────────────────────────────────────
    public String removerAssento(int codAssento) {
        String resultado = "";
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM assento WHERE cod_assento = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codAssento);
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            Logger.getLogger(AssentosControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    // ── MAIN (teste) ─────────────────────────────────────────────────────────
    public static void main(String[] args) {
        AssentosControle ctrl = new AssentosControle();
        System.out.println("=== Todos os assentos ===");
        for (Assentos a : ctrl.consultarAssentos()) {
            System.out.println(a);
        }
    }
}