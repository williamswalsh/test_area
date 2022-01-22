package string_testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManualResource {
    private String resourcePath;

    ManualResource(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    String getResourcePath() {
        return resourcePath;
    }

    Version getVersion() {
        return new Version(this.getVersionStr());
    }

    private String getVersionStr() {
        Pattern pattern = Pattern.compile("\\d+.\\d+.\\d+(.\\d+)?");
        Matcher matcher = pattern.matcher(this.resourcePath);
        if(matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    String getLanguage() {
        return this.resourcePath.split("/")[1];
    }
}
