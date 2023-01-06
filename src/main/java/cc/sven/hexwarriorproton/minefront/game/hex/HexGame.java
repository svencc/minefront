package cc.sven.hexwarriorproton.minefront.game.hex;

import cc.sven.hexwarriorproton.minefront.engine.GameTemplate;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.components.sprite.Sprite;
import cc.sven.hexwarriorproton.minefront.engine.graphics.components.sprite.SpriteAtlas;
import cc.sven.hexwarriorproton.minefront.game.hex.graphics.map.TestMergeable;
import cc.sven.hexwarriorproton.minefront.property.RendererProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Profile("hexgame")
@RequiredArgsConstructor
public class HexGame extends GameTemplate {

    @NonNull
    private final RendererProperties rendererResolution;
    @NonNull
    private final ScreenComposer screenComposer;
    @NonNull
    private final TestMergeable testMergeable;

    @Override
    public void init() {
        try {
            final SpriteAtlas spriteAtlas = new SpriteAtlas("/assets/hex62x32alpha.png");
            final Sprite hexSprite = spriteAtlas.createSprite(spriteAtlas.getPixelBuffer().getDimension(), 0, 0);
            testMergeable.setHexSprite(hexSprite);
            screenComposer.getLayerPipeline().clear();
            screenComposer.getLayerPipeline().add(testMergeable);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(666);
        }
    }

    @Override
    public void startGame() {

    }

}
