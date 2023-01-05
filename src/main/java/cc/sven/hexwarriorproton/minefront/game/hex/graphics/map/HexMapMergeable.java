package cc.sven.hexwarriorproton.minefront.game.hex.graphics.map;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import cc.sven.hexwarriorproton.minefront.game.hex.hexgrid.HexMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HexMapMergeable implements Mergeable {

    @NonNull
    private final RenderProvider renderProvider;
    @Nullable
    private final HexGridSpriteGenerator hexGridSpriteGenerator;
    @NonNull
    private final PixelBuffer pixelBuffer;
    @NonNull
    private Optional<HexMap> hexMap = Optional.empty();

    public void setHexMap(@NonNull HexMap newHexMap) {
        hexMap = Optional.of(newHexMap);
//        hexMap.get().getDimension();
        renderMapInBuffer();
    }

    private void renderMapInBuffer() {
        hexGridSpriteGenerator.renderHexGridToBuffer(hexMap.get(), pixelBuffer);
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

    @Override
    public void mergeWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

}
