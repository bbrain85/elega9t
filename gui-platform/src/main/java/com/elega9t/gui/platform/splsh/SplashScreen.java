/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.gui.platform.splsh;

import com.elega9t.gui.platform.Context;
import com.elega9t.gui.platform.Main;
import com.elega9t.gui.platform.mgr.PluginLoadEventListener;
import com.elega9t.gui.platform.mgr.PluginManager;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author yogesh
 */
public class SplashScreen extends javax.swing.JFrame implements PluginLoadEventListener {

    private int progressWidth = 5;

    private final Image image;

    private int progressOffset;
    private double progress;

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen(Image image, int progressOffset) {
        this.image = image;
        this.progressOffset = progressOffset;
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                final PluginManager pluginManager = PluginManager.getInstance();
                pluginManager.addPluginLoadEventListener(SplashScreen.this);
                pluginManager.addPluginProcessor(Context.getInstance().getMain());
                pluginManager.load();
                SplashScreen.this.dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Main main = Context.getInstance().getMain();
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                            SwingUtilities.updateComponentTreeUI(main);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        main.setVisible(true);
                        main.setExtendedState(MAXIMIZED_BOTH);
                    }
                });
                return null;
            }

        }.execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setSize(new java.awt.Dimension(image.getWidth(null), image.getHeight(null)));
        setUndecorated(true);
        getContentPane().setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(image, 0, 0, this);
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, progressOffset, getWidth(), progressWidth);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, progressOffset, (int) (getWidth() * progress), progressWidth);
    }

    @Override
    public void pluginLoading(int totalPluginCount, int processedPluginCount) {
        progress = BigDecimal.valueOf(processedPluginCount).divide(BigDecimal.valueOf(totalPluginCount), RoundingMode.HALF_EVEN).doubleValue();
        repaint();
    }

}