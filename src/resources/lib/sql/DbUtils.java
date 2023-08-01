/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.lib.sql;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
import resources.lib.date.DateUtils;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DbUtils {
    public static TableModel resultSetToTableModel(ResultSet rs, String... str) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector<Vector<Object>> rows = new Vector<>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<>();
                int strCount = 0;
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (str.length > strCount && str[strCount].equals(metaData.getColumnLabel(i))) {
                        if (rs.getLong(i) != 0) {
                            newRow.addElement(DateUtils.longToDateForTable(rs.getLong(i)));
                        }
                        strCount++;
                    } else {
                        newRow.addElement(rs.getObject(i));
                    }
                }
                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames);
        } catch (SQLException e) {

            return null;
        }
    }

}
