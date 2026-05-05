package controle;

import modelo.PacoteAssento;
import java.sql.*;
import conexao.ConexaoMySQLSky;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class PacoteAssentoControle {

    public PacoteAssentoControle() {}

    // ── CONSULTAR TODOS ──────────────────────────────────────────────────────
    public ArrayList<PacoteAssento> consultarPacoteAssentos() {
        ArrayList<PacoteAssento> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            ResultSet resultado = conn.createStatement().executeQuery("SELECT * FROM pacoteassento");
            while (resultado.next()) {
                PacoteAssento pa = new PacoteAssento();
                pa.setCodPacote(resultado.getInt("cod_pacote"));
                pa.setCodAssento(resultado.getInt("cod_assento"));
                lista.add(pa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacoteAssentoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // ── CONSULTAR POR PACOTE ─────────────────────────────────────────────────
    public ArrayList<PacoteAssento> consultarPorPacote(int codPacote) {
        ArrayList<PacoteAssento> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM pacoteassento WHERE cod_pacote = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codPacote);
            ResultSet resultado = stm.executeQuery();
            while (resultado.next()) {
                PacoteAssento pa = new PacoteAssento();
                pa.setCodPacote(resultado.getInt("cod_pacote"));
                pa.setCodAssento(resultado.getInt("cod_assento"));
                lista.add(pa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacoteAssentoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // ── INSERIR ──────────────────────────────────────────────────────────────
    public String inserirPacoteAssento(PacoteAssento pa) {
        String resultado = "";
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO PacoteAssento (cod_pacote, cod_assento) VALUES (?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, pa.getCodPacote());
            stm.setInt(2, pa.getCodAssento());
            stm.executeUpdate();
            resultado = "inserido";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            Logger.getLogger(PacoteAssentoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    // ── REMOVER ──────────────────────────────────────────────────────────────
    public String removerPacoteAssento(int codPacote, int codAssento) {
        String resultado = "";
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM pacoteassento WHERE cod_pacote = ? AND cod_assento = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codPacote);
            stm.setInt(2, codAssento);
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            Logger.getLogger(PacoteAssentoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public static void main(String[] args) {
        PacoteAssentoControle ctrl = new PacoteAssentoControle();

        // ── CONSULTAR TODOS ──────────────────────────────────────────────────
        System.out.println("=== Todos os PacoteAssentos ===");
        for (PacoteAssento pa : ctrl.consultarPacoteAssentos()) {
            System.out.println(pa);
        }

        // ── INSERIR ──────────────────────────────────────────────────────────
        System.out.println("\n=== Inserindo ===");
        PacoteAssento novo = new PacoteAssento(1, 10);
        System.out.println("Resultado: " + ctrl.inserirPacoteAssento(novo));

        // ── CONSULTAR POR PACOTE ─────────────────────────────────────────────
        System.out.println("\n=== Consultando por pacote (cod_pacote = 1) ===");
        for (PacoteAssento pa : ctrl.consultarPorPacote(1)) {
            System.out.println(pa);
        }

        // ── REMOVER ──────────────────────────────────────────────────────────
        System.out.println("\n=== Removendo (cod_pacote=1, cod_assento=10) ===");
        System.out.println("Resultado: " + ctrl.removerPacoteAssento(1, 10));

        // ── CONSULTAR TODOS DEPOIS DA REMOÇÃO ────────────────────────────────
        System.out.println("\n=== Após remoção ===");
        for (PacoteAssento pa : ctrl.consultarPacoteAssentos()) {
            System.out.println(pa);
        }
    }
}