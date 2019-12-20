import java.awt.*;
import java.awt.event.*;


public class MouseAndKeyEvent
{
    private Frame f;
    private Button b;
    private TextField tf;

    MouseAndKeyEvent()
    {
        init();

    }

    public void init()
    {
        f = new Frame("my Frame");
        f.setBounds(500, 200, 800, 600);
        f.setLayout(new FlowLayout());

        tf = new TextField(20);
        f.add(tf);

        b = new Button("My Button");
        f.add(b);

        myEvent();
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

        // 给button添加一个键盘事件
        b.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 27)
                    System.exit(0);
                else
                    System.out.println(e.getKeyChar() + "---" + e.getKeyCode());
            }
        });

        tf.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int code = e.getKeyCode();
                if(!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9))
                {
                    System.out.println(code + " is 非法的");
                    e.consume();
                }
                    
            }
        });

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("button active");
            }
        });

        b.addMouseListener(new MouseAdapter(){
            private int n = 1;
            public void mouseEntered(MouseEvent e)
            {
                System.out.println("button enter "+ (n++));
            }

            public void mouseClicked(MouseEvent e)
            {
                if(e.getClickCount() == 2)
                    System.out.println("double click");
                else
                    System.out.println("button enter "+ (--n));
            }
        });

        
    }


    public static void main(String[] args) {
        new MouseAndKeyEvent();
    }
}