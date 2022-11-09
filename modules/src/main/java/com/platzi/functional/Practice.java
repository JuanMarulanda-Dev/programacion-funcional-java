package com.platzi.functional;


import java.util.*;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(3);
        list.add("Red");
        list.add("Green");
        list.add("Orange");
        list.add("White");
        list.add("Black");

        List<String> list1 = new ArrayList<>();
        list1.add("Red");
        list1.add("Green");
        list1.add("Orange");
        list1.add("Black");

        //list.forEach(color -> System.out.println(color));

        //Collections.shuffle(list);
        //Collections.reverse(list);
        //list.subList(0, 3);
        //list.stream().map(color -> (list1.contains(color) ? "Yes" : "No")).forEach(System.out::println);
        //Collections.swap(list, 0, 2 );
        //list.addAll(list1);
        //List<String> list2 = (ArrayList<String>) list.clone();
        //list.removeAll(list);
        // list.isEmpty();


        //System.out.println("<---------------------->");


        //System.out.println("abc".endsWith("c"));

        /*int[] a = {3, 2, 5};
        int[] b = {1, 4, 4};

        IntBinaryOperator funcBinaryOperato = (x, y) -> x * y;
        int resultA = Arrays.stream(a).reduce(1, funcBinaryOperato);
        int resultB = Arrays.stream(b).reduce(1, funcBinaryOperato);
        int result = (resultA - resultB);
        System.out.println(result < 0 ? result * -1 : result);*/

        Integer num = 1234;

        //System.out.println(Integer.bitCount(num));

        //list.stream().forEach(System.out::println);

        //System.out.println(printDimon(1));

        //toCamelCase("The_Stealth_Warrior");
        //int arr[] = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        //System.out.println(find(arr));

        //System.out.println(sumDigPow(1,100).toString());

        //System.out.println(makeReadable(359999));

        //System.out.println(decode(" .    .   . "));
        //System.out.println("//wont won't won't".replaceAll("([^a-zA-Z0-9'])|(\\s{2,})", " "));
        //top3("").forEach(System.out::println);

        List<String> names = new ArrayList<>();
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Juan");
        names.add("Alejandro");
        names.add("David");
        names.add("Santiago");
        names.add("Hector");
        names.add("Luis");
        names.add("Lucas");
        names.add("Andres");

        //Map<String, Long> result = countRepeatNames(names);

        //System.out.println(result);

        //System.out.println(switcheroo("aaabcccbaaa"));

        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        //System.out.println(snail(array));

        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[] {"A", "B"};
        //System.out.println(stockSummary(art, cd));

        System.out.println((int)'a' - 4);
        //System.out.println(decode("6015ekx"));

    }

    public static String toCamelCase(String s){
        String words[] = s.split(s.contains("-") ? "-" : "_");
        //return Arrays.stream(words,3, words.length);
        return Arrays.stream(Arrays.copyOfRange(words,1, words.length)).reduce(words[0], (cadena, word) -> {
            return cadena + Character.toUpperCase(word.charAt(0)) + word.substring(1);
        });
    }

    public static int find(int[] integers) {
        // Since we are warned the array may be very large, we should avoid counting values any more than we need to.

        // We only need the first 3 integers to determine whether we are chasing odds or evens.
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
        int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
        int mod = (sum == 0 || sum == 1) ? 1 : 0;

        return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
                .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
    }

    public static String printDimon(int n) {
        //it's not valid
        if(n % 2 == 0 || n <= 0){
            return null;
        }

        return IntStream.range(0, n * 2)
                .filter(i -> i % 2 > 0)
                .map(i -> i > n ? n - (i - n) : i)
                .mapToObj(i -> " ".repeat((n - i) / 2) + "*".repeat(i) + "\n")
                .collect(Collectors.joining());
    }

    public static List<Long> sumDigPow(long a, long b){

       return LongStream.range(a, b + 1)
                .filter(num -> {
                    long result = 0;
                    String arr[] = String.valueOf(num).split("");
                    for (int i = 1; i <= arr.length; i++) {
                        result+= Math.pow(Long.parseLong(arr[i-1]), i);
                    }
                    return num == result;
                })
                .boxed()
                .collect(Collectors.toList());
    }

    public static String camelCase(String input){
        
        return input.replaceAll("([A-Z])", " $1");
    }

    public static String makeReadable(int seconds) {
        // Do something
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
    }

    public static String decodeMorse(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
       return Arrays.stream(morseCode.split("   ")).map(word -> {
           return Arrays.stream(word.trim().split(" "))
                   //.map(MorseCode::get)
                   .collect(Collectors.joining());
        }).collect(Collectors.joining(" "));
    }

    public static List<String> top3(String s) {
        // Your code here
        HashMap<String, Integer> words = new HashMap<>();

        Arrays.stream(
                s.toLowerCase()
                .replaceAll("([^a-zA-Z0-9'])|(\\s{2,})", " ")
                        .replaceAll("('){2,}", "'")
                .split(" ")
                )
                .forEach(word -> {
            String key = word.trim();
            if(!key.equals("") && !key.equals("'")){
                if (words.containsKey(key)) {
                    words.put(key, words.get(key) + 1);
                } else {
                    words.put(key, 1);
                }
            }
        });

        return words
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static Map<String, Long> countRepeatNames(List<String> names) {

        return names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //.entrySet().stream()
        //.collect(Collectors.toMap(x -> x.getKey(), y -> y.getValue().size()));

    }

    public static String switcheroo(String x) {
        return Arrays.stream(x.split("")).map((letter) -> {
            return letter.equals("a") ? "b" : (letter.equals("b") ? "a" : letter);
        }).collect(Collectors.joining());
    }

    public static int[] snail(int[][] array) {
        // enjoy
        int x = 0;
        int y = 0;
        int yLenght = array.length;
        int xLenght = array[0].length;
        int limit = 0;

        int[] result = new int[(yLenght * xLenght)];
        for (int i = 0; i < (yLenght * xLenght); i++) {



        }

        return result;
    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if(lstOfArt.length == 0){
            return "";
        }

        if(lstOf1stLetter.length == 0){
            return "";
        }

        return Arrays.stream(lstOf1stLetter).map((category) -> {
            Stream<String> books = Arrays.stream(lstOfArt);
            int booksAmount = books.filter(book -> book.substring(0, 1).equals(category))
                    .map(book -> Integer.parseInt(book.trim().split(" ")[1]))
                    .reduce(0, Integer::sum);
            return "(" + category + " : " + booksAmount + ")";
        }).collect(Collectors.joining(" - "));

    }

    public static String decode(String chain) {
        // decode "6015ekx" -> "mer"
        String chainNumber = chain.replaceAll("[a-z]", "");

        if(chainNumber.equals("")){
            return "Impossible to decode";
        }

        String chainOnlyLetters = chain.replaceAll("[0-9]", "");



        return null;
    }



}
