package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
class DefaultRendererTest {

    private DefaultRenderer rendererToTest;
    private PixelBuffer targetBuffer;

    @BeforeEach
    void setUp() {
        rendererToTest = new DefaultRenderer();
    }

    @Test
    void renderBufferToBuffer() {
        // PREPARE
        targetBuffer = new PixelBuffer(PixelDimension.builder().widthX(1).heightY(1).build());
        final PixelBuffer sourceBuffer = new PixelBuffer(PixelDimension.builder().widthX(1).heightY(1).build());
        int sourceBufferContent = 0xffffff;
        sourceBuffer.fillBuffer(0xffffff);

        // EXECUTE
        rendererToTest.render(sourceBuffer, targetBuffer, 0, 0);

        // ASSERT
        // render-buffer-to-buffer method only proxies PixelBuffer copy method! -> see PixelBufferTest
        assertEquals(sourceBufferContent, targetBuffer.scanPixelAt(0, 0));
    }

    @Test
    void renderScanableToBuffer() {
        // PREPARE
        targetBuffer = new PixelBuffer(PixelDimension.builder().widthX(2).heightY(2).build());
        final PixelBuffer sourceBuffer = new PixelBuffer(PixelDimension.builder().widthX(1).heightY(1).build());
        int sourceBufferContent = 0xffffff;
        sourceBuffer.fillBuffer(0xffffff);

        // EXECUTE
        rendererToTest.render((Scanable) sourceBuffer, targetBuffer, 0, 0);

        // ASSERT
        assertEquals(sourceBufferContent, targetBuffer.scanPixelAt(0, 0));
        assertEquals(0, targetBuffer.scanPixelAt(1, 0));
        assertEquals(0, targetBuffer.scanPixelAt(0, 1));
        assertEquals(0, targetBuffer.scanPixelAt(1, 1));
    }

    @Test
    void renderScanableToBufferWithOffset() {
        // PREPARE
        targetBuffer = new PixelBuffer(PixelDimension.builder().widthX(2).heightY(2).build());
        final PixelBuffer sourceBuffer = new PixelBuffer(PixelDimension.builder().widthX(2).heightY(2).build());
        int sourceBufferContent = 0xffffff;
        sourceBuffer.fillBuffer(0xffffff);

        // EXECUTE
        rendererToTest.render((Scanable) sourceBuffer, targetBuffer, 1, 1);

        // ASSERT
        assertEquals(0, targetBuffer.scanPixelAt(0, 0));
        assertEquals(0, targetBuffer.scanPixelAt(1, 0));
        assertEquals(0, targetBuffer.scanPixelAt(0, 1));
        assertEquals(sourceBufferContent, targetBuffer.scanPixelAt(1, 1));
    }

    @Test
    void renderScanableToBufferWithNegativeOffset() {
        // PREPARE
        targetBuffer = new PixelBuffer(PixelDimension.builder().widthX(2).heightY(2).build());
        final PixelBuffer sourceBuffer = new PixelBuffer(PixelDimension.builder().widthX(2).heightY(2).build());
        int sourceBufferContent = 0xffffff;
        sourceBuffer.fillBuffer(0xffffff);

        // EXECUTE
        rendererToTest.render((Scanable) sourceBuffer, targetBuffer, -1, -1);

        // ASSERT
        assertEquals(sourceBufferContent, targetBuffer.scanPixelAt(0, 0));
        assertEquals(0, targetBuffer.scanPixelAt(1, 0));
        assertEquals(0, targetBuffer.scanPixelAt(0, 1));
        assertEquals(0, targetBuffer.scanPixelAt(1, 1));
    }

    @Test
    void setPixelAt() {
        // PREPARE
        targetBuffer = new PixelBuffer(PixelDimension.builder().widthX(2).heightY(2).build());
        int newPixelContent = 0xffffff;

        // EXECUTE
        rendererToTest.setPixelAt(targetBuffer, 1, 1, newPixelContent);

        // ASSERT
        assertEquals(0, targetBuffer.scanPixelAt(0, 0));
        assertEquals(0, targetBuffer.scanPixelAt(1, 0));
        assertEquals(0, targetBuffer.scanPixelAt(0, 1));
        assertEquals(newPixelContent, targetBuffer.scanPixelAt(1, 1));
    }

    @Test
    void setPixelAtOutOfBounds() {
        // PREPARE
        targetBuffer = new PixelBuffer(PixelDimension.builder().widthX(2).heightY(2).build());
        int newPixelContent = 0xffffff;

        // EXECUTE
        rendererToTest.setPixelAt(targetBuffer, 9, 9, newPixelContent);

        // ASSERT
        assertEquals(0, targetBuffer.scanPixelAt(0, 0));
        assertEquals(0, targetBuffer.scanPixelAt(1, 0));
        assertEquals(0, targetBuffer.scanPixelAt(0, 1));
        assertEquals(0, targetBuffer.scanPixelAt(1, 1));
    }

}