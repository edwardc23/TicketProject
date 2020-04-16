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


            public static void main(String[] args) throws Exception {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/train_project",
                        "TrainTicket",
                        "TrainTicket"
                );

                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Customer");
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet(" Records 2");

                XSSFRow row = spreadsheet.createRow(1);
                XSSFCell cell;
                cell = row.createCell(1);
                cell.setCellValue("Customer_ID");
                cell = row.createCell(2);
                cell.setCellValue("firstName");
                cell = row.createCell(3);
                cell.setCellValue("lastName");
                cell = row.createCell(4);
                cell.setCellValue("Email");
                cell = row.createCell(5);
                cell.setCellValue("Phone_Number");
                cell = row.createCell(6);
                cell.setCellValue("Age");
                cell = row.createCell(7);
                cell.setCellValue("Gender");



                int i = 2;

                while (resultSet.next()) {
                    row = spreadsheet.createRow(i);
                    cell = row.createCell(1);
                    cell.setCellValue(resultSet.getInt("Customer_ID"));
                    cell = row.createCell(2);
                    cell.setCellValue(resultSet.getString("firstName"));
                    cell = row.createCell(3);
                    cell.setCellValue(resultSet.getString("lastName"));
                    cell = row.createCell(4);
                    cell.setCellValue(resultSet.getString("Email"));
                    cell = row.createCell(5);
                    cell.setCellValue(resultSet.getString("Phone_Number"));
                    cell = row.createCell(6);
                    cell.setCellValue(resultSet.getString("Age"));
                    cell = row.createCell(7);
                    cell.setCellValue(resultSet.getString("Gender"));

                    i++;
                }



               /* Statement statement2 = connect.createStatement();
                ResultSet resultSet2 = statement2.executeQuery("select * from Train_Ticket");
                XSSFWorkbook workbook2 = new XSSFWorkbook();
                XSSFSheet spreadsheet2 = workbook.createSheet(" Records 2");


                 XSSFRow row2 = spreadsheet2.createRow(1);
                 XSSFCell cell2 ;

                cell2 = row2.createCell(1);
                cell2.setCellValue("ID");
                cell2 = row2.createCell(2);
                cell2.setCellValue("D");
                cell2 = row2.createCell(3);
                cell2.setCellValue("Origin");
                cell2 = row2.createCell(4);
                cell2.setCellValue("Destination");
                cell2 = row2.createCell(5);
                cell2.setCellValue("EstimatedTimeOfArrival");
                cell2 = row2.createCell(6);
                cell2.setCellValue("DepartureTime");
                cell2 = row2.createCell(7);
                cell2.setCellValue("TicketPrice");

                int b = 1;

                while(resultSet2.next()) {
                    row2 = spreadsheet.createRow(b);
                    cell2.setCellValue(resultSet2.getString("ID"));
                    cell2 = row2.createCell(1);
                    cell2.setCellValue(resultSet2.getString("Boarding_Pass_Num"));
                    cell2 = row2.createCell(2);
                    cell2.setCellValue(resultSet2.getString("Date"));
                    cell2 = row2.createCell(3);
                    cell2.setCellValue(resultSet2.getString("Origin"));
                    cell2 = row2.createCell(4);
                    cell2.setCellValue(resultSet2.getString("Destination"));
                    cell2 = row2.createCell(5);
                    cell2.setCellValue(resultSet2.getString("EstimatedTimeOfArrival"));
                    cell2 = row2.createCell(6);
                    cell2.setCellValue(resultSet2.getString("DepartureTime"));
                    cell2 = row2.createCell(7);
                    cell2.setCellValue(resultSet2.getString("TicketPrice"));

                b++;
            }*/



                FileOutputStream out = new FileOutputStream(new File("Records25.xlsx"));
                workbook.write(out);
                //workbook2.write(out);
                out.close();
                System.out.println("Records25.xlsx written successfully");
            }
        }



