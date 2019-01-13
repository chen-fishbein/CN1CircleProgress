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
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Slider;
import com.codename1.ui.Stroke;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.GeneralPath;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author Chen
 */
public class CircleProgress extends BaseRoundProgress {

    private int arcWidth = 10;
    
    private boolean clockwise = false;
    
    private int startAngle = START_12_OCLOCK;

    public static final int START_12_OCLOCK = 0;

    public static final int START_3_OCLOCK = 1;

    public static final int START_6_OCLOCK = 2;

    public static final int START_9_OCLOCK = 3;

    public CircleProgress() {
        setRenderPercentageOnTop(true);
    }

    public void setArcWidth(int arcWidth){
        this.arcWidth = arcWidth;
    }

    public void setClockwise(boolean clockwise){
        this.clockwise = clockwise;
    }
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    @Override
    public void paint(Graphics g) {
        Style style = getStyle();
        int wPadding = style.getPadding(isRTL(), Component.RIGHT) + style.getPadding(isRTL(), Component.LEFT);
        int hPadding = style.getPadding(Component.TOP) + style.getPadding(Component.BOTTOM);
        GeneralPath path = new GeneralPath();
        int size = Math.min(getWidth() - wPadding, getHeight() - hPadding);
        size = size - arcWidth;
        int x = getX() + style.getPadding(isRTL(), Component.LEFT) + arcWidth/2;
        int y = getY() + style.getPadding(Component.TOP) + arcWidth/2;
        if(style.getAlignment() == CENTER){
            x = getX() + (getWidth() - size)/2;
        }else if(style.getAlignment() == RIGHT){
            x = getX() + getWidth() - (style.getPadding(isRTL(), Component.RIGHT) + arcWidth/2);           
        }

        path.arc(x, y, size, size, 0, 2*Math.PI);
        Stroke stroke1 = new Stroke(arcWidth, Stroke.CAP_ROUND, Stroke.JOIN_ROUND, 4);
        g.setAntiAliased(true);
        g.setColor(getStyle().getBgColor());
        g.drawShape(path, stroke1);        
        int p = getProgress();
        GeneralPath path1 = new GeneralPath();
        double angle = 0;
        switch(startAngle){
            case START_12_OCLOCK:
                angle = Math.PI/2;
                break;
            case START_3_OCLOCK:
                angle = 0;
                break;
            case START_6_OCLOCK:
                angle = -Math.PI/2;
                break;
            case START_9_OCLOCK:
                angle = Math.PI;
                break;                
        }
        if(clockwise){
            path1.arc(x, y, size, size, angle, -(Math.PI*2)*p/getMaxValue());
        }else{
            path1.arc(x, y, size, size, angle, (Math.PI*2)*p/getMaxValue());
        }
        g.setColor(getStyle().getFgColor());
        g.drawShape(path1, stroke1);        
        
        if(isRenderPercentageOnTop()){
            String val = formattedValue(p);
            g.setFont(style.getFont());
            g.drawString(val, x + (size + arcWidth - style.getFont().stringWidth(val))/2, y + (size - style.getFont().getHeight())/2);
        }
    }


}
