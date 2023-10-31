import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;



public class Db {
    public static User Check(String name, String password) {
        try {
            File file = new File("src/db.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                if (Objects.equals(data[0], name) && Objects.equals(data[1], password)){
                    scanner.close();

                    User user = new User(data[0], data[1], data[2]);
                    return user;
                }
            }
            scanner.close();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void CreateUser(User user) {
        try {
            FileWriter writer = new FileWriter("src/db.txt", true);
            String data = "\n" + user.name + " " + user.password + " " + user.role;
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
