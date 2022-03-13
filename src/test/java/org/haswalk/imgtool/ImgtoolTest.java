package org.haswalk.imgtool;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.*;

public class ImgtoolTest implements GetResources{

    @Test
    public void resize() throws IOException {

        int targetWidth = 100;
        int targetHeight = 200;

        final BufferedImage src = getResourceImage("imgs/lena.jpg");
        final BufferedImage dst = Imgtool.resize(src, targetWidth, targetHeight, Image.SCALE_FAST);

        assertEquals(dst.getWidth(), targetWidth);
        assertEquals(dst.getHeight(), targetHeight);

    }

    @Test
    public void resize_scale() throws IOException {

        double scale = 0.11;
        final BufferedImage src = getResourceImage("imgs/lena.jpg");
        final BufferedImage dst = Imgtool.resize(src, scale, Image.SCALE_FAST);

        assertEquals(dst.getWidth(), (int)(src.getWidth() * scale));
        assertEquals(dst.getHeight(), (int)(src.getHeight() * scale));

    }
}