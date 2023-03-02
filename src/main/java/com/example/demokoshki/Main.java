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

//        cats.add(new CreateKoshka("Eva", "1", "Black", "Green", "tiki", "Кошка"));
//        cats.add(new CreateKoshka("Begemot", "1", "Green", "Yellow", "no", "Кот"));
//        cats.add(new CreateKoshka("Adam", "1", "Gold", "Blue", "no", "Кот"));

        catBox.getItems().addAll(cats);

        sex.getItems().addAll(sexes);
        fur.getItems().addAll(furs);
        colourFur.getItems().addAll(coloursFur);
        colourEye.getItems().addAll(coloursEye);
        isStripped.getItems().addAll(stripped);

        root.getChildren().add(strings);

        strings.setPadding(new Insets(10, 30, 10, 30));
        strings.setSpacing(20);

        strings.getChildren().add(new Text("Выберите кошку: "));
        strings.getChildren().add(buttonBox);
        strings.getChildren().add(new Text("Добавить кошку"));
        strings.getChildren().add(addCatBox);

        buttonBox.setSpacing(10);
        buttonBox.getChildren().add(catBox);
        buttonBox.getChildren().add(buttonGetInfo);
        buttonBox.getChildren().add(textInfo);

        addCatBox.setSpacing(10);
        addCatBox.getChildren().add(new Text("Имя: "));
        addCatBox.getChildren().add(name);
        addCatBox.getChildren().add(new Text("Окрас: "));
        addCatBox.getChildren().add(colourFur);
        addCatBox.getChildren().add(new Text("Цвет глаз: "));
        addCatBox.getChildren().add(colourEye);
        addCatBox.getChildren().add(new Text("Тип шерсти: "));
        addCatBox.getChildren().add(fur);
        addCatBox.getChildren().add(new Text("Полоски: "));
        addCatBox.getChildren().add(isStripped);
        addCatBox.getChildren().add(new Text("Пол: "));
        addCatBox.getChildren().add(sex);
        addCatBox.getChildren().add(buttonAddCat);

        buttonGetInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateKoshka u = (CreateKoshka) catBox.getSelectionModel().getSelectedItem();
                if (u != null) {
                    textInfo.setText("Имя: " + u.getName() + ", " + "Тип шерсти: " + u.getFur() + ", " + "Окрас: " + u.getColourFur() + ", " + "Цвет глаз: " + u.getColourEye() + ", " + "Полоски: " + u.getStripped() + ", " + "Пол: " + u.getGender());
                } else {
                    textInfo.setText("Кот не выбран");
                }
            }
        });
        buttonAddCat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateKoshka u = new CreateKoshka(name.getText(), fur.getSelectionModel().getSelectedItem().toString(), colourFur.getSelectionModel().getSelectedItem().toString(), colourEye.getSelectionModel().getSelectedItem().toString(), isStripped.getSelectionModel().getSelectedItem().toString(), sex.getSelectionModel().getSelectedItem().toString());
                cats.add(u);
                catBox.getItems().addAll(u);
                name.clear();
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
    ComboBox colourFur = new ComboBox();
    ComboBox colourEye = new ComboBox();
    ComboBox isStripped = new ComboBox();
    Button buttonGetInfo = new Button("Информация");
    Text textInfo = new Text();

    VBox addCatBox = new VBox();
    Button buttonAddCat = new Button("Добавить кота");
    TextField name = new TextField();

    final private int WIDTH = 1000;
    final private int HEIGHT = 600;

    private ArrayList<CreateKoshka> cats = new ArrayList<>();

    String[] sexes = new String[]{"Кот", "Кошка"};
    String[] furs = new String[]{"Короткошерстный", "Длинношерстный", "Без шерсти"};

    String[] coloursFur = new String[]{"Абрикосовый", "Абрикосовый с белыми пятнами",
            "Белый", "Голубой", "Голубой с белыми пятнами", "Карамельный",
            "Карамельный с белыми пятнами", "Коричневый", "Коричневый с белыми пятнами",
            "Кремовый", "Кремовый с белыми пятнами", "Лиловый", "Лиловый с белыми пятнами",
            "Рыжий", "Рыжий с белыми пятнами", "Фавн", "Фавн с белыми пятнами", "Циннамон",
            "Циннамон с белыми пятнами", "Черепаховый", "Черепаховый с белыми пятнами",
            "Черный", "Черный с белыми пятнами"
    };

    String[] coloursEye = new String[]{"Желтый", "Зеленый", "Карий", "Охра", "Светло-голубой",
            "Серый", "Синий", "Темно-голубой", "Желтый + Темно-голубой", "Зеленый + Синий",
            "Карий + Серый", "Охра + Светло-голубой"};

    String[] stripped = new String[]{"Тикированный", "Полосатый", "Мраморный", "Не полосатый"};




}
