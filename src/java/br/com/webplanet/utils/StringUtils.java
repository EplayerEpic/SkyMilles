/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.utils;

/**
 *
 * @author Budrys
 */
public class StringUtils {
    public static String formatTelefone(String tel) {
    if (tel == null) return "";

    return tel.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }
}
