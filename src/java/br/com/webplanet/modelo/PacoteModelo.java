package br.com.webplanet.modelo;

import java.util.ArrayList;
import br.com.webplanet.conexao.ConexaoMySQLSky;
import java.sql.*;
import br.com.webplanet.daos.Assentos;
import br.com.webplanet.daos.Pacote;
import br.com.webplanet.daos.Quarto;

public class PacoteModelo {
    

    public PacoteModelo() {}

    public ArrayList<Pacote> consultarPacotes() {
        ArrayList<Pacote> vPacote = new ArrayList<>();
        
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM pacote";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Pacote pack = new Pacote();
                pack.setCodPacote(resultado.getInt("cod_pacote"));
                pack.setValorPacote(resultado.getDouble("valor_pacote"));
                
                Quarto q = new Quarto();
                q.setCodQuarto(resultado.getInt("cod_pacote"));
                
                Assentos a = new Assentos();
                a.setCodAssento(resultado.getInt("cod_assento"));
                pack.setAssento(a);
                pack.setQuarto(q);
                
               
                vPacote.add(pack);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vPacote;
    }

    public Pacote consultarPacoteCodigo(int codPacote) {
        Pacote pack = null;
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM pacote WHERE cod_pacote = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codPacote);
            ResultSet resultado = stm.executeQuery();

            if (resultado.next()) {
                pack = new Pacote();
                pack.setCodPacote(resultado.getInt("cod_usuario"));
                pack.setValorPacote(resultado.getDouble("valor_pacote"));

           
                Quarto q = new Quarto();
                q.setCodQuarto(resultado.getInt("cod_quarto"));
                pack.setQuarto(q);
                Assentos a = new Assentos();
                a.setCodAssento(resultado.getInt("cod_assento"));
                
                pack.setAssento(a);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return pack;
    }

    public String inserirPacote(Pacote pack) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO pacote (cod_pacote, valor_pacote, cod_assento, cod_quarto) VALUES (?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, pack.getCodPacote());
            stm.setDouble(2, pack.getValorPacote());
            stm.setInt(3, pack.getQuarto().getCodQuarto());
            stm.setInt(4, pack.getAssento().getCodAssento());

            stm.executeUpdate();
            return "Inserido";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String alterarPacote(Pacote pack) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE pacote SET cod_pacote=?, valor_pacote=?, cod_quarto=?, cod_assento=? WHERE cod_pacote=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, pack.getCodPacote());
            stm.setDouble(2, pack.getValorPacote());
            stm.setInt(3, pack.getQuarto().getCodQuarto());
            stm.setInt(4, pack.getAssento().getCodAssento());
            stm.setInt(5, pack.getCodPacote());

            stm.executeUpdate();
            return "Alterado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String deletarPacote(int codPacote) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM pacote WHERE cod_pacote=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, codPacote);
            stm.executeUpdate();
            return "Deletado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }
    public static void main(String[] args){
        Pacote p = new Pacote();
                p.setCodPacote(9999);;
        Quarto q = new Quarto();
                q.setCodQuarto(9999);
                p.setQuarto(q);
        Assentos a = new Assentos();
                a.setCodAssento(999);
                p.setAssento(a);
        
    }
}