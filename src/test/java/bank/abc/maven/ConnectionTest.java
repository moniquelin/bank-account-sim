package bank.abc.maven;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class ConnectionTest {

    @BeforeAll
    // Registrasi Driver
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    @Test
    // Connect Driver
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/bank_abc";
        String username = "root";
        String password = "000000";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        
            System.out.println("Sukses connect ke database Bank ABC.");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    // Connect and Close Driver
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/bank_abc";
        String username = "root";
        String password = "000000";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Sukses connect ke database Bank ABC.");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    // @Test
    // // Connect and Close Driver - Cara lain (Manual)
    // void testConnectionClose() {
    //     String jdbcUrl = "jdbc:mysql://localhost:3306/bank_abc";
    //     String username = "root";
    //     String password = "000000";

    //     try {
    //         Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        
    //         System.out.println("Sukses connect ke database Bank ABC.");
    //         connection.close();
    //     } catch (SQLException exception) {
    //         Assertions.fail(exception);
    //     }
    // }
}
