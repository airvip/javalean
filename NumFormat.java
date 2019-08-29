class NumFormat
{
    public static void main(String[] args) {
        dec2bin(15);
        dec2bin(9);

        dec2hex(60);
        decToHex(-60);
    }


    // 十进制最大的整数 是 十六进制 8 位
    // 十进制最大的整数 是 二进制 32 位


    /**
     * 十进制转十六进制 （兼容正负数）
     * @param num
     */
    public static void decToHex(int num)
    {
        char[] arr={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] res = new char[8]; 
        int pos = res.length;
        
        while(num != 0)
        {
            int tmp = num & 15;
            // System.out.println(arr[tmp]);
            res[--pos] = arr[tmp];
            num = num >>> 4;
        }

        System.out.println(pos);

        for(int i=pos; i<res.length; i++){
            System.out.print(res[i]);
        }

        System.out.println();
    }

    /**
     * 十进制转十六进制(只能正数)
     * @param num
     */
    public static void dec2hex(int num)
    {
        StringBuffer s = new StringBuffer();
        
        while(num > 0){
            int tmp = num & 15;
            if(tmp>9)
                s.append((char)(tmp-10+'A'));
            else
                s.append(tmp);
            num = num >> 4;
        }
        System.out.println(s.reverse());
    }

    /**
     * 十进制转十六进制(只能正数)
     * @param num
     */
    public static void dec2bin(int num)
    {
        StringBuffer sb = new StringBuffer();

        while(num>0)
        {
            // System.out.print(num % 2);
            sb.append(num % 2);
            num = num >> 1;
        }

        System.out.println(sb.reverse());
    }
}