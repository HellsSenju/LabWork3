import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);
    Conversion convers = new Conversion();
    public int originalNumSys;
    public int finalNumSys;
    public int number;
    public String numStr;
    public void InputOrigin() {
        while (true) {
            System.out.print("Выберите исходную систему счисления: 2 - 16: -->");
            try {
                originalNumSys = scan.nextInt();
                if(originalNumSys >= 2 && originalNumSys <= 16) break;
                System.out.println("Недопустимая система счисления");
            } catch (Exception ex) {
                System.out.println();
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }
    public void InputFinal(){
        while(true){
            System.out.print("Выберите конечную систему счисления: 2 - 16: -->");
            try{
                finalNumSys = scan.nextInt();
                if(finalNumSys >= 2 && finalNumSys <= 16) break;
                System.out.println("Недопустимая система счисления");
            }catch (Exception ex){
                System.out.println();
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }
    public void InputNumber(){
        //TODO добавить проверку на ввод
        boolean minus = false;
        boolean run;
        while(true){
            System.out.print("Введите число: -->");
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
                    //TODO если не создавать новый сканер, то он первый рза не берет строку, а второй раз берет
                    Scanner scanf = new Scanner(System.in);
                    run = true;
                    numStr = scanf.nextLine();
                    numStr = numStr.toUpperCase();
                    int[] arr = new int[numStr.length()];
                    if((int)numStr.charAt(0) == 45) minus = true;
                    for(int i = 0; i < numStr.length(); i++){
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
                        else if( ((int)numStr.charAt(i) >= 48 && (int)numStr.charAt(i) <= 57) ){
                            arr[i] = Integer.parseInt(String.valueOf(numStr.charAt(i)));
                        }
                        else{
                            System.out.println("Недоступное значение числа");
                            run = false;
                            break;
                        }
                    }
                    if(run){
                        convers.Convers(originalNumSys, finalNumSys, 0, arr, minus);
                        break;
                    }
                }catch (Exception ex){
                    System.out.println();
                    System.out.println(ex.getMessage());
                    System.out.println("Try again");
                }
            }
        }
    }
}
