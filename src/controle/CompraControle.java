package controle;

import java.util.ArrayList;
import modelo.Compra;
import modelo.Clientes;
import modelo.Pacote;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraControle {

    public CompraControle() {
    }

    // READ - Todos
    public ArrayList<Compra> consultarCompra() {
        ArrayList<Compra> vCompra = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String consulta = "SELECT * FROM compra";
            PreparedStatement stm = conn.prepareStatement(consulta);
            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Compra com = new Compra();
                com.setCodCompra(resultado.getInt("cod_compra"));
                com.setFormaPagamento(resultado.getString("forma_paga"));
                com.setValor(resultado.getDouble("valor"));
                com.setDataCompra(resultado.getString("data_compra"));

                Clientes cli = new Clientes();
                cli.setCliCodigo(resultado.getInt("cod_cliente"));
                com.setCodCliente(cli);

                Pacote pac = new Pacote();
                pac.setCodPacote(resultado.getInt("cod_pacote"));
                com.setCodPacote(pac);

                vCompra.add(com);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vCompra;
    }

    // READ - Por código
    public Compra consultarCompraCodigo(int cod_compra) {
        Compra com = null;
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String consulta = "SELECT * FROM compra WHERE cod_compra = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, cod_compra);
            ResultSet resultado = stm.executeQuery();

            if (resultado.next()) {
                com = new Compra();
                com.setCodCompra(resultado.getInt("cod_compra"));
                com.setFormaPagamento(resultado.getString("forma_paga"));
                com.setValor(resultado.getDouble("valor"));
                com.setDataCompra(resultado.getString("data_compra"));

                Clientes cli = new Clientes();
                cli.setCliCodigo(resultado.getInt("cod_cliente"));
                com.setCodCliente(cli);

                Pacote pac = new Pacote();
                pac.setCodPacote(resultado.getInt("cod_pacote"));
                com.setCodPacote(pac);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return com;
    }

    // CREATE
    public String inserirCompra(Compra com) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "INSERT INTO compra "
                    + "(forma_paga, valor, data_compra, cod_cliente, cod_pacote) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, com.getFormaPagamento());
            stm.setDouble(2, com.getValor());
            stm.setString(3, com.getDataCompra());
            stm.setInt(4, com.getCodCliente().getCliCodigo());
            stm.setInt(5, com.getCodPacote().getCodPacote());

            stm.executeUpdate();
            return "inserido";

        } catch (SQLException ex) {
            System.err.println(ex);
            return ex.getSQLState();
        }
    }

    // UPDATE
    public String alterarCompra(Compra com) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "UPDATE compra SET "
                    + "forma_paga = ?, valor = ?, data_compra = ?, "
                    + "cod_cliente = ?, cod_pacote = ? WHERE cod_compra = ?";

            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, com.getFormaPagamento());
            stm.setDouble(2, com.getValor());
            stm.setString(3, com.getDataCompra());
            stm.setInt(4, com.getCodCliente().getCliCodigo());
            stm.setInt(5, com.getCodPacote().getCodPacote());
            stm.setInt(6, com.getCodCompra());

            stm.executeUpdate();
            return "alterado";

        } catch (SQLException ex) {
            System.err.println(ex);
            return ex.getSQLState();
        }
    }

    // DELETE
    public String deletarCompra(int cod_compra) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "DELETE FROM compra WHERE cod_compra = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, cod_compra);

            stm.executeUpdate();
            return "deletado";

        } catch (SQLException ex) {
            System.err.println(ex);
            return ex.getSQLState();
        }
    }

    public static void main(String[] args) {
        CompraControle cc = new CompraControle();

        // ===== INSERIR =====
        Compra nova = new Compra();
        nova.setFormaPagamento("cartao");
        nova.setValor(199.90);
        nova.setDataCompra("2026-04-14");

        Clientes cli = new Clientes();
        cli.setCliCodigo(1); // TEM que existir no banco
        nova.setCodCliente(cli);

        Pacote pac = new Pacote();
        pac.setCodPacote(1); // TEM que existir no banco
        nova.setCodPacote(pac);

        System.out.println("Inserir: " + cc.inserirCompra(nova));

        // ===== LISTAR =====
        ArrayList<Compra> lista = cc.consultarCompra();
        System.out.println("\n--- LISTA DE COMPRAS ---");
        for (Compra c : lista) {
            System.out.println(c);
        }

        if (lista.isEmpty()) {
            System.out.println("\nNada foi inserido. Algo já está errado.");
            return;
        }

        // ===== PEGAR ID REAL =====
        int id = lista.get(lista.size() - 1).getCodCompra(); // pega o último inserido (provável)

        // ===== DELETAR =====
        System.out.println("\nDeletar: " + cc.deletarCompra(id));

        // ===== LISTAR DE NOVO =====
        ArrayList<Compra> listaFinal = cc.consultarCompra();
        System.out.println("\n--- LISTA FINAL ---");
        for (Compra c : listaFinal) {
            System.out.println(c);
        }
    }
}