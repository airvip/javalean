abstract class TimeUse
{
    public final void getTime()
    {
        long start = System.currentTimeMillis();

        runcode();

        long end = System.currentTimeMillis();
        System.out.println("use time "+ (end-start)+"'");
    }

    public abstract void runcode();
}

class SubTime extends TimeUse
{
    public void runcode()
    {
        for(int i=0; i<4000; i++)
        {
            System.out.println(i);
        }
    }
}

class TemplateDemo
{
    public static void main(String[] args) {
        // TimeUse t = new TimeUse();
        SubTime t = new SubTime();
        t.runcode();
    }
}