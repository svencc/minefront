package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid;

import cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.strategy.RectangularFlatToppedEqualUpLayoutStrategy;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class HexMapLayout {

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
