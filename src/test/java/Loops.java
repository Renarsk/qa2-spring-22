import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.JsonToWebElementConverter;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Loops {
    @Test
    public void loopsLesson() {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Dmitry");
        studentNames.add("Renārs");
        studentNames.add("Krista");
        studentNames.add("Damirs");
        studentNames.add("Dana");
        studentNames.add("Dita");
        studentNames.add("Georgijs");
        studentNames.add("Agnese");
        studentNames.add("Dita Fon Tease");
        studentNames.add("Karīna");
        studentNames.add("Dārta");


        System.out.println(studentNames.get(2));
        System.out.println(studentNames.size());
        System.out.println(studentNames.isEmpty());


        //=================== FOR =====================//

        /*for (int i = 0; i < studentNames.size(); i++) {
            System.out.println(studentNames.get(i));

        }*/

        //=================== FOREACH =====================//

       /* for (String names : studentNames) {
            System.out.println(names);
        }*/

        for(String name :studentNames){
            if(name.startsWith("D")){
                System.out.println(name);
            }
        }


        //=================== IF-ELSE =====================//

        for(String name :studentNames){
            if(name.startsWith("D")){
                System.out.println("These names starts with D: " + name);
            } else {
                System.out.println("These names starts with different letter: " + name);
            }
        }
    }
}