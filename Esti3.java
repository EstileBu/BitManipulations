package test;

public class Esti3 {
    //Conversion


    public static int countSetBits(int n){ //this function count the set of bits.
        int count= 0;
        while (n != 0 ){ //stop condition
            count++;
            n &=(n-1); // this decrease will get us to the stop condition
        }
        return count;
    }



    public static int bitSwapRequired(int a, int b){
        return countSetBits(a^b);
    }



    public static String binaryCalculate(int num){
        // This is a method to convert a integer number to a string representing the number in a binary base.
        String result = Integer.toBinaryString(num);
        return result;
    }

    //Pairwise Swap

    public static int swapOddEvenBits(int x){
        int even_bits = x & 0xAAAAAAAA; // this is the way to count even bits
        int odd_bits = x & 0x55555555; // this is the way to count odd bits
        even_bits >>=1; // shifting all the even bits one place to the right.
        odd_bits <<= 1; //shifting all the odd bits one place to the left
        return (even_bits | odd_bits); // we return or, because it is possible that
        // did the same change to 2 neighbors bits, but actually we changed 2 bits.
    }

    //monochrome
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
        int start_offset = x1%8; //checking the 'offset', what is the remainder after the first full byte.
        int first_full_byte = x1/8;
        if (start_offset!=0){
            first_full_byte++; // we need to +1 to the first full byte in order to contain the reminder
        }
        int end_offset = x2 % 8;
        int last_full_byte = x2/8;
        if (end_offset != 7){
            last_full_byte--; // we need to -1 to the last full byte in order to not getting out of bound.
        }

        for(int b= first_full_byte ; b<= last_full_byte ; b++){
            //divide the width by 8, to get to the "begining" of the line, multiply by y, this is the height of the line
            // add the first full byte, then we "draw" it.
            screen[(width/8)*y +b] = (byte)0xFF; //the array is byte array, so we need to cast the bit to byte,
            // 00000000
            // 00000000
            // 01111100
            // 00000000
            // 00000000
            // 00000000
            // width = 8, x1 = 2, x2= 6, y = 4

        }
    }

    public static void main(String[]args){
        int a = 17; //        00010001
        int b = 16;//         00010000
        System.out.println(bitSwapRequired(a, b));

        int c = 8; //         00001000
        int d = 16;//         00010000
        System.out.println(bitSwapRequired(c, d));

        String c1 = binaryCalculate(c);
        String d1 = binaryCalculate(d);
        System.out.println(c1);
        int len1 = c1.length(); // defining the length of the binary number
        int index1 =0; // this index will be the index to 'cut' the trail of '0'
        int count1 =0;  //this counter is counting the amount of '0' in the tail
        for(int i = len1-1 ; i>= 0 ; i-- ){
            if(c1.charAt(i) == '0') //if there is a zero on the tail, we count it.
                count1++;
            else // it means we got to '1', therefor, the tail ended.
                index1 = count1;
        }
        int len2 = d1.length();
        int index2 = 0;
        int count2 =0;
        for(int i = len2-1 ; i>= 0 ; i-- ){
            if(d1.charAt(i) == '0')
                count2++;
            else
                index2 = count2;
        }
        int index = Math.min(index1, index2);
        c1.substring(len1-index);
        d1.substring(len2-index);
        // it is necessary to convert c1 and d1 into the integer form into c2 and d2.
        //c2 =
        //d2 =
        //int result = bitSwapRequired(int c2, int d2);
        // print result
        System.out.println("swap exercise");
        int x = 13; // 00001101
        System.out.println(swapOddEvenBits(x));
    }
}
