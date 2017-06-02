/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.composants;

import ch.ceff.ict3.sdajcemanager.listeners.AppListener;
import ch.ceff.ict3.sdajcemanager.modele.Carte;
import ch.ceff.ict3.sdajcemanager.modele.CarteTableModeleAjout;
import ch.ceff.ict3.sdajcemanager.modele.Conteneur;
import ch.ceff.ict3.sdajcemanager.modele.Deck;
import ch.ceff.ict3.sdajcemanager.modele.SpinnerEditor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author cp-13jru
 */
public class TablePanelAjoutDeck extends JPanel {

    private JTable table;
    private CarteTableModeleAjout carteModel;
    private AppListener appListener;
    private TableRowSorter<TableModel> rowSorter;
    List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(3);

    public TablePanelAjoutDeck() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        table = new JTable();
        carteModel = new CarteTableModeleAjout();
        table = new JTable(carteModel);
        
        
        TableColumn nombreColumn = table.getColumn("Nombre");
        nombreColumn.setCellEditor(new SpinnerEditor());
        
        setPreferredSize(new Dimension(685, 200));
        add(new JScrollPane(table), BorderLayout.CENTER);
        
    }
    

    public void setData(List<Carte> data) {
        carteModel.setData(data);
        TableColumn nombreColumn = table.getColumn("Nombre");
        nombreColumn.setCellEditor(new SpinnerEditor(data.size()));
        
    }
    
    public List<Carte> getCartes() {
        List<Carte> cartes = new ArrayList<>();
        
        for(int i = 0; i < table.getRowCount(); i++) {
            
            if ((int)table.getValueAt(i, 0) > 0) {
                Carte carte = new Carte(
                        (int)table.getValueAt(i, 2),
                        (String)table.getValueAt(i, 3),
                        (String)table.getValueAt(i, 4),
                        (String)table.getValueAt(i, 5),
                        (int)table.getValueAt(i, 0),
                        (Conteneur)((CarteTableModeleAjout)table.getModel()).getCartes().get(i).getConteneur()
                );
                cartes.add(carte);
            }
            
        }
        return cartes;
    }

    public void setAutoCreateRowSorter() {
        table.setAutoCreateRowSorter(true);
    }

    public void refresh() {
        carteModel.fireTableDataChanged();
        
    }

    public void searchByText(String text) {
        filters.add(RowFilter.regexFilter("(?i)" + text, 1));
    }

    public void search() {

        RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
        rowSorter.setRowFilter(rf);
    }

    public void searchByType(String text) {
        filters.add(RowFilter.regexFilter("(?i)" + text, 2));
        search();
    }

    public void searchBySphere(String text) {
        filters.add(RowFilter.regexFilter("(?i)" + text, 3));
        search();
    }

    public void searchByConteneur(String text) {
        filters.add(RowFilter.regexFilter("(?i)" + text, 4));
        search();
    }

    public void delFilters() {
        filters.clear();
    }

    public void setSorter() {
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        rowSorter.setSortKeys(sortKeys);
    }

}
