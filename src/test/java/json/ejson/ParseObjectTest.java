package json.ejson;

import io.ebean.text.json.EJson;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class ParseObjectTest {


    @Test
    public void parseObject() throws IOException {
        String rawJson = "{\"name\":\"rob doc\", \"something\":{\"inner\":\"so\", \"other\":34},\"age\":24, \"title\":\"Some title\"}";

        Data data = createObject(rawJson);
    }
    private Data createObject(String rawJson) throws IOException {
        Map<String, Object> content = EJson.parseObject(rawJson);
        return new Data(content.get("name").toString(), content.get("something").toString(), content.get("age").toString(), content.get("title").toString());
    }
}
class Data {

    String name;
    Something something;
    int age;
    String title;

    Data(String name, String something, String age, String title) throws IOException {
        this.name = name;
        this.something = new Something(something);
        this.age = Integer.parseInt(age);
        this.title = title;

    }
}
class Something {

    String inner;
    String other;

    public Something(String something) throws IOException {

    }
}
