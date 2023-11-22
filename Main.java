import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        String texto;
        int iLlave;
        Codificador c1;

        do {
            System.out.print("Escribe un texto a codificar/decodificar: ");
            texto = sc.nextLine();
            System.out.print("Introduce un numero positivo para codificar o uno negativo para decodificar el texto: ");
            iLlave = Integer.valueOf(sc.nextLine());

            c1 = new Codificador(texto);
            texto = c1.codificaDecodifica(iLlave);

            System.out.printf("Texto codificado: %s\n", texto);

            System.out.print("¿Quieres codificar/decodificar otro texto? Responde SI/NO: ");
            texto = sc.nextLine();

            if (texto.equalsIgnoreCase("no")) {
                continuar = false;
            }

            System.out.println("");
        } while (continuar);

        //System.out.print("Finalizando el programa...");
    }
}