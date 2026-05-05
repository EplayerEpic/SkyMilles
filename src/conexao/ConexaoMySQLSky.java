package conexao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMySQLSky {

    // Dados do banco


    // Construtor geral
    public ConexaoMySQLSky() {}

    // Método conectar
    public Connection conectar() {
        Connection conn = null;
        int x;
        try {
             System.out.println("Conectando ao banco... ");
            String ip = "127.0.0.1";
            String us = "root";
            String bd = "Skymilles";
            String pw = "";
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + bd , us , pw);
            System.out.println("Conectado.");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão: " + ex.getMessage());
        }
        return conn;
    }
    
    public static void main(String[] args){
     ConexaoMySQLSky conexao = new ConexaoMySQLSky();
     Connection conn = conexao.conectar();
     System.out.println(conn);
    }
}