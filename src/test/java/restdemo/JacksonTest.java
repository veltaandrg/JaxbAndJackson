package restdemo;

import java.util.*;
import org.junit.*;
import com.fasterxml.jackson.databind.*;

public class JacksonTest {
    
    ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void testSerialization() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Soap", 3));
        products.add(new Product("Felt", 8));
        products.add(new Product("Guts", 5));
        String json;
        try {
            json = mapper.writeValueAsString(products);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertNotNull(json);
        System.out.println("Serialization result:");
        System.out.println(json);
    }
    
    @Test
    public void testDeserialization() throws Exception {
        String json = "[{'name':'Sugar','price':12},{'name':'Salt','price':5}]";
        json = json.replaceAll("'", "\"");
        Product[] products;
        products = mapper.readValue(json, Product[].class);
        System.out.println("Deserialization result:");
        System.out.println(Arrays.toString(products));
    }
    
}

