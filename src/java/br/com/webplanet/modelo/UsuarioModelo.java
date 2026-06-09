package br.com.webplanet.modelo;

import java.util.ArrayList;
import br.com.webplanet.daos.Usuario;
import br.com.webplanet.daos.Clientes;
import br.com.webplanet.conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioModelo {

    public UsuarioModelo() {
    }

    public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> vUsuarios = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT u.*, c.nome_cliente "
                    + "FROM usuario u "
                    + "INNER JOIN cliente c "
                    + "ON u.cod_cliente = c.cod_cliente";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Usuario usu = new Usuario();
                usu.setUsuCodigo(resultado.getInt("cod_usuario"));
                usu.setUsuLogin(resultado.getString("login"));
                usu.setUsuSenha(resultado.getString("senha"));
                usu.setUsuEmail(resultado.getString("e_mail"));

                Clientes cli = new Clientes();
                cli.setCliCodigo(resultado.getInt("cod_cliente"));
                cli.setCliNome(resultado.getString("nome_cliente"));
                usu.setUsuCliente(cli);

                vUsuarios.add(usu);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vUsuarios;
    }

    public Usuario consultarUsuarioCodigo(int usuCodigo) {
        Usuario usu = null;
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM usuario WHERE cod_usuario = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, usuCodigo);
            ResultSet resultado = stm.executeQuery();

            if (resultado.next()) {
                usu = new Usuario();
                usu.setUsuCodigo(resultado.getInt("cod_usuario"));
                usu.setUsuLogin(resultado.getString("login"));
                usu.setUsuSenha(resultado.getString("senha"));
                usu.setUsuEmail(resultado.getString("e_mail"));

                Clientes cli = new Clientes();
                cli.setCliCodigo(resultado.getInt("cod_cliente"));
                usu.setUsuCliente(cli);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }

    public String inserirUsuario(Usuario usu) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO usuario (login, senha, e_mail, cod_cliente) VALUES (?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, usu.getUsuLogin());
            stm.setString(2, usu.getUsuSenha());
            stm.setString(3, usu.getUsuEmail());
            stm.setInt(4, usu.getUsuCliente().getCliCodigo());

            stm.executeUpdate();
            return "Inserido";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String alterarUsuario(Usuario usu) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "UPDATE usuario SET login=?, senha=?, e_mail=?, cod_cliente=? WHERE cod_usuario=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, usu.getUsuLogin());
            stm.setString(2, usu.getUsuSenha());
            stm.setString(3, usu.getUsuEmail());
            stm.setInt(4, usu.getUsuCliente().getCliCodigo());
            stm.setInt(5, usu.getUsuCodigo());

            stm.executeUpdate();
            return "Alterado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String deletarUsuario(int usuCodigo) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM usuario WHERE cod_usuario=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, usuCodigo);
            stm.executeUpdate();
            return "Deletado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public static void main(String[] args) {

        UsuarioModelo uc = new UsuarioModelo();

        // ===== CREATE =====
        Usuario novo = new Usuario();
        novo.setUsuLogin("testeUser");
        novo.setUsuSenha("123456");
        novo.setUsuEmail("teste@email.com");

        Clientes cli = new Clientes();
        cli.setCliCodigo(1); // TEM que existir
        novo.setUsuCliente(cli);

        System.out.println("Inserir: " + uc.inserirUsuario(novo));

        // ===== READ =====
        ArrayList<Usuario> lista = uc.consultarUsuarios();
        System.out.println("\n--- LISTA ---");
        for (Usuario u : lista) {
            System.out.println(u);
        }

        if (lista.isEmpty()) {
            System.out.println("\nNada encontrado.");
            return;
        }

        int id = lista.get(0).getUsuCodigo();

        // ===== READ BY ID =====
        Usuario u = uc.consultarUsuarioCodigo(id);
        System.out.println("\n--- CONSULTADO ---");
        System.out.println(u);

        // ===== UPDATE =====
        u.setUsuLogin("loginAlterado");
        System.out.println("\nAlterar: " + uc.alterarUsuario(u));

        // ===== DELETE =====
        System.out.println("\nDeletar: " + uc.deletarUsuario(id));

        // ===== FINAL =====
        System.out.println("\n--- LISTA FINAL ---");
        for (Usuario usu : uc.consultarUsuarios()) {
            System.out.println(usu);
        }
    }

}
