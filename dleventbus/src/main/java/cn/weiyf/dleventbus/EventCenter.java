package cn.weiyf.dleventbus;

public class EventCenter<T> {

    /**
     * reserved data
     */
    private T data;

    /**
     * this code distinguish between different events
     */
    private int eventCode = -1;

    public EventCenter(int eventCode) {
        this(eventCode, null);
    }

    public EventCenter(int eventCode, T data) {
        this.eventCode = eventCode;
        this.data = data;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "EventCenter{" +
                "data=" + data +
                ", eventCode=" + eventCode +
                '}';
    }
}
