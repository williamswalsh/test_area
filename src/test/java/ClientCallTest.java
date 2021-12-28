import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ClientCallTest {

    RestTemplate rest;

    @Before
    public void init() {
        rest = new RestTemplate();
    }

    @Test
    public void makeGetCallForObject() {
        int ingredientId = 9;
        Ingredient object =  rest.getForObject("http://localhost:8080/api/ingredient/{id}", Ingredient.class, ingredientId);
        System.out.println(object);
    }

    @Test
    public void makeGetCallForEntity() {
        int ingredientId = 9;
        ResponseEntity<Ingredient> response =  rest.getForEntity("http://localhost:8080/api/ingredient/{id}", Ingredient.class, ingredientId);
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }

    @Test
    public void makeGetCallForEntitySampleRestApi() {
        int userId = 2;
        ResponseEntity<User> response =  rest.getForEntity("https://reqres.in/api/users/{id}", User.class, userId);
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }

    @Test
    public void makeGetCallForEntitySampleRestApiButWithHashMap() {
        int userId = 2;
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", String.valueOf(userId));

        ResponseEntity<User> response =  rest.getForEntity("https://reqres.in/api/users/{id}", User.class, urlVariables);
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }

    @Test
    public void makePutCall() {

        int titleId = 2;
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", String.valueOf(titleId));

        Title sample = new Title("Will", "Senior Software Engineer");
        rest.put("https://reqres.in/api/users/{id}", sample, titleId);

        // System.out.println(response.getStatusCode());
        // System.out.println(response.getStatusCodeValue());
        // System.out.println(response.getHeaders());
        // System.out.println(response.getBody());
    }


}
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Title {
    String name;
    String job;
}
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Ingredient {
    String name;
}
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class User {
    Data data;
    Support support;
}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class Data {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class Support {
    public String url;
    public String text;
}
