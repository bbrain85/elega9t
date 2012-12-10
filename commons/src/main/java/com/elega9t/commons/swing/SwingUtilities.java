/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.swing;

import com.elega9t.commons.swing.BackgroundText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SwingUtilities {

    public static void escapeToDispose(final JDialog dialog) {
        dialog.getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dialog.dispose();
            }
        },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    public static void paintBackgroundText(Graphics graphics, Font font, int height, int width, BackgroundText...backgroundText) {
        ((Graphics2D)graphics).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int lastXPos = -1;
        for(int index=0; index < backgroundText.length; index++) {
            final BackgroundText bgText = backgroundText[index];
            int yPos = bgText.getY();
            int stringHeight = (int) graphics.getFontMetrics().getStringBounds(bgText.getText(), graphics).getHeight();
            if(yPos == -1) {
                yPos = (height - stringHeight) / 2;
            }
            graphics.setFont(new Font(font.getName(), bgText.isBold() ? Font.BOLD : Font.PLAIN, bgText.getFontSize()));
            int stringWidth = (int) graphics.getFontMetrics().getStringBounds(bgText.getText(), graphics).getWidth();
            int xPos = lastXPos;
            if(xPos == -1 || !bgText.isAlighWithPrevious()) {
                xPos = (width - stringWidth) / 2;
            }
            graphics.setColor(Color.WHITE);
            graphics.drawString(bgText.getText(), xPos + 1, yPos + 1);
            if(bgText.isUnderline()) {
                graphics.drawLine(xPos + 1, yPos + 6, xPos + stringWidth, yPos + 6);
            }
            graphics.setColor(new Color(0, 0, 0, 0.6f));
            graphics.drawString(bgText.getText(), xPos, yPos);
            if(bgText.isUnderline()) {
                graphics.drawLine(xPos, yPos + 5, xPos + stringWidth, yPos + 5);
            }
            lastXPos = xPos;
        }
    }

}
