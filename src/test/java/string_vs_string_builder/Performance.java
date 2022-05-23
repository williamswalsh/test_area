package string_vs_string_builder;

import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class Performance {

    String ROOT_FOLDER = "Manuals";

    @Test
    public void testCreateResourcePath() {

    }

    public String createResourcePath(String language, String version, String manualPrefix, String manualTypeFolder) {
        return new StringBuilder()
                .append(ROOT_FOLDER)
                .append("/" + language)
                .append("/" + manualTypeFolder)
                .append("/" + manualPrefix + " " + language + " v" + version
                        + ".pdf")
                .toString();
    }

    public String createPath(String language, String version, String manualPrefix, String manualTypeFolder) {
        return ROOT_FOLDER + "/" + language + "/" + manualTypeFolder + "/" + manualPrefix + " " + language + " v"
                + version
                + ".pdf";
    }

    @Test
    public void timer() {
        long startTime, endTime, duration, avg;
        long noOfRuns = 1000000;

        startTime = System.nanoTime();
        for (int i = 0; i < noOfRuns; i++) {
            // get_namespace_valid_letter_type();
            createPath("en", "2.1.6", "Org Portal Guide", "org_portal");
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        log.info("startTime: " + startTime);
        log.info("endTime: "+ endTime);
        log.info("duration: "+ duration);
        log.info("noOfRuns: "+ noOfRuns);
        avg = duration/noOfRuns;
        log.info("Average test duration across " + noOfRuns + " iterations: " + avg + " nanoseconds");
    }

}
