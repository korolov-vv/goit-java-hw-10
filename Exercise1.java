import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Exercise1 {


    public String filter(List<String> list){

        return list.stream()
                .filter(Objects::nonNull)
                .filter((name) -> list.indexOf(name) % 2 != 0)
                .map((name) -> list.indexOf(name) + ". " + name).collect(Collectors.joining(", ")).toString();
    }
}
