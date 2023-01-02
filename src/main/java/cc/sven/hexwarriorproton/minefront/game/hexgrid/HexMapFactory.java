package cc.sven.hexwarriorproton.minefront.game.hexgrid;

import cc.sven.hexwarriorproton.minefront.game.hexgrid.strategy.RectangularFlatToppedEqualUpLayoutStrategy;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
public class HexMapFactory {

    @NonNull
    public HexMap layout(@NonNull HexMapProperties hexMapProperties) {
        switch (hexMapProperties.getMapShape()) {
            case ODD_Q:
                final RectangularFlatToppedEqualUpLayoutStrategy rectangularFlatToppedEqualUpLayoutStrategy = new RectangularFlatToppedEqualUpLayoutStrategy();
                return rectangularFlatToppedEqualUpLayoutStrategy.layout(hexMapProperties);
            default:
                throw new IllegalStateException(hexMapProperties.getMapShape() + " not handled yet!");

        }
    }

}
