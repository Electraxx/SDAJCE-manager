/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.DeckTableModele;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author cp-14syf
 */
public class TablePanelDeck extends JPanel {

    private JTable table;
    private DeckTableModele deckModel;
    private TableRowSorter<TableModel> rowSorter;

    public TablePanelDeck() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        table = new JTable();
        deckModel = new DeckTableModele();
        table = new JTable(deckModel);
        setPreferredSize(new Dimension(685, 200));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Deck> data) {
        deckModel.setData(data);
    }

    public void setAutoCreateRowSorter() {
        table.setAutoCreateRowSorter(true);
    }

    public void setSorter() {
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
    }

    public void search(String text) {
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

}
