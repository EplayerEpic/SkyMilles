package controle;

import java.util.ArrayList;
import modelo.Hotel;
import modelo.Cidade;
import conexao.ConexaoMySQLSky;
import java.sql.*;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelControle {

    public ArrayList<Hotel> consultarHoteis() {
        ArrayList<Hotel> vHoteis = new ArrayList<>();

        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT h.*, c.nome_cidade "
                    + "FROM hotel h "
                    + "INNER JOIN cidade c "
                    + "ON h.cod_cidade = c.cod_cidade";
            
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Hotel hot = new Hotel();
                hot.setCodHotel(resultado.getInt("cod_hotel"));
                hot.setCNPJ(resultado.getString("cnpj"));
                hot.setLocal(resultado.getString("_local"));
                hot.setEndereco(resultado.getString("endereco"));

                Date checkIn = resultado.getDate("check_in");
                if (checkIn != null) {
                    hot.setCheckIn(checkIn.toLocalDate());
                }

                Date checkOut = resultado.getDate("check_out");
                if (checkOut != null) {
                    hot.setCheckOut(checkOut.toLocalDate());
                }

                Cidade cidade = new Cidade();
                cidade.setCodCidade(resultado.getInt("cod_cidade"));
                cidade.setNomeCidade(resultado.getString("nome_cidade"));
                hot.setCidade(cidade);

                vHoteis.add(hot);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelControle.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vHoteis;
    }

    public Hotel consultarHotelCodigo(int codHotel) {
        Hotel hot = null;

        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String consulta = "SELECT * FROM hotel WHERE cod_hotel = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, codHotel);
            ResultSet resultado = stm.executeQuery();

            if (resultado.next()) {
                hot = new Hotel();
                hot.setCodHotel(resultado.getInt("cod_hotel"));
                hot.setCNPJ(resultado.getString("cnpj"));
                hot.setLocal(resultado.getString("_local"));
                hot.setEndereco(resultado.getString("endereco"));

                Date checkIn = resultado.getDate("check_in");
                if (checkIn != null) {
                    hot.setCheckIn(checkIn.toLocalDate());
                }

                Date checkOut = resultado.getDate("check_out");
                if (checkOut != null) {
                    hot.setCheckOut(checkOut.toLocalDate());
                }

                Cidade cidade = new Cidade();
                cidade.setCodCidade(resultado.getInt("cod_cidade"));
                hot.setCidade(cidade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelControle.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hot;
    }

    public String inserirHotel(Hotel hot) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "INSERT INTO hotel (cnpj, _local, endereco, check_in, check_out, cod_cidade) VALUES (?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hot.getCNPJ());
            stm.setString(2, hot.getLocal());
            stm.setString(3, hot.getEndereco());
            stm.setDate(4, hot.getCheckIn() != null ? Date.valueOf(hot.getCheckIn()) : null);
            stm.setDate(5, hot.getCheckOut() != null ? Date.valueOf(hot.getCheckOut()) : null);
            stm.setInt(6, hot.getCidade().getCodCidade());

            stm.executeUpdate();
            return "Inserido";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String alterarHotel(Hotel hot) {
        try {
            if (hot.getCidade() == null) {
                return "Erro: cidade nula";
            }

            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "UPDATE hotel SET cnpj=?, _local=?, endereco=?, check_in=?, check_out=?, cod_cidade=? WHERE cod_hotel=?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hot.getCNPJ());
            stm.setString(2, hot.getLocal());
            stm.setString(3, hot.getEndereco());
            stm.setDate(4, hot.getCheckIn() != null ? Date.valueOf(hot.getCheckIn()) : null);
            stm.setDate(5, hot.getCheckOut() != null ? Date.valueOf(hot.getCheckOut()) : null);
            stm.setInt(6, hot.getCidade().getCodCidade());
            stm.setInt(7, hot.getCodHotel());

            stm.executeUpdate();
            return "Alterado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }

    public String deletarHotel(int codHotel) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();

            String sql = "DELETE FROM hotel WHERE cod_hotel=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codHotel);

            stm.executeUpdate();
            return "Deletado";

        } catch (SQLException ex) {
            System.out.println(ex);
            return ex.getSQLState();
        }
    }
    public static void main(String[] args) {

        HotelControle hc = new HotelControle();
        /*
        // ===== INSERIR =====
        Hotel novo = new Hotel();
        novo.setCNPJ("12345678901234");
        novo.setLocal("Centro");
        novo.setEndereco("Rua Teste, 123");
        novo.setCheckIn(java.time.LocalDate.of(2026, 5, 1));
        novo.setCheckOut(java.time.LocalDate.of(2026, 5, 10));

        Cidade cidade = new Cidade();
        cidade.setCodCidade(1); // TEM que existir no banco
        novo.setCodCidade(cidade);

        System.out.println("Inserir: " + hc.inserirHotel(novo));

        // ===== CONSULTAR TODOS =====
        ArrayList<Hotel> lista = hc.consultarHoteis();
        System.out.println("\n--- LISTA DE HOTÉIS ---");
        for (Hotel h : lista) {
            System.out.println(h);
        }

        if (lista.isEmpty()) {
            System.out.println("\nNada no banco. Teste abortado.");
            return;
        }

        // ===== PEGAR UM ID VÁLIDO =====
        int id = lista.get(0).getCodHotel(); // pega o primeiro, não inventa

        // ===== CONSULTAR POR ID =====
        */
        Hotel h = hc.consultarHotelCodigo(1);
        h.setCidade(new CidadeControle().consultarCidades().get(1));
        hc.alterarHotel(h);
        
        /*if (h == null) {
            System.out.println("\nHotel não encontrado.");
            return;
        }

        System.out.println("\n--- HOTEL CONSULTADO ---");
        System.out.println(h);
        
        // ===== ALTERAR =====
        h.setEndereco("Endereço Atualizado");
        System.out.println("\nAlterar: " + hc.alterarHotel(h));

        // ===== CONSULTAR NOVAMENTE =====
        Hotel atualizado = hc.consultarHotelCodigo(id);
        System.out.println("\n--- APÓS ALTERAÇÃO ---");
        System.out.println(atualizado);

        // ===== DELETAR =====
        System.out.println("\nDeletar: " + hc.deletarHotel(id));
        */
        // ===== CONSULTAR FINAL =====
        ArrayList<Hotel> finalLista = hc.consultarHoteis();
        System.out.println("\n--- LISTA FINAL ---");
        for (Hotel hotel : finalLista) {
            System.out.println(hotel);
        }
        
    }
}