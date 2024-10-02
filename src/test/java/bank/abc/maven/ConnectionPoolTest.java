package bank.abc.maven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {
    @Test
    // konfigurasi HikariCP
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bank_abc");
        config.setUsername("root");
        config.setPassword("000000");

        // konfigurasi pool
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10*60_000);

        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close(); // kembalikan connection ke pool
            dataSource.close(); // close semua koneksi dalam pool stlh selesai 
        } catch (SQLException exception) {
            Assertions.fail(exception);

        }
    }

    @Test
    // Create connection pool and request a connection from the pool via ConnectionUtil
    void testUtil() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }
}
