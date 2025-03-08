import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Main{
    public static void metodo(){
        int resultado = 10/0;
    }

    static void validarIdade(int idade) throws IllegalArgumentException{
        if (idade < 18) {
            throw new IllegalArgumentException("Idade inválida para acesso.");
        }
    }

    public static void FinallyExample(){
         FileReader fileReader = null;
        
        try {
            // Tentando abrir um arquivo que pode não existir
            fileReader = new FileReader("dados.txt");
            BufferedReader br = new BufferedReader(fileReader);
            System.out.println("Primeira linha do arquivo: " + br.readLine());
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
        } finally {
            // Garante que o arquivo será fechado, mesmo que ocorra uma exceção
            try {
                if (fileReader != null) {
                    fileReader.close();
                    System.out.println("Arquivo fechado com sucesso.");
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }

    public static void moveOn(){
        int a=0, b=0, c=0;
        Random r = new Random();
        for(int i=0; i<32000; i++) {
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b/c);
            } catch (ArithmeticException e) {
                System.out.println("Division by zero.");
                a = 0; // set a to zero and continue
            }
            System.out.println("a: " + a);
        }
    }
    public static void main(String[] args){
        // try 
        // {
        //     int resultado = 10/0;
        // } catch (ArithmeticException e) { 
        //     System.out.println("Erro: divisão por zero!"); 
        // }
        //try {
            validarIdade(15);    
        //} catch (Exception e) {
        //    System.out.println(e.getMessage());
       // }
        

        //moveOn();

    }
}