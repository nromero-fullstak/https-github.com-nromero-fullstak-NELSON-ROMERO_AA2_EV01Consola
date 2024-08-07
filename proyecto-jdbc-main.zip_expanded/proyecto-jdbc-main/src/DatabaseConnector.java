import java.sql.*;

/**
 * La clase DatabaseConnector proporciona métodos para establecer y cerrar conexiones a una base de datos MySQL.
 */
public class DatabaseConnector {

    // URL de conexión a la base de datos
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bd_ejemplo";

    // Credenciales de acceso a la base de datos
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "prime";

    /**
     * Establece una conexión a la base de datos utilizando las credenciales proporcionadas.
     *
     * @return Una instancia de Connection si la conexión es exitosa, o null si hay un error.
     */
    public static Connection conectar() {
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            return DriverManager.getConnection(JDBC_URL, USUARIO, CONTRASEÑA);
        } catch (ClassNotFoundException | SQLException e) {
            // Maneja excepciones imprimiendo detalles para facilitar diagnósticos.
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cierra la conexión a la base de datos si no está cerrada.
     *
     * @param connection La conexión a cerrar.
     */
    public static void cerrarConexion(Connection connection) {
        try {
            // Verificar si la conexión no es nula y aún no está cerrada
            if (connection != null && !connection.isClosed()) {
                // Cerrar la conexión
                connection.close();
            }
        } catch (SQLException e) {
            // Manejar excepciones imprimiendo la traza de la pila
            e.printStackTrace();
        }
    }
}
