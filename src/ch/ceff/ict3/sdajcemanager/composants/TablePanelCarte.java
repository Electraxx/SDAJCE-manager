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
import javax.swing.table.JTableHeader;

/**
 *
 * @author cp-13jru
 */
public class TablePanelCarte extends JPanel {

    private JTable table;
    private CarteTableModele carteModel;
    private AppListener appListener;

    public TablePanelCarte() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        table = new JTable();
        carteModel = new CarteTableModele();
        table = new JTable(carteModel);
        JTableHeader entete = table.getTableHeader();
        entete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                if (event.getButton() == MouseEvent.BUTTON1) {
                    int colonne = entete.columnAtPoint(event.getPoint());
                    switch (colonne) {
                        case 1:
                            if (appListener != null) {
                                appListener.orderTable();
                            }
                            break;
                        default:
                            return;
                    }
                }
            }
        });
        setPreferredSize(new Dimension(685, 200));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Carte> data) {
        carteModel.setData(data);
    }

    public void refresh() {
        carteModel.fireTableDataChanged();
    }
    
    public void setCarteTableListener(AppListener listener) {
        this.appListener = listener;
    }

}
