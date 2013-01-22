/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.gui.platform;

import com.elega9t.docking.DockLocation;
import com.elega9t.docking.DockPanel;
import com.elega9t.docking.DockablePanel;
import com.elega9t.gui.platform.actions.menu.file.ExitAction;
import com.elega9t.gui.platform.components.EventProgressPanel;
import com.elega9t.gui.platform.mgr.event.Event;
import com.elega9t.gui.platform.mgr.event.EventListener;
import com.elega9t.gui.platform.mgr.event.EventManager;
import com.elega9t.gui.platform.mgr.plugin.PluginManager;
import com.elega9t.gui.platform.model.NameWithMnemonic;
import com.elega9t.platform.binding.plugin.Action;
import com.elega9t.platform.binding.plugin.ActionGroup;
import com.elega9t.platform.binding.plugin.DocksDock;
import com.elega9t.platform.binding.plugin.Plugin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import static com.elega9t.gui.platform.Utilities.readableSize;

public class Main extends javax.swing.JFrame implements EventListener {

    private static final DecimalFormat MEMORY_FORMAT = new DecimalFormat("#,##0");

    private static Main INSTANCE;

    private javax.swing.Action exitAction = new ExitAction();

    private Timer memoryStatusMonitor;

    /**
     * Creates new form Main
     */
    private Main() {
        initComponents();
        EventManager.getInstance().addListener(EventManager.ALL_EVENTS, this);
        memoryStatusMonitor = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                long freeMemory = Runtime.getRuntime().freeMemory();
                long maxMemory = Runtime.getRuntime().maxMemory();
                long usedMemory = maxMemory - freeMemory;
                memoryStatusProgressBar.setString(readableSize(usedMemory, MEMORY_FORMAT) + " of " + readableSize(maxMemory, MEMORY_FORMAT));
                memoryStatusProgressBar.setValue((int) ((usedMemory * 100) / maxMemory));
            }
        });
        memoryStatusMonitor.start();
    }

    public static Main getInstance() {
        if(INSTANCE == null) {
            synchronized (Main.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Main();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBarBasePanel = new javax.swing.JPanel();
        dockPanel = new DockPanel();
        statusPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        statusToolBar = new javax.swing.JToolBar();
        separator2 = new javax.swing.JToolBar.Separator();
        eventProgressPanel = new EventProgressPanel();
        separator1 = new javax.swing.JToolBar.Separator();
        memoryStatusProgressBar = new javax.swing.JProgressBar();
        mainMenu = new javax.swing.JMenuBar();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Elega9t GUI Platform v1.0-SNAPSHOT");
        setExtendedState(MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        toolBarBasePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        getContentPane().add(toolBarBasePanel, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(dockPanel, java.awt.BorderLayout.CENTER);

        statusPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 3)));
        statusPanel.setLayout(new javax.swing.BoxLayout(statusPanel, javax.swing.BoxLayout.LINE_AXIS));

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        statusPanel.add(filler2);

        statusToolBar.setFloatable(false);
        statusToolBar.setRollover(true);
        statusToolBar.add(separator2);

        eventProgressPanel.setEnabled(false);
        statusToolBar.add(eventProgressPanel);
        statusToolBar.add(separator1);

        memoryStatusProgressBar.setMaximumSize(new java.awt.Dimension(50, 20));
        memoryStatusProgressBar.setString("");
        memoryStatusProgressBar.setStringPainted(true);
        memoryStatusProgressBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memoryStatusProgressBarMouseClicked(evt);
            }
        });
        statusToolBar.add(memoryStatusProgressBar);

        statusPanel.add(statusToolBar);

        getContentPane().add(statusPanel, java.awt.BorderLayout.PAGE_END);
        setJMenuBar(mainMenu);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exitAction.actionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void memoryStatusProgressBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memoryStatusProgressBarMouseClicked
        System.gc();
    }//GEN-LAST:event_memoryStatusProgressBarMouseClicked

    @Override
    public void dispose() {
        memoryStatusMonitor.stop();
        super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dockPanel;
    private javax.swing.JPanel eventProgressPanel;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JProgressBar memoryStatusProgressBar;
    private javax.swing.JToolBar.Separator separator1;
    private javax.swing.JToolBar.Separator separator2;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JToolBar statusToolBar;
    private javax.swing.JPanel toolBarBasePanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void pastEvent(Event event) {
        eventOccurred(event);
    }

    @Override
    public void eventOccurred(Event event) {
        if(PluginManager.PLUGIN_LOAD_EVENT_TYPE.equals(event.getEventType())) {
            Plugin plugin = (Plugin) event.getSource();
            if("Application".equalsIgnoreCase(plugin.getInfo().getCategory())) {
                setTitle(plugin.getInfo().getName() + " v" + plugin.getInfo().getVersion());
                String iconPath = plugin.getInfo().getIcon();
                if(iconPath != null) {
                    setIconImage(new ImageIcon(iconPath).getImage());
                }
            }
            if(plugin.getActions() != null) {
                for (ActionGroup actionGroup : plugin.getActions().getGroups()) {
                    NameWithMnemonic nameWithMnemonic = new NameWithMnemonic(actionGroup.getName());
                    javax.swing.JMenu menuGroup = new javax.swing.JMenu(nameWithMnemonic.getName());
                    menuGroup.setMnemonic(nameWithMnemonic.getMnemonic());
                    menuGroup.setToolTipText(actionGroup.getDescription());
                    if(actionGroup.getAddToGroup().getGroupId().equals("MainMenu")) {
                        mainMenu.add(menuGroup);
                    }
                    for (Action action : actionGroup.getAction()) {
                        try {
                            javax.swing.JMenuItem actionItem = new javax.swing.JMenuItem();
                            javax.swing.Action actionInstance = initMenuItemAction(action, actionItem);
                            menuGroup.add(actionItem);
                            if("ExitApplication".equals(action.getId())) {
                                exitAction = actionInstance;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if(plugin.getDocks() != null) {
                for (DocksDock dock : plugin.getDocks().getDock()) {
                    try {
                        java.awt.Component component = (Component) Class.forName(dock.getComponentClass()).newInstance();
                        javax.swing.Icon icon = null;
                        javax.swing.Icon disabledIcon = null;
                        if(dock.getIcon() != null) {
                            icon = new javax.swing.ImageIcon(getClass().getResource(dock.getIcon()));
                        }
                        if(dock.getDisabledIcon() != null) {
                            disabledIcon = new javax.swing.ImageIcon(getClass().getResource(dock.getIcon()));
                        }
                        DockablePanel dockablePanel = ((DockPanel) dockPanel).addDock(DockLocation.valueOf(dock.getLocation().name()), dock.getName(), icon, disabledIcon, component, dock.isEnabled(), dock.isVisible());
                        if(dock.getAction() != null) {
                            for (Action action : dock.getAction()) {
                                JButton actionButton = new JButton();
                                initActionItem(action, actionButton);
                                dockablePanel.addToolbarButton(actionButton, true);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        statusLabel.setText(event.getEventLog());
    }

    private javax.swing.Action initMenuItemAction(Action action, JMenuItem actionItem) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        javax.swing.Action actionInstance = initActionItem(action, actionItem);
        if(action.getKeyboardShortcut() != null) {
            actionItem.setAccelerator(KeyStroke.getKeyStroke(action.getKeyboardShortcut()));
        }
        return actionInstance;
    }

    private javax.swing.Action initActionItem(Action action, AbstractButton actionItem) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        javax.swing.Action actionInstance = (javax.swing.Action) Class.forName(action.getClazz()).newInstance();
        actionItem.setAction(actionInstance);
        NameWithMnemonic nameWithMnemonic = new NameWithMnemonic(action.getName());
        actionItem.setText(nameWithMnemonic.getName());
        if(nameWithMnemonic.getMnemonic() != null) {
            actionItem.setMnemonic(nameWithMnemonic.getMnemonic());
        }
        actionItem.setToolTipText(action.getDescription());
        if(action.getIcon() != null) {
            actionItem.setIcon(new javax.swing.ImageIcon(getClass().getResource(action.getIcon())));
        }
        return actionInstance;
    }

}
