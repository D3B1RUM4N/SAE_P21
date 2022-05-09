import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//creation d'un TXT
public class Test3 {

    public static void main(String[] args) {
        Path path = Paths.get("../fichierTXT/testCreation.txt");
        try {
            String str = "Test creation \n Hello W0rld";
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}