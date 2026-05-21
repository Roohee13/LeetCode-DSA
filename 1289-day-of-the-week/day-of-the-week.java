import java.time.LocalDate;
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] days = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        LocalDate date = LocalDate.of(year, month, day);

        return days[date.getDayOfWeek().getValue() % 7];
    }
}