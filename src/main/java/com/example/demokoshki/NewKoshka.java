package com.example.demokoshki;

public class NewKoshka  {

    void newKoshka(CreateKoshka koshka, CreateKoshka kot) {

        String koshkaGenome = koshka.getGenome();
        String kotGenome = kot.getGenome();


        int kittensCount = (int) (Math.random() * 5) + 3;

        for (int i = 1; i < kittensCount + 1; i++) {

            StringBuilder kittenGenome = new StringBuilder();

            for (int j = 0; j < koshkaGenome.length(); j = j + 2) {

                int a = (int) (Math.random() * 2);

                if (a == 0) {

                    kittenGenome.append(koshkaGenome.charAt(i));

                } else {

                    kittenGenome.append(koshkaGenome.charAt(i + 1));

                }

                int b = (int) (Math.random() * 2);

                if (b == 0) {

                    kittenGenome.append(kotGenome.charAt(i));

                } else {

                    kittenGenome.append(kotGenome.charAt(i + 1));

                }


            }

            //CreateKoshka kitten = new CreateKoshka(); TODO сделать так чтобы вместо принта
            // TODO создавался экземпляр класса
            // TODO ну и собственно чтобы в таблички добавлялся я хуз

        }


    }

}
