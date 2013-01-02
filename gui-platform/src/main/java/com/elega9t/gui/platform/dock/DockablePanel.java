/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */
package com.elega9t.gui.platform.dock;

/**
 *
 * @author yogesh
 */
public class DockablePanel extends javax.swing.JPanel {

    /**
     * Creates new form DockablePanel
     */
    public DockablePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsPanel = new javax.swing.JPanel();
        dockToolBar = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground().darker()));
        setLayout(new java.awt.BorderLayout());

        toolsPanel.setLayout(new java.awt.BorderLayout());

        dockToolBar.setFloatable(false);
        dockToolBar.setRollover(true);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dockToolBar.add(jButton1);

        toolsPanel.add(dockToolBar, java.awt.BorderLayout.LINE_END);

        add(toolsPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar dockToolBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
