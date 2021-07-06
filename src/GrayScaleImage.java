import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

public class GrayScaleImage {
    String path;
    int width, height;
    float[][] imageArray;
    float[] singleDimensionArray;

    public GrayScaleImage(String imagePath) {
        try {
            this.path = imagePath;
            String filename = imagePath;
            File file = new File(filename);
            BufferedImage bufferedImage = ImageIO.read(file);
            width = bufferedImage.getWidth();
            height = bufferedImage.getHeight();
            imageArray = new float[width][height];
            Raster raster = bufferedImage.getRaster();
            singleDimensionArray = new float[width * height];
            int count = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    imageArray[i][j] = (float) raster.getSample(i, j, 0);
                }
            }
            normalizeValues();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Min-Max normalization
     */
    private void normalizeValues() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                imageArray[i][j] = imageArray[i][j] / 255f;
            }
        }
    }

    private float[] convertTo1DimensionArray() {
        singleDimensionArray = new float[width * height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                singleDimensionArray[j * i + j] = imageArray[i][j];
            }
        }
        return singleDimensionArray;
    }

    float[] get1DimensionArray() {
        return convertTo1DimensionArray();
    }

    public void printValues() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(imageArray[i][j]);
            }
        }
    }
}
