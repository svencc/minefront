package cc.sven.hexwarriorproton.minefront.property;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("renderer.resolution")
public class RendererResolutionProperties {

    private static PixelDimension singletonPixelDimension = null;
    private int width;
    private int height;
    private int scale;

    public int getScaledWidth() {
        return width;
    }

    public int getHeight() {
        return height / scale;
    }

    public int getScaledHeight() {
        return height;
    }

    public PixelDimension toRendererDimension() {
        if (singletonPixelDimension == null) {
            singletonPixelDimension = PixelDimension.builder()
                    .widthX(getWidth())
                    .heightY(getHeight())
                    .build();
        }

        return singletonPixelDimension;
    }

    public int getWidth() {
        return width / scale;
    }

}
