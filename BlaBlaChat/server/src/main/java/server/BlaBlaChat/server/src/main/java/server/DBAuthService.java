package server;


import java.sql.*;

public class DBAuthService implements AuthService {
    private static Connection connection;
    private static Statement stmt;
    ResultSet rs;

    {
        try {
            rs = stmt.getResultSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:D:\\sql studio\\SQLiteStudio\\accounts.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public boolean registration(String login, String password, String nickname) {
        try {
            ResultSet rs = stmt.getResultSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//stmt.executeUpdate("INSERT INTO accounts (nickname, login, password) VALUES ('%s', '%s', '%s')", login, password, nickname);
        String sql = String.format("INSERT INTO accounts (nickname, login, password) VALUES ('%s', '%s', '%s')", login, password, nickname);

        try {
            int rs = stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return true;
    } public String getNicknameByLoginAndPassword(String login, String password) {
        String sql = String.format("SELECT nickname FROM accounts WHERE login = '%s' and password = '%s'", login, password);

        try {
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String str = rs.getString(1);
                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String changeNickname (String nickname, String login){
        try {
            ResultSet rs = stmt.getResultSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql = String.format("UPDATE accounts SET nickname =  '%s' WHERE login = '%s'", nickname, login);
        try {
           boolean rs = stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }
}
