package cc.sven.hexwarriorproton.minefront.engine.graphics.components.sprite;

import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;

public class Sprite implements HasPixelBuffer {

    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;

    public Sprite(@NonNull PixelDimension dimension) {
        pixelBuffer = new PixelBuffer(dimension);
    }

    public Sprite(@NonNull PixelDimension dimension, @NonNull SpriteAtlas spriteAtlas, int atlasOffsetX, int atlasOffsetY) {
        pixelBuffer = new PixelBuffer(dimension);
        loadSpriteFromAtlas(spriteAtlas, atlasOffsetX, atlasOffsetY, false, false);
    }

    private void loadSpriteFromAtlas(@NonNull SpriteAtlas spriteAtlas, int atlasOffsetX, int atlasOffsetY, boolean invertX, boolean invertY) {
        for (int y = 0; y < pixelBuffer.getDimension().getHeightY(); y++) {
            int pickY = y;
            if (invertY) {
                pickY = pixelBuffer.getDimension().getHeightY() - y;
            }
            for (int x = 0; x < pixelBuffer.getDimension().getWidthX(); x++) {
                int pickX = x;
                if (invertX) {
                    pickX = pixelBuffer.getDimension().getWidthX() - x;
                }

                pixelBuffer.bufferPixelAt(x, y, getPixelAtIndex(spriteAtlas, atlasOffsetX, atlasOffsetY, pickY, pickX));
            }
        }
    }

    private static int getPixelAtIndex(@NonNull SpriteAtlas spriteAtlas, int atlasOffsetX, int atlasOffsetY, int pickY, int pickX) {
        return spriteAtlas.getPixelBuffer().scanPixelAtIndex((pickX + atlasOffsetX) + (pickY + atlasOffsetY) * spriteAtlas.getPixelBuffer().getDimension().getWidthX());
    }

    public Sprite(@NonNull PixelDimension dimension, @NonNull SpriteAtlas spriteAtlas, int offsetX, int offsetY, boolean invertX, boolean invertY) {
        pixelBuffer = new PixelBuffer(dimension);
        loadSpriteFromAtlas(spriteAtlas, offsetX, offsetY, invertX, invertY);
    }

}
