

interface Pci 
{
    public abstract void open();
    public abstract void close();

}


class NetCard implements Pci
{
    @Override
    public void open() {
        System.out.println("net card open");
    }

    @Override
    public void close() {
        System.out.println("net card close");
    }
}


class SoundCard implements Pci
{
    @Override
    public void open() {
        System.out.println("sound card open");
    }

    @Override
    public void close() {
        System.out.println("sound card close");
    }
}


class MainBoard
{
    public void run()
    {
        System.out.println("main board runing...");
    }

    public void usePCI(Pci p) {
        if(p != null)
        {
            p.open();
            p.close();
        }
    }
}

class DuotaiDemo2
{
    public static void main(String[] args) {
        MainBoard mb = new MainBoard();
        mb.run();
        mb.usePCI(null);
        mb.usePCI(new NetCard());
        mb.usePCI(new SoundCard());

    }
}