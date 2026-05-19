package controle;

import modelo.Aeroporto;
import modelo.Cidade;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeroportoControle {

    public ArrayList<Aeroporto> consultarAeroportos() {
        ArrayList<Aeroporto> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
             String sql = "SELECT a.*, c.nome_cidade "
                    + "FROM aeroporto a "
                    + "INNER JOIN cidade c "
                    + "ON a.cod_cidade = c.cod_cidade";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Aeroporto a = new Aeroporto();
                a.setCodAeroporto(rs.getInt("cod_aeroporto"));
                a.setNomeAero(rs.getString("nome_aeroporto"));

                Cidade c = new Cidade();
                c.setCodCidade(rs.getInt("cod_cidade"));
                c.setNomeCidade(rs.getString("nome_cidade"));
                a.setCidade(c);

                lista.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AeroportoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Aeroporto consultarAeroportoCodigo(int codAeroporto) {
        Aeroporto a = null;
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM aeroporto WHERE cod_aeroporto = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codAeroporto);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                a = new Aeroporto();
                a.setCodAeroporto(rs.getInt("cod_aeroporto"));
                a.setNomeAero(rs.getString("nome_aeroporto"));

                Cidade c = new Cidade();
                c.setCodCidade(rs.getInt("cod_cidade"));
                a.setCidade(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AeroportoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public String inserirAeroporto(Aeroporto a) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "INSERT INTO aeroporto (nome_aeroporto, cod_cidade) VALUES (?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, a.getNomeAero());
            stm.setInt(2, a.getCidade().getCodCidade());

            stm.executeUpdate();
            return "inserido";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String alterarAeroporto(Aeroporto a) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "UPDATE aeroporto SET nome_aeroporto=?, cod_cidade=? WHERE cod_aeroporto=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, a.getNomeAero());
            stm.setInt(2, a.getCidade().getCodCidade());
            stm.setInt(3, a.getCodAeroporto());

            stm.executeUpdate();
            return "alterado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String removerAeroporto(int cod) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "DELETE FROM aeroporto WHERE cod_aeroporto=?";
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

        AeroportoControle ac = new AeroportoControle();

        // ===== CREATE =====
        Aeroporto novo = new Aeroporto();
        novo.setNomeAero("Aeroporto Teste");

        Cidade c = new Cidade();
        c.setCodCidade(1); // precisa existir
        novo.setCidade(c);

        System.out.println("Inserir: " + ac.inserirAeroporto(novo));

        // ===== READ =====
        ArrayList<Aeroporto> lista = ac.consultarAeroportos();
        System.out.println("\n=== LISTA ===");
        for (Aeroporto a : lista) {
            System.out.println(a);
        }

        if (lista.isEmpty()) return;

        int id = lista.get(lista.size() - 1).getCodAeroporto();

        // ===== READ BY ID =====
        System.out.println("\n=== CONSULTADO ===");
        System.out.println(ac.consultarAeroportoCodigo(id));

        // ===== UPDATE =====
        Aeroporto a = ac.consultarAeroportoCodigo(id);
        a.setNomeAero("Aeroporto Alterado");
        System.out.println("\nAlterar: " + ac.alterarAeroporto(a));

        // ===== DELETE =====
        System.out.println("\nDeletar: " + ac.removerAeroporto(id));

        // ===== FINAL =====
        System.out.println("\n=== FINAL ===");
        for (Aeroporto aero : ac.consultarAeroportos()) {
            System.out.println(aero);
        }
    }
}