/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.docking;

import javax.swing.*;
import java.awt.*;

public class DockButtonHolderPanel extends javax.swing.JPanel {

    private final Component glue;

    /**
     * Creates new form DockButtonHolderPanel
     */
    public DockButtonHolderPanel(DockLocation dockLocation) {
        initComponents();
        switch(dockLocation) {
            case LEFT_FIRST:
            case LEFT_LAST:
            case RIGHT_FIRST:
            case RIGHT_LAST:
                glue = Box.createVerticalGlue();
                break;
            case BOTTOM_FIRST:
            case BOTTOM_LAST:
                glue = Box.createHorizontalGlue();
                break;
            default:
                glue = null;
        }
        add(glue);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public java.awt.Dimension getPreferredSize() {
        if(isVisible()) {
            return super.getPreferredSize();
        } else {
            return new java.awt.Dimension(0, 0);
        }
    }

    @Override
    public boolean isVisible() {
        return super.isVisible() && getComponentCount() > 0;
    }

    public void add(Component component, DockLocation location) {
        switch(location) {
            case LEFT_FIRST:
            case RIGHT_FIRST:
            case BOTTOM_FIRST:
                Component[] components = getComponents();
                removeAll();
                for (int index = 0; index < components.length; index++) {
                    Component existingComponent = components[index];
                    if (existingComponent == glue) {
                        if(index > 0) {
                            addGlue(location);
                        }
                        add(component);
                    }
                    add(existingComponent);
                }
                break;
            case LEFT_LAST:
            case RIGHT_LAST:
            case BOTTOM_LAST:
                for (int index = 0; index < getComponentCount(); index++) {
                    Component existingComponent = getComponent(index);
                    if (existingComponent == glue) {
                        if(getComponentCount() - index > 0) {
                            addGlue(location);
                        }
                    }
                }
                add(component);
                break;
        }
        validate();
    }

    public void addGlue(DockLocation location) {
        switch(location) {
            case LEFT_FIRST:
            case LEFT_LAST:
            case RIGHT_FIRST:
            case RIGHT_LAST:
                add(Box.createVerticalStrut(10));
                break;
            case BOTTOM_FIRST:
            case BOTTOM_LAST:
                add(Box.createHorizontalStrut(10));
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
