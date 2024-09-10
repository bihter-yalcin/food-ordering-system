package com.food.ordering.system.restaurant.service.domain.entity;
import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.ProductId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Product extends BaseEntity<ProductId>{
    private ProductId productId;
    private String name;
    private Money price;
    private final int quantity;
    private boolean available;

    public Product(int quantity) {
        this.quantity = quantity;
    }

    public void updateWithConfirmedNamePriceAndAvailability(String name, Money price, boolean available){
        this.name = name;
        this.price = price;
        this.available = available;
    }

    //TODO MAYBE BUILDER
}

