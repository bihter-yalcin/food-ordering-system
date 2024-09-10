package com.food.ordering.system.domain.event;

public final class EmptyEvent implements DomainEvent<Void>{
    public static final EmptyEvent INSTANCE = new EmptyEvent();

    //TODO MARKER CLASS ????
    private EmptyEvent(){}
    @Override
    public void fire() {

    }
}
