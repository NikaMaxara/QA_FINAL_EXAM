package test.automation.data.models.response;

import lombok.Data;
import java.util.List;

@Data
public class BrandsResponse {

    private int responseCode;
    private List<Brand> brands;

    @Data
    public static class Brand {
        private int id;
        private String brand;
    }
}
