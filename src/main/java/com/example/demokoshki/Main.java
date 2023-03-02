package com.example.demokoshki;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {

        cats.add(new CreateKoshka("Eva", "1", "Black", "Green", "tiki", "Кошка"));
        cats.add(new CreateKoshka("Begemot", "1", "Green", "Yellow", "no", "Кот"));
        cats.add(new CreateKoshka("Adam", "1", "Gold", "Blue", "no", "Кот"));

        catBox.getItems().addAll(cats);

        sex.getItems().addAll(sexes);
        fur.getItems().addAll(furs);

        root.getChildren().add(strings);

        strings.setPadding(new Insets(10, 30, 10, 30));
        strings.setSpacing(20);

        strings.getChildren().add(new Text("Select the cat"));
        strings.getChildren().add(buttonBox);
        strings.getChildren().add(new Text("Add new cat"));
        strings.getChildren().add(addCatBox);

        buttonBox.setSpacing(10);
        buttonBox.getChildren().add(catBox);
        buttonBox.getChildren().add(buttonGetInfo);
        buttonBox.getChildren().add(textInfo);

        addCatBox.setSpacing(10);
        addCatBox.getChildren().add(new Text("Имя: "));
        addCatBox.getChildren().add(name);
        addCatBox.getChildren().add(new Text("ColourFur: "));
        addCatBox.getChildren().add(ColourFur);
        addCatBox.getChildren().add(new Text("ColourEye: "));
        addCatBox.getChildren().add(ColourEye);
        addCatBox.getChildren().add(new Text("Fur: "));
        addCatBox.getChildren().add(fur);
        addCatBox.getChildren().add(new Text("Stripped: "));
        addCatBox.getChildren().add(stripped);
        addCatBox.getChildren().add(new Text("Пол: "));
        addCatBox.getChildren().add(sex);
        addCatBox.getChildren().add(buttonAddCat);

        buttonGetInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateKoshka u = (CreateKoshka) catBox.getSelectionModel().getSelectedItem();
                if (u != null) {
                    textInfo.setText("Имя: " + u.getName() + ", " +
                            "Тип шерсти: " + u.getFur() + ", " +
                            "Окрас: " + u.getColourFur() + ", " +
                            "Цвет глаз: " + u.getColourEye() + ", " +
                            "Полоски: " + u.getStripped() + ", " +
                            "Sex: " + u.getGender());
                } else {
                    textInfo.setText("Cat not selected");
                }
            }
        });
        buttonAddCat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateKoshka u = new CreateKoshka(name.getText(), fur.getSelectionModel().getSelectedItem().toString(), ColourFur.getText(),
                        ColourEye.getText(), stripped.getText(), sex.getSelectionModel().getSelectedItem().toString());
                cats.add(u);
                catBox.getItems().addAll(u);
                name.clear();
                ColourFur.clear();
                ColourEye.clear();
            }
        });

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Cat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    Group root = new Group();

    VBox strings = new VBox();

    HBox buttonBox = new HBox();
    ComboBox<CreateKoshka> catBox = new ComboBox<>();
    ComboBox sex = new ComboBox();
    ComboBox fur = new ComboBox();
    Button buttonGetInfo = new Button("Info");
    Text textInfo = new Text();

    VBox addCatBox = new VBox();
    Button buttonAddCat = new Button("Add Cat");
    TextField name = new TextField();
    TextField ColourFur = new TextField();
    TextField ColourEye = new TextField();
    TextField stripped = new TextField();

    final private int WIDTH = 1000;
    final private int HEIGHT = 600;

    private ArrayList<CreateKoshka> cats = new ArrayList<>();

    String[] sexes = new String[] {"Кот", "Кошка"};
    String[] furs = new String[] {"Короткошерстный", "Длинношерстный", "Без шерсти"};

    String[] coloursFur = new String[] {"", ""};


}
