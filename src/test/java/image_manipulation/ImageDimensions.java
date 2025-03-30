package image_manipulation;

import lombok.Data;

@Data
public class ImageDimensions {
    // TODO - add protection against invalid values in constructor
    // TODO - Reject negative values
    // TODO - Reject H:0,W:0
    private final int height;
    private final int width;
}
