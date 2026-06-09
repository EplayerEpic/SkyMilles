package br.com.webplanet.modelo;

import br.com.webplanet.daos.Voo;
import br.com.webplanet.conexao.ConexaoMySQLSky;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.webplanet.utils.DataUtils;

public class VooModelo {

    public ArrayList<Voo> consultarVoos() {
        ArrayList<Voo> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            AeroportoModelo ac = new AeroportoModelo();
            String sql = "SELECT * FROM voo";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Voo v = new Voo();
                v.setCodVoo(rs.getInt("cod_voo"));
                v.setNumVoo(rs.getString("num_voo"));
                v.setDataHoraChegada(rs.getTimestamp("data_hora_chegada").toLocalDateTime());
                v.setDataHoraPartida(rs.getTimestamp("data_hora_partida").toLocalDateTime());
                v.setAviao(rs.getString("aviao"));
                v.setCompanhia(rs.getString("companhia"));
                v.setAeroDestino(ac.consultarAeroportoCodigo(rs.getInt("cod_destino")));
                v.setAeroPartida(ac.consultarAeroportoCodigo(rs.getInt("cod_local_partida")));
                lista.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VooModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Voo consultarVooCodigo(int codVoo) {
        Voo v = null;
        try {

            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "SELECT * FROM voo where cod_voo = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, codVoo);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                v = new Voo();
                AeroportoModelo ac = new AeroportoModelo();
                v.setCodVoo(rs.getInt("cod_voo"));
                v.setNumVoo(rs.getString("num_voo"));
                v.setDataHoraChegada(rs.getTimestamp("data_hora_chegada").toLocalDateTime());
                v.setDataHoraPartida(rs.getTimestamp("data_hora_partida").toLocalDateTime());
                v.setAviao(rs.getString("aviao"));
                v.setCompanhia(rs.getString("companhia"));
                v.setAeroDestino(ac.consultarAeroportoCodigo(rs.getInt("cod_destino")));
                v.setAeroPartida(ac.consultarAeroportoCodigo(rs.getInt("cod_local_partida")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VooModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public String inserirVoo(Voo v) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "INSERT INTO voo (cod_voo, num_voo, data_hora_chegada, data_hora_partida, aviao, companhia, cod_destino, cod_local_partida) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, v.getCodVoo());
            stm.setString(2, v.getNumVoo());
            stm.setTimestamp(3, Timestamp.valueOf(v.getDataHoraChegada()));
            stm.setTimestamp(4, Timestamp.valueOf(v.getDataHoraPartida()));
            stm.setString(5, v.getAviao());
            stm.setString(6, v.getCompanhia());
            stm.setInt(7, v.getAeroDestino().getCodAeroporto());
            stm.setInt(8, v.getAeroPartida().getCodAeroporto());
            stm.executeUpdate();
            return "inserido";
        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public String removerVoo(int cod) {
        try {
            Connection conn = new ConexaoMySQLSky().conectar();
            String sql = "DELETE FROM voo WHERE cod_voo = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, cod);
            stm.executeUpdate();
            return "removido";
        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }

    public static void main(String[] args) {
        AeroportoModelo ac = new AeroportoModelo();
        VooModelo vc = new VooModelo();

        // ===== CREATE (2 VOOS) =====
        Voo v1 = new Voo();
        v1.setNumVoo("AZ123");
        v1.setDataHoraChegada(LocalDateTime.parse("01-05-2026 10:00:00", DataUtils.DataHora));
        v1.setDataHoraPartida(LocalDateTime.parse("2026-05-01 08:00:00", DataUtils.DataHora));
        v1.setAviao("Boeing 737");
        v1.setCompanhia("Azul");
        v1.setAeroDestino(ac.consultarAeroportoCodigo(1));
        v1.setAeroPartida(ac.consultarAeroportoCodigo(2));

        Voo v2 = new Voo();
        v2.setNumVoo("LA456");
        v2.setDataHoraChegada(LocalDateTime.parse("02-05-2026 15:00:00", DataUtils.DataHora));
        v2.setDataHoraPartida(LocalDateTime.parse("02-05-2026 13:00:00", DataUtils.DataHora));
        v2.setAviao("Airbus A320");
        v2.setCompanhia("Latam");
        v2.setAeroDestino(ac.consultarAeroportoCodigo(2));
        v2.setAeroPartida(ac.consultarAeroportoCodigo(1));

        System.out.println("Inserir Voo 1: " + vc.inserirVoo(v1));
        System.out.println("Inserir Voo 2: " + vc.inserirVoo(v2));

        // ===== READ =====
        ArrayList<Voo> lista = vc.consultarVoos();
        System.out.println("\n=== LISTA DE VOOS (APÓS INSERT) ===");
        for (Voo v : lista) {
            System.out.println(v);
        }

        if (lista.size() < 2) {
            System.out.println("\nErro: menos de 2 voos inseridos.");
            return;
        }

        // ===== DELETE (remove o primeiro) =====
        int idRemover = lista.get(0).getCodVoo();
        System.out.println("\nRemovendo voo ID: " + idRemover);
        System.out.println("Resultado: " + vc.removerVoo(idRemover));

        // ===== READ FINAL =====
        ArrayList<Voo> listaFinal = vc.consultarVoos();
        System.out.println("\n=== LISTA FINAL (APÓS DELETE) ===");
        for (Voo v : listaFinal) {
            System.out.println(v);
        }
    }
}
