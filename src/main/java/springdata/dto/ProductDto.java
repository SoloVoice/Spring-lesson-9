package springdata.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import springdata.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private int price;
    private String category;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.price = p.getPrice();
        this.category = p.getProdCategory().getCategory();
    }
}
