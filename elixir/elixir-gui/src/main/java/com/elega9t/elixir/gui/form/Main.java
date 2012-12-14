/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.gui.form;

import com.elega9t.commons.entity.GuiEntityNode;
import com.elega9t.commons.swing.BackgroundText;
import com.elega9t.commons.swing.GuiEntityNodeTreeCellRenderer;
import com.elega9t.commons.swing.SwingUtilities;
import com.elega9t.commons.swing.config.ConfigDialog;
import com.elega9t.commons.util.Predicate;
import com.elega9t.elixir.gui.ResourceStrings;
import com.elega9t.elixir.gui.components.TextBackgroundSplitPane;
import com.elega9t.elixir.gui.components.config.LookAndFeelConfigElement;
import com.elega9t.elixir.gui.config.ConnectionDetails;
import com.elega9t.elixir.gui.dialog.ConnectToDatabaseDialog;
import com.elega9t.elixir.gui.entity.ConnectionGuiEntity;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.tree.TreeNode;

public class Main extends javax.swing.JFrame {

    private GuiEntityNode savedConnections = new GuiEntityNode(ResourceStrings.main.getString("saved.connections"), new javax.swing.ImageIcon(getClass().getResource("/com/elega9t/elixir/gui/icons/saved_database_connections.png")), ResourceStrings.main.getString("saved.connections.tooltip"));
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        loadConfig();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        connectToDatabaseToolBarButton = new javax.swing.JButton();
        bodyPanel = new javax.swing.JPanel();
        bodySplitPane = new javax.swing.JSplitPane();
        rightBasePanel = new javax.swing.JPanel();
        editorTabbedPane = new TextBackgroundSplitPane(
            new BackgroundText(ResourceStrings.main.getString("title"), 100, 30).bold(),
            new BackgroundText(ResourceStrings.main.getString("website"), 130, 20),
            new BackgroundText("No tabs are open", 220, 20).underlined().bold(),
            new BackgroundText("\u2023 Open Recent files with \u2318E", 255, 17),
            new BackgroundText("\u2023 Drag'n'Drop file(s) here from Finder", 280, 17).alighWithPrevious()
        );
        leftBasePanel = new javax.swing.JPanel();
        leftPanelTabbedPane = new javax.swing.JTabbedPane();
        connectionsTreeBasePanel = new javax.swing.JPanel();
        connectionTreeToolBarPanel = new javax.swing.JPanel();
        connectionsTreeToolBar = new javax.swing.JToolBar();
        expandAllButton = new javax.swing.JButton();
        collapseAllButton = new javax.swing.JButton();
        connectionsTreeToolBarSeparator1 = new javax.swing.JToolBar.Separator();
        connectionsTreeScrollPane = new javax.swing.JScrollPane();
        connectionsTree = new javax.swing.JTree(savedConnections);
        bottomPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        connectToDatabaseFileMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        settingsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(ResourceStrings.main.getString("title"));
        setExtendedState(MAXIMIZED_BOTH);

        topPanel.setLayout(new java.awt.BorderLayout());

        toolBar.setRollover(true);

        connectToDatabaseToolBarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elega9t/elixir/gui/icons/connect_to_database.png"))); // NOI18N
        connectToDatabaseToolBarButton.setFocusable(false);
        connectToDatabaseToolBarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        connectToDatabaseToolBarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        connectToDatabaseToolBarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectToDatabaseToolBarButtonActionPerformed(evt);
            }
        });
        toolBar.add(connectToDatabaseToolBarButton);

        topPanel.add(toolBar, java.awt.BorderLayout.CENTER);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        bodySplitPane.setDividerLocation(200);
        bodySplitPane.setOneTouchExpandable(true);

        rightBasePanel.setLayout(new java.awt.BorderLayout());
        rightBasePanel.add(editorTabbedPane, java.awt.BorderLayout.CENTER);
        editorTabbedPane.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                editorTabbedPaneDropEvent(evt);
            }
        });

        bodySplitPane.setRightComponent(rightBasePanel);

        leftBasePanel.setLayout(new java.awt.BorderLayout());

        connectionsTreeBasePanel.setLayout(new java.awt.BorderLayout());

        connectionTreeToolBarPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        connectionsTreeToolBar.setFloatable(false);
        connectionsTreeToolBar.setRollover(true);

        expandAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elega9t/elixir/gui/icons/expand_all.png"))); // NOI18N
        expandAllButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        expandAllButton.setFocusable(false);
        expandAllButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        expandAllButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        expandAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expandAllButtonActionPerformed(evt);
            }
        });
        connectionsTreeToolBar.add(expandAllButton);

        collapseAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elega9t/elixir/gui/icons/collapse_all.png"))); // NOI18N
        collapseAllButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        collapseAllButton.setFocusable(false);
        collapseAllButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        collapseAllButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        collapseAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collapseAllButtonActionPerformed(evt);
            }
        });
        connectionsTreeToolBar.add(collapseAllButton);
        connectionsTreeToolBar.add(connectionsTreeToolBarSeparator1);

        connectionTreeToolBarPanel.add(connectionsTreeToolBar);

        connectionsTreeBasePanel.add(connectionTreeToolBarPanel, java.awt.BorderLayout.PAGE_START);

        connectionsTree.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        connectionsTree.setCellRenderer(new GuiEntityNodeTreeCellRenderer());
        connectionsTree.setRowHeight(20);
        connectionsTree.addTreeWillExpandListener(new javax.swing.event.TreeWillExpandListener() {
            public void treeWillExpand(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {
                connectionsTreeTreeWillExpand(evt);
            }
            public void treeWillCollapse(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {
            }
        });
        connectionsTreeScrollPane.setViewportView(connectionsTree);

        connectionsTreeBasePanel.add(connectionsTreeScrollPane, java.awt.BorderLayout.CENTER);

        leftPanelTabbedPane.addTab(ResourceStrings.main.getString("connections"), connectionsTreeBasePanel);

        leftBasePanel.add(leftPanelTabbedPane, java.awt.BorderLayout.CENTER);

        bodySplitPane.setLeftComponent(leftBasePanel);

        bodyPanel.add(bodySplitPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(bodyPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bottomPanel.setLayout(new java.awt.BorderLayout());

        statusLabel.setText(ResourceStrings.main.getString("title"));
        bottomPanel.add(statusLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        fileMenu.setText(ResourceStrings.menu.getString("main.file.menu"));

        connectToDatabaseFileMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/elega9t/elixir/gui/icons/connect_to_database.png"))); // NOI18N
        connectToDatabaseFileMenuItem.setText(ResourceStrings.menu.getString("file.menu.connectToDatabase"));
        connectToDatabaseFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectToDatabaseFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(connectToDatabaseFileMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText(ResourceStrings.menu.getString("main.edit.menu"));

        settingsMenuItem.setText(ResourceStrings.menu.getString("edit.menu.settings"));
        settingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(settingsMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void connectToDatabaseToolBarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectToDatabaseToolBarButtonActionPerformed
        connectToDatabaseFileMenuItemActionPerformed(evt);
    }//GEN-LAST:event_connectToDatabaseToolBarButtonActionPerformed

    private void connectToDatabaseFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectToDatabaseFileMenuItemActionPerformed
        new ConnectToDatabaseDialog(this, true).openDialog();
    }//GEN-LAST:event_connectToDatabaseFileMenuItemActionPerformed

    private void expandAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expandAllButtonActionPerformed
        SwingUtilities.expandAll(connectionsTree, savedConnections, new Predicate<TreeNode>() {
            @Override
            public boolean evaluate(TreeNode value) {
                return !(value instanceof ConnectionGuiEntity) || ((ConnectionGuiEntity)value).isConnected();
            }
        });
    }//GEN-LAST:event_expandAllButtonActionPerformed

    private void collapseAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collapseAllButtonActionPerformed
        SwingUtilities.collapseAll(connectionsTree, savedConnections);
    }//GEN-LAST:event_collapseAllButtonActionPerformed

    private void connectionsTreeTreeWillExpand(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {//GEN-FIRST:event_connectionsTreeTreeWillExpand
        Object component = evt.getPath().getLastPathComponent();
        if(component instanceof ConnectionGuiEntity && !((ConnectionGuiEntity)component).isConnected()) {
            ConnectionGuiEntity connection = (ConnectionGuiEntity) component;
            try {
                connection.connect();
                editorTabbedPane.addTab(connection.getName(), connection.getIcon(), new EditorPanel());
            } catch (SQLException e) {
                errorOccured(e);
            }
        }
    }//GEN-LAST:event_connectionsTreeTreeWillExpand

    private void settingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMenuItemActionPerformed
        new ConfigDialog(
                this, 
                true, 
                ResourceStrings.buttons.getString("apply"), 
                ResourceStrings.buttons.getString("cancel"), 
                ResourceStrings.buttons.getString("help"),
                new LookAndFeelConfigElement()
                ).setVisible(true);
    }//GEN-LAST:event_settingsMenuItemActionPerformed

    private void editorTabbedPaneDropEvent(DropTargetDropEvent evt) {
        try {
            evt.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles = (List<File>)
                evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            for (File file : droppedFiles) {
                editorTabbedPane.addTab(file.getName(), new EditorPanel());
            }
        } catch (Exception ex) {
            errorOccured(ex);
        }
    }

    private void loadConfig() {
        ConnectionDetails mysqlConnectionDetails = new ConnectionDetails("root@localhost [mysql]", "mysql", "root", "password", "mysql");
        ConnectionGuiEntity mySQL = new ConnectionGuiEntity(mysqlConnectionDetails);
        savedConnections.addChild(mySQL);
        expandAllButtonActionPerformed(null);
    }

    private void errorOccured(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JSplitPane bodySplitPane;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton collapseAllButton;
    private javax.swing.JMenuItem connectToDatabaseFileMenuItem;
    private javax.swing.JButton connectToDatabaseToolBarButton;
    private javax.swing.JPanel connectionTreeToolBarPanel;
    private javax.swing.JTree connectionsTree;
    private javax.swing.JPanel connectionsTreeBasePanel;
    private javax.swing.JScrollPane connectionsTreeScrollPane;
    private javax.swing.JToolBar connectionsTreeToolBar;
    private javax.swing.JToolBar.Separator connectionsTreeToolBarSeparator1;
    private javax.swing.JMenu editMenu;
    private javax.swing.JTabbedPane editorTabbedPane;
    private javax.swing.JButton expandAllButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel leftBasePanel;
    private javax.swing.JTabbedPane leftPanelTabbedPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel rightBasePanel;
    private javax.swing.JMenuItem settingsMenuItem;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
