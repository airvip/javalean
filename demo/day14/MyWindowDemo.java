package mymenu;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;




public class MyWindowDemo
{

    private Frame f;
    private TextField tf;
    private Button bt;
    private TextArea ta;

    private Dialog d;
    private Label lab;
    private Button okB;

    MyWindowDemo()
    {
        init();
    }

    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,200,600,400);
        f.setLayout(new FlowLayout());

        tf = new TextField(30);
        bt = new Button("button");
        ta = new TextArea("输入有效信息", 10, 40, 0);

        d = new Dialog(f, "warning", true);
        d.setBounds(400, 200, 200, 150);
        d.setLayout(new FlowLayout());
        lab = new Label();
        // lab.setAlignment(Label.CENTER);
        okB = new Button("ok");

        d.add(lab);
        d.add(okB);

        f.add(tf);
        f.add(bt);
        f.add(ta);

        myEvent();
        f.setVisible(true);

    }

    public void myEvent()
    {

        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String dirPath = tf.getText();
                // ta.setText(dirPath);

                File dirs = new File(dirPath);
                if(dirs.exists() && dirs.isDirectory()){
                    ta.setText("");
                    String[] names = dirs.list();
                    for(String name:names)
                    {
                        ta.append(name + "\n\r");
                    }
                }
                else
                {
                    lab.setText("are you ok ?");
                    lab.setAlignment(Label.CENTER);
                    
                    d.setVisible(true);
                    
                }
                // tf.setText("");
            }
        });

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });


        
        okB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                d.setVisible(false);
            }
        });

        d.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                d.setVisible(false);
            }
        });


    }

    public static void main(String[] args)
    {
        new MyWindowDemo();
        // 打包成可执行文件  jar -cvfm my.jar 1.txt mymenu
        //  Main-Class: mymenu.MyMenuDemo
    }
}