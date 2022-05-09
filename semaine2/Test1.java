import java.io.File;
import java.io.FileInputStream;


public class Test1 {

    //essai de l'ecture d'un texte en .txt
    public static void main(String args[]){

        //lecture du fichier
        try
        {
            File f = new File("../fichierTXT/txt1.txt");
            FileInputStream fIS = new FileInputStream(f);
            System.out.println("file content: ");
            int r = 0;
            while((r = fIS.read())!=-1)
            {
                System.out.print((char)r);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}