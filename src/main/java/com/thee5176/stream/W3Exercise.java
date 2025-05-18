package com.thee5176.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class W3Exercise {
    public static void main(String[] args) {
        // 1: 平均計算
        List<Integer> findAverage = Arrays.asList(1,2,3,4,5,6,7,8,9);

//        int total = 0;
//        for(int num : findAverage){
//            total += num;
//        }
//        int avg = total/findAverage.size();
//        System.out.println("Average: " + avg);

        int streamSum = findAverage.stream().reduce(0, Integer::sum);
        int streamAvg = streamSum/findAverage.size();
        System.out.println("Stream Average: " + streamAvg);

        // 2: 名前の大文字/小文字変換
        //名・氏を分けて -> それぞれの1文字目を大文字に変えて -> スペースでjoin
        List<String> names = Arrays.asList("emma johnson", "liam smith", "olivia williams", "noah brown", "ava jones", "william garcia", "sophia miller", "benjamin davis", "isabella rodriguez", "mason martinez");

        Function<String, String> capitalizeFirstChar = name ->
                name.replaceFirst(
                        String.valueOf( name.charAt(0) ),
                        String.valueOf(Character.toUpperCase( name.charAt(0) ))
                );

        List<String> capitalizedName = names.stream()
                .map( namePart ->
                        // "name surname" -> ["name" "surname"] -> "Name Surname"
                        Arrays.stream(namePart.split(" "))
                                .map( capitalizeFirstChar )
                                .collect(Collectors.joining(" "))
                )
                .collect(Collectors.toList());

        System.out.println(capitalizedName);

        // 3: Stringの数字リストを偶数・奇数の合計算出
        List<String> randomStringNumber = Arrays.asList(
                "482", "175", "936", "643", "287", "521", "794", "358", "609", "124",
                "831", "456", "723", "189", "547", "302", "678", "915", "234", "761",
                "398", "845", "127", "569", "432", "876", "213", "654", "987", "341",
                "502", "719", "265", "843", "176", "429", "593", "812", "347", "658",
                "901", "236", "574", "319", "782", "405", "637", "128", "953", "260",
                "714", "385", "629", "142", "867", "503", "298", "671", "924", "135",
                "486", "753", "219", "592", "807", "364"
        );

        Function<String, Integer> formatToInteger = Integer::valueOf;

        Integer sumOddNumber = randomStringNumber.stream()
                                                .map( formatToInteger )
                                                .filter( num -> num % 2 == 1)
                                                .reduce(0, Integer::sum);
        System.out.println("奇数合計: " + sumOddNumber);

        Integer sumEvenNumber = randomStringNumber.stream()
                                                .map( formatToInteger )
                                                .filter( num -> num % 2 == 0)
                                                .reduce(0, Integer::sum);
        System.out.println("偶数合計: " + sumEvenNumber);

        // 4: 重複要素なしInteger生成
        Random random = new Random();

        List<Integer> integerData = IntStream.generate( () -> random.nextInt(16))
                                            .distinct()
                                            .limit(5)
                                            .boxed()
                                            .collect(Collectors.toList());
        System.out.println(integerData.toString());

        // 5: 第二最小値/最大値検出
        //データは練習３：randomStringNumber
        List<Integer> sortedIntegerData = randomStringNumber.stream()
                                                            .map(formatToInteger)
                                                            .sorted(Comparator.reverseOrder())
                                                            .collect(Collectors.toList());
        int length = sortedIntegerData.size();

        System.out.println("第二最小値：" + sortedIntegerData.get(length - 2));
        System.out.println("第二最大値：" + sortedIntegerData.get(1));

        // 6: 特定文字列で始まる要素のカウント
        //データは練習２：name
        //１文字目を取り出す　-> 回数を数える　
        Map<Character, Integer> countFirstAlphabet = new HashMap<>();
        names.stream().map( name -> name.charAt(0)).reduce()
                .forEach( c -> countFirstAlphabet.put(c,))
    }
}
