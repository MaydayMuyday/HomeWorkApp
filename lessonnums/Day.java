package lessonnums;

public enum Day {
    Monday(8),
    Tuesday(8),
    Wednesday(8),
    Thursday(8),
    Friday(8),
    Saturday(0),
    Sunday(0);

    private int workHours;


    public int getWorkHours() {
        return workHours;
    }

    Day(int workHours) {
        this.workHours = workHours;
    }

    static int getCheckHours(Day day) {
        int result = day.getWorkHours();
        return result;
    }


     public static void getWorkingHours(Day day) {
        if (getCheckHours(day) == 0) {
//            return " today";
            System.out.println( "Сегодня выходной");
        }
        else {
            int result = 0;
            for (int i = day.ordinal(); i < Day.values().length; i++) {
                result += Day.getCheckHours(Day.values()[i]);
            }

            System.out.println("до конца рабочей недели " + result + " часов");

        }


    }
}