/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.CarteTableModele;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author cp-13jru
 */
public class TablePanelCarte extends JPanel {

    private JTable table;
    private CarteTableModele carteModel;
    private AppListener appListener;
    private TableRowSorter<TableModel> rowSorter;

    public TablePanelCarte() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        table = new JTable();
        carteModel = new CarteTableModele();
        table = new JTable(carteModel);
        setPreferredSize(new Dimension(685, 200));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Carte> data) {
        carteModel.setData(data);
    }

    public void setAutoCreateRowSorter() {
        table.setAutoCreateRowSorter(true);
    }

    public void refresh() {
        carteModel.fireTableDataChanged();
    }

    public void search(String text) {
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
        }
    }

    public void setSorter() {
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
    }

}
