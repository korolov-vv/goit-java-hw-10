import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

    public List<String> changed(List<String> list){
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
