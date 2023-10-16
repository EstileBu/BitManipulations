package test;

public class EstiTest {
    public static int EX1(int m, int n, int i, int j){
        //This Exercise gets two numbers and adds m (just between the indexes i and j in binary base) to n
        if( i> j || i < 0 || j > 32)
            return 0;
        String m2 = binaryCalculate(m);
        char[] numbers = m2.toCharArray();
        int result = 0;
        for(int index=numbers.length -1; index>=0 ; index--)
            // this if, is to check: if the bit is '1', and if the bit is the range between i and j.
            // and if so, we will calculate its value, in order add the sum to n.
            if(numbers[index]=='1' && index>=i && index<= j)
                // here we take 2 to the power of (numbers.length-index-1), we
                // actually moving in the opposite direction.
                // in binary base we are moving from right to left
                // but java, is moving from left to right (in an array or loop)
                result+= Math.pow(2, (numbers.length-index-1));
        n = n + result;
        return n;
    }

    public static String binaryCalculate(int num){
        // This is a method to convert a integer number to a string representing the number in a binary base.
        String result = Integer.toBinaryString(num);
        return result;
    }

    public static int integerCalculate(String num){
        char[] numbers = num.toCharArray();
        int result = 0;
        for(int i=numbers.length -1; i>=0 ; i--)
            if(numbers[i]=='1')
                result+= Math.pow(2, (numbers.length-i-1));
        return result;

    }

    public static void main(String []args){
//        String binary_num = binaryCalculate(65);
//        System.out.println(binary_num);
//        System.out.println(integerCalculate(binary_num));
        System.out.println(EX1(70, 20, 4, 5));

    }


}
