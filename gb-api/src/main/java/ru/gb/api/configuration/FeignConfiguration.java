package ru.gb.api.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.gb.api.category.api.CategoryGateway;
import ru.gb.api.manufacturer.api.ManufacturerGateway;
import ru.gb.api.order.api.OrderGateway;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.security.api.AuthenticationUserGateway;
import ru.gb.api.security.api.UserGateway;


@Configuration
@EnableConfigurationProperties(GbApiProperties.class)
@RequiredArgsConstructor
@Import(value = {FeignClientFactory.class})
public class FeignConfiguration {

    private final GbApiProperties gbApiProperties;
    private final FeignClientFactory feignClientFactory;

    @Bean
    public ManufacturerGateway manufacturerGateway() {
        return feignClientFactory.newFeignClient(ManufacturerGateway.class, "http://localhost:8081/api/v1/manufacturer");
    }

    @Bean
    public CategoryGateway categoryGateway() {
        return feignClientFactory.newFeignClient(CategoryGateway.class, "http://localhost:8081/api/v1/category");
    }

    @Bean
    public ProductGateway productGateway() {
        return feignClientFactory.newFeignClient(ProductGateway.class, "http://localhost:8081/api/v1/product");
    }

    @Bean
    public OrderGateway orderGateway() {
        return feignClientFactory.newFeignClient(OrderGateway.class, "http://localhost:8081/api/v1/order");
    }


    @Bean
    public UserGateway userGateway() {
        return feignClientFactory.newFeignClient(UserGateway.class, gbApiProperties.getEndpoint().getUserUrl());
    }

    @Bean
    public AuthenticationUserGateway AuthUserGateway() {
        return feignClientFactory.newFeignClient(AuthenticationUserGateway.class, gbApiProperties.getEndpoint().getAuthUserUrl());
    }
}
