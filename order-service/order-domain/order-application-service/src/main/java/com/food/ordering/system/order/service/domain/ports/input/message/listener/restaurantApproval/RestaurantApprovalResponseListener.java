package com.food.ordering.system.order.service.domain.ports.input.message.listener.restaurantApproval;

import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse;

/***This input port is message listener, they triggered by events not by clients**/

public interface RestaurantApprovalResponseListener {
    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
