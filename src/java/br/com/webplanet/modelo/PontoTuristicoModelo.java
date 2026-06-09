package br.com.webplanet.modelo;

import br.com.webplanet.daos.PontoTuristico;
import br.com.webplanet.daos.Cidade;
import br.com.webplanet.conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PontoTuristicoModelo {

    public ArrayList<PontoTuristico> consultarPontos() {
        ArrayList<PontoTuristico> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT pt.*, c.nome_cidade "
                    + "FROM ponto_turistico pt "
                    + "INNER JOIN cidade c "
                    + "ON pt.cod_cidade = c.cod_cidade";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                PontoTuristico p = new PontoTuristico();
                p.setCodPonto(rs.getInt("cod_ponto"));
                p.setDescricao(rs.getString("descricao"));
                p.setEndereco(rs.getString("endereco"));

                Cidade cidade = new Cidade();
                cidade.setCodCidade(rs.getInt("cod_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                p.setCidade(cidade);

                lista.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PontoTuristicoModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public PontoTuristico consultarPontoCodigo(int codPonto) {
        PontoTuristico p = null;
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM ponto_turistico WHERE cod_ponto = ?";
            
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codPonto);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                p = new PontoTuristico();
                p.setCodPonto(rs.getInt("cod_ponto"));
                p.setDescricao(rs.getString("descricao"));
                p.setEndereco(rs.getString("endereco"));

                Cidade cidade = new Cidade();
                cidade.setCodCidade(rs.getInt("cod_cidade"));
                p.setCidade(cidade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PontoTuristicoModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public String inserirPonto(PontoTuristico p) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO ponto_turistico (cod_ponto, descricao, endereco, cod_cidade) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, p.getCodPonto());
            stm.setString(2, p.getDescricao());
            stm.setString(3, p.getEndereco());
            stm.setInt(4, p.getCidade().getCodCidade());

            stm.executeUpdate();
            return "inserido";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String alterarPonto(PontoTuristico p) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE ponto_turistico SET descricao=?, endereco=?, cod_cidade=? WHERE cod_ponto=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, p.getDescricao());
            stm.setString(2, p.getEndereco());
            stm.setInt(3, p.getCidade().getCodCidade());
            stm.setInt(4, p.getCodPonto());

            stm.executeUpdate();
            return "alterado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String removerPonto(int cod) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM ponto_turistico WHERE cod_ponto = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, cod);

            stm.executeUpdate();
            return "removido";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public static void main(String[] args) {

        PontoTuristicoModelo pt = new PontoTuristicoModelo();

        // ===== CREATE =====
        PontoTuristico novo = new PontoTuristico();
        novo.setCodPonto(999);
        novo.setDescricao("Ponto Teste");
        novo.setEndereco("Rua Teste");

        Cidade c = new Cidade();
        c.setCodCidade(1); // precisa existir
        novo.setCidade(c);

        System.out.println("Inserir: " + pt.inserirPonto(novo));

        // ===== READ =====
        System.out.println("\n=== LISTA ===");
        for (PontoTuristico p : pt.consultarPontos()) {
            System.out.println(p);
        }

        // ===== READ BY ID =====
        System.out.println("\n=== CONSULTADO ===");
        System.out.println(pt.consultarPontoCodigo(999));

        // ===== UPDATE =====
        novo.setDescricao("Ponto Alterado");
        System.out.println("\nAlterar: " + pt.alterarPonto(novo));

        // ===== DELETE =====
        System.out.println("\nDeletar: " + pt.removerPonto(999));

        // ===== FINAL =====
        System.out.println("\n=== FINAL ===");
        for (PontoTuristico p : pt.consultarPontos()) {
            System.out.println(p);
        }
    }
}