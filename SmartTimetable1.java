public class SmartTimetable1 {

    
}lass SmartTimetable1 {

    static String subjects[] = {"Math", "Science", "English"};
    static String slots[] = {"9AM", "10AM", "11AM"};
    static String timetable[] = new String[3];

    // Backtracking function
    static boolean generate(int index) {

        if (index == subjects.length) {
            return true;
        }

        for (int i = 0; i < slots.length; i++) {

            if (timetable[i] == null) {
                timetable[i] = subjects[index];

                if (generate(index + 1)) {
                    return true;
                }

                // backtrack
                timetable[i] = null;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        if (generate(0)) {
            System.out.println("Generated Timetable:");

            for (int i = 0; i < slots.length; i++) {
                System.out.println(slots[i] + " -> " + timetable[i]);
            }

        } else {
            System.out.println("No valid timetable found");
        }
    }
}