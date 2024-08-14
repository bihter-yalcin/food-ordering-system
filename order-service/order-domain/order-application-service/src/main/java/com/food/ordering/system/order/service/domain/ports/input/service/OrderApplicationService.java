package com.food.ordering.system.order.service.domain.ports.input.service;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;
/***This input port used by client ex. Rest api calls**/
public interface OrderApplicationService {
/***To enable validation annotations use @Valid annotation**/
     CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
     TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
