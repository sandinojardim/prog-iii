// class A {
//     int i, j;
//     void showij() {
//         System.out.println("i and j: " + i + " " + j);
//     }
// }

// class B extends A {
//     int k;
//     void showk() {
//         System.out.println("k: " + k);
//     }
//     void sum() {
//         System.out.println("i+j+k: " + (i + j + k));
//     }
// }

class SimpleInheritance {
    public static void main(String[] args) {
        A superOb = new A(); // Objeto da superclasse
        B subOb = new B();   // Objeto da subclasse

        superOb.i = 10;
        superOb.j = 20;
        superOb.showij(); // Acessa métodos da classe A

        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;
        subOb.showij(); // Herdado de A
        subOb.showk();  // Método exclusivo de B
        subOb.sum();    // Combina atributos de A e B
    }
}

class SuperClass {
    private int privateVar = 10;      // Apenas acessível na própria classe
    protected int protectedVar = 20; // Acessível na classe e nas subclasses
    public int publicVar = 30;       // Acessível em qualquer lugar

    public int getPrivateVar() {     // Método público para acessar privateVar
        return privateVar;
    }
}

class SubClass extends SuperClass {
    void showValues() {
        // System.out.println("privateVar: " + privateVar); // ERRO: Não acessível
        System.out.println("privateVar (via getter): " + getPrivateVar());
        System.out.println("protectedVar: " + protectedVar); // Acessível
        System.out.println("publicVar: " + publicVar);       // Acessível
    }
}

public class AccessModifiersExample {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();

        // Acessando membros da superclasse diretamente
        // System.out.println("privateVar: " + superClass.privateVar); // ERRO
        System.out.println("privateVar (via getter): " + superClass.getPrivateVar());
        // System.out.println("protectedVar: " + superClass.protectedVar); // ERRO
        System.out.println("publicVar: " + superClass.publicVar);       // Acessível

        System.out.println("\nValores na subclasse:");
        subClass.showValues(); // Mostra os valores acessíveis
    }
}

class SuperClass {
    int num = 100;
    void display() { System.out.println("SuperClass"); }
}
class SubClass extends SuperClass {
    int num = 200;
    void show() {
        System.out.println(super.num); // 100
        super.display(); // Chama o método da superclasse
    }
}

class SuperClass {
    SuperClass(String msg) { System.out.println(msg); }
}
class SubClass extends SuperClass {
    SubClass(String msg) { super(msg); } // Chama o construtor da SuperClass
}

class A {
    void show() { System.out.println("Superclasse"); }
}
class B extends A {
    @Override
    void show() {
        super.show(); // Chama o método da superclasse
        System.out.println("Subclasse");
    }
}
public class Test {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
    }
}

class Animal {
    void sound() {
        System.out.println("Animal faz som");
    }
}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Cachorro late");
    }
}
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Gato mia");
    }
}
public class Teste {
    public static void main(String[] args) {
        Animal a; // Referência genérica
        a = new Dog();
        a.sound(); // Cachorro late
        a = new Cat();
        a.sound(); // Gato mia
    }
    

}

abstract class NomeDaClasse {
    abstract void metodoAbstrato(); // Sem corpo
    void metodoConcreto() {
        System.out.println("Método concreto");
    }
}

class Pessoa {
    String nome;
    int idade;

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && nome.equals(pessoa.nome);
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Ana", 30);
        Pessoa p2 = new Pessoa("Ana", 30);
        System.out.println(p1); // Pessoa [nome=Ana, idade=30]
        System.out.println(p1.equals(p2)); // true

        List<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.remove("Python");
        System.out.println(lista.get(0)); // Java

      


    }
}





