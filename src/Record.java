import entity.CustomerTrainTicket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Record {

    String currDir = System.getProperty("user.dir");
    public void writeBoardingPass(CustomerTrainTicket ticket) {
    try {
        File file = new File(currDir + "\\src\\BoardingPass.txt");



        FileWriter fw= new FileWriter(file);
       fw.write(ticket.toString());





        fw.flush();
        fw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
