/**
 * 单例设计模式
 * 
 * // 饿汉式
 * 
 * class Single
 * {
 *     private static final Single s = new Single();
 *     private Single(){}
 *     public static Single getInstance()
 *     {
 *         return s;
 *     }
 * 
 * }
 * 
 */


 class Single 
 {
     private static final Single s = null;
     private Single(){}
     public static synchronized Single getInstance()
     {
         if(s == null)
         {
            s = new Single();
         }
        return s;
     }
 }


 // 懒汉式
 class SingleDemo 
 {
     public static void main(String[] args) {
         
     }
 }