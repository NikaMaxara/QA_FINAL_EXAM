package test.automation.data.models.response;

import lombok.Data;
import java.util.List;

@Data
public class ProductsResponse {

    private int responseCode;
    private List<Product> products;

    @Data
    public static class Product {
        private int id;
        private String name;
        private String price;
        private String brand;
        private Category category;
    }

    @Data
    public static class Category {
        private UserType usertype;
        private String category;
    }

    @Data
    public static class UserType {
        private String usertype;
    }
}