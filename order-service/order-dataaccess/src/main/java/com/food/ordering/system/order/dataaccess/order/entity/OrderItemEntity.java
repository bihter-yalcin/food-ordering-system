package com.food.ordering.system.order.dataaccess.order.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
@Entity
@IdClass(OrderItemEntityId.class)
public class OrderItemEntity {
    @Id
    private Long Id;

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

    private UUID productId;
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(Id, that.Id) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, order);
    }

    private Integer quantity;
    private BigDecimal subTotal;

    //To provide uniqueness to this entity we OrderEntity and id should be together.
    // For multiColumn primary key, OrderItemIdEntity Created


}
