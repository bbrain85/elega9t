/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.gui.components;

import com.elega9t.elixir.gui.mgrs.log.LogEvent;
import com.elega9t.elixir.gui.mgrs.log.LogListener;
import com.elega9t.elixir.gui.mgrs.log.LogManager;
import com.elega9t.elixir.gui.mgrs.log.LogType;

import javax.swing.table.DefaultTableModel;

public class QueryHistoryPanel extends javax.swing.JPanel implements LogListener {

    /**
     * Creates new form LogManagerPanel
     */
    public QueryHistoryPanel() {
        initComponents();
        LogManager.getInstance().addLogListener(LogType.QUERY, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbarPanel = new javax.swing.JPanel();
        queryHistoryToolBar = new javax.swing.JToolBar();
        bodyPanel = new javax.swing.JPanel();
        queryHistoryTableScrollPane = new javax.swing.JScrollPane();
        queryHistoryTable = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        toolbarPanel.setLayout(new java.awt.BorderLayout());

        queryHistoryToolBar.setRollover(true);
        toolbarPanel.add(queryHistoryToolBar, java.awt.BorderLayout.CENTER);

        add(toolbarPanel, java.awt.BorderLayout.PAGE_START);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        queryHistoryTable.setModel(new javax.swing.table.DefaultTableModel(new Object[] {"Date", "Database Connection", "Query"}, 0));
        queryHistoryTableScrollPane.setViewportView(queryHistoryTable);

        bodyPanel.add(queryHistoryTableScrollPane, java.awt.BorderLayout.CENTER);

        add(bodyPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void log(LogEvent event) {
        DefaultTableModel model = (DefaultTableModel) queryHistoryTable.getModel();
        model.addRow(new Object[] { "blah", "blah", event.getLog() });
        System.out.println("QueryHistory: " + event.getLog());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JTable queryHistoryTable;
    private javax.swing.JScrollPane queryHistoryTableScrollPane;
    private javax.swing.JToolBar queryHistoryToolBar;
    private javax.swing.JPanel toolbarPanel;
    // End of variables declaration//GEN-END:variables

}
