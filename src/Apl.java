public class Apl {

    public static void main(String[] args) {
        new Apl().run();
    }

    private void run() {

        try {
            Student student1 = new Student();
            student1.enroll();
            student1.payTuition();

            System.out.println(student1.toString());

        } catch (Exception E) {
            E.printStackTrace();
        }

    }
}
