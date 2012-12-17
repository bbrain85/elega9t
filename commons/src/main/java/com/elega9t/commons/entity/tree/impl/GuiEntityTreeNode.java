/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.entity.tree.impl;

import com.elega9t.commons.entity.GuiEntity;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.Enumeration;

public class GuiEntityTreeNode<T extends GuiEntityTreeNode> extends DefaultEntityTreeNode<T> implements GuiEntity, TreeNode {

    private Icon icon;
    private String tooltip;

    public GuiEntityTreeNode(String name) {
        this(name, null);
    }

    public GuiEntityTreeNode(String name, Icon icon) {
        this(name, icon, null);
    }

    public GuiEntityTreeNode(String name, Icon icon, String tooltip) {
        super(name);
        this.icon = icon;
        this.tooltip = tooltip;
    }

    @Override
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public String getTooltip() {
        return tooltip;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return children.indexOf(node);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public Enumeration children() {
        return Collections.enumeration(children);
    }

}
