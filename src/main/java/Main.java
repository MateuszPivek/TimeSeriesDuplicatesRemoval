public class Main {

    public static void main(String[] args) {

       IOStreamer ioStreamReader = new IOStreamer();

        try {
            ioStreamReader.listen();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }
}
