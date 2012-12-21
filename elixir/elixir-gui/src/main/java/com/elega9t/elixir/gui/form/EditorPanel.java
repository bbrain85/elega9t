package com.elega9t.elixir.gui.form;

import com.elega9t.commons.swing.CheckBoxTableRowHeader;
import com.elega9t.commons.swing.GuiEntityListCellRenderer;
import com.elega9t.commons.swing.ResultSetTableModel;
import com.elega9t.commons.swing.RowNumberTableRowHeader;
import com.elega9t.commons.swing.SwingUtilities;
import com.elega9t.commons.swing.syntax.SqlTextPane;
import com.elega9t.elixir.Connection;
import com.elega9t.elixir.gui.entity.ConnectionGuiEntity;
import com.elega9t.elixir.gui.evnt.DatabaseConnectionEventListener;

import javax.swing.text.BadLocationException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditorPanel extends javax.swing.JPanel implements DatabaseConnectionEventListener {

    //http://boplicity.nl/confluence/display/Java/Xml+syntax+highlighting+in+Swing+JTextPane
    // http://tips4java.wordpress.com/2008/11/18/row-number-table/

    private final Main main;
    /**
     * Creates new form EditorPanel
     */
    public EditorPanel(Main main, ConnectionGuiEntity... connections) {
        initComponents();
        for (ConnectionGuiEntity connection : connections) {
            ((javax.swing.DefaultComboBoxModel)currentDatabaseComboBox.getModel()).addElement(connection);
        }
        this.main = main;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorSplitPane = new javax.swing.JSplitPane();
        topPanel = new javax.swing.JPanel();
        topPanelToolbarPanel = new javax.swing.JPanel();
        queryPanelToolBar = new javax.swing.JToolBar();
        executeQueryButton = new javax.swing.JButton();
        currentDatabaseToolBar = new javax.swing.JToolBar();
        currentDatabaseComboBox = new javax.swing.JComboBox();
        topPanelFooterPanel = new javax.swing.JPanel();
        lineNumberToolBar = new javax.swing.JToolBar();
        lineNumberLabel = new javax.swing.JLabel();
        separator1 = new javax.swing.JToolBar.Separator();
        queryEditorScrollPane = new javax.swing.JScrollPane();
        queryEditorTextPane = new SqlTextPane();
        bottomPanel = new javax.swing.JPanel();
        resultsTabbedPane = new javax.swing.JTabbedPane();
        resultTablePanel = new javax.swing.JPanel();
        resultTableScrollPane = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable() {

            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width < getParent().getWidth();
            }

        };
        messagesPanel = new javax.swing.JPanel();
        messagesScrollPane = new javax.swing.JScrollPane();
        messagesTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        editorSplitPane.setDividerLocation(300);
        editorSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        topPanel.setLayout(new java.awt.BorderLayout());

        topPanelToolbarPanel.setLayout(new java.awt.BorderLayout());

        queryPanelToolBar.setFloatable(false);
        queryPanelToolBar.setRollover(true);

        executeQueryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elega9t/elixir/gui/icons/execute_query.png"))); // NOI18N
        executeQueryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        executeQueryButton.setFocusable(false);
        executeQueryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        executeQueryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        executeQueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeQueryButtonActionPerformed(evt);
            }
        });
        queryPanelToolBar.add(executeQueryButton);

        topPanelToolbarPanel.add(queryPanelToolBar, java.awt.BorderLayout.LINE_START);

        currentDatabaseToolBar.setFloatable(false);
        currentDatabaseToolBar.setRollover(true);

        currentDatabaseComboBox.setModel(new javax.swing.DefaultComboBoxModel());
        currentDatabaseComboBox.setRenderer(new GuiEntityListCellRenderer());
        currentDatabaseToolBar.add(currentDatabaseComboBox);

        topPanelToolbarPanel.add(currentDatabaseToolBar, java.awt.BorderLayout.LINE_END);

        topPanel.add(topPanelToolbarPanel, java.awt.BorderLayout.PAGE_START);

        topPanelFooterPanel.setLayout(new java.awt.BorderLayout());

        lineNumberToolBar.setFloatable(false);
        lineNumberToolBar.setRollover(true);

        lineNumberLabel.setText("1:1");
        lineNumberToolBar.add(lineNumberLabel);
        lineNumberToolBar.add(separator1);

        topPanelFooterPanel.add(lineNumberToolBar, java.awt.BorderLayout.CENTER);

        topPanel.add(topPanelFooterPanel, java.awt.BorderLayout.PAGE_END);

        queryEditorTextPane.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                queryEditorTextPaneCaretUpdate(evt);
            }
        });
        queryEditorScrollPane.setViewportView(queryEditorTextPane);

        topPanel.add(queryEditorScrollPane, java.awt.BorderLayout.CENTER);

        editorSplitPane.setTopComponent(topPanel);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        resultTablePanel.setLayout(new java.awt.BorderLayout());

        resultTable.setModel(new ResultSetTableModel());
        resultTable.setRowHeight(20);
        //javax.swing.JTable rowTable = new RowNumberTableRowHeader(resultTable);
        javax.swing.JTable rowTable = new CheckBoxTableRowHeader(resultTable);
        resultTableScrollPane.setRowHeaderView(rowTable);
        resultTableScrollPane.setCorner(javax.swing.JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());
        resultTableScrollPane.setViewportView(resultTable);

        resultTablePanel.add(resultTableScrollPane, java.awt.BorderLayout.CENTER);

        resultsTabbedPane.addTab("Results", resultTablePanel);

        messagesPanel.setLayout(new java.awt.BorderLayout());

        messagesTextArea.setColumns(20);
        messagesTextArea.setRows(5);
        messagesScrollPane.setViewportView(messagesTextArea);

        messagesPanel.add(messagesScrollPane, java.awt.BorderLayout.CENTER);

        resultsTabbedPane.addTab("Messages", messagesPanel);

        bottomPanel.add(resultsTabbedPane, java.awt.BorderLayout.CENTER);

        editorSplitPane.setRightComponent(bottomPanel);

        add(editorSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void executeQueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeQueryButtonActionPerformed
        final ConnectionGuiEntity connectionGuiEntity = (ConnectionGuiEntity) currentDatabaseComboBox.getSelectedItem();
        final Connection connection = connectionGuiEntity.getEntity();
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(queryEditorTextPane.getText());
            final boolean isResultSet = preparedStatement.execute();
            if(isResultSet) {
                final ResultSetTableModel model = (ResultSetTableModel) resultTable.getModel();
                model.setResultSet(preparedStatement.getResultSet());
                setMessage(model.getRowCount() + " row(s) selected.");
                resultsTabbedPane.setSelectedComponent(resultTablePanel);
            } else {
                setMessage(preparedStatement.getUpdateCount() + " row(s) updated.");
                resultsTabbedPane.setSelectedComponent(messagesPanel);
            }
        } catch (SQLException e) {
            main.errorOccured(e);
        }
    }//GEN-LAST:event_executeQueryButtonActionPerformed

    private void queryEditorTextPaneCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_queryEditorTextPaneCaretUpdate
        try {
            lineNumberLabel.setText(SwingUtilities.getRow(evt.getDot(), queryEditorTextPane) + ":" + SwingUtilities.getColumn(evt.getDot(), queryEditorTextPane));
        } catch (BadLocationException e) {
            main.errorOccured(e);
        }
    }//GEN-LAST:event_queryEditorTextPaneCaretUpdate

    private void setMessage(String message) {
        messagesTextArea.setText(message);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JComboBox currentDatabaseComboBox;
    private javax.swing.JToolBar currentDatabaseToolBar;
    private javax.swing.JSplitPane editorSplitPane;
    private javax.swing.JButton executeQueryButton;
    private javax.swing.JLabel lineNumberLabel;
    private javax.swing.JToolBar lineNumberToolBar;
    private javax.swing.JPanel messagesPanel;
    private javax.swing.JScrollPane messagesScrollPane;
    private javax.swing.JTextArea messagesTextArea;
    private javax.swing.JScrollPane queryEditorScrollPane;
    private javax.swing.JTextPane queryEditorTextPane;
    private javax.swing.JToolBar queryPanelToolBar;
    private javax.swing.JTable resultTable;
    private javax.swing.JPanel resultTablePanel;
    private javax.swing.JScrollPane resultTableScrollPane;
    private javax.swing.JTabbedPane resultsTabbedPane;
    private javax.swing.JToolBar.Separator separator1;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel topPanelFooterPanel;
    private javax.swing.JPanel topPanelToolbarPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void connectionAdded(ConnectionGuiEntity connection) {
        currentDatabaseComboBox.addItem(connection);
    }

    @Override
    public void connectionRemoved(ConnectionGuiEntity connection) {
        currentDatabaseComboBox.removeItem(connection);
    }

    @Override
    public void connectionStateChanged(ConnectionGuiEntity connection) {
        currentDatabaseComboBox.updateUI();
    }

}
