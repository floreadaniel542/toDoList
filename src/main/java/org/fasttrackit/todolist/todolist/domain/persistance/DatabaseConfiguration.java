package org.fasttrackit.todolist.todolist.domain.persistance;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfiguration {

    public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        Properties properties = new Properties();

        InputStream inputStream = DatabaseConfiguration.class.getClassLoader()
                .getResourceAsStream("db.propreties");
        try {
            properties.load(inputStream);

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));
        } finally {
            //closing inputStrem to free up memory
            if (inputStream != null) {
                inputStream.close();
            }


        }
    }
}
