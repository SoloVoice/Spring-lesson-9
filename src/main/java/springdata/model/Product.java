package springdata.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import springdata.dto.ProductDto;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private ProdCategory prodCategory;
    //И вот тут я затупил как передать в БД категорию для нового товара.
    //Вытащить могу, а вставить что-то никак. Пойду пересматривать курс.
    //Кроме этого момента оставльное работает.

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Product(ProductDto productDto) {
        this.title = productDto.getTitle();
        this.price = productDto.getPrice();
    }
}
