import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Base {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> textWords = new ArrayList<>();
        File file = new File("C:\\Users\\User\\IdeaProjects\\Collections\\src\\main\\java\\File.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String fileWord = scan.next();
            String fileWordWithOutPunct = fileWord.replaceAll("\\p{Punct}", "");
            if (fileWordWithOutPunct != "") textWords.add(fileWordWithOutPunct);
        }
        scan.close();
        Collections.sort(textWords);
        System.out.println(textWords);
        Map<String, Integer> count = textWords.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        count.forEach((k, v) -> System.out.println(k + ": " + v));
        int max = 0;
        for (int v : count.values()) {
            if (v > max) max = v;
        }
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println("Самое частовстречающееся слово: " +  entry.getKey());
                System.out.println("Встречается " + entry.getValue() + " раз");

            }
        }


    }
}

