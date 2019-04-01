import Maploader.MapDemo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Gui extends Application {

    private ObservableList<RosterHours> obr;
    private ObservableList<Teacher> obt;
    private ObservableList<String> obl;
    private ObservableList<String> obv;
    private ObservableList<String> obk;
    private ObservableList<String> obbM;
    private ObservableList<String> obbH;
    private ArrayList<String> minutes;
    private ArrayList<String> hours;
    private ArrayList<String> vakken;
    private ArrayList<String> lokalen;
    private ArrayList<String> klassen;
    private ComboBox comboBoxTeacher;
    private TabPane tabPane;
    private  VBox vBox;
    private  HBox hBox;
    private  VBox vBoxTime;
    private  VBox vBox0;
    private VBox vBoxBtn;
    private  Label labelKlas;
    private  Label labelVak;
    private  Label labelBeginTijd;
    private  Label labelEindtijd;
    private  Label labelDocent;
    private  Label labelLokaal;
    private Label labelJson;
    private  VBox vBox1;
    private  TextField textFieldKlas;
    private ComboBox comboBoxKlas;
    private  TextField textFieldVak;
    private ComboBox comboBoxVak;
    private  TextField textFieldBegintijd;
    private ComboBox comboBoxBTijd;
    private ComboBox comboBoxHoursB;
    private ComboBox comboboxMinutesB;
    private ComboBox comboBoxHoursE;
    private ComboBox comboboxMinutesE;
    private  TextField textFieldEindtijd;
    private ComboBox comboBoxETijd;
    private  TextField textFieldDocent;
    private  TextField textFieldLokaal;
    private ComboBox comboBoxLokaal;
    private  VBox vBox2;
    private  Separator separator;
    private HBox hBox0;
    private  Button buttonChange;
    private Button buttonOphalen;
    private HBox hBox1;
    private Button buttonAdd;
    private Button buttonOpslaan;
    private Button btnMapPicker;
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
    private TableView<RosterHours> tableViewRoster;
    private HBox hBox3;
    private Button buttonClear;
    private Button buttonHelp;
    private BorderPane borderpane;
    private Label labelteacher;
    private Tab roosterTab;
    private Tab simulationTab;
    private HBox hboxBtn;
    private VBox vBoxMap;
    private Button btnSimulate;

    @Override
    public void start(Stage stage) {
        vakken = new ArrayList<>();
        lokalen = new ArrayList<>();
        klassen = new ArrayList<>();
        minutes = new ArrayList<>();
        hours = new ArrayList<>();

        obr = FXCollections.observableList(new ArrayList<RosterHours>());
        obt = FXCollections.observableList(new ArrayList<Teacher>());
        obbH = FXCollections.observableList(hours);
        obbM = FXCollections.observableList(minutes);
        obl = FXCollections.observableList(lokalen);
        obk = FXCollections.observableList(klassen);
        obv = FXCollections.observableList(vakken);

        tabPane = new TabPane();
        simulationTab = new Tab("Simulation");
        roosterTab = new Tab("Roster");
        tabPane.getTabs().add(roosterTab);
        tabPane.getTabs().add(simulationTab);


        for (int i = 0; i < 24; i++){
            if (i > 9){
                hours.add("" + i);
            }
            else{
                hours.add("0" + i );
            }

        }

        for (int i = 0; i < 60; i++){
            if (i > 9){
                minutes.add("" + i);
            }else{
                minutes.add("0" + i);
            }

        }

        hboxBtn = new HBox();
        labelJson = new Label();
        vakken.add("OGP");
        vakken.add("P&OC");
        vakken.add("2DGraphics");
        vakken.add("Senior");
        vakken.add("OOM");
        lokalen.add("LA001");
        lokalen.add("LA002");
        lokalen.add("LA003");
        lokalen.add("LA004");
        lokalen.add("LA005");
        lokalen.add("LA101");
        lokalen.add("LA102");
        lokalen.add("LA103");
        lokalen.add("LA104");
        klassen.add("A");
        klassen.add("B");
        klassen.add("C");


        btnSimulate = new Button();
        comboBoxTeacher = new ComboBox(obt);
        labelteacher = new Label();
        borderpane = new BorderPane();
        vBox = new VBox();
        hBox = new HBox();
        vBoxTime = new VBox();
        vBox0 = new VBox();
        vBoxMap = new VBox();
        labelKlas = new Label();
        labelVak = new Label();
        labelBeginTijd = new Label();
        labelEindtijd = new Label();
        labelDocent = new Label();
        labelLokaal = new Label();
        vBox1 = new VBox();
        textFieldKlas = new TextField();
        comboBoxKlas = new ComboBox();
        textFieldVak = new TextField();
        comboBoxVak = new ComboBox();
        btnMapPicker = new Button();
        textFieldBegintijd = new TextField();
        vBoxBtn = new VBox();
        comboBoxBTijd = new ComboBox();
        textFieldEindtijd = new TextField();
        comboBoxETijd = new ComboBox();
        comboBoxHoursB = new ComboBox();
        comboboxMinutesB = new ComboBox();
        comboboxMinutesE = new ComboBox();
        comboBoxHoursE = new ComboBox();
        textFieldDocent = new TextField();
        textFieldLokaal = new TextField();
        comboBoxLokaal = new ComboBox();
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
        tableViewRoster = new TableView<RosterHours>();
        TableColumn<RosterHours, String> klasCol //
                = new TableColumn<RosterHours, String>("Klas");
        TableColumn<RosterHours, String> vakCol //
                = new TableColumn<RosterHours, String>("Vak");
        TableColumn<RosterHours, String> leraarCol //
                = new TableColumn<RosterHours, String>("Leraar");
        TableColumn<RosterHours, String> lokaalCol //
                = new TableColumn<RosterHours, String>("Lokaal");
        TableColumn<RosterHours, String> tijdCol //
                = new TableColumn<RosterHours, String>("Tijd");
        TableColumn<RosterHours, String> begTijdCol //
                = new TableColumn<RosterHours, String>("Start Tijd");
        TableColumn<RosterHours, String> eindTijdCol //
                = new TableColumn<RosterHours, String>("Eind Tijd");
        tijdCol.getColumns().addAll(begTijdCol, eindTijdCol);

        tableViewRoster.getColumns().addAll(klasCol, vakCol, leraarCol, lokaalCol, tijdCol);

        klasCol.setCellValueFactory(new PropertyValueFactory<>("schoolClass"));
        vakCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        leraarCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        lokaalCol.setCellValueFactory(new PropertyValueFactory<>("classroom"));
        begTijdCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        eindTijdCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        hBox3 = new HBox();
        buttonClear = new Button();
        buttonHelp = new Button();

        borderpane.setPrefHeight(694.0);
        borderpane.setPrefWidth(750.0);
        borderpane.setRotate(0.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setId("VBox");
        vBox.setPrefHeight(674.0);
        vBox.setPrefWidth(390.0);
        vBox.setSpacing(5.0);

        hBox.setPrefHeight(503.0);
        hBox.setPrefWidth(309.0);
        hBox.setSpacing(10.0);

        vBoxTime.setPrefHeight(238.0);
        vBoxTime.setPrefWidth(92.0);
        vBoxTime.setSpacing(17.0);

        vBoxBtn.setPrefHeight(238.0);
        vBoxBtn.setPrefWidth(92.0);
        vBoxBtn.setSpacing(17.0);

        vBox0.setPrefHeight(238.0);
        vBox0.setPrefWidth(92.0);
        vBox0.setSpacing(27.0);

        labelKlas.setId("labelKlas");
        labelKlas.setPrefHeight(22.0);
        labelKlas.setPrefWidth(56.0);
        labelKlas.setText("Klas");

        labelVak.setId("labelVak");
        labelVak.setPrefHeight(22.0);
        labelVak.setPrefWidth(56.0);
        labelVak.setText("Vak");

        labelBeginTijd.setId("labelBegintijd");
        labelBeginTijd.setPrefHeight(22.0);
        labelBeginTijd.setPrefWidth(100.0);
        labelBeginTijd.setText("Begintijd");

        labelEindtijd.setId("labelEindtijd");
        labelEindtijd.setPrefHeight(22.0);
        labelEindtijd.setPrefWidth(100.0);
        labelEindtijd.setText("Eindtijd");

        labelDocent.setId("labelDocent");
        labelDocent.setPrefHeight(22.0);
        labelDocent.setPrefWidth(120.0);
        labelDocent.setText("Docent");

        labelLokaal.setId("labelLokaal");
        labelLokaal.setPrefHeight(22.0);
        labelLokaal.setPrefWidth(100.0);
        labelLokaal.setText("Lokaal");

        vBox1.setPrefHeight(238.0);
        vBox1.setPrefWidth(158.0);
        vBox1.setSpacing(16.0);

//        textFieldKlas.setId("textFieldKlas");
//        textFieldKlas.setPrefWidth(200.0);
        comboBoxKlas.setId("comboBox");
        comboBoxKlas.setPrefWidth(158.0);
//
//        textFieldVak.setId("textFieldVak");
//        textFieldVak.setPrefWidth(200.0);
        comboBoxVak.setId("comboBox");
        comboBoxVak.setPrefWidth(158.0);
//
//        textFieldBegintijd.setId("textFieldBegintijd");
//        textFieldBegintijd.setPrefWidth(148.0);
        comboboxMinutesB.setId("comboBox");
        comboboxMinutesB.setPrefWidth(70.0);
//
//        textFieldEindtijd.setId("textFieldEindtijd");
//        textFieldEindtijd.setPrefWidth(158.0);
        comboboxMinutesE.setId("comboBox");
        comboboxMinutesE.setPrefWidth(70.0);

        comboBoxHoursE.setId("comboBox");
        comboBoxHoursE.setPrefWidth(70.0);

        comboBoxHoursB.setId("comboBox");
        comboBoxHoursB.setPrefWidth(70.0);

        //textFieldDocent.setId("textFieldDocent");
        //textFieldDocent.setPrefWidth(158.0);

        comboBoxTeacher.setId("comboBox");
        comboBoxTeacher.setPrefWidth(158.0);

//        textFieldLokaal.setId("textFieldLokaal");
//        textFieldLokaal.setPrefWidth(158.0);
        comboBoxLokaal.setId("comboBox");
        comboBoxLokaal.setPrefWidth(158.0);

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

        btnMapPicker.setId("btnMapPicker");
        btnMapPicker.setMnemonicParsing(false);
        btnMapPicker.setPrefHeight(62.0);
        btnMapPicker.setPrefWidth(214.0);
        btnMapPicker.setText("Choose JSON File");

        btnSimulate.setId("btnSimulatie");
        btnSimulate.setMnemonicParsing(false);
        btnSimulate.setPrefWidth(214.0);
        btnSimulate.setText("Run Simulation");

        vBox3.setPrefHeight(674.0);
        vBox3.setPrefWidth(760.0);

        hBox2.setMinHeight(325.0);
        hBox2.setPrefHeight(650.0);
        hBox2.setPrefWidth(495.0);

        separator0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator0.setPrefHeight(2.0);
        separator0.setPrefWidth(40.0);

        vBox4.setPrefHeight(324.0);
        vBox4.setPrefWidth(39.0);
        vBox4.setSpacing(40.0);

        vBoxMap.setPrefHeight(324.0);
        vBoxMap.setPrefWidth(39.0);
        vBoxMap.setSpacing(40.0);

        labelJson.setText("Json File : ");
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

        tableViewRoster.setId("textAreaOutputBox");
        tableViewRoster.setPrefHeight(612.0);
        tableViewRoster.setPrefWidth(500.0);
        //textAreaOutputBox.setWrapText(true);

        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(500.0);

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

        vBox0.getChildren().add(labelBeginTijd);
        vBox0.getChildren().add(labelEindtijd);
        vBox0.getChildren().add(labelKlas);
        vBox0.getChildren().add(labelVak);
        vBox0.getChildren().add(labelDocent);
        vBox0.getChildren().add(labelLokaal);
        hBox.getChildren().add(vBox0);
        vBox1.getChildren().add(comboBoxHoursB);
        vBox1.getChildren().add(comboBoxHoursE);
        vBoxTime.getChildren().add(comboboxMinutesB);
        vBoxTime.getChildren().add(comboboxMinutesE);
        vBox1.getChildren().add(comboBoxKlas);
        vBox1.getChildren().add(comboBoxVak);
        vBox1.getChildren().add(comboBoxTeacher);
        vBox1.getChildren().add(comboBoxLokaal);

        vBoxMap.getChildren().add(btnMapPicker);
        vBoxMap.getChildren().add(labelJson);
        vBoxMap.getChildren().add(btnSimulate);

        hBox.getChildren().add(vBox1);
        hBox.getChildren().add(vBoxTime);
        vBox.getChildren().add(hBox);
        vBox2.getChildren().add(separator);
        hBox0.getChildren().add(buttonChange);
        hBox0.getChildren().add(buttonOphalen);
        vBox2.getChildren().add(hBox0);
        hBox1.getChildren().add(buttonAdd);
        hBox1.getChildren().add(buttonOpslaan);
        hBox.getChildren().add(vBoxBtn);
        vBoxBtn.getChildren().add(buttonChange);
        vBoxBtn.getChildren().add(buttonAdd);
        vBoxBtn.getChildren().add(buttonOphalen);
        vBoxBtn.getChildren().add(buttonOpslaan);
        vBox2.getChildren().add(hBox1);
        vBox.getChildren().add(vBox2);
        hBox2.getChildren().add(separator0);
        hBox2.getChildren().add(tableViewRoster);
        vBox3.getChildren().add(hBox2);
        hBox3.getChildren().add(buttonClear);
        hBox3.getChildren().add(buttonHelp);
        vBox3.getChildren().add(hBox3);

        //startup Methoden
        listTeachers();
        standardRoster();
        tableViewRoster.setItems(obr);
        comboBoxTeacher.setItems(obt);
        comboBoxLokaal.setItems(obl);
        comboBoxVak.setItems(obv);
        comboBoxKlas.setItems(obk);
        comboBoxHoursB.setItems(obbH);
        comboBoxHoursE.setItems(obbH);
        comboboxMinutesB.setItems(obbM);
        comboboxMinutesE.setItems(obbM);
        BorderPane pane = new BorderPane();
        roosterTab.setContent(vBox);
        simulationTab.setContent(vBoxMap);



        pane.setLeft(tabPane);
        pane.setRight(vBox3);
        Scene scene = new Scene(pane, 1050, 694.0);
        stage.setScene(scene);
        stage.setTitle("Rooster Simulatie");
        stage.show();

        buttonOphalen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FilerName();
                tableViewRoster.setItems(obr);
            }
        });

        btnMapPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JsonPicker();
            }
        });

        btnSimulate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RunSimulation();
            }
        });

        buttonClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tableViewRoster.getItems().clear();
            }
        });

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                readInputBoxes();
            }
        });
        buttonOpslaan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RosterHours.saveRosterHours(obr);
            }
        });

        buttonHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Press ophalen om een bestand te selecteren en roosters te vormen.\nDruk op Add om een nieuw roosteruur in the voegen. \nDruk op clear om het rooster te clearen. \n                                       ©B1 Avans Breda", "HELP", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }

    public void standardRoster(){
        Roster roster = new Roster();
        roster.readRosterHours("StockHours.txt");
        obr = FXCollections.observableList(roster.getPeriod());
    }

    public void listTeachers(){
        Teacher teacher = new Teacher();
        teacher.readTeachers("Docenten.txt");
        obt = FXCollections.observableList(teacher.getTeacher());
    }

    public void readInputBoxes(){

        if (validation() == true) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String beginTijd = comboBoxHoursB.getValue().toString() + ":" + comboboxMinutesB.getValue().toString();
            String eindTijd = comboBoxHoursE.getValue().toString() + ":" + comboboxMinutesE.getValue().toString();

            LocalTime beginTijdL = LocalTime.parse(beginTijd, formatter);
            LocalTime eindTijdL = LocalTime.parse(eindTijd, formatter);

            String klas = comboBoxKlas.getValue().toString();
            String vak = comboBoxVak.getValue().toString();
            String docent = comboBoxTeacher.getValue().toString();
            String lokaal = comboBoxLokaal.getValue().toString();

            if (validationClass(klas, beginTijdL, eindTijdL) == true) {
                Alert fail= new Alert(Alert.AlertType.WARNING);
                fail.setHeaderText("failure");
                fail.setContentText("Time is already occupied");
                fail.showAndWait();
                return;
            }

            obr.add(new RosterHours(new Subject(vak), new Class(klas), beginTijdL, eindTijdL, new Teacher(docent), new Classroom(lokaal)));

            comboBoxHoursE.getSelectionModel().clearSelection();
            comboBoxHoursB.getSelectionModel().clearSelection();
            comboboxMinutesE.getSelectionModel().clearSelection();
            comboboxMinutesB.getSelectionModel().clearSelection();
            comboBoxKlas.getSelectionModel().clearSelection();
            comboBoxVak.getSelectionModel().clearSelection();
            comboBoxBTijd.getSelectionModel().clearSelection();
            comboBoxETijd.getSelectionModel().clearSelection();
            comboBoxLokaal.getSelectionModel().clearSelection();
            comboBoxTeacher.getSelectionModel().clearSelection();

        }
    }

    public boolean validation(){
        if (comboBoxHoursB.getSelectionModel().isEmpty() ||
                comboBoxHoursE.getSelectionModel().isEmpty()||
                comboBoxKlas.getSelectionModel().isEmpty() ||
                comboBoxVak.getSelectionModel().isEmpty()||
                comboBoxLokaal.getSelectionModel().isEmpty()||
                comboBoxTeacher.getSelectionModel().isEmpty() ||
                comboboxMinutesB.getSelectionModel().isEmpty() ||
                comboboxMinutesE.getSelectionModel().isEmpty()) {
            Alert fail= new Alert(Alert.AlertType.WARNING);
            fail.setHeaderText("failure");
            fail.setContentText("One or more fields are empty!");
            fail.showAndWait();

            return false ;
        }
        return true;
    }

    public boolean validationClass(String schoolClass, LocalTime startTime, LocalTime endTime){
        for (RosterHours listRoster :obr) {
            if (listRoster.getSchoolClass().getName().equals(schoolClass)) {
                if (listRoster.getStartTime().isAfter(startTime) && listRoster.getStartTime().isBefore(endTime)||
                        listRoster.getEndTime().isAfter(startTime) && listRoster.getEndTime().isBefore(endTime)||
                        listRoster.getEndTime().isAfter(endTime) && listRoster.getStartTime().isBefore(startTime)){
                    return true;
                }
            }
        }
        return false;
    }

    public void FilerName(){

        Roster r = new Roster(null, false);
        r.openFile();

        obr = FXCollections.observableList(r.getPeriod());
        System.out.println("Rooster Text I/O: " + r.toString());
    }

    public void JsonPicker(){
        MapDemo md = new MapDemo();
        String fileName = md.MapOpener();
        labelJson.setText("Json File : " + fileName );
    }

    public void RunSimulation(){
        MapDemo md = new MapDemo();
        md.init();
    }


    public static void main(String[] args)
    {
        launch(Gui.class);
    }
}
