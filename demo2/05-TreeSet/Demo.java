import java.util.*;


public class Demo {
    public static void main(String[] args) {
        List<Message> received = new ArrayList<>();
        received.add(new Message(1, "Hello!"));
        received.add(new Message(2, "发工资了吗？"));
        received.add(new Message(2, "发工资了吗？"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(4, "Bye"));

        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> se= new TreeSet<>();
        for(Message m:received){ se.add(m); }

        return new ArrayList<Message>(se);
    }
}

class Message implements Comparable<Object> {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }


    @Override
    public int compareTo(Object o) {
        Message m = (Message) o;
        if (this.sequence==m.sequence) {
            return 0;
        }
        return this.sequence>m.sequence? 1: -1;
    }
}