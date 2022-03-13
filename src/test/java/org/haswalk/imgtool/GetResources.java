package org.haswalk.imgtool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface GetResources {

    default String getResourcePath(String name) {

        return GetResources.class.getResource("/" + name).getPath().substring(1);

    }

    default File getResourceFile(String name){

        return new File(getResourcePath(name));

    }

    default BufferedImage getResourceImage(String name) throws IOException {

        return ImageIO.read(getResourceFile(name));

    }

}
