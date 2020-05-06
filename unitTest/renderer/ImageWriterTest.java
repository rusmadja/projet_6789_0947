package renderer;

import org.junit.jupiter.api.Test;

import java.awt.*;

class ImageWriterTest {

    @Test
    void writeToImage() {
        String imagename = "imageWriterTest";
        int width = 1600;
        int height = 1000;
        int nx =800;
        int ny =500;
        ImageWriter imageWriter = new ImageWriter(imagename, width, height, nx, ny);
        for (int col = 0; col < ny; col++) {
            for (int row = 0; row < nx; row++) {
                if (col % 50 == 0 || row % 50 == 0) {
                    imageWriter.writePixel(row, col, Color.yellow);
                }
                else
                    imageWriter.writePixel(row, col, Color.blue);

            }
        }
        imageWriter.writeToImage();
    }
}