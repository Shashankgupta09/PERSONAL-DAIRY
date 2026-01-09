import java.util.*;

class DiaryEntry {
    private String date;
    private String note;

    public DiaryEntry(String date, String note) {
        this.date = date;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Date: " + date +
               "\nNote: " + note +
               "\n-------------------";
    }
}

public class PersonalDiary {

    private static ArrayList<DiaryEntry> diary = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n=== PERSONAL DIARY ===");
            System.out.println("1. Add Entry");
            System.out.println("2. View All Entries");
            System.out.println("3. Delete Entry");
            System.out.println("4. Search Entry by Date");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEntry();
                    break;

                case 2:
                    viewEntries();
                    break;

                case 3:
                    deleteEntry();
                    break;

                case 4:
                    searchEntry();
                    break;

                case 5:
                    System.out.println("Exiting Diary... Have a good day!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private static void addEntry() {
        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        diary.add(new DiaryEntry(date, note));
        System.out.println("Entry added successfully.");
    }

    private static void viewEntries() {
        if (diary.isEmpty()) {
            System.out.println("No entries found.");
            return;
        }

        System.out.println("\n--- All Diary Entries ---");
        for (DiaryEntry entry : diary) {
            System.out.println(entry);
        }
    }

    private static void deleteEntry() {
        System.out.print("Enter date of entry to delete (dd-mm-yyyy): ");
        String date = sc.nextLine();
        boolean found = false;

        Iterator<DiaryEntry> it = diary.iterator();
        while (it.hasNext()) {
            DiaryEntry entry = it.next();
            if (entry.getDate().equals(date)) {
                it.remove();
                found = true;
                System.out.println("Entry deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("No entry found for this date.");
        }
    }

    private static void searchEntry() {
        System.out.print("Enter date to search (dd-mm-yyyy): ");
        String date = sc.nextLine();
        boolean found = false;

        for (DiaryEntry entry : diary) {
            if (entry.getDate().equals(date)) {
                System.out.println("\n--- Entry Found ---");
                System.out.println(entry);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No entry found for this date.");
        }
    }
}
