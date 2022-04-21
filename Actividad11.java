import java.lang.*;
import java.util.Scanner;
import java.io.*;

public class Actividad11{

    //Interfaz de la cual se basan las figuras
    public static interface Shape {

        public double getArea();

        public double getPerimeter();

    }

    //clase circulo
    public static class Circle implements Shape {

        double radio;

        // Implementacion de los metodos de la interfaz
        public double getArea() {
            return Math.PI * Math.pow(this.radio,2);
        }

        public double getPerimeter() {
            return Math.PI * this.radio * 2;
        }

        //este metodo es el que procesa la informacion recolectada por el menu
        //aqui se piden los atributos del circulo
        void processData(char metodo){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                System.out.println("Escriba el radio del circulo");
                this.radio = Double.parseDouble(br.readLine());
            }
            catch(IOException ioe){
                System.out.println(ioe);
            }
            if(metodo == 'a'){
                System.out.println("El area es: " + this.getArea());
            }
            else{
                System.out.println("El perimetro es: " + this.getPerimeter());
            }
        }

    }

    //clase de triangulo
    //asume que el triangulo es equilatero
    public static class Triangle implements Shape {

        double base;
        double altura;

        // Asumiendo un triangulo equilatero
        public double getArea() {
            return (this.base * this.altura)/2;
        }

        public double getPerimeter() {
            return this.base + 2 * this.altura;
        }

        //este metodo es el que procesa la informacion recolectada por el menu
        //aqui se piden los atributos del circulo
        void processData(char metodo){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                System.out.println("Escriba la base del triangulo");
                this.base = Double.parseDouble(br.readLine());
                System.out.println("Escriba la altura del triangulo");
                this.altura = Double.parseDouble(br.readLine());
            }
            catch(IOException ioe){
                System.out.println(ioe);
            }
            if(metodo == 'a'){
                System.out.println("El area es: " + this.getArea());
            }
            else{
                System.out.println("El perimetro es: " + this.getPerimeter());
            }
        }

    }

    //clase del circulo
    public static class Square implements Shape {

        double lado;

        public double getArea() {
            return Math.pow(this.lado,2);
        }

        public double getPerimeter() {
            return this.lado * 4;
        }

        //este metodo es el que procesa la informacion recolectada por el menu
        //aqui se piden los atributos del circulo
        void processData(char metodo){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                System.out.println("Escriba la longitud de un lado del cuadrado");
                this.lado = Double.parseDouble(br.readLine());
            }
            catch(IOException ioe){
                System.out.println(ioe);
            }
            if(metodo == 'a'){
                System.out.println("El area es: " + this.getArea());
            }
            else{
                System.out.println("El perimetro es: " + this.getPerimeter());
            }
        }

    }

    //menu que controla el sistema
    //pide la accion a realizar y el tipo de figura
    //posteriormente manda a llamar los metodos correspondientes en la figura
    //utiliza recursividad para repetirse
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba \'a\' si se desea calcular el area o \"p\" si se desea calcular el perimetro");
        char metodo = sc.next().charAt(0);
        System.out.println("Escriba \'o\' si se desea calcular un circulo,\'t\' si se desea calcular un triangulo o \"c\" si se desea calcular un cuadrado");
        char figura = sc.next().charAt(0);
        switch (figura){
            case 'o':
                Circle circulo = new Circle();
                circulo.processData(metodo);
                break;
            case 't':
                Triangle triangulo = new Triangle();
                triangulo.processData(metodo);
                break;
            case 'c':
                Square cuadrado = new Square();
                cuadrado.processData(metodo);
                break;
            default:
                System.out.println("Opción no reconocida, vuelva a intentarlo");
        }
        System.out.println("Escriba \'s\' si se desea salir del sistema o cualquier otro caracter si se desea hacer otro calculo");
        char salir = sc.next().charAt(0);
        if (salir == 's') {
            return;
        }
        else{
            menu();
        }
    }

    public static void main(String args[]){
        menu();
    }
}
