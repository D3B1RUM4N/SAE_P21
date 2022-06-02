public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        if(args[0] != null)
        {
            new Init(args[0]);
        }
        else {
            System.out.println("Saisis un fichier imbecile !");
            return;
        }
    }
}