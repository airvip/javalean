
/**
 * 正则表达式：符合一定规则的表达式。
 * 作用：用于专门操作字符串。
 * 特点：用于一些特定的符号来表示一些代码操作，这样就可以简化书写
 * 好处：可以简化对字符串的复杂操作
 * 弊端：符号定义越多，正则越长，阅读性越差
 * 
 * 具体操作功能：
 * 1. 匹配：String 类的 matches方法
 * 2. 切割：String 类的 split方法
 * 3. 替换：String 类的 replaceAll方法 
 * 
 */

 class RegexDemo
 {
     public static void main(String[] args) {
         checkQQ("980062449");

         splitAll("dajshjhhdaskkasdllas", "(\\w)\\1");


         replaceAllDemo("dajshjhhdaskkasdllas", "(\\w)\\1");

     }

     public static void replaceAllDemo(String str, String reg)
     {
         String s = str.replaceAll(reg, "airvip");
        sop(s);
     }

     public static void splitAll(String str, String reg)
     {
        String[] arr = str.split(reg);
        for(String v : arr)
        {
            sop(v);
        }
     }

     /**
      * 对QQ号进行校验 5-15 位，0不能开头，只能是数字
      */

      public static void checkQQ(String qq)
      {

        if(qq.matches("^[1-9]\\d{4,14}$"))
        {
            sop("qq is correct");
        }
        else 
        {
            sop("qq is error");
        }
        /* int len = qq.length();
        if(len < 5 || len > 15)
        {
            sop("length error");
            return ;
        }

        if(qq.startsWith("0"))
        {
            sop("qq can't startWith zero");
            return ;
        }

        char[] arr = qq.toCharArray();
        boolean tag = false;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < '0' || arr[i] > '9')
            {
                tag = true;
                break;
            }
        }
        if(tag)
        {
            sop("qq must is number");
            return ;
        }
            
        
        sop("qq is correct"); */
        
      }


      public static void sop(Object obj)
      {
            System.out.println(obj);
      }
 }