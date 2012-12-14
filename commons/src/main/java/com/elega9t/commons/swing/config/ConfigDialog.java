/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.swing.config;

import com.elega9t.commons.entity.GuiEntityNode;
import com.elega9t.commons.swing.SwingUtilities;
import com.elega9t.commons.util.Predicate;
import java.awt.CardLayout;
import javax.swing.tree.TreeNode;

public class ConfigDialog extends javax.swing.JDialog {
    
    private final String applyButtonLabel;
    private final String cancelButtonLabel;
    private final String helpButtonLabel;
    private final ConfigElement[] configElements;
    
    private GuiEntityNode<GuiEntityNode> configTreeRootNode;

    /**
     * Creates new form ConfigDialog
     */
    public ConfigDialog(java.awt.Frame parent, boolean modal, String applyButtonLabel, String cancelButtonLabel, String helpButtonLabel, ConfigElement... configElements) {
        super(parent, modal);
        configTreeRootNode = new GuiEntityNode("Config");
        this.applyButtonLabel = applyButtonLabel;
        this.cancelButtonLabel = cancelButtonLabel;
        this.helpButtonLabel = helpButtonLabel;
        this.configElements = configElements;
        initComponents();
        initConfigDialog();
        setLocationRelativeTo(parent);
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
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        bodyPanel = new javax.swing.JPanel();
        bodySplitPane = new javax.swing.JSplitPane();
        configElementsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        configTree = new javax.swing.JTree(configTreeRootNode);
        configPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        applyButton.setText(applyButtonLabel);
        buttonsPanel.add(applyButton);

        cancelButton.setText(cancelButtonLabel);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(cancelButton);

        helpButton.setText(helpButtonLabel);
        buttonsPanel.add(helpButton);

        getContentPane().add(buttonsPanel, java.awt.BorderLayout.PAGE_END);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        bodySplitPane.setDividerLocation(200);

        configElementsPanel.setLayout(new java.awt.BorderLayout());

        configTree.setRootVisible(false);
        configTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                configTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(configTree);

        configElementsPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        bodySplitPane.setLeftComponent(configElementsPanel);

        configPanel.setLayout(new java.awt.CardLayout());
        bodySplitPane.setRightComponent(configPanel);

        bodyPanel.add(bodySplitPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(bodyPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void configTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_configTreeValueChanged
        GuiEntityNode selectedNode = (GuiEntityNode) evt.getNewLeadSelectionPath().getLastPathComponent();
        CardLayout cardLayout = (CardLayout) configPanel.getLayout();
        cardLayout.show(configPanel, selectedNode.getName());
    }//GEN-LAST:event_configTreeValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JSplitPane bodySplitPane;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel configElementsPanel;
    private javax.swing.JPanel configPanel;
    private javax.swing.JTree configTree;
    private javax.swing.JButton helpButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void initConfigDialog() {
        for(ConfigElement configElement: configElements) {
            String[] parentCategories = configElement.getParentCategory();
            GuiEntityNode<GuiEntityNode> currentNode = configTreeRootNode;
            for(String parentCategory: parentCategories) {
                for(int index=0; index<currentNode.getChildCount(); index++) {
                    GuiEntityNode<GuiEntityNode> node = currentNode.getChildAt(index);
                    if(node.getName().equals(parentCategory)) {
                        currentNode = node;
                        break;
                    }
                }
                if(!currentNode.getName().equals(parentCategory)) {
                    GuiEntityNode<GuiEntityNode> node = new GuiEntityNode<GuiEntityNode>(parentCategory);
                    currentNode.addChild(node);
                    currentNode = node;
                }
            }
            configPanel.add(configElement.getConfigPanel(), currentNode.getName());
        }
        SwingUtilities.expandAll(configTree, configTreeRootNode);
    }

}
