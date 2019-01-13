/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */
package com.codename1.progress;

import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Slider;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.GeneralPath;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author Chen
 */
public class CircleFilledProgress extends BaseRoundProgress{

    private int textColor = 0;

    public CircleFilledProgress() {
        setRenderPercentageOnTop(true);
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public void paint(Graphics g) {
        Style style = getStyle();
        int wPadding = style.getPadding(isRTL(), Component.RIGHT) + style.getPadding(isRTL(), Component.LEFT);
        int hPadding = style.getPadding(Component.TOP) + style.getPadding(Component.BOTTOM);
        GeneralPath path = new GeneralPath();
        int size = Math.min(getWidth() - wPadding, getHeight() - hPadding);
        int x = getX() + style.getPadding(isRTL(), Component.LEFT);
        int y = getY() + style.getPadding(Component.TOP);
        if(style.getAlignment() == CENTER){
            x = getX() + (getWidth() - size)/2;
        }else if(style.getAlignment() == RIGHT){
            x = getX() + getWidth() - (style.getPadding(isRTL(), Component.RIGHT));
        }

        path.arc(x, y, size, size, 0, 2*Math.PI);
        g.setAntiAliased(true);
        g.setColor(getStyle().getBgColor());
        g.setClip(path);
        g.fillRect(x, y, size, size);
        int p = getProgress();

        g.setColor(getStyle().getFgColor());
        int h = (getHeight() * p) /getMaxValue();
        g.fillRect(x, y + getHeight() - h, size, h);

        if(isRenderPercentageOnTop()){
            String val = formattedValue(p);
            g.setFont(style.getFont());
            g.setColor(textColor);
            g.drawString(val, x + (size - style.getFont().stringWidth(val))/2, y + (size - style.getFont().getHeight())/2);
        }
        g.resetAffine();
    }

}
