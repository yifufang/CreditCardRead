public class Main {
    public static void main(String[] args) {
        TypeParse parser = new TypeParse();
        parser.parseCSV("./data/input_file.csv");
        parser.parseJSON("./data/input_file.json");
    }
}
