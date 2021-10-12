package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService //implements AuthService
 {
//    private static Connection connection;
//    private static Statement stmt;
//    public static void connect() throws ClassNotFoundException, SQLException {
//        Class.forName("org.sqlite.JDBC");
//        connection = DriverManager.getConnection("jdbc:D:\\sql studio\\SQLiteStudio\\accounts.db");
//        stmt = connection.createStatement();
//    }
//
//    public static void disconnect() {
//        try {
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            stmt.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    public boolean registration(String login, String password, String nickname) {
//        try {
//            connect();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        String sql = String.format("INSERT INTO accounts (nickname, login, password) VALUES ('%s', '%s', '%s')", login, password, nickname);
//
//        try {
//            boolean rs = stmt.execute(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        return true;
//    } public String getNicknameByLoginAndPassword(String login, String password) {
//        String sql = String.format("SELECT nickname FROM accounts WHERE login = '%s' and password = '%s'", login, password);
//
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//
//            if (rs.next()) {
//                String str = rs.getString(1);
//                return rs.getString(1);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//public String changeNickname (String nickname, String login){
//    String sql = String.format("UPDATE accounts SET nickname =  '%s' WHERE login = '%s'", nickname, login);
//    try {
//        boolean rs = stmt.execute(sql);
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return sql;
//}


    private static class UserData {
        String login;
        String password;
        String nickname;




        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() {
        this.users = new ArrayList<>();
        users.add(new UserData("qwe", "qwe", "qwe"));
        users.add(new UserData("asd", "asd", "asd"));
        users.add(new UserData("zxc", "zxc", "zxc"));
        for (int i = 1; i < 10; i++) {
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
    }

//    @Override
//    public String getNicknameByLoginAndPassword(String login, String password) {
//        for (UserData u : users) {
//            if (u.login.equals(login) && u.password.equals(password)) {
//                return u.nickname;
//            }
//        }
//
//        return null;
//    }

//    @Override
//    public boolean registration(String login, String password, String nickname) {
//        for (UserData u : users) {
//            if (u.login.equals(login) || u.nickname.equals(nickname)) {
//                return false;
//            }
//        }
//        users.add(new UserData(login, password, nickname));
//        return true;
//    }
}
