package com.kvvssut.pnlcalc.bean;

public class MarketEvent {

    private EventType type;
    private Object payload;

    public MarketEvent(EventType type, Object payload) {
        this.type = type;
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
