package cn.weiyf.dleventbus.meta;


import cn.weiyf.dleventbus.ThreadMode;

public class SubscriberMethodInfo {
    final String methodName;
    final ThreadMode threadMode;
    final Class<?> eventType;
    final int tag;
    final int priority;
    final boolean sticky;

    public SubscriberMethodInfo(String methodName, Class<?> eventType, ThreadMode threadMode,
                                int tag, int priority, boolean sticky) {
        this.methodName = methodName;
        this.threadMode = threadMode;
        this.eventType = eventType;
        this.tag = tag;
        this.priority = priority;
        this.sticky = sticky;
    }

    public SubscriberMethodInfo(String methodName, Class<?> eventType, int tag) {
        this(methodName, eventType, ThreadMode.POSTING, tag, 0, false);
    }

    public SubscriberMethodInfo(String methodName, Class<?> eventType, ThreadMode threadMode, int tag) {
        this(methodName, eventType, threadMode, tag, 0, false);
    }

}