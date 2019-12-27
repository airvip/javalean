import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的第四个功能
 * 4. 获取：将字符串中的符合规划的子串取出
 * 
 * 操作步骤
 * 1.将正则表达式封装成对象
 * 2.让正则对象和要操作的字符串相关联
 * 3.关联后，获取正则匹配引擎
 * 4.通过引擎对符合规则的子串进行操作，比如取出
 * 
 */

 class RegexDemo2
 {
     public static void main(String[] args) {
         
        // getDemo("0980062449", "^[1-9]\\d{4,14}");
        getDemo("airvip is a boy, hello boy!", "\\b\\w{3}\\b");

     }

     public static void getDemo(String str, String reg)
     {
         // 将正则表达式封装成对象
         Pattern p = Pattern.compile(reg);
         // 让正则对象和要操作的字符串相关联,获取匹配器对象
         Matcher m =  p.matcher(str);
         
        //  sop(m.matches());
        /* boolean flag =  m.find();
        sop(flag);

        if(flag)
            sop(m.group()); */

        while(m.find())
        {
            sop(m.group());
            sop(m.start() + "---" + m.end());
        }
            




     }


     
      public static void sop(Object obj)
      {
            System.out.println(obj);
      }
 }