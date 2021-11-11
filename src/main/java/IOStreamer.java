import java.util.Scanner;

public class IOStreamer extends IOReader{

    @Override
    public String readRecord() {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        return inputValue;
    }

    @Override
    public void writeRecord(String output) {
        System.out.println(getLastRecord());
    }
}
