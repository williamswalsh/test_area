package json;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import static org.junit.Assert.assertTrue;

public class JsonObjectTest {

    private static String UPLOAD_ONLY_JSON = "metadata_template.json";
    @Test
    public void test() {
        JSONObject metadata = new JSONObject(metadata());
        addMetadataUpdate(metadata);
        assertTrue((boolean)(metadata.getJSONObject("settings").get("metadata_update")));
    }

    private void addMetadataUpdate(JSONObject jsonObject) {
        jsonObject.getJSONObject("settings").put("metadata_update", true);
    }

    public String metadata() {
        String jsonStr = retrieveTemplate(UPLOAD_ONLY_JSON);
        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONObject user = jsonObject.getJSONObject("user");
        JSONObject initialLogin = user.getJSONObject("initial_login");

        JSONObject document = jsonObject.getJSONObject("document");
        JSONArray customFields = document.getJSONArray("custom_fields");
        return jsonStr;
    }

    private String retrieveTemplate(final String resourceName) {
        String result = "";
        try {
            result = getJsonFromResource(resourceName);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @SneakyThrows public static String getJsonFromResource(final String resourceName)
            throws IOException, ParseException {

        final JSONObject googleJsonObject;
        final InputStream resourceInputStream
                = new ClassPathResource(resourceName).getInputStream();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int length; (length = resourceInputStream.read(buffer)) != -1; ) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }
}
