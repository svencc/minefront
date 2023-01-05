package cc.sven.hexwarriorproton.minefront.engine.graphics.components.sprite;

import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteAtlas implements HasPixelBuffer {

    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;

    public SpriteAtlas(@NonNull String path) throws IOException {
        final BufferedImage image = ImageIO.read(SpriteAtlas.class.getResource(path));
        final PixelDimension dimension = PixelDimension.builder().widthX(image.getWidth()).heightY(image.getHeight()).build();

        int[] preparedBuffer = new int[dimension.getWidthX() * dimension.getHeightY()];
        image.getRGB(0, 0, dimension.getWidthX(), dimension.getHeightY(), preparedBuffer, 0, dimension.getWidthX());

        pixelBuffer = new PixelBuffer(dimension, preparedBuffer);
    }

}
