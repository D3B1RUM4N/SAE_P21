import static java.lang.System.lineSeparator;

public class ClassUML {
    //public static Class cName;

    public Class<?> classGet(String fichier)
    {
        try {
            return Class.forName(fichier);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //System.out.println("La classe de l'objet obj est : " + c.getName())
    }

    public String name(Class name)
    {
        return name.getName();
        //Init.stringClass += "class " + cName.getName() + "{" + lineSeparator();
    }
}
