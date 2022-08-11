/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.persistancev2.ModelToTable;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teacher
 */
public class DbUtils<V> {
    private static ResultSet rs;
    private static ResultSetMetaData metaData;
    private static int numberOfColumns;
    private static Vector<Vector<Object>> rows;
    private V v;

    public DbUtils() {
    }

    public DbUtils(V v) {
        this.v = v;
    }

    public static Vector<Vector<Object>> getAllDataRows() {
        try {
            // Get all rows.
             rows = new Vector<>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                rows.addElement(newRow);
            }
            return rows;
        } catch (SQLException e) {
            return null;
        }
    }

    public static Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();

        // Get the column names
        for (int column = 0; column < numberOfColumns; column++) {
            try {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            } catch (SQLException ex) {
                Logger.getLogger(DbUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return columnNames;
    }
    
    public static void resultSetToDbUtils(ResultSet resultSet){
        DbUtils.rs = resultSet;
        try {
            metaData=rs.getMetaData();
            numberOfColumns = metaData.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(DbUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static List<List<Object>> resultSetToNestedList(ResultSet rs, boolean includeColumnNames) {
//        try {
//            // To contain all rows.
//            List<List<Object>> rows = new ArrayList<>();
//            ResultSetMetaData metaData = rs.getMetaData();
//            int numberOfColumns = metaData.getColumnCount();
//
//            // Include column headers as first row if required
//            if (includeColumnNames) {
//                List<Object> columnNames = new ArrayList<>();
//
//                // Get the column names
//                for (int column = 0; column < numberOfColumns; column++) {
//                    columnNames.add(metaData.getColumnLabel(column + 1));
//                }
//                rows.add(columnNames);
//            }
//
//            // Get the data
//            while (rs.next()) {
//                List<Object> newRow = new ArrayList<>();
//
//                for (int i = 1; i <= numberOfColumns; i++) {
//                    newRow.add(rs.getObject(i));
//                }
//
//                rows.add(newRow);
//            }
//            return rows;
//        } catch (SQLException e) {
//
//            return null;
//        }
//    }
//
//    public static List<List<Object>> resultSetToNestedList(ResultSet rs) {
//        try {
//            // To contain all rows.
//            List<List<Object>> rows = new ArrayList<>();
//            ResultSetMetaData metaData = rs.getMetaData();
//            int numberOfColumns = metaData.getColumnCount();
//
//            // Get the data
//            while (rs.next()) {
//                List<Object> newRow = new ArrayList<>();
//
//                for (int i = 1; i <= numberOfColumns; i++) {
//                    newRow.add(rs.getObject(i));
//                }
//
//                rows.add(newRow);
//            }
//            return rows;
//        } catch (SQLException e) {
//
//            return null;
//        }
//    }

}
