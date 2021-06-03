package springdata.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "prod_category")
public class ProdCategory {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String category;
}
