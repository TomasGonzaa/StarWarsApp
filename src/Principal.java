import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner lectura = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("""
                ...........................................
                *** BIENVENIDO AL MUNDO DE STARWARS ***
                """);
        while(true){
        System.out.println("""
            ...........................................
           ¿Sobre qué Pelicula le gustaria saber más?
            ...........................................
            1- A New Hope.
            2- The Empire Strikes Back.
            3- Return of the Jedi.
            4- The Phantom Menace.
            5- Attack of the Clones.
            6- Revenge of the Sith.
            7- Salir.
            ...........................................
           \s""");
        try{
            var nroPelicula = Integer.valueOf(lectura.nextLine());
            if (nroPelicula == 7){
                System.out.println("¡Que tenga un Excelente día! Hasta Luego...");
                break;
            }
            Pelicula pelicula = consulta.buscaPelicula(nroPelicula);
            System.out.println(pelicula);

            System.out.println("""
                ...................................................................
                ¿Le gustaría guardar la informacion de esta pelicula en un archivo?
                ...................................................................
                """);
            System.out.println("Escriba 'SI' o 'NO' para indicar su respuesta:");
            String respuesta = lectura.nextLine();
            if (respuesta.equalsIgnoreCase("si")){
                GeneradorArchivo generador = new GeneradorArchivo();
                generador.guardarJson(pelicula);
                System.out.println("Archivo json creado!");
            }if(!respuesta.equalsIgnoreCase("si") & !respuesta.equalsIgnoreCase("no")){
                System.out.println("Opcion No Encontrada...");
            }


        }catch (NumberFormatException e){
            System.out.println("Numero no encontrado "+ e.getMessage());
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la Aplicacion");
        }
        }


    }
}
