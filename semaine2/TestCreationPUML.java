import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


//reussite de creation d'un puml
public class TestCreationPUML {

    public static String unString;
    public static void main(String args[]){
        //chemin d'acces lecture
        String chemin = "fichierTXT/uml.txt";

        //lecture fichier
        lecture(chemin);

        //creation d'un nouveau fichier
        ecriture();
    }

    public static void lecture(String path)
    {
        //lecture du fichier
        try
        {
            File f = new File("fichierTXT/uml.txt");
            FileInputStream fIS = new FileInputStream(f);
            System.out.println("file content: ");
            int r = 0;
            while((r = fIS.read())!=-1)
            {
                unString += (char)r;
            }
        }
        catch(Exception e)
        {
            System.out.println("erreur lecture");
            e.printStackTrace();
        }
        System.out.println("fksndgfndkflndlkfjdlkfj\n" + unString);
    }


    public static void ecriture()
    {
        Path path = Paths.get("fichierTXT/uml1.puml");
        try {
            //String str = "Test creation \n Hello W0rld";
            byte[] bs = unString.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
