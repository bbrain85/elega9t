/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.elixir.gui.dialog;

import com.elega9t.commons.swing.SwingUtilities;
import com.elega9t.elixir.gui.ResourceStrings;
import com.elega9t.elixir.gui.form.Main;

public class ConnectToDatabaseDialog extends javax.swing.JDialog {

    /**
     * Creates new form ConnectToDatabaseDialog
     */
    public ConnectToDatabaseDialog(Main main, boolean modal) {
        super(main, modal);
        initComponents();
        setLocationRelativeTo(main);
        SwingUtilities.escapeToDispose(this);
    }
    
    public void openDialog() {
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonsPanel = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        testConnectionButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(ResourceStrings.dialog.connectToDatabase.getString("title"));
        setSize(new java.awt.Dimension(800, 500));

        buttonsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        connectButton.setText(ResourceStrings.buttons.getString("connect"));
        buttonsPanel.add(connectButton);

        testConnectionButton.setText(ResourceStrings.buttons.getString("test.connection"));
        buttonsPanel.add(testConnectionButton);

        cancelButton.setText(ResourceStrings.buttons.getString("cancel"));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(cancelButton);

        helpButton.setText(ResourceStrings.buttons.getString("help"));
        buttonsPanel.add(helpButton);

        getContentPane().add(buttonsPanel, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton testConnectionButton;
    // End of variables declaration//GEN-END:variables
}
