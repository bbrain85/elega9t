/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.docking;

import javax.swing.*;

public class DockablePanel extends javax.swing.JPanel {

    private static final ImageIcon DOCK_LEFT = new javax.swing.ImageIcon(DockablePanel.class.getResource("/dock-left.png"));
    private static final ImageIcon DOCK_RIGHT = new javax.swing.ImageIcon(DockablePanel.class.getResource("/dock-right.png"));
    private static final ImageIcon DOCK_BOTTOM = new javax.swing.ImageIcon(DockablePanel.class.getResource("/dock-bottom.png"));
    private final String title;

    private final DockLocation location;

    /**
     * Creates new form DockablePanel
     */
    public DockablePanel(String title, DockLocation location) {
        this.title = title;
        this.location = location;
        initComponents();
        initDock();
    }

    private void initDock() {
        switch (location) {
            case LEFT_FIRST:
            case LEFT_LAST:
                dockButton.setIcon(DOCK_LEFT);
                break;
            case RIGHT_FIRST:
            case RIGHT_LAST:
                dockButton.setIcon(DOCK_RIGHT);
                break;
            case BOTTOM_FIRST:
            case BOTTOM_LAST:
                dockButton.setIcon(DOCK_BOTTOM);
                break;
        }
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
        titleLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        dockButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground().darker()));
        setLayout(new java.awt.BorderLayout());

        toolsPanel.setLayout(new java.awt.BorderLayout());

        dockToolBar.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        dockToolBar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        dockToolBar.setFloatable(false);
        dockToolBar.setRollover(true);

        titleLabel.setForeground(javax.swing.UIManager.getDefaults().getColor("Label.disabledForeground"));
        titleLabel.setText(title);
        dockToolBar.add(titleLabel);
        dockToolBar.add(filler1);

        dockButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dockButton.setFocusable(false);
        dockButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dockButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dockToolBar.add(dockButton);

        toolsPanel.add(dockToolBar, java.awt.BorderLayout.CENTER);

        add(toolsPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getDockButton() {
        return dockButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dockButton;
    private javax.swing.JToolBar dockToolBar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
