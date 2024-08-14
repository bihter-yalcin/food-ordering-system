package com.food.ordering.system.domain.event.publisher;

import com.food.ordering.system.domain.event.DomainEvent;

//TODO LOOK FOR T GENERICS
public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
