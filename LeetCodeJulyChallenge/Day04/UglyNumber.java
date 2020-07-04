class UglyNumber {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        
        // 1 is considered ugly number by default
        uglyNumbers[0] = 1;
        
        // Any number in the ugly number list will be multiplied by 2 to get the next multiple of two.
        // This way we will get 4, 6, 8, 10....
        int next_2_multiple = 2; int i2 = 1;     
        
        // We will get 6, 9, 12....
        int next_3_multiple = 3; int i3 = 1;
        
        // We will get 10, 15, 20, 25....
        int next_5_multiple = 5; int i5 = 1;
        
        for(int i = 1; i < n; i++) {
            uglyNumbers[i] = java.lang.Math.min(next_2_multiple, java.lang.Math.min(next_3_multiple, next_5_multiple));
            
            if(uglyNumbers[i] == next_2_multiple) next_2_multiple = uglyNumbers[i2++]*2;
            if(uglyNumbers[i] == next_3_multiple) next_3_multiple = uglyNumbers[i3++]*3;
            if(uglyNumbers[i] == next_5_multiple) next_5_multiple = uglyNumbers[i5++]*5;
        }
        
        return uglyNumbers[n-1];
    }

    public static void main(String args[]) 
    { 
        int n = 150; 
        UglyNumber obj = new UglyNumber(); 
        System.out.println(obj.nthUglyNumber(n)); 
    }
}
