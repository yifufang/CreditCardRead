public class Main {
    public static void main(String[] args) {
        TypeParse parser = new TypeParse();
        parser.parseFile("./data/input_file.csv");
        parser.parseFile("./data/input_file.json");
        parser.parseFile("./data/input_file.xml");
    }
}
