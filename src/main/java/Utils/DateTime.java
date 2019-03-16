/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author FELGUEIRAS
 */
public class DateTime {

    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date hoje = new java.util.Date();
        return new java.sql.Timestamp(hoje.getTime());

    }
}
