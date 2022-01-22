package string_testing;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Version implements Comparable<Version> {
    private int major;
    private int minor;
    private int patch;
    private int subPatch;
    private String string;
    private boolean isThreeDigit;

    /**
     * This constructor accepts version strings in the format:
     * <MAJOR>.<MINOR>.<PATCH>[.<SUB_PATCH>]
     * 1      .2      .3
     * 1      .2      .3       .4
     * 11     .22     .33      .44
     *
     * @param version String representation of version.
     *                Can be 3 digit groups or 4 digit groups.
     */
    public Version(String version) {
        this.string = version;
        this.isThreeDigit = true;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(version);
        if(matcher.find()) {
            this.major = Integer.parseInt(matcher.group());
        }
        if(matcher.find()) {
            this.minor = Integer.parseInt(matcher.group());
        }
        if(matcher.find()) {
            this.patch = Integer.parseInt(matcher.group());
        }
        if(matcher.find()) {
            this.isThreeDigit = false;
            this.subPatch = Integer.parseInt(matcher.group());
        }
    }

    /**
     * This method is used to compare 2 versions.
     *
     * @param o The object to compare this object with.
     * @return The outcome of the comparison.
     */
    @Override
    public int compareTo(@NotNull Version o) {
        if(this.getMajor() > o.getMajor()) {
            return 1;
        } else if(this.getMajor() < o.getMajor()) {
            return -1;
        }

        if(this.getMinor() > o.getMinor()) {
            return 1;
        } else if(this.getMinor() < o.getMinor()) {
            return -1;
        }

        if(this.getPatch() > o.getPatch()) {
            return 1;
        } else if(this.getPatch() < o.getPatch()) {
            return -1;
        }

        if(this.isThreeDigit() && !o.isThreeDigit()) {
            return -1;
        }
        if(!this.isThreeDigit() && o.isThreeDigit()) {
            return 1;
        }
        if(!this.isThreeDigit() && !o.isThreeDigit()) {
            if(this.getSubPatch() > o.getSubPatch()) {
                return 1;
            } else if(this.getSubPatch() < o.getSubPatch()) {
                return -1;
            }
        }

        // If both are 3 digits   -> 0
        // If both 4 digits are = -> 0
        return 0;
    }
}
