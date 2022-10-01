public class Conversion {
    boolean minus;
    public void Convers(int originalNumSys, int finalNumSys, int number, int[] arr, boolean minus){
        this.minus = minus;
        int temp = 0, j = arr.length - 1;
        String result = "";
        if(originalNumSys != 10){
            for(int i = 0; i < arr.length; i++){
                temp = temp + arr[i] * (int)Math.pow(originalNumSys, j);
                j--;
            }
        }
        else temp = Math.abs(number);

        while(temp > 0){
            result += String.valueOf(temp % finalNumSys);
            temp /= finalNumSys;
        }
        if(finalNumSys == 2) strightCode(result);
        if (minus) result += "-";
        result = reverse(result);
        System.out.println("Результат: " + result);
    }

    public void strightCode(String scRez){
        int plusFour = 0;
        while(plusFour <= scRez.length()) plusFour += 4;
        int ost = plusFour % scRez.length();
        if(minus){
            for(int i = 0; i < ost - 1; i++) scRez += "0";
            scRez += "1";
        }
        else for(int i = 0; i < ost; i++) scRez += "0";
        scRez = reverse(scRez);
        System.out.println("Результат(ПК): " + scRez);
    }
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
