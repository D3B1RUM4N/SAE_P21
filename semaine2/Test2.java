import java.io.File;
import java.io.FileInputStream;


public class Test2 {

    //essai de l'ecture d'un texte en .class
    public static void main(String args[]){

        //lecture du fichier
        try
        {
            File f = new File("../fichierTXT/GType.class");
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
        //resultat etrange
        //utiliser static Class.forName(nomClass)
        //class pass JAVA
        // ./
    }
}