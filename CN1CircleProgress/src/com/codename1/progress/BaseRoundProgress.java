package com.codename1.progress;

import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Slider;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.plaf.Style;

/**
 * @author Yaakov Gesher
 */
public abstract class BaseRoundProgress extends Slider {
    private int proportionalWidth = 30;
    private int pixelWidth = -1;

    /**
     *
     * @param widthPercent percentage of the screen width
     */
    public void setProportionalWidth(int widthPercent){
        proportionalWidth = widthPercent;
    }

    /**
     *
     * @param pixels width of the component to set, in pixels. Overrides values set using {{@link #setProportionalWidth(int)}}
     */
    public void setPixelWidth(int pixels){
        pixelWidth = pixels;
    }

    @Override
    protected Dimension calcPreferredSize() {
        Style style = getStyle();
        int prefH, prefW;
        if(pixelWidth > 0){
            prefW = pixelWidth;
            prefH = pixelWidth;
        }
        else {
            prefW = Display.getInstance().getDisplayWidth() * proportionalWidth / 100;
            prefH = prefW;
        }

        prefH += (style.getPadding(false, Component.TOP) + style.getPadding(false, Component.BOTTOM));
        prefW += (style.getPadding(isRTL(), Component.RIGHT) + style.getPadding(isRTL(), Component.LEFT));

        return new Dimension(prefW, prefH);
    }

    public void paintComponentBackground(Graphics g) {
    }
}
