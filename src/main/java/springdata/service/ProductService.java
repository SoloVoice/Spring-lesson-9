package springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.dto.ProductDto;
import springdata.model.Product;
import springdata.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        List<ProductDto> temp = new ArrayList<>();
        for (Product p: productRepository.findAll()) {
            temp.add(new ProductDto(p));
        }
        return temp;
    }

    public ProductDto getProductById(Long id) {
        return new ProductDto(productRepository.findById(id).orElse(new Product()));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void addProduct (ProductDto productDto) {
        productRepository.save(new Product(productDto));
    }

}
