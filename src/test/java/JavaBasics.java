import org.junit.jupiter.api.Test;

public class JavaBasics {
    @Test
    public void javaBasics() {
        double d = 10.70;
        String s = "10";

        int result = Integer.parseInt(s);
        System.out.println(result);

        int b = (int)d;
        System.out.println(b);
    }
}
