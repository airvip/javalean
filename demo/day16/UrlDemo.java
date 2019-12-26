import java.net.*;

class UrlDemo
{
    public static void main(String[] args) throws MalformedURLException
    {
        // URL url = new URL("http://192.168.1.44:10001");
        URL url = new URL("https://www.php.net/manual/zh/install.windows.php");

        
        sop( "getProtocol() : " + url.getProtocol());
        sop( "getHost() : " + url.getHost());
        sop( "getPort() : " + url.getPort());
        sop( "getPath() : " + url.getPath());
        sop( "getFile() : " + url.getFile());
        sop( "getQuery() : " + url.getQuery());
    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}