package cc.sven.hexwarriorproton.minefront.engine.graphics.xthreeD;

import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;

public class Renderer3D extends Renderer3DBase {

    private Renderer3DBase test;

    public Renderer3D(@NonNull ResolutionProperties resolution) {
        super(resolution);
    }

    /**
     * xx = x3DPix
     * yy = y3DPix
     *
     * @param tick
     */
    public void renderFloor(StopWatch tick) {

        double floorPosition = 8;
        double ceilingPosition = 8;

        double rotation = tick.getTime() / 100.0;
        double forward = tick.getTime() / 5.0;
        double right = tick.getTime() / -5.0;

        double cosign = Math.cos(rotation);
        double sine = Math.sin(rotation);

        for (int y = 0; y < resolution.getHeight(); y++) {
            double ceiling = (y + -resolution.getHeight() / 2.0) / resolution.getHeight();

            double z = floorPosition / ceiling;

            if (ceiling < 0) {
                z = ceilingPosition / -ceiling;
            }


            for (int x = 0; x < resolution.getWidth(); x++) {
                double depth = (x - resolution.getWidth() / 2.0) / resolution.getHeight();
                depth *= z;
                double xx = depth * cosign + z * sine + right;
                double yy = z * cosign - depth * sine + forward;
                int xPix = (int) (xx);
                int yPix = (int) (yy);
                pixelRaster[x + y * resolution.getWidth()] = ((xPix & 15) * 16) | ((yPix & 15) * 16) << 8;
            }
        }
    }


}
