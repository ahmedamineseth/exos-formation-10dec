package medical.m2i.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import medical.m2i.model.Ville;

public class VilleDao {

	private Properties db = new Properties();

	public List<Ville> getVilles() throws ClassNotFoundException {
		try {
			db.load(getClass().getResourceAsStream("connectiondb.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String url = db.getProperty("url");
		String user = db.getProperty("user");
		String password = db.getProperty("password");

		String GET_ALL_VILLE = "SELECT * from ville";

		List<Ville> listVille = new ArrayList<Ville>();

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(url, user, password);
				// Creation du statement utilise pour la connection object
				Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(GET_ALL_VILLE);

			while (resultSet.next()) {
				Ville ville = new Ville(resultSet.getInt(1), resultSet.getString("nom"),
						resultSet.getInt("code_postal"));
				listVille.add(ville);
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString("nom") + "\t"
						+ resultSet.getString("code_postal"));
			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}

		return listVille;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
