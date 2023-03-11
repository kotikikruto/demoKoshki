package com.example.demokoshki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {

        cats.add(new CreateKoshka("Ева", "Короткошерстный", "Черный", "Голубой", "Тикированный", "Кошка"));
        cats.add(new CreateKoshka("Begemot", "1", "Green", "Yellow", "no", "Кот"));
        cats.add(new CreateKoshka("Adam", "1", "Gold", "Blue", "no", "Кот"));

        catBox.getItems().addAll(cats);

        sex.getItems().addAll(sexes);
        sex.setValue("                                                         ");
        fur.getItems().addAll(furs);
        fur.setValue("                                                         ");
        colourFur.getItems().addAll(coloursFur);
        colourFur.setValue("                                                        ");
        colourEye.getItems().addAll(coloursEye);
        colourEye.setValue("                                                         ");
        isStripped.getItems().addAll(stripped);
        isStripped.setValue("                                                         ");
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
                //Label secondLabel = new Label("Кошка: ");
                HBox secondaryLayout = new HBox();
                //secondaryLayout.getChildren().add(secondLabel);
                secondaryLayout.getChildren().add(textInfo);
                Scene secondScene = new Scene(secondaryLayout, 370, 60);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Кошка-инфа");
                newWindow.setScene(secondScene);

                // Specifies the modality for new window.
                newWindow.initModality(Modality.WINDOW_MODAL);

                // Specifies the owner Window (parent) for new window
                newWindow.initOwner(primaryStage);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);

                newWindow.show();

                CreateKoshka u = (CreateKoshka) catBox.getSelectionModel().getSelectedItem();
                if (u != null) {
                    textInfo.setText("   Имя: " + u.getName() + ", " + "Тип шерсти: " + u.getFur() + ", " + "  \n" + "   Окрас: " + u.getColourFur() + ", \n" + "   Цвет глаз: " + u.getColourEye() + ", " + "Полоски: " + u.getStripped() + ", " + "Пол: " + u.getGender());
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

    TextField name = new TextField("Горшок");

    final private int WIDTH = 350;
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

    public static void main(String[] args) {
        launch(args);
    }

}