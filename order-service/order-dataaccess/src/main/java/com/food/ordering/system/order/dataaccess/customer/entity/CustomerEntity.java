package com.food.ordering.system.order.dataaccess.customer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "customers")
public class CustomerEntity {
    @Id
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;

}
