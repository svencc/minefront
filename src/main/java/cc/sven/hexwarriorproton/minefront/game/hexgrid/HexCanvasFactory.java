//package cc.sven.hexwarriorproton.minefront.game.hexgrid;
//
//import lombok.NonNull;
//import lombok.extern.java.Log;
//
//import java.awt.*;
//import java.util.Optional;
//import java.util.concurrent.atomic.AtomicReference;
//
//@Log
//public class HexCanvasFactory {
//
//    @NonNull
//    public Canvas fabricate(@NonNull final HexMap map) {
//        // CANVAS & HEX-RENDERING
//        final Canvas canvas = new Canvas();
//        canvas.getGraphicsContext2D().stroke();
//        final GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
//        final ScreenDimensions screenDimensions = determineCanvasSizeWithHexCenter(map);
//        canvas.setHeight(screenDimensions.getHeight());
//        canvas.setWidth(screenDimensions.getWidth());
//        renderHexgridToCanvas(graphicsContext2D, map);
//
//        addSimpleMouseEventListener(map, canvas);
//
//        return canvas;
//    }
//
//    private static void addSimpleMouseEventListener(@NonNull HexMap map, @NonNull Canvas canvas) {
//        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                final Optional<CubicHex> cubicHex = map.pixelToHex(event.getSceneX(), event.getSceneY());
//                log.info(String.format("Button %s x%s y%s",
//                        event.getButton(),
//                        event.getSceneX(),
//                        event.getSceneY()
//                ));
//
//                if (cubicHex.isPresent()) {
//                    log.info("hex q" + cubicHex.get().getQ() + " r" + cubicHex.get().getR());
//                }
//            }
//        });
//    }
//
//
//    @NonNull
//    private ScreenDimensions determineCanvasSizeWithHexCenter(@NonNull HexMap hexMap) {
//        final AtomicReference<Double> maxHeight = new AtomicReference<>(0.0);
//        final AtomicReference<Double> maxWidth = new AtomicReference<>(0.0);
//
//        hexMap.getCubicHexList().forEach(hex -> {
//            maxHeight.set(Math.max(maxHeight.get(), hex.getCenter().getY()));
//            maxWidth.set(Math.max(maxWidth.get(), hex.getCenter().getX()));
//        });
//
//        final ScreenDimensions dimensions = ScreenDimensions.builder()
//                .height(maxHeight.get() + (hexMap.getHexMapProperties().getMapOffsetY() * 2))
//                .width(maxWidth.get() + (hexMap.getHexMapProperties().getMapOffsetX() * 2))
//                .build();
//
//        return scaleDimensionWithMapOffset(dimensions, hexMap);
//    }
//
//
//    public void renderHexgridToCanvas(@NonNull GraphicsContext context, @NonNull HexMap map) {
//        final long start = System.currentTimeMillis();
//        int hexagonCount = 1;
////        final Font defaultFont = context.getFont();
////        final Font gridNrFont = Font.font("Verdana", 9);
//        context.setLineWidth(1);
//
//        for (CubicHex hexagon : map.getCubicHexList()) {
//            int pointIterationCounter = 0;
//            ScreenCoordinate firstPoint = null;
////            context.setFont(defaultFont);
//
//            for (final ScreenCoordinate currentIterationCorner : hexagon.corners()) {
//                final ScreenCoordinate translatedHexCorner = translateWithMapOffset(currentIterationCorner, map);
//                final ScreenCoordinate translatedHexCenter = translateWithMapOffset(hexagon.getCenter(), map);
//                context.setFill(Color.BLACK);
//
//                if (firstPoint == null) {
//                    firstPoint = translatedHexCorner;
////                    context.setTextAlign(TextAlignment.CENTER);
////                    context.setTextBaseline(VPos.CENTER);
//
////                    context.strokeText(
////                            String.format("q%02d r%02d", hexagon.getQ(), hexagon.getR()),
////                            translatedHexCenter.getX(),
////                            translatedHexCenter.getY() - 20
////                    );
//
////                    context.setStroke(Color.RED);
////                    context.setFont(gridNrFont);
////                    context.strokeText(String.format("%d", hexagonCount), translatedHexCenter.getX(), translatedHexCenter.getY() + 10);
////                    context.setStroke(Color.BLACK);
//                } else {
//                    context.lineTo(translatedHexCorner.getX(), translatedHexCorner.getY());
////                    context.stroke();
//                }
//
//                context.moveTo(translatedHexCorner.getX(), translatedHexCorner.getY());
//
//                // draw the last line back to first point
//                if (pointIterationCounter == 5) {
//                    context.lineTo(firstPoint.getX(), firstPoint.getY());
////                    context.stroke();
//                }
//                pointIterationCounter++;
//            }
//            hexagonCount++;
//        }
//        context.stroke();
//
//        log.info("Rendered in " + (System.currentTimeMillis() - start));
//    }
//
//    @NonNull
//    private ScreenCoordinate translateWithMapOffset(@NonNull ScreenCoordinate currentIterationPoint, @NonNull HexMap map) {
//        return ScreenCoordinate.builder()
//                .x(currentIterationPoint.getX() + map.getHexMapProperties().getMapOffsetX())
//                .y(currentIterationPoint.getY() + map.getHexMapProperties().getMapOffsetY())
//                .build();
//    }
//
//    @NonNull
//    private ScreenDimensions scaleDimensionWithMapOffset(@NonNull ScreenDimensions dimension, @NonNull HexMap hexMap) {
//        return dimension;
////        return ScreenDimensions.builder()
////                .height(dimension.getHeight() + hexMap.getHexMapProperties().getMapOffsetY())
////                .width(dimension.getWidth() + hexMap.getHexMapProperties().getMapOffsetX())
////                .build();
//    }
//
//}
