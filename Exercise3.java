import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Exercise3 {

    public void sortNumbers(String[] numbers){

        System.out.println(Arrays.stream(numbers)
                .flatMap((s) -> Arrays.stream(s.split(", "))
                        .map(Integer::parseInt))
                .sorted(Comparator.naturalOrder())
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }
}
