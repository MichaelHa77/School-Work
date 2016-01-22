
class Conversion {
    public static void main(String[] args) {
        //Testing stringToBitSeq:
        String userID = "moLLY1";
        String bae[] = new String[36];
        String binarys[] = new String[5]; 
       
        bae = stringToBitSeq(userID);
        for(int i = 0; i < 36; i++){
            System.out.println("bae[" + i + "] = " + bae[i]);
        }
        for(int i = 0; i < 36; i++){
            System.out.print(bae[i]);
        }
		System.out.println();

        //Testing BitseqToDigitseq:
        int encrypted [] = new int[9];
        encrypted = BitseqToDigitseq(stringToBitSeq(userID),4);

        for(int i = 0; i < 9; i++){
            System.out.println("encrypted[" + i + "] = " + encrypted[i]);
        }
    }

    public static String[] stringToBitSeq(String s) {
        char[] temp = s.toCharArray();
        int[] asciiValue = new int[temp.length];
        int[] returnArray = new int[temp.length];
        String [] binaryString = new String[6];

        for(int i = (temp.length - 1); i >= 0; i--) {
            asciiValue[temp.length - i - 1] = (int)temp[i];
        }

        for(int i = 0; i < temp.length; i++) {
            if(asciiValue[i] > 47 && asciiValue[i] < 58) {
                returnArray[i] = asciiValue[i] - 48;
            } else if (asciiValue[i] > 96 && asciiValue[i] < 123) { //lower case letters
                returnArray[i] = asciiValue[i] - 87;
            } else if (asciiValue[i] > 64 && asciiValue[i] < 91) {  //upper case letters
                returnArray[i] = asciiValue[i] - 29;
            }
        }

        int yoga = returnArray.length;
        String bob[] = new String[yoga * 6];
        int z = 0;

        for(int a = 0; a < bob.length; a=a+6){
            int c = returnArray[z];
            binaryString = NumToBitseq(c);

            for(int j = 0; j < 6; j++) {
                bob[j+a] = binaryString[j];             
            }
            z++;
        }
        return bob; 
    }

    public static int[] BitseqToDigitseq(String[] bs, int k){
        int remZero;
        int m = bs.length / k;
        int[] a = new int[m];


        //initializing variables
        String d = "";
        int c = 1;
        int n = 0;

        String[] f = new String[m];
        String fourBits = "";

        for(int i = 0; i < m; i++) {
            for(int j = i * k; j < k * (i + 1); j++) {
                int temp25 = bs.length - 1 - j;
                fourBits = fourBits + bs[temp25];
                f[m - 1 - i] = fourBits;
            }
            fourBits = "";
        }

        for(int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(f[i], 2);
        }
        return a;
    }

    //  BigInt BitseqToBigNum(int[] bs, int k) {

    //  }

    public static String [] NumToBitseq(int n){

        String binary[] = new String[96];
        int index = 0;
        int count = 6;
        int remZero;
        while(n > 0){
            int a = n % 2;
            binary[index] = Integer.toString(a);
            n = n/2;
            index++;
        }

        String binary2[] = new String[index];

        for(int i = 0; i < binary2.length; i++) {
            binary2[i] = binary[i];
        }

        //check to see if the length of the char array of 0's and 1's is a number divisible by k
        if(binary2.length != count) {   //if remainder not 0, add additional bits so it can be even
           remZero = count - binary2.length;
        } else {
            remZero = 0;
        }

        //temp array that will include all necessary bits (including zeros if needed)
        String[] temp = new String[binary2.length + remZero];

        for(int i = 0; i < temp.length; i++) {

            if(i < binary2.length) {
                temp[i] = binary2[i]; 
            } else {
                temp[i] = "0"; 
            }           
        }
        return temp;
    }
}
