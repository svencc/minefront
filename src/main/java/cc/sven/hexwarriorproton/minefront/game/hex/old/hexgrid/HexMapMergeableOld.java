package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid;

import cc.sven.hexwarriorproton.minefront.engine.components.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Optional;

//@Component
@RequiredArgsConstructor
public class HexMapMergeableOld implements Mergeable {

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
        renderMapInBuffer();
    }

    private void renderMapInBuffer() {
        hexGridSpriteGenerator.renderHexGridToBuffer(hexMap.get(), pixelBuffer);
    }

    @Override
    public void mergeBufferWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

    @Override
    public void mergeBufferWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

    @Override
    public void prepareBuffer() {

    }

    @Override
    public void disposeBuffer() {

    }

}
