import static java.lang.System.lineSeparator;

public class GetClass {
    public static void classGet()
    {
        try {
            Init.cName = Class.forName(Init.fichier);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("La classe de l'objet obj est : " + c.getName())
    }

    public static void umlClass()
    {
        Init.stringClass += "class " + Init.cName.getName() + "{" + lineSeparator();
    }
}
