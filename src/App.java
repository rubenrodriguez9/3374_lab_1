import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {


        File database = new File("student_database.txt"); 
         
        createDatabase(database);

    }

    static void createDatabase(File file){
        String header = "\tName\tTUID\tEmail Address\tPhone Number\tMajor\t Expected graduation\tUndergraduate Status";

        try {
            if(file.createNewFile()){
                BufferedWriter out = new BufferedWriter(new FileWriter(file, true));

                out.write(header);
                String studentInfo = getInfo();
                out.write(studentInfo);
                out.close();
                
                System.out.println("Student database created " + file.getName());
            } else {
                appendToDatabase(file);
                
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }

    static void appendToDatabase(File file){
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));

            String studentInfo = getInfo();
            out.write(studentInfo);
            out.close();
            
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static String getInfo(){
        StringBuilder str = new StringBuilder();
      Scanner in = new Scanner(System.in);
        System.out.println("Enter your full name: ");
        str.append("\n" + in.nextLine() + "\t");
        System.out.println("Enter your TUID:");
        String id = in.nextLine();
        while(id.length() != 9){
            System.out.println("Please enter a 9 digit TUID");
            id = in.nextLine();
        }
        str.append(id + "\t");
        System.out.println("Enter your email address:");
        str.append(in.nextLine() + "\t");
        System.out.println("Enter your phone number:");
        str.append(in.nextLine() + "\t");
        System.out.println("Enter your major:");
        str.append(in.nextLine() + "\t");
        System.out.println("Enter your expected graduation date:");
        str.append(in.nextLine() + "\t");
        System.out.println("Are you an undergraduate? Type 'y' or 'n' ");

        in.close();
        return str.toString();


    }
}
