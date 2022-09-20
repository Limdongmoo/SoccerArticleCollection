import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoMatchDate extends Match{
    private String Date;
    private final String content = "경기 일정이 없습니다.";

    public NoMatchDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "NoMatchDate{" +
                "Date='" + Date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
