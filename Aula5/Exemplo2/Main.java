import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main{

    public static void method() throws MyException{
        throw new MyException("Erro");
    }
    public static void main(String[] args){
        try {
            FileReader file = new FileReader("arquivo.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            int resultado = 10 / 0;
            method();    
        } catch (ArithmeticException e) {
            // TODO: handle exception
        } catch(MyException e){
            // TODO: handle exception
        }
        
        // try {
        //     int resultado = 10 / 0;
        // } catch (ArithmeticException e) {
        //     System.out.println("Divisao por zero não permitida");
        //     try {
        //         ///...
        //     } catch (Exception e) {
        //         System.out.println("Exceção após ArithmeticException");
        //     }
        // }
    }
}