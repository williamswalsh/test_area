package image_manipulation;

import lombok.Data;

@Data
public class ImageSizeLimits {
    // TODO - add protection against invalid values in constructor
    // TODO - Reject negative values
    // TODO - Reject H:0,W:0
    private final int minHeight;
    private final int maxHeight;
    private final int minWidth;
    private final int maxWidth;
}
