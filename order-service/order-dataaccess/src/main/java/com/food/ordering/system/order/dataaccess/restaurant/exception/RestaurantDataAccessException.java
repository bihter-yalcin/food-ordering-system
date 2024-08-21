package com.food.ordering.system.order.dataaccess.restaurant.exception;

import com.food.ordering.system.domain.exception.DomainException;

public class RestaurantDataAccessException extends RuntimeException {
    public RestaurantDataAccessException(String message) {
        super(message);
    }
}
