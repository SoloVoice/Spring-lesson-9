package springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springdata.dto.ProductDto;
import springdata.model.Product;
import springdata.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductByID(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam(name = "id") Long id) {
        productService.deleteProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        return getAllProducts();
    }
}
