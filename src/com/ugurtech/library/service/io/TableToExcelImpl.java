/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.io;

import com.ugurtech.library.service.validation.UserInfoMessages;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ugur
 */
public class TableToExcelImpl {
    
    private JFileChooser fileChooser;
    private FileNameExtensionFilter fileNameExtensionFilter;
    private File file;
    private TableToExcel tableToExcel;
    private final JTable table;
    private final String title;
    
    public TableToExcelImpl(JTable table,String title){
        this.table=table;
        this.title=title;
    }
    
    private int fileChooser(){
        fileChooser = new JFileChooser();
        fileNameExtensionFilter = new FileNameExtensionFilter("Excel", "xls", "xlsx");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.setName(title);
        return fileChooser.showDialog(null,"Kaydet");
    }
    
    public void writeToTable(){
        if(JFileChooser.APPROVE_OPTION == fileChooser()){
        tableToExcel= new TableToExcel(table, null, title);
        file = new File(fileChooser.getSelectedFile().getPath()+".xls");
        try {
                tableToExcel.generate(file);
            } catch (Exception ex) {
                UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Table to Write Excell Error");
            }
        }
    }
}
