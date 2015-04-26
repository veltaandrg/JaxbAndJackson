package restdemo;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
import com.fasterxml.jackson.databind.*;

public class ProductHandler extends AbstractHandler {
    
    private ObjectMapper mapper = new ObjectMapper();
    
    private static Map<String, Product> products = new HashMap<>();
    
    public void handle(String target, Request baseReq,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        baseReq.setHandled(true);
        //response.getWriter().println("<h1>Hi, People</h1>");
        
        String result = null;
        String method = request.getMethod();
        String name = request.getParameter("name");
        try {
            switch (method) {
                case "GET":
                    if (name == null) {
                        result = listProducts();
                    } else {
                        result = showProduct(name);
                    }
                    break;
                case "POST":
                    result = addProduct(request.getReader());
                    break;
                case "DELETE":
                    result = deleteProduct(name);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        response.getWriter().print(result);
    }
    
    String listProducts() throws Exception {
        return mapper.writeValueAsString(products.keySet().toArray());
    }
    
    String addProduct(Reader reader) throws Exception {
        Product product = mapper.readValue(reader, Product.class);
        products.put(product.getName(), product);
        return "{\"ok\":true}";
    }
    
    String showProduct(String name) throws Exception {
        Product product = products.get(name);
        return mapper.writeValueAsString(product);
    }
    
    String deleteProduct(String name) {
        products.remove(name);
        return "{\"ok\":true}";
    }
}

