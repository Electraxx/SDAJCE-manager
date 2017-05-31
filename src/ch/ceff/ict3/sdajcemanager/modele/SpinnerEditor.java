/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.awt.Component;
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

  public SpinnerEditor() {
    spinner.setModel(new SpinnerNumberModel(0, 0, 0, 1));
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    spinner.setModel(new SpinnerNumberModel(0, 0, (int)value, 1));
    return spinner;
  }

  public boolean isCellEditable(EventObject evt) {
      return true;
  }

  public Object getCellEditorValue() {
    return spinner.getValue();
  }
}
