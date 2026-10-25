import java.time.LocalDate;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int startAlice = LocalDate.parse("2023-" + arriveAlice).getDayOfYear();
        int endAlice = LocalDate.parse("2023-" + leaveAlice).getDayOfYear();
        int startBob = LocalDate.parse("2023-" + arriveBob).getDayOfYear();
        int endBob = LocalDate.parse("2023-" + leaveBob).getDayOfYear();

        int start = Math.max(startAlice, startBob);
        int end = Math.min(endAlice, endBob);

        return Math.max(0, end - start + 1);
    }
}