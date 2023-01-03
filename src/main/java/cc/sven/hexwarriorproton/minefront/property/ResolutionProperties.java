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
@ConfigurationProperties("resolution")
public class ResolutionProperties {

    private int width;
    private int height;
    private int scale;
    private PixelDimension singleton = null;

    public int getWidth() {
        return width / scale;
    }

    public int getScaledWidth() {
        return width;
    }

    public int getHeight() {
        return height / scale;
    }

    public int getScaledHeight() {
        return height;
    }

    public PixelDimension toRenderDimension() {
        if (singleton == null) {
            singleton = PixelDimension.builder()
                    .widthX(getWidth())
                    .heightY(getWidth())
                    .build();
        }

        return singleton;
    }

}
