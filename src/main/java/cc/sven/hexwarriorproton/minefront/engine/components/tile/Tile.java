package cc.sven.hexwarriorproton.minefront.engine.components.tile;

import cc.sven.hexwarriorproton.minefront.engine.components.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.components.Positionable;
import cc.sven.hexwarriorproton.minefront.engine.components.sprite.Sprite;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelCoordinate;

public interface Tile extends HasPixelBuffer, Positionable {

    PixelCoordinate getPosition();

    Sprite getSprite();

    PixelBuffer getPixelBuffer();

}
