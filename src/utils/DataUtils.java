/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static final DateTimeFormatter DataHora
            = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static LocalDateTime parseDataHora(String texto) {
        return LocalDateTime.parse(texto, DataHora);
    }

    public static String formatDataHora(LocalDateTime data) {
        return data.format(DataHora);
    }

    public static String formatData(LocalDate data) {
        return data.format(Data);
    }
    public static final DateTimeFormatter HORA
            = DateTimeFormatter.ofPattern("HH:mm");

    public static String formatHora(LocalTime hora) {
        return hora.format(HORA);
    }
    public static final DateTimeFormatter Data
            = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate parseData(String texto) {
        return LocalDate.parse(texto, Data);
    }
}
