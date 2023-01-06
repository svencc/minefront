package cc.sven.hexwarriorproton.minefront.game.hex.graphics.map;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleMergeable implements Mergeable, HasPixelBuffer {

    @NonNull
    private final RenderProvider renderProvider;
    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;

    @Override
    public void mergeWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

    @Override
    public void mergeWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

}
