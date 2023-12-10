public class Main {
    public static void main(String[] args) {
        TypeParse parser = new TypeParse();
        if (args.length > 0) {
            parser.parseFile(args[0]);
        } else {
            System.out.println("No files provided.");
        }
    }
}
