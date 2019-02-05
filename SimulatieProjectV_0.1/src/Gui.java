import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application
{
    private Button button;
    private Button button0;
    private Button button1;
    private Button button2;
    private Separator separator;
    private Separator separator0;
    private HBox hBox;
    private VBox vBox;
    private Label label;
    private Label label0;
    private Label label1;
    private  Label label2;
    private  VBox vBox0;
    private  TextField textField;
    private  TextField textField0;
    private  TextField textField1;
    private  TextField textField2;
    private  Button button3;
    private Button button4;
    private HBox hBox0;
    private  VBox vBox1;
    private  Label label3;
    private  Label label4;
    private  Label label5;
    private  Label label6;
    private  Label label7;
    private  Label label8;
    private  Label label9;
    private  Label label10;
    private  Label label11;
    private  Label label12;
    private  Label label13;
    private  TextArea textArea;
    private  HBox hBox1;
    private  VBox vBox2;
    private HBox hBox2;
    private VBox vBox3;
    private HBox hBox3;
    private VBox vBox4;
    @Override
    public  void start(Stage stage)
    {
        vBox = new VBox();
        hBox = new HBox();
        vBox0 = new VBox();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        vBox1 = new VBox();
        textField = new TextField();
        textField0 = new TextField();
        textField1 = new TextField();
        textField2 = new TextField();
        vBox2 = new VBox();
        separator = new Separator();
        hBox0 = new HBox();
        button = new Button();
        button0 = new Button();
        hBox1 = new HBox();
        button1 = new Button();
        button2 = new Button();
        vBox3 = new VBox();
        hBox2 = new HBox();
        separator0 = new Separator();
        vBox4 = new VBox();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        label10 = new Label();
        label11 = new Label();
        label12 = new Label();
        label13 = new Label();
        textArea = new TextArea();
        hBox3 = new HBox();
        button3 = new Button();
        button4 = new Button();



        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setId("VBox");
        vBox.setLayoutX(25.0);
        vBox.setLayoutY(22.0);
        vBox.setSpacing(5.0);

        hBox.setPrefHeight(238.0);
        hBox.setPrefWidth(272.0);

        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);
        vBox0.setSpacing(15.0);

        label.setText("Klas");

        label0.setText("Vak");

        label1.setText("Begintijd");

        label2.setText("Eindtijd");

        vBox1.setPrefHeight(238.0);
        vBox1.setPrefWidth(158.0);
        vBox1.setSpacing(8.0);

        textField.setPrefWidth(200.0);

        textField0.setPrefWidth(200.0);

        textField1.setPrefWidth(148.0);

        textField2.setPrefWidth(158.0);

        vBox2.setPrefHeight(86.0);
        vBox2.setPrefWidth(269.0);

        separator.setPrefWidth(283.0);

        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(282.0);
        hBox0.setSpacing(30.0);

        button.setMnemonicParsing(false);
        button.setPrefHeight(35.0);
        button.setPrefWidth(123.0);
        button.setText("Change");

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(35.0);
        button0.setPrefWidth(123.0);
        button0.setText("Ophalen");

        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(282.0);
        hBox1.setSpacing(30.0);

        button1.setMnemonicParsing(false);
        button1.setPrefHeight(35.0);
        button1.setPrefWidth(123.0);
        button1.setText("Add");

        button2.setMnemonicParsing(false);
        button2.setPrefHeight(35.0);
        button2.setPrefWidth(123.0);
        button2.setText("Opslaan");

        vBox3.setLayoutX(297.0);
        vBox3.setLayoutY(14.0);
        vBox3.setPrefHeight(325.0);
        vBox3.setPrefWidth(295.0);

        hBox2.setMinHeight(325.0);
        hBox2.setPrefHeight(325.0);
        hBox2.setPrefWidth(283.0);

        separator0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator0.setPrefHeight(2.0);
        separator0.setPrefWidth(20.0);

        vBox4.setPrefHeight(324.0);
        vBox4.setPrefWidth(39.0);
        vBox4.setSpacing(14.0);

        label3.setText("08:00");

        label4.setText("09:00");

        label5.setText("10:00");

        label6.setText("11:00");

        label7.setText("12:00");

        label8.setText("13:00");

        label9.setText("14:00");

        label10.setText("15:00");

        label11.setText("16:00");

        label12.setText("17:00");

        label13.setText("18:00");

        textArea.setPrefHeight(325.0);
        textArea.setPrefWidth(259.0);
        textArea.setWrapText(true);

        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(200.0);

        button3.setMnemonicParsing(false);
        button3.setPrefHeight(35.0);
        button3.setPrefWidth(78.0);
        button3.setText("Clear");

        button4.setMnemonicParsing(false);
        button4.setPrefWidth(56.0);
        button4.setText("Help");
        button4.setTextFill(javafx.scene.paint.Color.BLACK);

        vBox0.getChildren().add(label);
        vBox0.getChildren().add(label0);
        vBox0.getChildren().add(label1);
        vBox0.getChildren().add(label2);
        hBox.getChildren().add(vBox0);
        vBox1.getChildren().add(textField);
        vBox1.getChildren().add(textField0);
        vBox1.getChildren().add(textField1);
        vBox1.getChildren().add(textField2);
        hBox.getChildren().add(vBox1);
        vBox.getChildren().add(hBox);
        vBox2.getChildren().add(separator);
        hBox0.getChildren().add(button);
        hBox0.getChildren().add(button0);
        vBox2.getChildren().add(hBox0);
        hBox1.getChildren().add(button1);
        hBox1.getChildren().add(button2);
        vBox2.getChildren().add(hBox1);
        vBox.getChildren().add(vBox2);

        hBox2.getChildren().add(separator0);
        vBox4.getChildren().add(label3);
        vBox4.getChildren().add(label4);
        vBox4.getChildren().add(label5);
        vBox4.getChildren().add(label6);
        vBox4.getChildren().add(label7);
        vBox4.getChildren().add(label8);
        vBox4.getChildren().add(label9);
        vBox4.getChildren().add(label10);
        vBox4.getChildren().add(label11);
        vBox4.getChildren().add(label12);
        vBox4.getChildren().add(label13);
        hBox2.getChildren().add(vBox4);
        hBox2.getChildren().add(textArea);
        vBox3.getChildren().add(hBox2);
        hBox3.getChildren().add(button3);
        hBox3.getChildren().add(button4);
        vBox3.getChildren().add(hBox3);

        BorderPane pane = new BorderPane();

        pane.setLeft(vBox);
        pane.setRight(vBox3);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("School simulatie");
        stage.show();
    }




    public static void main(String[] args)
    {
        launch(Gui.class);
    }

}
