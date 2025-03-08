public class JavaFeaturesExample {

    public static void main(String[] args) {
        // Comentários: Este é um exemplo que demonstra várias características do Java.

        // Tipos primitivos
        int inteiro = 42;               // Inteiro
        double pontoFlutuante = 3.14;   // Número de ponto flutuante
        char caractere = 'A';           // Caractere
        boolean verdade = true;         // Booleano

        // Inteiros e números de ponto flutuante literais
        int x = 123_456_789;            // Inteiro literal
        int numeroHexadecimal = 0x1F;  // Literal hexadecimal
        double numeroCientifico = 1.23e2; // Notação científica (123.0)
        double num = 9_423_497_862.0;   // Double literal

        // Local variable type inference (var)
        var mensagem = "Olá, Java!"; // O tipo é inferido como String

        // Arrays unidimensionais
        int[] arrayUnidimensional = {1, 2, 3, 4, 5};

        // Arrays multidimensionais
        int[][] arrayMultidimensional = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // If statement
        if (inteiro > 40) {
            System.out.println("O inteiro é maior que 40.");
        } else {
            System.out.println("O inteiro é 40 ou menor.");
        }

        // For loop
        System.out.println("Elementos do array unidimensional:");
        for (int i = 0; i < arrayUnidimensional.length; i++) {
            System.out.println(arrayUnidimensional[i]);
        }

        // For-each loop com variável local do tipo inferido (var)
        System.out.println("Elementos do array multidimensional:");
        for (var linha : arrayMultidimensional) {
            for (var elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
        
        String season;
        int month = 4;
        if(month == 12 || month == 1 || month == 2)
            season = "Winter";
        else if(month == 3 || month == 4 || month == 5)
            season = "Spring";
        else if(month == 6 || month == 7 || month == 8)
            season = "Summer";
        else if(month == 9 || month == 10 || month == 11)
            season = "Autumn";
        else
            season = "Bogus Month";
        System.out.println("April is in the " + season + ".");

        // Lifetime of a variable
        {
            int escopoLimitado = 99; // Variável com escopo limitado a este bloco
            System.out.println("Variável no escopo limitado: " + escopoLimitado);
        }
        // A variável `escopoLimitado` não está mais acessível aqui.

        // Trabalhando com Strings
        String saudacao = "Hello"; 
        saudacao += ", World!"; // Concatenação de Strings
        System.out.println(saudacao);

        // Caracteres e manipulação
        System.out.println("Caractere inicial da saudação: " + saudacao.charAt(0));
        System.out.println("Comprimento da saudação: " + saudacao.length());
    }
}
