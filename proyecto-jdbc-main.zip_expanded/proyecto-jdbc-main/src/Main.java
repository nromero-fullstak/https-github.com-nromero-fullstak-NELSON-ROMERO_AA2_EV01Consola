import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Intenta conectar a la base de datos
        Connection connection = DatabaseConnector.conectar();

        // Verifica si la conexión fue exitosa
        if (connection != null) {
            System.out.println("¡Conexión exitosa a la base de datos!");

            // Muestra el menú y procesa las opciones del usuario
            mostrarMenu(connection);

            // Cierra la conexión al finalizar
            DatabaseConnector.cerrarConexion(connection);
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
    }

    private static void mostrarMenu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        UsuarioManager usuarioManager = new UsuarioManager();

        while (true) {
            System.out.println("\n|--------------Menú:--------------|");
            System.out.println("|1. Crear usuario                 |");
            System.out.println("|2. Consultar usuarios            |");
            System.out.println("|3. Actualizar usuario            |");
            System.out.println("|4. Eliminar usuario              |");
            System.out.println("|5. Salir                         |");
            System.out.println("|---------------------------------|");
            System.out.print("|Elige una opción: ");


            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    usuarioManager.crearUsuario(connection);
                    break;
                case 2:
                    usuarioManager.consultarUsuarios(connection);
                    break;
                case 3:
                    usuarioManager.actualizarUsuario(connection);
                    break;
                case 4:
                    usuarioManager.eliminarUsuario(connection);
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}