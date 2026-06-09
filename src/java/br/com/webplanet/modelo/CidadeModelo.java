package br.com.webplanet.modelo;

import br.com.webplanet.daos.Cidade;
import br.com.webplanet.conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CidadeModelo {

    public ArrayList<Cidade> consultarCidades() {
        ArrayList<Cidade> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM cidade";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Cidade c = new Cidade();
                c.setCodCidade(rs.getInt("cod_cidade"));
                c.setDdd(rs.getString("ddd"));
                c.setEstado(rs.getString("estado"));
                c.setNomeCidade(rs.getString("nome_cidade"));
                lista.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CidadeModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public Cidade consultarCidadeCodigo(int codCidade) {
        Cidade c = null; 
        try {
            
            ConexaoMySQLSky conexao = new ConexaoMySQLSky();
            Connection conn = conexao.conectar();
            String consulta = "SELECT * FROM cidade WHERE cod_cidade = " + codCidade;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            if (rs.next()) {
                c = new Cidade();
                c.setCodCidade(rs.getInt("cod_cidade"));
                c.setDdd(rs.getString("ddd"));
                c.setEstado(rs.getString("estado"));
                c.setNomeCidade(rs.getString("nome_cidade"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public String inserirCidade(Cidade c) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO cidade (cod_cidade, ddd, estado, nome_cidade) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, c.getCodCidade());
            stm.setString(2, c.getDdd());
            stm.setString(3, c.getEstado());
            stm.setString(4, c.getNomeCidade());

            stm.executeUpdate();
            return "inserido";

        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public String alterarCidade(Cidade c) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE cidade SET ddd=?, estado=?, nome_cidade=? WHERE cod_cidade=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, c.getDdd());
            stm.setString(2, c.getEstado());
            stm.setString(3, c.getNomeCidade());
            stm.setInt(4, c.getCodCidade());

            stm.executeUpdate();
            return "alterado";

        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public String removerCidade(int cod) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM cidade WHERE cod_cidade=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, cod);
            stm.executeUpdate();
            return "removido";

        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public static void main(String[] args) {
        CidadeModelo cc = new CidadeModelo();

        // ===== CREATE =====
        Cidade nova = new Cidade();
        nova.setCodCidade(999); // cuidado com PK duplicada
        nova.setDdd("34");
        nova.setEstado("MG");
        nova.setNomeCidade("Cidade Teste");

        System.out.println("Inserir: " + cc.inserirCidade(nova));

        // ===== READ =====
        System.out.println("\n=== TODAS ===");
        for (Cidade c : cc.consultarCidades()) {
            System.out.println(c);
        }

        // ===== UPDATE =====
        nova.setNomeCidade("Cidade Alterada");
        System.out.println("\nAlterar: " + cc.alterarCidade(nova));

        // ===== DELETE =====
        System.out.println("\nDeletar: " + cc.removerCidade(999));

        // ===== FINAL =====
        System.out.println("\n=== FINAL ===");
        for (Cidade c : cc.consultarCidades()) {
            System.out.println(c);
        }
    }
}