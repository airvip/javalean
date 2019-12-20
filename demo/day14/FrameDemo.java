import java.awt.*;
import java.awt.event.*;

public class FrameDemo
{

    private Frame f;
    private Button b;

    FrameDemo()
    {
        init();

    }

    public void init()
    {
        f = new Frame("my Frame");
        // 对frame进行设置
        f.setBounds(500, 200, 800, 600);
        f.setLayout(new FlowLayout());

        b = new Button("My Button");
        // 将组件添加到frame中
        f.add(b);

        // 加载一下窗体上事件
        myEvent();

        // 显示窗体
        f.setVisible(true);
    }

    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        // 让按钮具备退出程序的功能
        /**
         * 按钮就是事件源
         * 那么选择哪个监听器呢？
         * 通过关闭窗体示例了解到，想要知道哪个组件具备什么特有监听器，需要查看该组件对象的功能
         * 通过查阅button的描述，发现按钮支持一个特有监听 addActionListener
         */
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("button");
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        new FrameDemo();
    }
}