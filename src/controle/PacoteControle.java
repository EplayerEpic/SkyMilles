package controle;

import java.util.ArrayList;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import modelo.Assentos;
import modelo.Pacote;
import modelo.PacoteAssento;
import modelo.PacoteQuarto;
import modelo.Quarto;

public class PacoteControle {
    

    public PacoteControle() {}

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
                
                PacoteQuarto pq = new PacoteQuarto();
                Quarto q = new Quarto();
                q.setCodQuarto(resultado.getInt("cod_pacote"));
                Pacote p1 = new Pacote();
                p1.setCodPacote(resultado.getInt("cod_pacote"));
                pq.setPacote(p1);
                pq.setQuarto(q);
                
                PacoteAssento pa = new PacoteAssento();
                Pacote p2 = new Pacote();
                p2.setCodPacote(resultado.getInt("cod_pacote"));
                Assentos a = new Assentos();
                a.setCodAssento(resultado.getInt("cod_assento"));
                pa.setPacote(p2);
                pa.setAssento(a);
                pack.setPacoteQuarto(pq);
                pack.setPacoteAssento(pa);
                if(pack.getPacoteQuarto() ==null){
                    pack.setPacoteQuarto(pq);
                }
                if(pack.getPacoteAssento() ==null){
                    pack.setPacoteAssento(pa);
                }
                
               
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

                PacoteQuarto pq = new PacoteQuarto();
                Pacote p1 = new Pacote();
                p1.setCodPacote(resultado.getInt("cod_pacote"));
                Quarto q = new Quarto();
                q.setCodQuarto(resultado.getInt("cod_quarto"));
                pq.setPacote(p1);
                pq.setQuarto(q);
                
                PacoteAssento pa = new PacoteAssento();
                Pacote p2 = new Pacote();
                p2.setCodPacote(resultado.getInt("cod_pacote"));
                pa.setPacote(p2);
                Assentos a = new Assentos();
                a.setCodAssento(resultado.getInt("cod_assento"));
                
                pack.setPacoteAssento(pa);
                pack.setPacoteQuarto(pq);
                if(pack.getPacoteQuarto() ==null){
                    pack.setPacoteQuarto(pq);
                }
                if(pack.getPacoteAssento() ==null){
                    pack.setPacoteAssento(pa);
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return pack;
    }

    public String inserirPacote(Pacote pack) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO pacote (cod_pacote, valor_pacote, cod_pacote_quarto, cod_pacote_assento) VALUES (?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, pack.getCodPacote());
            stm.setDouble(2, pack.getValorPacote());
            stm.setInt(3, pack.getPacoteQuarto().getPacote().getCodPacote());
            stm.setInt(4, pack.getPacoteAssento().getPacote().getCodPacote());

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
            String sql = "UPDATE pacote SET cod_pacote=?, valor_pacote=?, cod_pacote_quarto=?, cod_pacote_assento=? WHERE cod_pacote=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, pack.getCodPacote());
            stm.setDouble(2, pack.getValorPacote());
            stm.setInt(3, pack.getPacoteQuarto().getPacote().getCodPacote());
            stm.setInt(4, pack.getPacoteAssento().getPacote().getCodPacote());
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
        PacoteQuarto pqr = new PacoteQuarto();
        Pacote p1 = new Pacote();
                p1.setCodPacote(9999);
                pqr.setPacote(p1);
        Quarto q = new Quarto();
                q.setCodQuarto(9999);
                pqr.setQuarto(q);
        PacoteAssento par = new PacoteAssento();
        Pacote p2 = new Pacote();
                p2.setCodPacote(999);
        Assentos a = new Assentos();
                a.setCodAssento(999);
                par.setPacote(p2);
                par.setAssento(a);
        
    }
}