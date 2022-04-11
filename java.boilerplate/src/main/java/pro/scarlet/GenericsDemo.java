package pro.scarlet;

interface IMessage {
    public void send(String str);
}

class MessageImpl implements IMessage {
    public void send(String str) {
        System.out.println("message sending: " + str);
    }
}

class Factory {
    public static <T> T getInstance(String className, T t){
        if ("messageImpl".equalsIgnoreCase(className)){
            return (T) new MessageImpl();
        }
        return null;
    }
}

public class GenericsDemo {
    Class<IMessage> msg = Factory.getInstance("messageImpl", IMessage.class);
}
