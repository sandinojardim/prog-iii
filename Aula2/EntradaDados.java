import java.util.Scanner;

public class EntradaDados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Olá, " + nome + ". Você tem " + idade + " anos.");
        
        scanner.close(); // Fecha o Scanner
        int numAlunos = 7, numListas = 10;
        
        int[] valores = new int[10];
        double[][] notas = new double[4][5];
        double[][] listas = new double[numAlunos][numListas];
    }
}