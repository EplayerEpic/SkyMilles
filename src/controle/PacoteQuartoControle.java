package controle;

import modelo.PacoteQuarto;
import java.sql.*;
import conexao.ConexaoMySQLSky;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import modelo.Pacote;
import modelo.Quarto;

public class PacoteQuartoControle {

    public PacoteQuartoControle() {}

    // ── CONSULTAR TODOS ──────────────────────────────────────────────────────
    public ArrayList<PacoteQuarto> consultarPacoteQuartos() {
        ArrayList<PacoteQuarto> lista = new ArrayList<>();
        PacoteQuartoControle pqc = new PacoteQuartoControle();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            ResultSet resultado = conn.createStatement().executeQuery("SELECT * FROM pacoteQuarto");
            while (resultado.next()) {
                PacoteQuarto pq = new PacoteQuarto();
                Pacote p = new Pacote();
                p.setCodPacote((resultado.getInt("cod_pacote")));
                Quarto q = new Quarto();
                q.setCodQuarto(resultado.getInt("cod_quarto"));
                pq.setPacote(p);
                pq.setQuarto(q);
                lista.add(pq);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacoteQuartoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // ── CONSULTAR POR PACOTE ─────────────────────────────────────────────────
    public ArrayList<PacoteQuarto> consultarPorPacote(int codPacote) {
        ArrayList<PacoteQuarto> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM pacoteQuarto WHERE cod_pacote = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codPacote);
            ResultSet resultado = stm.executeQuery();
            while (resultado.next()) {
                PacoteQuarto pq = new PacoteQuarto();
                Pacote p = new Pacote();
                p.setCodPacote(resultado.getInt("cod_pacote"));
                Quarto q = new Quarto();
                q.setCodQuarto(resultado.getInt("cod_quarto"));
                pq.setPacote(p);
                pq.setQuarto(q);
                lista.add(pq);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacoteQuartoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // ── INSERIR ──────────────────────────────────────────────────────────────
    public String inserirPacoteQuarto(PacoteQuarto pq) {
        String resultado = "";
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO pacoteQuarto (cod_pacote, cod_quarto) VALUES (?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, pq.getPacote().getCodPacote());
            stm.setInt(2, pq.getQuarto().getCodQuarto());
            stm.executeUpdate();
            resultado = "inserido";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            Logger.getLogger(PacoteQuartoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public String alterarPacoteQuarto(PacoteQuarto pq) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE pacoteQuarto SET cod_pacote =?, cod_quarto=? WHERE cod_pacote = ? AND cod_quarto =?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, pq.getPacote().getCodPacote());
            stm.setInt(2, pq.getQuarto().getCodQuarto());
            stm.setInt(3, pq.getPacote().getCodPacote());
            stm.setInt(4, pq.getQuarto().getCodQuarto());

            stm.executeUpdate();
            return "alterado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    // ── REMOVER ──────────────────────────────────────────────────────────────
    public String removerPacoteQuarto(int codPacote, int codQuarto) {
        String resultado = "";
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM pacoteQuarto WHERE cod_pacote = ? AND cod_quarto = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codPacote);
            stm.setInt(2, codQuarto);
            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            Logger.getLogger(PacoteQuartoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    // ── MAIN (teste) ─────────────────────────────────────────────────────────
    public static void main(String[] args) {
        PacoteQuartoControle ctrl = new PacoteQuartoControle();

        System.out.println("=== Todos os PacoteQuartos ===");
        for (PacoteQuarto pq : ctrl.consultarPacoteQuartos()) {
            System.out.println(pq);
        }

        System.out.println("\n=== Inserindo ===");
        Pacote p = new Pacote();
        p.setCodPacote(1);
        Quarto q = new Quarto();
        q.setCodQuarto(1);
        PacoteQuarto novo = new PacoteQuarto(p, q);
        System.out.println("Resultado: " + ctrl.inserirPacoteQuarto(novo));

        System.out.println("\n=== Consultando por pacote (cod_pacote = 1) ===");
        for (PacoteQuarto pq : ctrl.consultarPorPacote(1)) {
            System.out.println(pq);
        }

        System.out.println("\n=== Removendo (cod_pacote=1, cod_quarto=10) ===");
        System.out.println("Resultado: " + ctrl.removerPacoteQuarto(1, 10));

        System.out.println("\n=== Após remoção ===");
        for (PacoteQuarto pq : ctrl.consultarPacoteQuartos()) {
            System.out.println(pq);
        }
    }
}