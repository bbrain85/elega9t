/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.gui.form;

import com.elega9t.commons.entity.tree.impl.DefaultGuiEntityTreeNode;
import com.elega9t.commons.entity.tree.impl.DefaultLazyLoadEntityTreeNode;
import com.elega9t.commons.swing.BackgroundText;
import com.elega9t.commons.swing.EtchedBorderOnMouseOverListener;
import com.elega9t.commons.swing.GuiEntityNodeTreeCellRenderer;
import com.elega9t.commons.swing.LongTask;
import com.elega9t.commons.swing.util.SwingUtilities;
import com.elega9t.commons.util.Predicate;
import com.elega9t.elixir.binding.plugin.Action;
import com.elega9t.elixir.binding.plugin.ActionGroup;
import com.elega9t.elixir.binding.plugin.Plugin;
import com.elega9t.elixir.gui.ResourceStrings;
import com.elega9t.elixir.gui.components.TextBackgroundSplitPane;
import com.elega9t.elixir.gui.config.ConnectionDetails;
import com.elega9t.elixir.gui.entity.ConnectionGuiEntity;
import com.elega9t.elixir.gui.entity.DatabaseGuiEntity;
import com.elega9t.elixir.gui.entity.TableGuiEntity;
import com.elega9t.elixir.gui.evnt.DatabaseConnectionEventListener;
import com.elega9t.elixir.gui.mgr.IconsManager;
import com.elega9t.elixir.mgr.PluginProcessor;
import com.elega9t.elixir.mgr.evnt.EventManager;

import javax.swing.*;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeNode;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends javax.swing.JFrame implements PluginProcessor {

    private DefaultGuiEntityTreeNode savedConnections = new DefaultGuiEntityTreeNode(ResourceStrings.main.getString("saved.connections"), new javax.swing.ImageIcon(getClass().getResource("/com/elega9t/elixir/gui/icons/saved_database_connections.png")), ResourceStrings.main.getString("saved.connections.tooltip"));
    private List<DatabaseConnectionEventListener> databaseConnectionEventListeners = new ArrayList<DatabaseConnectionEventListener>();

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
        eventLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(ResourceStrings.main.getString("title"));
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(IconsManager.getInstance().system.getIcon().getImage());

        topPanel.setLayout(new java.awt.BorderLayout());

        toolBar.setRollover(true);
        topPanel.add(toolBar, java.awt.BorderLayout.CENTER);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        bodySplitPane.setDividerLocation(300);
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
        connectionsTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                connectionsTreeValueChanged(evt);
            }
        });
        connectionsTreeScrollPane.setViewportView(connectionsTree);

        connectionsTreeBasePanel.add(connectionsTreeScrollPane, java.awt.BorderLayout.CENTER);

        leftPanelTabbedPane.addTab(ResourceStrings.main.getString("connections"), connectionsTreeBasePanel);

        leftBasePanel.add(leftPanelTabbedPane, java.awt.BorderLayout.CENTER);

        bodySplitPane.setLeftComponent(leftBasePanel);

        bodyPanel.add(bodySplitPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(bodyPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bottomPanel.setLayout(new java.awt.BorderLayout());

        statusLabel.setText(ResourceStrings.main.getString("title"));
        bottomPanel.add(statusLabel, java.awt.BorderLayout.CENTER);

        eventLabel.setFont(SwingUtilities.subscriptFont(eventLabel.getFont()));
        eventLabel.setForeground(new java.awt.Color(250, 5, 5));
        eventLabel.setIcon(IconsManager.getInstance().system.getEventManagerIcon());
        eventLabel.setText(String.valueOf(EventManager.getInstance().getEventCount()));
        eventLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        eventLabel.setEnabled(false);
        eventLabel.setIconTextGap(0);
        eventLabel.addMouseListener(new EtchedBorderOnMouseOverListener(eventLabel));
        bottomPanel.add(eventLabel, java.awt.BorderLayout.LINE_END);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);
        setJMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void expandAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expandAllButtonActionPerformed
        SwingUtilities.expandAll(connectionsTree, savedConnections, new Predicate<TreeNode>() {
            @Override
            public boolean evaluate(TreeNode value) {
                return value == savedConnections || ((DatabaseGuiEntity) value).isLoaded();
            }
        });
    }//GEN-LAST:event_expandAllButtonActionPerformed

    private void collapseAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collapseAllButtonActionPerformed
        SwingUtilities.collapseAll(connectionsTree, savedConnections);
    }//GEN-LAST:event_collapseAllButtonActionPerformed

    private void connectionsTreeTreeWillExpand(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {//GEN-FIRST:event_connectionsTreeTreeWillExpand
        final Object component = evt.getPath().getLastPathComponent();
        if(component instanceof DefaultLazyLoadEntityTreeNode && !((DefaultLazyLoadEntityTreeNode)component).isLoaded()) {
            try {
                new LongTask() {
                    @Override
                    protected void executeTask() throws Exception {
                        DefaultLazyLoadEntityTreeNode lazyLoadEntityTreeNode = (DefaultLazyLoadEntityTreeNode) component;
                        lazyLoadEntityTreeNode.load();
                        if(component instanceof ConnectionGuiEntity) {
                            addTab(lazyLoadEntityTreeNode.getName());
                            fireDatabaseConnectionStateChanged((ConnectionGuiEntity) component);
                        }
                    }
                }.execute(this);
            } catch (Exception e) {
                errorOccured(e);
                e.printStackTrace();
                throw new ExpandVetoException(evt);
            }
        }
    }//GEN-LAST:event_connectionsTreeTreeWillExpand

    public void addTab(String name) {
        final EditorPanel editorPanel = new EditorPanel(this, getConnectionNodes());
        editorTabbedPane.addTab(name, IconsManager.getInstance().sqlResultTable.getEditIcon(), editorPanel);
        addDatabaseConnectionEventListener(editorPanel);
        int index = editorTabbedPane.indexOfComponent(editorPanel);
        CloseTabPanel closeTabPanel = new CloseTabPanel();
        closeTabPanel.setTitle(name);
        closeTabPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editorTabbedPane.remove(editorPanel);
            }
        });
        editorTabbedPane.setTabComponentAt(index, closeTabPanel);

        //btnClose.addActionListener(myCloseActionHandler);
    }

    private void connectionsTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_connectionsTreeValueChanged
        final Object node = connectionsTree.getLastSelectedPathComponent();
        if(node instanceof TableGuiEntity) {
            final String name = ((TableGuiEntity) node).getName();
            currentEditorPanel().execute("select * from " + name);
        }
    }//GEN-LAST:event_connectionsTreeValueChanged

    public EditorPanel currentEditorPanel() {
        return (EditorPanel) editorTabbedPane.getSelectedComponent();
    }

    private void editorTabbedPaneDropEvent(DropTargetDropEvent evt) {
        try {
            evt.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles = (List<File>)
                    evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            for (File file : droppedFiles) {
                editorTabbedPane.addTab(file.getName(), new EditorPanel(this, getConnectionNodes()));
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

    public void errorOccured(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    private ConnectionGuiEntity[] getConnectionNodes() {
        final List<TreeNode> nodes = SwingUtilities.filterNodes(savedConnections, new Predicate<TreeNode>() {
            @Override
            public boolean evaluate(TreeNode value) {
                return value instanceof ConnectionGuiEntity;
            }
        }, new Predicate<TreeNode>() {
            @Override
            public boolean evaluate(TreeNode value) {
                return !(value instanceof ConnectionGuiEntity);
            }
        });
        return nodes.toArray(new ConnectionGuiEntity[nodes.size()]);
    }

    public void addDatabaseConnectionEventListener(DatabaseConnectionEventListener listener) {
        databaseConnectionEventListeners.add(listener);
    }

    public void removeDatabaseConnectionEventListener(DatabaseConnectionEventListener listener) {
        databaseConnectionEventListeners.remove(listener);
    }

    private void fireDatabaseConnectionStateChanged(ConnectionGuiEntity connection) {
        for (DatabaseConnectionEventListener databaseConnectionEventListener : databaseConnectionEventListeners) {
            databaseConnectionEventListener.connectionStateChanged(connection);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JSplitPane bodySplitPane;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton collapseAllButton;
    private javax.swing.JPanel connectionTreeToolBarPanel;
    private javax.swing.JTree connectionsTree;
    private javax.swing.JPanel connectionsTreeBasePanel;
    private javax.swing.JScrollPane connectionsTreeScrollPane;
    private javax.swing.JToolBar connectionsTreeToolBar;
    private javax.swing.JToolBar.Separator connectionsTreeToolBarSeparator1;
    private javax.swing.JTabbedPane editorTabbedPane;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JButton expandAllButton;
    private javax.swing.JPanel leftBasePanel;
    private javax.swing.JTabbedPane leftPanelTabbedPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel rightBasePanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void process(Plugin plugin) {
        if(plugin.getActions() != null) {
            for (ActionGroup actionGroup : plugin.getActions().getGroups()) {
                JMenu menuGroup = new JMenu(actionGroup.getName());
                menuGroup.setToolTipText(actionGroup.getDescription());
                if(actionGroup.getAddToGroup().getGroupId().equals("MainMenu")) {
                    menuBar.add(menuGroup);
                }
                for (Action action : actionGroup.getAction()) {
                    try {
                        javax.swing.Action actionInstance = (javax.swing.Action) Class.forName(action.getClazz()).newInstance();
                        JMenuItem actionItem = new JMenuItem();
                        actionItem.setAction(actionInstance);
                        actionItem.setText(action.getName());
                        actionItem.setToolTipText(action.getDescription());
                        menuGroup.add(actionItem);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
