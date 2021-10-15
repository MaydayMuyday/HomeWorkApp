package client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<String> clientList;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private HBox authPanel;
    @FXML
    private HBox msgPanel;

    private Socket socket;
    private final int PORT = 8189;
    private final String IP_ADDRESS = "localhost";
    private DataInputStream in;
    private DataOutputStream out;

    private boolean authenticated;
    private String nickname;
    private Stage stage;
    private Stage regStage;
    private RegController regController;
    private File logs;
    private final int MESSAGE_QUANTITY = 100;

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
        authPanel.setVisible(!authenticated);
        authPanel.setManaged(!authenticated);
        msgPanel.setVisible(authenticated);
        msgPanel.setManaged(authenticated);
        clientList.setVisible(authenticated);
        clientList.setManaged(authenticated);

        if (!authenticated) {
            nickname = "";
        }
        setTitle(nickname);
        textArea.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            stage = (Stage) textField.getScene().getWindow();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    System.out.println("bye");
                    if (socket != null && !socket.isClosed()) {
                        try {
                            out.writeUTF("/end");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        });
        setAuthenticated(false);
    }

    private void connect() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(this::run).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sendMsg(ActionEvent actionEvent) {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();

            try (FileWriter fw = new FileWriter(logs, true)) {
                fw.append(textArea.getText() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connect();
        }

        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();
        String msg = String.format("/auth %s %s", login, password);

        try {
            out.writeUTF(msg);
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setTitle(String nickname) {
        Platform.runLater(() -> {
            if (!nickname.equals("")) {
                stage.setTitle(String.format("Home Chat[ %s ]", nickname));
            } else {
                stage.setTitle("BlaBlaChat");
            }
        });
    }

    public void clientListClick(MouseEvent mouseEvent) {
        String receiver = clientList.getSelectionModel().getSelectedItem();
        textField.setText(String.format("/w %s ", receiver));
    }

    private void createRegWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/reg.fxml"));
            Parent root = fxmlLoader.load();
            regStage = new Stage();
            regStage.setTitle("Home Chat registration");
            regStage.setScene(new Scene(root, 600, 400));
            regController = fxmlLoader.getController();
            regController.setController(this);

            regStage.initStyle(StageStyle.UTILITY);
            regStage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegWindow(ActionEvent actionEvent) {
        if (regStage == null) {
            createRegWindow();
        }
        regStage.show();
    }

    public void registration(String login, String password, String nickname) {
        String msg = String.format("/reg %s %s %s", login, password, nickname);

        if (socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void msgHistory() {
//
//        File logs = new File("MsgHistory_" + nickname + ".txt");
//        if (!logs.exists()) {
//            System.out.println("File " + logs + " created");
//            try {
//                logs.createNewFile();
//                PrintWriter printWriter = new PrintWriter(new FileWriter(logs, false));
//                BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
//                bufferedWriter.write(textArea.getText());
//                bufferedWriter.flush();
//                bufferedWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

//    public void loadMSG() {
//        int msgLines = 100;
//        File logs = new File("MsgHistory.txt");
//        List<String> logsList = new ArrayList<>();
//        try {
//            FileInputStream in = new FileInputStream(logs);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//            String temp = null;
//            while (true) {
//                try {
//                    if (!((temp = bufferedReader.readLine()) != null)) break;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                logsList.add(temp);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (logsList.size() > msgLines) {
//            for (int i = logsList.size() - msgLines; i <= (logsList.size() - 1); i++) {
//                textArea.appendText(logsList.get(i) + "\n");
//            }
//
//
//        } else {
//            for (int i = 0; i < msgLines; i++) {
//                //  System.out.println(logsList.get(i));
//            }
//        }
//    }

    private void run() {
        try {
            // цикл аутентификации
            while (true) {
                String str = null;
                try {
                    str = in.readUTF();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (str.startsWith("/")) {
                    if (str.equals("/end")) {
                        break;
                    }
                    if (str.startsWith("/authok")) {
                        nickname = str.split("\\s")[1];
                        setAuthenticated(true);
                        int lineNumber = 0;
                        if (setLogs().exists()) {
                            try (FileReader fr = new FileReader(logs)) {
                                LineNumberReader lnr = new LineNumberReader(fr);
                                while (lnr.readLine() != null) {
                                    lineNumber++;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try (BufferedReader br = new BufferedReader(new FileReader(logs))) {
                                for (int i = 0; i < lineNumber; i++) {
                                    String line = br.readLine();
                                    if (i >= lineNumber - MESSAGE_QUANTITY) {
                                        textArea.appendText(line + "\n");
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                logs.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }


                        break;
                    }
                    if (str.equals("/regok")) {
                        regController.regResult("Регистрация прошла успешно");
                    }
                    if (str.equals("/regno")) {
                        regController.regResult("Логин или никнейм уже заняты");
                    }
                } else {
                    textArea.appendText(str + "\n");
//                    msgHistory();
                }
            }

            // цикл работы
            while (authenticated) {
//
//
                String str = in.readUTF();
                if (str.startsWith("/")) {
                    if (str.equals("/end")) {
                        break;
                    }
                    if (str.startsWith("/clientlist ")) {
                        String[] token = str.split("\\s+");
                        Platform.runLater(() -> {
                            clientList.getItems().clear();
                            for (int i = 1; i < token.length; i++) {
                                clientList.getItems().add(token[i]);
                            }
                        });
                    }
                } else {
                    textArea.appendText(str + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("disconnected");
            setAuthenticated(false);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File setLogs() {
        logs = new File("History_" + nickname + ".txt");
        return logs;
    }
}

//проба работы с гитом через интерфейс идеи