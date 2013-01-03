/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.docking;

import javax.swing.*;
import java.awt.*;

public class DockPanel extends javax.swing.JPanel {

    private final ComponentResizer componentResizer = new ComponentResizer();

    /**
     * Creates new form DockPanel
     */
    public DockPanel() {
        initComponents();
        componentResizer.registerComponent(leftBodyPanel, rightBodyPanel, bottomBodyPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftDockPanel = new DockButtonHolderPanel();
        rightDockPanel = new DockButtonHolderPanel();
        bottomDockPanel = new DockButtonHolderPanel();
        bodyPanel = new javax.swing.JPanel();
        leftBodyPanel = new DockRegionPanel();
        rightBodyPanel = new DockRegionPanel();
        bottomBodyPanel = new DockRegionPanel();
        centerBodyPanel = new javax.swing.JPanel();
        editorTabbedPane = new TextBackgroundTabbedPane(
            new BackgroundText("Tabs", 100, 30).bold(),
            new BackgroundText("No tabs are open", 220, 20).underlined().bold(),
            new BackgroundText("\u2023 Open Recent files with \u2318E", 255, 17),
            new BackgroundText("\u2023 Drag'n'Drop file(s) here from Finder", 280, 17).alighWithPrevious()
        );

        setLayout(new java.awt.BorderLayout());

        leftDockPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 1)));
        leftDockPanel.setLayout(new javax.swing.BoxLayout(leftDockPanel, javax.swing.BoxLayout.PAGE_AXIS));
        add(leftDockPanel, java.awt.BorderLayout.LINE_START);

        rightDockPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 1)));
        rightDockPanel.setLayout(new javax.swing.BoxLayout(rightDockPanel, javax.swing.BoxLayout.PAGE_AXIS));
        add(rightDockPanel, java.awt.BorderLayout.LINE_END);

        bottomDockPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 1)));
        bottomDockPanel.setLayout(new javax.swing.BoxLayout(bottomDockPanel, javax.swing.BoxLayout.LINE_AXIS));
        add(bottomDockPanel, java.awt.BorderLayout.PAGE_END);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        leftBodyPanel.setLayout(new javax.swing.BoxLayout(leftBodyPanel, javax.swing.BoxLayout.PAGE_AXIS));
        bodyPanel.add(leftBodyPanel, java.awt.BorderLayout.LINE_START);

        rightBodyPanel.setLayout(new javax.swing.BoxLayout(rightBodyPanel, javax.swing.BoxLayout.PAGE_AXIS));
        bodyPanel.add(rightBodyPanel, java.awt.BorderLayout.LINE_END);

        bottomBodyPanel.setLayout(new javax.swing.BoxLayout(bottomBodyPanel, javax.swing.BoxLayout.LINE_AXIS));
        bodyPanel.add(bottomBodyPanel, java.awt.BorderLayout.PAGE_END);

        centerBodyPanel.setLayout(new java.awt.BorderLayout());

        editorTabbedPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        centerBodyPanel.add(editorTabbedPane, java.awt.BorderLayout.CENTER);

        bodyPanel.add(centerBodyPanel, java.awt.BorderLayout.CENTER);

        add(bodyPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void addDock(final DockLocation location, String name, javax.swing.Icon icon, java.awt.Component component) {
        final DockButton dockButton = new DockButton(location, name, icon);
        final DockablePanel dockablePanel = new DockablePanel(name, location);
        dockablePanel.setVisible(false);
        dockablePanel.setPreferredSize(new Dimension(300, 100));
        dockablePanel.add(component, java.awt.BorderLayout.CENTER);
        DockStateAction.install(dockButton, dockablePanel);
        switch (location) {
            case LEFT_FIRST:
            case LEFT_LAST:
                if(leftDockPanel.getComponentCount() > 0) {
                    leftDockPanel.add(Box.createVerticalStrut(10));
                }
                leftDockPanel.add(dockButton);
                leftBodyPanel.add(dockablePanel);
                break;
            case RIGHT_FIRST:
            case RIGHT_LAST:
                if(rightDockPanel.getComponentCount() > 0) {
                    rightDockPanel.add(Box.createVerticalStrut(10));
                }
                rightDockPanel.add(dockButton);
                rightBodyPanel.add(dockablePanel);
                break;
            case BOTTOM_FIRST:
            case BOTTOM_LAST:
                if(bottomDockPanel.getComponentCount() > 0) {
                    bottomDockPanel.add(Box.createHorizontalStrut(10));
                }
                bottomDockPanel.add(dockButton);
                bottomBodyPanel.add(dockablePanel);
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JPanel bottomBodyPanel;
    private javax.swing.JPanel bottomDockPanel;
    private javax.swing.JPanel centerBodyPanel;
    private javax.swing.JTabbedPane editorTabbedPane;
    private javax.swing.JPanel leftBodyPanel;
    private javax.swing.JPanel leftDockPanel;
    private javax.swing.JPanel rightBodyPanel;
    private javax.swing.JPanel rightDockPanel;
    // End of variables declaration//GEN-END:variables

}