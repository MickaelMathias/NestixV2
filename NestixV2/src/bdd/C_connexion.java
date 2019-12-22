package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C_connexion {
    private static Connection connection = null;
    protected static Statement statement = null;
    private static String url = "jdbc:mysql://localhost:3306/nestix?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "";

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion a " + url + " avec succes");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connexion");
        }
    }

    public static ResultSet ex_Query(String requete) {
        ResultSet resultat = null;
        try {
            getConnexion();
            statement = connection.createStatement();
            resultat = statement.executeQuery(requete);
            System.out.println(requete);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requete Query : " + requete);
        }
        return resultat;
    }

    public int ex_Update(String requete) {
        int resultat = -1;
        try {
            getConnexion();
            statement = connection.createStatement();
            resultat = statement.executeUpdate(requete);
            System.out.println(requete);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requete Query : " + requete);
        }
        return resultat;
    }

    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnexion() {
        if (connection == null) {
            connect();
        }
    return connection;
    }

}