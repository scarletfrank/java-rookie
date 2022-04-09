package pro.scarlet;

interface IMessage{
    public void send(String str);
}

interface InnerAnnoymous{
    public void send(String str);
    public static InnerAnnoymous getInstance(){
        return new InnerAnnoymous() {
            public void send(String str){
                System.out.println(str);
            }  
        };
    }
}
public class InnerClassDemo {
    public static void main(String args[]){
        IMessage msg = new IMessage() {
            public void send(String str){
                System.out.println(str);
            }
        };
        msg.send("scarletfrank.pro");
        InnerAnnoymous.getInstance().send("scarletfrank.pro");
    }
}
