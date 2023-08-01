/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.lib.sql;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 *
 */
import com.ugurtech.library.presentation.view.logFrame.LogInternalFrame;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ListUtils {

    public static TableModel resultSetToTableModel(ResultSet rs, String... str) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();
            columnNames.addElement("Components");
            columnNames.addElement("Permission");
//            Vector<Object> componentNames = new Vector<>();
//
////	     Get the column names
//	    for (int column = 2; column < numberOfColumns; column++) {
//		componentNames.addElement(metaData.getColumnLabel(column + 1));
//	    }

            // Get all rows.
            Vector<Vector<Object>> rows = new Vector<>();
            for (int column = 2; column < numberOfColumns; column++) {
                // while (rs.next()) {
                Vector<Object> newRow = new Vector<>();
                for (int i = 3; i <= numberOfColumns; i++) {
                    newRow.addElement(metaData.getColumnLabel(column + 1));
                    newRow.addElement(rs.getBoolean(column + 1));
                }
                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    switch (columnIndex) {
                        case 0:
                            return java.lang.String.class;
                        case 1:
                            return java.lang.Boolean.class;
                        default:
                            return java.lang.Object.class;
                    }
                }

            };
        } catch (SQLException e) {
            LogInternalFrame.INSTANCE.exceptionInfoMessages(ListUtils.class.getName(), e, "Fill Table Error");
            return null;
        }
    }
}
