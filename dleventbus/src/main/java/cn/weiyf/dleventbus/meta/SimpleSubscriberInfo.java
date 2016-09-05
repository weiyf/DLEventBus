package cn.weiyf.dleventbus.meta;


import cn.weiyf.dleventbus.SubscriberMethod;

/**
 * Uses {@link SubscriberMethodInfo} objects to create {@link cn.weiyf.dleventbus.SubscriberMethod} objects on demand.
 */
public class SimpleSubscriberInfo extends AbstractSubscriberInfo {

    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class subscriberClass, boolean shouldCheckSuperclass, SubscriberMethodInfo[] methodInfos) {
        super(subscriberClass, null, shouldCheckSuperclass);
        this.methodInfos = methodInfos;
    }

    @Override
    public synchronized SubscriberMethod[] getSubscriberMethods() {
        int length = methodInfos.length;
        SubscriberMethod[] methods = new SubscriberMethod[length];
        for (int i = 0; i < length; i++) {
            SubscriberMethodInfo info = methodInfos[i];
            methods[i] = createSubscriberMethod(info.methodName, info.eventType, info.threadMode,
                  info.tag ,info.priority, info.sticky);
        }
        return methods;
    }
}