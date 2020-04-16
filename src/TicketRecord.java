import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TicketRecord {

    //nnote added for commit

            public static void main(String[] args) throws Exception {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/train_project",
                        "TrainTicket",
                        "TrainTicket"
                );

                //SELECT * FROM Table ORDER BY Boarding_Pass_ID DESC LIMIT 1
                //select * from CustomerTrainTicket

                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Table ORDER BY Boarding_Pass_ID DESC LIMIT 1");
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet(" Records 1");

                XSSFRow row = spreadsheet.createRow(1);
                XSSFCell cell;
                cell = row.createCell(1);
                cell.setCellValue("Boarding_Pass_Num");
                cell = row.createCell(2);
                cell.setCellValue("Date");
                cell = row.createCell(3);
                cell.setCellValue("Origin");
                cell = row.createCell(4);
                cell.setCellValue("Destination");
                cell = row.createCell(5);
                cell.setCellValue("EstimatedTimeOfArrival");
                cell = row.createCell(6);
                cell.setCellValue("DepartureTime");
                cell = row.createCell(7);
                cell.setCellValue("TicketPrice");
                cell = row.createCell(8);
                cell.setCellValue("firstName");
                cell = row.createCell(9);
                cell.setCellValue("lastName");
                cell = row.createCell(10);
                cell.setCellValue("Email");
                cell = row.createCell(11);
                cell.setCellValue("Phone_Number");
                cell = row.createCell(12);
                cell.setCellValue("Age");
                cell = row.createCell(13);
                cell.setCellValue("Gender");




                int i = 2;

                while (resultSet.next()) {
                    row = spreadsheet.createRow(i);
                    cell = row.createCell(1);
                    cell.setCellValue(resultSet.getInt("Boarding_Pass_Num"));
                    cell = row.createCell(2);
                    cell.setCellValue(resultSet.getString("Date"));
                    cell = row.createCell(3);
                    cell.setCellValue(resultSet.getString("Origin"));
                    cell = row.createCell(4);
                    cell.setCellValue(resultSet.getString("Destination"));
                    cell = row.createCell(5);
                    cell.setCellValue(resultSet.getString(" EstimatedTimeOfArrival"));
                    cell = row.createCell(6);
                    cell.setCellValue(resultSet.getString("DepartureTime"));
                    cell = row.createCell(7);
                    cell.setCellValue(resultSet.getDouble("TicketPrice"));
                    cell = row.createCell(8);
                    cell.setCellValue(resultSet.getString("firstName"));
                    cell = row.createCell(9);
                    cell.setCellValue(resultSet.getString("lastName"));
                    cell = row.createCell(10);
                    cell.setCellValue(resultSet.getString("Email"));
                    cell = row.createCell(11);
                    cell.setCellValue(resultSet.getString("Phone_Number"));
                    cell = row.createCell(12);
                    cell.setCellValue(resultSet.getInt("Age"));
                    cell = row.createCell(13);
                    cell.setCellValue(resultSet.getString("Gender"));

                    i++;
                }




                FileOutputStream out = new FileOutputStream(new File("Records25.xlsx"));
                workbook.write(out);

                out.close();
                System.out.println("Records25.xlsx written successfully");
            }
        }



