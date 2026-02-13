package test.automation.data.models.response;

import lombok.Data;
import java.util.List;

@Data
public class SearchProductResponse {

    private int responseCode;
    private List<ProductsResponse.Product> products;
}