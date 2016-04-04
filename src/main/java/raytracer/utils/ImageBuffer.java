package raytracer.utils;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ImageBuffer {
    private static class PixelIndex {
        final int row;
        final int col;

        PixelIndex(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    ConcurrentHashMap<PixelIndex, Color> buffer = new ConcurrentHashMap<>();
    int width;
    int height;

    public ImageBuffer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void putPixel(int row, int col, Color c) {
        buffer.put(new PixelIndex(row, col), c);
    }

    public void saveAsPng(String path) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(Map.Entry<PixelIndex, Color> idxAndColor: buffer.entrySet()) {
            PixelIndex idx = idxAndColor.getKey();
            Color c = idxAndColor.getValue();
            bufferedImage.setRGB(idx.col, idx.row, c.toRGB());
        }

        FileImageOutputStream fios = new FileImageOutputStream(new File(path));
        ImageWriter iw = ImageIO.getImageWritersByFormatName("png").next();
        iw.setOutput(fios);
        iw.write(bufferedImage);
        fios.close();
    }
}
