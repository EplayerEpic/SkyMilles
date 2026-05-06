package controle;

import java.util.ArrayList;
import modelo.Clientes;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesControle {

    public ClientesControle() {
    }

    public ArrayList<Clientes> consultarClientes() {
        ArrayList<Clientes> vClientes = new ArrayList<>();
        try {
            ConexaoMySQLSky conexao = new ConexaoMySQLSky();
            Connection conn = conexao.conectar();
            String consulta = "SELECT * FROM cliente";
            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                Clientes cli = new Clientes();
                cli.setCliCodigo(resultado.getInt("cod_cliente"));
                cli.setCliNome(resultado.getString("nome_cliente"));
                cli.setCliEndereco(resultado.getString("endereco"));
                cli.setCliCPF(resultado.getString("cpf"));
                cli.setCliTelefone(resultado.getString("telefone"));
                cli.setCliSexo(resultado.getString("sexo").charAt(0));

                Date dataNasc = resultado.getDate("data_nasc");
                if (dataNasc != null) {
                    cli.setCliDataNasc(dataNasc.toLocalDate());
                }

                vClientes.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vClientes;
    }

    public Clientes consultarClienteCodigo(int cliCodigo) {
        Clientes cli = null;

        try {
            ConexaoMySQLSky conexao = new ConexaoMySQLSky();
            Connection conn = conexao.conectar();

            String consulta = "SELECT * FROM cliente WHERE cod_cliente = " + cliCodigo;
            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            if (resultado.next()) {
                cli = new Clientes(); // só cria se existir

                cli.setCliCodigo(resultado.getInt("cod_cliente"));
                cli.setCliNome(resultado.getString("nome_cliente"));
                cli.setCliEndereco(resultado.getString("endereco"));
                cli.setCliCPF(resultado.getString("cpf"));
                cli.setCliTelefone(resultado.getString("telefone"));
                cli.setCliSexo(resultado.getString("sexo").charAt(0));

                Date dataNasc = resultado.getDate("data_nasc");
                if (dataNasc != null) {
                    cli.setCliDataNasc(dataNasc.toLocalDate());
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesControle.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cli;
    }

    public String inserirCliente(Clientes cli) {
        String resultado = "";
        try {
            ConexaoMySQLSky conexao = new ConexaoMySQLSky();
            Connection conn = conexao.conectar();

            String consulta = "INSERT INTO cliente "
                    + "(nome_cliente, cpf, sexo, endereco, telefone, data_nasc) "
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, cli.getCliNome());
            stm.setString(2, cli.getCliCPF());
            stm.setString(3, cli.getCliSexo() + "");
            stm.setString(4, cli.getCliEndereco());
            stm.setString(5, cli.getCliTelefone());
            stm.setDate(6, cli.getCliDataNasc() != null ? Date.valueOf(cli.getCliDataNasc()) : null);

            stm.executeUpdate();
            resultado = "Inserido";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            System.out.println(ex);
        }
        return resultado;
    }

    public String alterarCliente(Clientes cli) {
        String resultado = "";
        try {
            ConexaoMySQLSky conexao = new ConexaoMySQLSky();
            Connection conn = conexao.conectar();

            String consulta = "UPDATE cliente SET "
                    + "nome_cliente = ?, cpf = ?, sexo = ?, endereco = ?, "
                    + "telefone = ?, data_nasc = ? WHERE cod_cliente = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, cli.getCliNome());
            stm.setString(2, cli.getCliCPF());
            stm.setString(3, cli.getCliSexo() + "");
            stm.setString(4, cli.getCliEndereco());
            stm.setString(5, cli.getCliTelefone());
            stm.setDate(6, cli.getCliDataNasc() != null ? Date.valueOf(cli.getCliDataNasc()) : null);
            stm.setInt(7, cli.getCliCodigo());

            stm.executeUpdate();
            resultado = "Alterado";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            System.out.println(ex);
        }
        return resultado;
    }

    public String deletarCliente(int cliCodigo) {
        String resultado = "";
        try {
            ConexaoMySQLSky conexao = new ConexaoMySQLSky();
            Connection conn = conexao.conectar();

            String consulta = "DELETE FROM cliente WHERE cod_cliente = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, cliCodigo);

            stm.executeUpdate();
            resultado = "Deletado";
        } catch (SQLException ex) {
            resultado = ex.getSQLState();
            System.out.println(ex);
        }
        return resultado;
    }

    public static void main(String[] args) {
        ClientesControle cc = new ClientesControle();
        ArrayList<Clientes> vClientes = new ArrayList<>();

        for (Clientes cli : vClientes) {
            System.out.println(cli.toString());
        }

        cc.deletarCliente(2);

        vClientes = cc.consultarClientes();

        for (Clientes cli : vClientes) {
            System.out.println(cli.toString());
        }
    }
}
