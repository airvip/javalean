import java.awt.*;
import java.awt.event.*;


public class MyMenuDemo
{
    private Frame f;
    private MenuBar mb;
    private Menu m,subMenu;
    private MenuItem closeItem,subItem;

    MyMenuDemo()
    {
        init();
    }

    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,200,600,400);
        f.setLayout(new FlowLayout());


        mb = new MenuBar();
        m = new Menu("File");

        subMenu = new Menu("next");
        subItem = new MenuItem("exit");

        closeItem = new MenuItem("exit");

        
        m.add(subMenu);
        subMenu.add(subItem);

        m.add(closeItem);

        mb.add(m);

        f.setMenuBar(mb);

        myEvent();
        f.setVisible(true);
    }


    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        closeItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

    }



    public static void main(String[] args) {
        new MyMenuDemo();
    }
}