package images;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImageManipulationTest {

    // private String imageWithPrefix = "data:image/png;base64," + image;
    private String base64ImageStr;

    @Before
    public void setup() throws IOException {
        base64ImageStr = readFile("tmp.txt", StandardCharsets.UTF_8);
    }

    @Test
    public void isImageSizeInvalidTest() {
        boolean result = isImageSizeInvalid(base64ImageStr);
        assertTrue(result);
    }


    private boolean isImageSizeInvalid(final String imageStr) {
        ImageDimensions uploadedDims = getUploadedImageDimensions(imageStr);

        ImageSizeLimits limits = retrieveImageSizeLimits();

        // this accepts a range of X and Y
        return areDimensionsOutsideLimits(uploadedDims, limits);
    }

    private ImageDimensions getUploadedImageDimensions(final String imageStr) {
        // requireNonBlank(imageStr);

        byte[] decodedImage = Base64.decodeBase64(imageStr);

        InputStream imageStream = new ByteArrayInputStream(decodedImage);
        BufferedImage image;
        try {
            image = ImageIO.read(imageStream);
            return new ImageDimensions(image.getHeight(), image.getWidth());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ImageSizeLimits retrieveImageSizeLimits() {
        // Test if limits are valid amounts here
        // Verify in constructor minimum value - get data from config
        return new ImageSizeLimits(0, 100, 0, 100);
    }

    private boolean areDimensionsOutsideLimits(ImageDimensions dimensions, ImageSizeLimits limits) {
        // TODO - could use && or ||
        //  could use OR statement to combine expressions so if one dimension is wrong.
        return isDimensionOutsideLimits(dimensions.getHeight(), limits.getMinHeight(), limits.getMaxHeight()) ||
                isDimensionOutsideLimits(dimensions.getWidth(), limits.getMinWidth(), limits.getMaxWidth());
    }



    private boolean isDimensionOutsideLimits(int actual, int min, int max) {
        return actual < min || actual > max;
    }


    @Test
    public void base64StringToString() {
        byte[] decodedImage = Base64.decodeBase64(base64ImageStr);
        System.out.println(new String(decodedImage, StandardCharsets.UTF_8));
    }

    @Test
    public void byteArrayToImageHeightAndWidth() throws IOException {
        byte[] decodedImage = Base64.decodeBase64(base64ImageStr);

        File tempFile = new File("temp.tmp");
        OutputStream os = new FileOutputStream(tempFile);
        os.write(decodedImage);
        BufferedImage image = ImageIO.read(tempFile);
        os.close();
        tempFile.deleteOnExit();

        int height = image.getHeight();
        int width = image.getWidth();
        System.out.println("H: " + height + ", W: " + width);
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
