import static java.lang.System.lineSeparator;

public class Ecriture {

    public Ecriture() {    }

    public String debutEcriture()
    {
        String ecriture = "@startuml" + lineSeparator() +
                lineSeparator() +
                "'UML GENERE PAR CODE :)" + lineSeparator() +
                lineSeparator() +
                "skinparam style strictuml" + lineSeparator() +
                "skinparam classAttributeIconSize 0" + lineSeparator() +
                "skinparam classFontStyle Bold" + lineSeparator() +
                "hide empty members" + lineSeparator() +
                lineSeparator();
        return ecriture;
    }

    public String finEcriture()
    {
        return lineSeparator() +
                "@enduml" + lineSeparator();
    }


}
