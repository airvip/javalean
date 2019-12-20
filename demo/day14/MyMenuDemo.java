import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MyMenuDemo
{
    private Frame f;
    private MenuBar mb;
    private TextArea ta;
    private Menu m,subMenu;
    private MenuItem openItem,saveItem,closeItem,subItem;
    private FileDialog openDia, saveDia;
    private File file;

    MyMenuDemo()
    {
        init();
    }

    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,200,600,400);
        // f.setLayout(new FlowLayout());


        mb = new MenuBar();
        m = new Menu("File");

        subMenu = new Menu("next");
        subItem = new MenuItem("exit");

        openItem = new MenuItem("open");
        saveItem = new MenuItem("save");
        closeItem = new MenuItem("exit");

        
        m.add(subMenu);
        subMenu.add(subItem);

        m.add(openItem);
        m.add(saveItem);
        m.add(closeItem);

        mb.add(m);

        f.setMenuBar(mb);

        ta = new TextArea();
        f.add(ta);

        openDia = new FileDialog(f, "open", FileDialog.LOAD);
        saveDia = new FileDialog(f, "save", FileDialog.SAVE);

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

        openItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                openDia.setVisible(true);
                String dirPath = openDia.getDirectory();
                String fileName = openDia.getFile();
                if(dirPath == null || fileName == null)
                {
                    openDia.setVisible(false);
                    return ;
                }
                ta.setText("");
                File file = new File(dirPath, fileName);
                try
                {
                    BufferedReader bufr = new BufferedReader(new FileReader(file));
                    String line = null;
                    while((line = bufr.readLine()) != null)
                    {
                        ta.append(line + System.lineSeparator());
                    }
                    bufr.close();
                }
                catch(IOException ex)
                {
                    throw new RuntimeException("open read error");
                }

            }
        });

        saveItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(file == null)
                {
                    saveDia.setVisible(true);
                    String dirPath = saveDia.getDirectory();
                    String fileName = saveDia.getFile();
                    if(dirPath == null || fileName == null)
                    {
                        saveDia.setVisible(false);
                        return ;
                    }
                    file = new File(dirPath, fileName);
                }

                try
                {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));

                    String text = ta.getText();
                    bufw.write(text);
                    bufw.flush();
                    bufw.close();

                }
                catch(IOException ex)
                {
                    throw new RuntimeException("save write error");
                }
                file = null;
                
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


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}