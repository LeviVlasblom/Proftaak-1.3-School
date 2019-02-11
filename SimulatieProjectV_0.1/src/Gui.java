import java.lang.*;


import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;


import java.io.*;


public class Gui extends Application {

    private  VBox vBox;
    private  HBox hBox;
    private  VBox vBox0;
    private  Label labelKlas;
    private  Label labelVak;
    private  Label labelBeginTijd;
    private  Label labelEindtijd;
    private  VBox vBox1;
    private  TextField textFieldKlas;
    private  TextField textFieldVak;
    private  TextField textFieldBegintijd;
    private  TextField textFieldEindtijd;
    private  VBox vBox2;
    private  Separator separator;
    private HBox hBox0;
    private  Button buttonChange;
    private Button buttonOphalen;
    private HBox hBox1;
    private Button buttonAdd;
    private Button buttonOpslaan;
    private VBox vBox3;
    private HBox hBox2;
    private Separator separator0;
    private VBox vBox4;
    private Label label8;
    private Label label9;
    private Label label10;
    private Label Label11;
    private Label label12;
    private Label label13;
    private Label label14;
    private Label label15;
    private Label label16;
    private Label label17;
    private Label label18;
    private TextArea textAreaOutputBox;
    private HBox hBox3;
    private Button buttonClear;
    private Button buttonHelp;
    private BorderPane borderpane;
    private Label labelteacher;
    @Override
    public void start(Stage stage) {
        labelteacher = new Label();
        borderpane = new BorderPane();
        vBox = new VBox();
        hBox = new HBox();
        vBox0 = new VBox();
        labelKlas = new Label();
        labelVak = new Label();
        labelBeginTijd = new Label();
        labelEindtijd = new Label();
        vBox1 = new VBox();
        textFieldKlas = new TextField();
        textFieldVak = new TextField();
        textFieldBegintijd = new TextField();
        textFieldEindtijd = new TextField();
        vBox2 = new VBox();
        separator = new Separator();
        hBox0 = new HBox();
        buttonChange = new Button();
        buttonOphalen = new Button();
        hBox1 = new HBox();
        buttonAdd = new Button();
        buttonOpslaan = new Button();
        vBox3 = new VBox();
        hBox2 = new HBox();
        separator0 = new Separator();
        vBox4 = new VBox();
        label8 = new Label();
        label9 = new Label();
        label10 = new Label();
        Label11 = new Label();
        label12 = new Label();
        label13 = new Label();
        label14 = new Label();
        label15 = new Label();
        label16 = new Label();
        label17 = new Label();
        label18 = new Label();
        textAreaOutputBox = new TextArea();
        hBox3 = new HBox();
        buttonClear = new Button();
        buttonHelp = new Button();

        borderpane.setPrefHeight(694.0);
        borderpane.setPrefWidth(750.0);
        borderpane.setRotate(0.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setId("VBox");
        vBox.setPrefHeight(674.0);
        vBox.setPrefWidth(370.0);
        vBox.setSpacing(5.0);

        hBox.setPrefHeight(503.0);
        hBox.setPrefWidth(309.0);

        vBox0.setPrefHeight(238.0);
        vBox0.setPrefWidth(86.0);
        vBox0.setSpacing(15.0);

        labelKlas.setId("labelKlas");
        labelKlas.setPrefHeight(22.0);
        labelKlas.setPrefWidth(56.0);
        labelKlas.setText("Klas");

        labelVak.setId("labelVak");
        labelVak.setPrefHeight(22.0);
        labelVak.setPrefWidth(29.0);
        labelVak.setText("Vak");

        labelBeginTijd.setId("labelBegintijd");
        labelBeginTijd.setPrefHeight(22.0);
        labelBeginTijd.setPrefWidth(56.0);
        labelBeginTijd.setText("Begintijd");

        labelEindtijd.setId("labelEindtijd");
        labelEindtijd.setPrefHeight(22.0);
        labelEindtijd.setPrefWidth(72.0);
        labelEindtijd.setText("Eindtijd");

        vBox1.setPrefHeight(238.0);
        vBox1.setPrefWidth(158.0);
        vBox1.setSpacing(16.0);

        textFieldKlas.setId("textFieldKlas");
        textFieldKlas.setPrefWidth(200.0);

        textFieldVak.setId("textFieldVak");
        textFieldVak.setPrefWidth(200.0);

        textFieldBegintijd.setId("textFieldBegintijd");
        textFieldBegintijd.setPrefWidth(148.0);

        textFieldEindtijd.setId("textFieldEindtijd");
        textFieldEindtijd.setPrefWidth(158.0);

        vBox2.setPrefHeight(183.0);
        vBox2.setPrefWidth(471.0);

        separator.setPrefWidth(283.0);

        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(282.0);
        hBox0.setSpacing(30.0);

        buttonChange.setId("buttonChange");
        buttonChange.setMnemonicParsing(false);
        buttonChange.setPrefHeight(62.0);
        buttonChange.setPrefWidth(214.0);
        buttonChange.setText("Change");

        buttonOphalen.setId("buttonOphalen");
        buttonOphalen.setMnemonicParsing(false);
        buttonOphalen.setPrefHeight(62.0);
        buttonOphalen.setPrefWidth(214.0);
        buttonOphalen.setText("Ophalen");

        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(282.0);
        hBox1.setSpacing(30.0);

        buttonAdd.setId("buttonAdd");
        buttonAdd.setMnemonicParsing(false);
        buttonAdd.setPrefHeight(62.0);
        buttonAdd.setPrefWidth(214.0);
        buttonAdd.setText("Add");

        buttonOpslaan.setId("buttonOpslaan");
        buttonOpslaan.setMnemonicParsing(false);
        buttonOpslaan.setPrefHeight(62.0);
        buttonOpslaan.setPrefWidth(214.0);
        buttonOpslaan.setText("Opslaan");
        borderpane.setLeft(vBox);
        borderpane.setPadding(new Insets(10.0, 0.0, 10.0, 10.0));

        vBox3.setPrefHeight(674.0);
        vBox3.setPrefWidth(460.0);

        hBox2.setMinHeight(325.0);
        hBox2.setPrefHeight(650.0);
        hBox2.setPrefWidth(295.0);

        separator0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator0.setPrefHeight(2.0);
        separator0.setPrefWidth(20.0);

        vBox4.setPrefHeight(324.0);
        vBox4.setPrefWidth(39.0);
        vBox4.setSpacing(40.0);

        label8.setId("Label8");
        label8.setText("08:00");

        label9.setId("Label9");
        label9.setText("09:00");

        label10.setId("label10");
        label10.setText("10:00");

        Label11.setId("Label11");
        Label11.setText("11:00");

        label12.setId("Label12");
        label12.setText("12:00");

        label13.setId("label13");
        label13.setText("13:00");

        label14.setId("Label14");
        label14.setText("14:00");

        label15.setId("label15");
        label15.setText("15:00");

        label16.setId("label16");
        label16.setText("16:00");

        label17.setId("label17");
        label17.setText("17:00");

        label18.setId("label18");
        label18.setText("18:00");

        textAreaOutputBox.setId("textAreaOutputBox");
        textAreaOutputBox.setPrefHeight(612.0);
        textAreaOutputBox.setPrefWidth(323.0);
        textAreaOutputBox.setWrapText(true);

        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(200.0);

        buttonClear.setId("buttonClear");
        buttonClear.setMnemonicParsing(false);
        buttonClear.setPrefHeight(35.0);
        buttonClear.setPrefWidth(78.0);
        buttonClear.setText("Clear");
        HBox.setMargin(buttonClear, new Insets(0.0, 0.0, 0.0, 60.0));

        buttonHelp.setId("buttonHelp");
        buttonHelp.setMnemonicParsing(false);
        buttonHelp.setPrefWidth(56.0);
        buttonHelp.setText("Help");
        buttonHelp.setTextFill(javafx.scene.paint.Color.BLACK);
        HBox.setMargin(buttonHelp, new Insets(0.0, 0.0, 0.0, 190.0));
        borderpane.setRight(vBox3);

        vBox0.getChildren().add(labelKlas);
        vBox0.getChildren().add(labelVak);
        vBox0.getChildren().add(labelBeginTijd);
        vBox0.getChildren().add(labelEindtijd);
        hBox.getChildren().add(vBox0);
        vBox1.getChildren().add(textFieldKlas);
        vBox1.getChildren().add(textFieldVak);
        vBox1.getChildren().add(textFieldBegintijd);
        vBox1.getChildren().add(textFieldEindtijd);
        hBox.getChildren().add(vBox1);
        vBox.getChildren().add(hBox);
        vBox2.getChildren().add(separator);
        hBox0.getChildren().add(buttonChange);
        hBox0.getChildren().add(buttonOphalen);
        vBox2.getChildren().add(hBox0);
        hBox1.getChildren().add(buttonAdd);
        hBox1.getChildren().add(buttonOpslaan);
        vBox2.getChildren().add(hBox1);
        vBox.getChildren().add(vBox2);
        hBox2.getChildren().add(separator0);
        vBox4.getChildren().add(label8);
        vBox4.getChildren().add(label9);
        vBox4.getChildren().add(label10);
        vBox4.getChildren().add(Label11);
        vBox4.getChildren().add(label12);
        vBox4.getChildren().add(label13);
        vBox4.getChildren().add(label14);
        vBox4.getChildren().add(label15);
        vBox4.getChildren().add(label16);
        vBox4.getChildren().add(label17);
        vBox4.getChildren().add(label18);
        hBox2.getChildren().add(vBox4);
        hBox2.getChildren().add(textAreaOutputBox);
        vBox3.getChildren().add(hBox2);
        hBox3.getChildren().add(buttonClear);
        hBox3.getChildren().add(buttonHelp);
        vBox3.getChildren().add(hBox3);
        BorderPane pane = new BorderPane();

        pane.setLeft(vBox);
        pane.setRight(vBox3);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("School simulatie");
        stage.show();

        buttonOphalen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FilerName();
            }
        });
    }
    public  void add(){
        readInputBoxes();
        //displayRosterHour();
    }
    public void readInputBoxes(){
            String klas = textFieldKlas.getText();
            String vak = textFieldVak.getText();
            String beginTijd = textFieldBegintijd.getText();
            String eindTijd = textFieldEindtijd.getText();
            String rosterHour = beginTijd + "-" + eindTijd + "Lokaal: " + klas + "Vak: " + vak + "/n";
            textAreaOutputBox.setText(rosterHour);
    }

    public static void FilerName(){
        String fileName;
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("Open Resource File");
//                fileChooser.showOpenDialog(stage);



        FileChooser fileChooser = new FileChooser();
        //String userDirectoryString = System.getProperty("C:\\Users\\Levi Vlasblom\\Desktop\\schooltroep\\Avans Jaar 1\\1.3\\Proftaak-School\\Proftaak-1.3-School\\SimulatieProjectV_0.1\\Files");
        //File userDirectory = new File(userDirectoryString);
        //fileChooser.setInitialDirectory(userDirectory);
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            System.out.println("Found u my lord!");
            fileName = selectedFile.getName();
            System.out.println(fileName);

            String line = null;

            try {
                FileReader fileReader = new FileReader( "Files" +"\\" +fileName);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            }
            catch(IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");
            }
        }

    }
    public static void main(String[] args)
    {
        launch(Gui.class);
    }
}
