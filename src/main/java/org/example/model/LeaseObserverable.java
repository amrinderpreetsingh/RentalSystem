package org.example.model;

public interface LeaseObserverable {
    public abstract void addSubscriber(Tenant tenant);
    public abstract void UnSubscribe(Tenant tenant);
    public abstract void notifySubscriber();
}
