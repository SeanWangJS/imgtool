package org.haswalk.imgtool;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Imgtool {

    /**
     * Image resize by specific {@code width} and {@code height}
     * @param src source image
     * @param width width of target size
     * @param height height of target size
     * @param hints type of algorithm for image sampling
     *
     * @return resized image
     *
     * @see java.awt.Image#SCALE_DEFAULT
     * @see java.awt.Image#SCALE_REPLICATE
     * @see java.awt.Image#SCALE_AREA_AVERAGING
     * @see java.awt.Image#SCALE_FAST
     * @see java.awt.Image#SCALE_SMOOTH
     * */
    static BufferedImage resize(BufferedImage src, int width, int height, int hints){

        final Image scaledInstance = src.getScaledInstance(width, height, hints);
        final BufferedImage dst = new BufferedImage(width, height, src.getType());

        final Graphics2D g = dst.createGraphics();
        g.drawImage(scaledInstance, 0, 0, null);
        g.dispose();
        return dst;

    }

    /**
     * Image resize by specific {@code scale}
     * @param src the source image
     * @param scale the resize parameter
     * @param hints type of algorithm for image sampling
     *
     * @return resized image
     * */
    static BufferedImage resize(BufferedImage src, double scale, int hints) {

        final int w = (int) (src.getWidth() * scale);
        final int h = (int) (src.getHeight() * scale);
        return resize(src, w, h, hints);

    }


}
