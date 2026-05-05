package controle;

import java.util.ArrayList;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import modelo.Pacote;
import modelo.PacoteAssento;
import modelo.PacoteQuarto;

public class PacoteControle {
    

    public PacoteControle() {}

    public ArrayList<Pacote> consultarPacotes() {
        ArrayList<Pacote> vPacote = new ArrayList<>();
        PacoteQuarto pqr = new PacoteQuarto();
                pqr.setCodPacote(999);
                pqr.setCodQuarto(999);
        PacoteAssento par = new PacoteAssento();
                par.setCodPacote(999);
                par.setCodAssento(999);
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
                pq.setCodPacote(resultado.getInt("cod_pacote"));
                
                PacoteAssento pa = new PacoteAssento();
                pa.setCodPacote(resultado.getInt("cod_pacote"));
                
                pack.setPacoteQuarto(pq);
                pack.setPacoteAssento(pa);
                if(pack.getPacoteQuarto() ==null){
                    pack.setPacoteQuarto(pqr);
                }
                if(pack.getPacoteAssento() ==null){
                    pack.setPacoteAssento(par);
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
        PacoteQuarto pqr = new PacoteQuarto();
                pqr.setCodPacote(999);
                pqr.setCodQuarto(999);
        PacoteAssento par = new PacoteAssento();
                par.setCodPacote(999);
                par.setCodAssento(999);
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
                pq.setCodPacote(resultado.getInt("cod_pacote"));
                
                PacoteAssento pa = new PacoteAssento();
                pa.setCodPacote(resultado.getInt("cod_pacote"));
                
                pack.setPacoteAssento(pa);
                pack.setPacoteQuarto(pq);
                if(pack.getPacoteQuarto() ==null){
                    pack.setPacoteQuarto(pqr);
                }
                if(pack.getPacoteAssento() ==null){
                    pack.setPacoteAssento(par);
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
            stm.setInt(3, pack.getPacoteQuarto().getCodPacote());
            stm.setInt(4, pack.getPacoteAssento().getCodPacote());

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
            stm.setInt(3, pack.getPacoteQuarto().getCodPacote());
            stm.setInt(4, pack.getPacoteAssento().getCodPacote());
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
}