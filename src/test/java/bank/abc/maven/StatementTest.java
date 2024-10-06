package bank.abc.maven;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class StatementTest {
    
    @Test
    void testCreateStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        
        statement.close();
        connection.close();
    }
    
    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        
        String sql = """
                INSERT INTO accounts(account_number, account_holder, balance) 
                VALUES ('0', 'Monique Madelin', '100000')
                """;
        int update = statement.executeUpdate(sql);
        System.out.println(update);
        statement.close();
        connection.close();
    }
}
