/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.awt.Component;
import java.util.Arrays;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author cp-14luf
 */
public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
    private JSpinner spinner = new JSpinner();
    private int[] max;
    
    
    public SpinnerEditor(int length) {
        this.max = new int[length];
        Arrays.fill(this.max, -1);
    }

    public SpinnerEditor() {
        max = new int[1];
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        int v = 0;
        if(this.max[row] == -1) {
            System.out.println(this.max[row]);
            this.max[row] = (int)value;
        }else{
            v = (int)value;
        }
        
        spinner.setModel(new SpinnerNumberModel(v, 0, this.max[row], 1));
        return spinner;
    }
    
    
    @Override
    public boolean isCellEditable(EventObject evt) {
        return true;
    }
    
    @Override
    public Object getCellEditorValue() {
        return this.spinner.getValue();
    }
}
