import static java.lang.System.lineSeparator;

public class Ecriture {

    private String ecriture = "";
    public Ecriture() {    }

    public String debutEcriture()
    {
        ecriture += "@startuml" + lineSeparator() +
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
        ecriture += "@enduml" + lineSeparator();
        return ecriture;
    }


}
