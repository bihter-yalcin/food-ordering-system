package com.foodordering.system.outbox;

public interface OutboxScheduler {

    void processOutboxMessage();
}
