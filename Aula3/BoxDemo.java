class Box {
    private double width;
    private double height;
    private double depth;

    public Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
    public Box() {
        width = -1; 
        height = -1; 
        depth = -1;
    }
    /* ... */
    Box(Box ob) { 
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }
    /* ... */
    public Box(double len) {
        width = height = depth = len;
    }
    public double volume() {
        return width * height * depth;
    }
}

// Objetos são passados por referência.
class Test {
    int a, b;
    Test(int i, int j) {
    a = i;
    b = j;
    }
    // pass an object
    void meth(Test o) {
    o.a *= 2;
    o.b /= 2;
    }
    }
    class PassObjRef {
        public static void main(String[] args) {
        Test ob = new Test(15, 20);
        System.out.println("ob.a and ob.b before call: " +
        ob.a + " " + ob.b);
        ob.meth(ob);
        System.out.println("ob.a and ob.b after call: " +
        ob.a + " " + ob.b);
        }
    }

    class StaticDemo {
        static int a = 42;
        static void callme() {
            System.out.println("a = " + a);
        }
        static {
            System.out.println("Bloco estático inicializado.");
        }
        public static void main(String[] args) {
            StaticDemo.callme();
        }
    }

    class Outer {
        int outer_x = 100;
        void test() {
            Inner inner = new Inner();
            inner.display();
        }
        class Inner { // Classe Interna
            void display() {
                System.out.println("display: outer_x = " + outer_x);
            }
        }
    }
    class InnerClassDemo {
        public static void main(String[] args) {
            Outer outer = new Outer();
            outer.test();
        }
    }

    class Outer {
        int outer_x = 100;
        void test() {
            for (int i = 0; i < 3; i++) {
                class Inner {
                    void display() {
                        System.out.println("display: outer_x = " + outer_x);
                    }
                }
                Inner inner = new Inner();
                inner.display();
            }
        }
    }

    static void vaTest(int ... v) {  
        // v é tratado como um array do tipo int[].  
    }
    
    class VarArgs {
        static void vaTest(int ... v) {
            System.out.print("Número de args: " + v.length + " Conteúdo: ");
            for (int x : v) System.out.print(x + " ");
            System.out.println();
        }
        public static void main(String[] args) {
            vaTest(10);        // 1 argumento
            vaTest(1, 2, 3);   // 3 argumentos
            vaTest();          // nenhum argumento
        }
    }
    class OverloadVarargs {
        static void test(int a) {
            System.out.println("Método com 1 parâmetro int: " + a);
        }
        static void test(int ... a) {
            System.out.println("Método varargs com int[]. Número de args: " + a.length);
        }
        public static void main(String[] args) {
            test(5);        // Chama o método normal
            test(1, 2, 3);  // Chama o método varargs
        }
    }
    class AmbiguityExample {
        static void test(int ... a) {
            System.out.println("Varargs com int[]");
        }
        static void test(long ... a) {
            System.out.println("Varargs com long[]");
        }
        public static void main(String[] args) {
            // test(10); // Erro: Ambiguidade!
        }
    }

    class ResolveAmbiguity {
        static void test(int ... a) {
            System.out.println("Varargs com int[]");
        }
        static void test(long ... a) {
            System.out.println("Varargs com long[]");
        }
        public static void main(String[] args) {
            test((int) 10);   // Chama o método com int
            test((long) 10);  // Chama o método com long
        }
    }
    
    
    
class CallByValue {
    public static void main(String[] args) {
        Test ob = new Test();
        int a = 15, b = 20;
        System.out.println("a and b before call: " + a + " " + b);
        ob.meth(a, b);
        System.out.println("a and b after call: " + a + " " + b);
    }
}
// This class declares an object of type Box.
class BoxDemo {
    public static void main(String[] args) {
        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box();
        Box mycube = new Box(7);
        Box cloneBox = new Box(mybox1);
        double vol;
        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is " + vol);
        
        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is " + vol);

        vol = mycube.volume();
        System.out.println("Volume of mycube is " + vol);
    }
}