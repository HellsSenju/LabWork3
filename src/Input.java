import java.util.Scanner;
public class Input {
    Scanner scan = new Scanner(System.in);
    Conversion convers = new Conversion();
    public int originalNumSys;
    public int finalNumSys;
    public int number;
    public String numStr;
    public String cc11 = "-0123456789A";
    public String cc12 = "-0123456789AB";
    public String cc13 = "-0123456789ABC";
    public String cc14 = "-0123456789ABCD";
    public String cc15 = "-0123456789ABCDE";
    public String cc16 = "-0123456789ABCDEF";
    public void InputOrigin() {
        while (true) {
            System.out.print("Original CC: 2 - 16: -->");
            try {
                originalNumSys = scan.nextInt();
                if(originalNumSys >= 2 && originalNumSys <= 16) break;
                System.out.println("Error");
            } catch (Exception ex) {
                System.out.println();
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }
    public void InputFinal(){
        while(true){
            System.out.print("Final CC: 2 - 16: -->");
            try{
                finalNumSys = scan.nextInt();
                if(finalNumSys >= 2 && finalNumSys <= 16) break;
                System.out.println("Error");
            }catch (Exception ex){
                System.out.println();
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }
    public void InputNumber(){
        boolean minus = false;
        while(true){
            System.out.print("Number: -->");
            if(originalNumSys < 11){
                try{
                    number = scan.nextInt();
                    numStr = String.valueOf(Math.abs(number));
                    int[] arr = new int[numStr.length()];
                    if(number < 0) minus = true;
                    for(int i = 0; i < numStr.length(); i++){
                        arr[i] = Integer.parseInt(String.valueOf(numStr.charAt(i)));
                    }
                    convers.Convers(originalNumSys, finalNumSys, number, arr, minus);
                    break;
                }catch (Exception ex){
                    System.out.println();
                    System.out.println(ex.getMessage());
                    System.out.println("Try again");
                }
            }
            else{
                try{
                    Scanner scanf = new Scanner(System.in);
                    numStr = scanf.nextLine();
                    numStr = numStr.toUpperCase();
                    if(Check()) {
                        int[] arr = new int[numStr.length()];
                        if ((int) numStr.charAt(0) == 45) minus = true;
                        arr = addToString(arr, minus);
                        convers.Convers(originalNumSys, finalNumSys, 0, arr, minus);
                        break;
                    }
                    System.out.println("Error");
                }catch (Exception ex){
                    System.out.println();
                    System.out.println(ex.getMessage());
                    System.out.println("Try again");
                }
            }
        }
    }

    public int[] addToString(int[] arr, boolean flag){
        for(int i = 0; i < numStr.length(); i++){
            if(flag) {
                i++;
                flag = false;
            }
            if( ((int)numStr.charAt(i)  >= 65 && (int)numStr.charAt(i)  <= 70) ){
                switch((int)numStr.charAt(i) ){
                    case 65:
                        arr[i] = 10;
                        break;
                    case 66:
                        arr[i] = 11;
                        break;
                    case 67:
                        arr[i] = 12;
                        break;
                    case 68:
                        arr[i] = 13;
                        break;
                    case 69:
                        arr[i] = 14;
                        break;
                    case 70:
                        arr[i] = 15;
                        break;
                }
            }
            else
                arr[i] = Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        return arr;
    }

    public boolean Check(){
        for(int i = 0; i < numStr.length(); i++){
            String temp = Character.toString(numStr.charAt(i));
            switch(originalNumSys){
                case 11:
                    if(cc11.contains(temp)) return true;
                    break;
                case 12:
                    if(cc12.contains(temp)) return true;
                    break;
                case 13:
                    if(cc13.contains(temp)) return true;
                    break;
                case 14:
                    if(cc14.contains(temp)) return true;
                    break;
                case 15:
                    if(cc15.contains(temp)) return true;
                    break;
                case 16:
                    if(cc16.contains(temp)) return true;
                    break;
            }
        }
        return false;
    }
}
