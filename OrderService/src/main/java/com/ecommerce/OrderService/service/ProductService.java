package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.dto.request.CreateProductRequest;
import com.ecommerce.OrderService.dto.request.UpdateProductRequest;
import com.ecommerce.OrderService.dto.response.ProductResponse;
import com.ecommerce.OrderService.model.Product;
import com.ecommerce.OrderService.repository.ProductRepository;
import com.ecommerce.OrderService.service.abstraction.GenericService;
import com.ecommerce.OrderService.service.helper.ProductHelper;
import com.ecommerce.OrderService.utils.enums.SortingOrder;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService extends GenericService<Product, Long> {

    @Autowired
    private ProductHelper helper;

    public ProductResponse creaProdotto(CreateProductRequest request) {
        return helper.buildResponse(repository.save(helper.buildEntityFromRequest(request)));
    }

    public ProductResponse leggiProdotto(Long idProdotto) {
        return helper.buildResponse(super.read(idProdotto));
    }

    public List<ProductResponse> listaProdotti() {
        return super.findAll().stream()
                .map(product -> helper.buildResponse(product))
                .collect(Collectors.toList());
    }

    public Page<ProductResponse> listaProdottiPage(Integer pageNumber, Integer pageSize, String sortBy, SortingOrder sortingOrder, String sortingFilter) {
        Pageable pageable;
        final String sortingFilterLower = Strings.isEmpty(sortingFilter) ? null : sortingFilter.toLowerCase();

        if (sortingOrder.equals(SortingOrder.ASC)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }

        List<ProductResponse> listProductResponse = ((ProductRepository)repository).findAll(pageable)
                .stream()
                .filter(product -> Strings.isEmpty(sortingFilterLower) || product.getProductName().toLowerCase().contains(sortingFilterLower) || product.getProductDesq().toLowerCase().contains(sortingFilterLower))
                .map(product -> helper.buildResponse(product))
                .toList();

        return new PageImpl<ProductResponse>(listProductResponse, pageable, repository.findAll().size());
    }

    public ProductResponse modificaProdotto(UpdateProductRequest request) {
        Product product = helper.buildEntityFromRequest(request);
        product.setIdProduct(request.getIdProduct());
        return helper.buildResponse(super.update(product));
    }

    public String eliminaProdotto(Long idProdotto) {
        if(Objects.isNull(super.read(idProdotto)) || Objects.isNull(idProdotto)) {
            return "PRODOTTO_NON_TROVATO_CON_ID: "+idProdotto;
        }

        super.deleteById(idProdotto);
        return "PRODOTTO_ELIMINATO";
    }
}
