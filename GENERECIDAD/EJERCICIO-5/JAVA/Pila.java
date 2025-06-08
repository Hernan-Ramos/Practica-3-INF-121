public class Pila <H>{
    private H[] arreglo;
    private int top;
    private int n;

    public Pila(int n){
        this. n = n;
        this.top = -1;
        this.arreglo = (H[])new Object[n];

    }
    public void push(H e){
        if(this.isFull()){
            System.out.println("pila llena, ya no se puede agregar elementos");
        }else{
        this.top ++;
        this.arreglo[top] = e;
        System.out.println("Se agrego este elemento a la pila: ------- " + this.arreglo[top]);
        }
    }

    public H pop(){
        if (this.isEmpty()){
            System.out.println("pila vacia");
            return null;
        }
        else{
            H valor = arreglo[this.top];
            arreglo[top]= null;
            this.top--;
            System.out.print("Se elemino etse elemento ---------");
            return valor;
        }
    }

    public H peek (){
        if(this.isEmpty()){
            System.out.println("pila vacia");
            return null;
        }
        System.out.print("Este elemento esta en la cima de la pila: --------");
        return this.arreglo[top];
    }
    public boolean isEmpty(){
        return this.top == -1;
    }
    public boolean isFull(){
        return this.top == this.n - 1;
    }
    public void mostrar(){
        for (int i = 0; i < this.n; i++){
            if(this.arreglo[i] == null){
                return;
            }
            System.out.println( this.arreglo[i]);
        }
    }

    public static void main(String[] args) {
        Pila<Integer> p1 = new Pila(4);
        Pila <String> p2 = new Pila(3);
        Pila <Libros> p3 = new Pila(2);

        p1.push(3);
        p1.push(1000);
        p1.push(300);
        p1.push(200);
        p1.push(500);
        System.out.println(p1.peek());
        System.out.println(p1.pop());

        p1.mostrar();
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        p2.push("Hello" );
        p2.push("World" );
        p2.push("My name is Hernan" );
        System.out.println(p2.peek());
        System.out.println(p2.pop());
        p2.mostrar();

        p3.push(new Libros("Cien años de soledad"));
        p3.push(new Libros("Sherlock Holmes"));
        p3.mostrar();

    }
}
