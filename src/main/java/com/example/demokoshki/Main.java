package com.example.demokoshki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;

public class Main extends Application {

    String newKoshka(CreateKoshka koshka, CreateKoshka kot) {

        String koshkaGenome = koshka.getGenome();
        String kotGenome = kot.getGenome();


        StringBuilder kittenGenome = new StringBuilder();

        for (int j = 0; j < koshkaGenome.length(); j = j + 2) {

            int a = (int) (Math.random() * 2);

            if (a == 0) {

                kittenGenome.append(koshkaGenome.charAt(j));
            } else {

                kittenGenome.append(koshkaGenome.charAt(j + 1));

            }

            int b = (int) (Math.random() * 2);

            if (b == 0) {

                kittenGenome.append(kotGenome.charAt(j));

            } else {

                kittenGenome.append(kotGenome.charAt(j + 1));

            }

        }

        StringBuilder goodKittenGenome = new StringBuilder();
        ArrayList<String> anotherKittenGenome = new ArrayList<>();

        for (int j = 0; j < kittenGenome.length(); j = j + 2) {

            if (((kittenGenome.charAt(j) > kittenGenome.charAt(j + 1)) && kittenGenome.toString().charAt(j + 1) != '-') || (kittenGenome.toString().charAt(j) == '-')) {

                goodKittenGenome.append(kittenGenome.toString().charAt(j + 1));
                goodKittenGenome.append(kittenGenome.toString().charAt(j));

            } else {

                goodKittenGenome.append(kittenGenome.toString().charAt(j));
                goodKittenGenome.append(kittenGenome.toString().charAt(j + 1));

            }

            if ((j == 10) || (j == 14) || (j == 18) || (j == 22)) {

                anotherKittenGenome.add(goodKittenGenome.toString());
                goodKittenGenome.delete(0, goodKittenGenome.length()); //Если тут будет ошибка это значит что надо вычесть один из гудкитенгеном.ленс

            }
        }

        return goodKittenGenome.toString();
    }

    public void start(Stage primaryStage) throws Exception {

        cats.add(new CreateKoshka("Ева", "Короткошерстный", "Черный", "Голубой", "Тикированный", "Кошка"));
        cats.add(new CreateKoshka("Begemot", "1", "Green", "Yellow", "no", "Кот"));
        cats.add(new CreateKoshka("Adam", "1", "Gold", "Blue", "no", "Кот"));

        CreateKoshka Asya = new CreateKoshka("Asya", "1", "Gold", "Blue", "no", "Кошка", "aabbccddff");
        CreateKoshka Slava = new CreateKoshka("Slava", "1", "Gold", "Blue", "no", "Кот", "AABBCCDD--");
        catsBox.getItems().addAll(cats);


        ArrayList<CreateKoshka> cat = new ArrayList<>();

        ArrayList<CreateKoshka> caty = new ArrayList<>();

        for (CreateKoshka test : cats) {
            if (test.gender == "Кот") {
                cat.add(test);
            }
        }

        for (CreateKoshka test : cats) {
            if (test.gender == "Кошка") {
                caty.add(test);
            }
        }


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
        buttonBox.getChildren().add(catsBox);
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
        addCatBox.getChildren().add(buttonCrossCat);

        buttonGetInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                HBox secondaryLayout = new HBox();
                secondaryLayout.getChildren().add(textInfo);
                Scene secondScene = new Scene(secondaryLayout, 370, 60);

                Stage newWindow1 = new Stage();
                newWindow1.setTitle("Кошка-инфа");
                newWindow1.setScene(secondScene);

                newWindow1.initModality(Modality.WINDOW_MODAL);

                newWindow1.initOwner(primaryStage);

                newWindow1.setX(primaryStage.getX() + 200);
                newWindow1.setY(primaryStage.getY() + 100);

                newWindow1.show();

                CreateKoshka u = (CreateKoshka) catsBox.getSelectionModel().getSelectedItem();
                if (u != null) {
                    textInfo.setText("   Имя: " + u.getName() + ", " + "Тип шерсти: " + u.getFur() + ", " + "  \n" + "   Окрас: " + u.getColourFur() + ", \n" + "   Цвет глаз: " + u.getColourEye() + ", " + "Полоски: " + u.getStripped() + ", " + "Пол: " + u.getGender());
                } else {
                    textInfo.setText(newKoshka(Asya, Slava));
                    //textInfo.setText("Кот не выбран");
                }
            }
        });
        buttonAddCat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateKoshka A = new CreateKoshka(name.getText(), fur.getSelectionModel().getSelectedItem().toString(), colourFur.getSelectionModel().getSelectedItem().toString(), colourEye.getSelectionModel().getSelectedItem().toString(), isStripped.getSelectionModel().getSelectedItem().toString(), sex.getSelectionModel().getSelectedItem().toString());
                cats.add(A);
                catsBox.getItems().addAll(A);
                for (CreateKoshka test : cats) {
                    if (test.gender == "Кот") {
                        cat.add(test);
                    }
                }

                for (CreateKoshka test : cats) {
                    if (test.gender == "Кошка") {
                        caty.add(test);
                    }
                }
                name.clear();
            }
        });
        buttonCrossCat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                HBox thirdLayout = new HBox();
                VBox catLayout = new VBox();
                VBox catyLayout = new VBox();
                VBox kittenLayout = new VBox();

                //thirdLayout.getChildren().add(textInfo);
                Scene thirdScene = new Scene(thirdLayout, 300, 300);
                Stage newWindow2 = new Stage();
                newWindow2.setTitle("Получатель котиков");
                newWindow2.setScene(thirdScene);
                newWindow2.initModality(Modality.WINDOW_MODAL);
                newWindow2.initOwner(primaryStage);
                newWindow2.setX(primaryStage.getX() + 200);
                newWindow2.setY(primaryStage.getY() + 100);

                thirdLayout.getChildren().add(catLayout);
                thirdLayout.getChildren().add(catyLayout);
                thirdLayout.getChildren().add(kittenLayout);

                Button buttonNewCat = new Button("Скрестить котов");

                TextField kittenName = new TextField();
                ComboBox<CreateKoshka> catBox = new ComboBox<>();
                ComboBox<CreateKoshka> catyBox = new ComboBox<>();
                catLayout.getChildren().add(new Text("Коты:"));
                catLayout.getChildren().add(catBox);
                catLayout.setSpacing(30);

                catBox.getItems().addAll(cat);
                catyLayout.getChildren().add(new Text("Кошки:"));
                catyLayout.getChildren().add(catyBox);
                catyLayout.setSpacing(30);
                catyBox.getItems().addAll(caty);
                kittenLayout.getChildren().add(kittenName);
                kittenLayout.getChildren().add(buttonNewCat);

                newWindow2.show();
//                buttonNewCat.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent e) {
//                        //CreateKoshka u = new NewKoshka(catBox.getSelectionModel().getSelectedItem(), catyBox.getSelectionModel().getSelectedItem(), kittenName.getText());
//                        CreateKoshka u = new NewKoshka(, kittenName.getText());
//                        cats.add(u);
//                        catsBox.getItems().addAll(u);
//                        name.clear();
//                    }
//                });
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
    ComboBox<CreateKoshka> catsBox = new ComboBox<>();
    ComboBox sex = new ComboBox();

    ComboBox fur = new ComboBox();
    ComboBox colourFur = new ComboBox();
    ComboBox colourEye = new ComboBox();
    ComboBox isStripped = new ComboBox();
    Button buttonGetInfo = new Button("Информация");
    Text textInfo = new Text();

    VBox addCatBox = new VBox();
    Button buttonAddCat = new Button("Добавить кота");
    Button buttonCrossCat = new Button("Скрестить кота");
    TextField name = new TextField("Горшок");

    final private int WIDTH = 350;
    final private int HEIGHT = 600;

    public ArrayList<CreateKoshka> cats = new ArrayList<>();


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