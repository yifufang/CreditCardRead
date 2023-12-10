import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import org.json.*;
import org.jdom.input.*;
import org.jdom.output.*;
import org.jdom.*;


public class TypeParse {

    public void parseFile(String inputFilePath){
        if (inputFilePath.endsWith(".csv")) {
            parseCSV(inputFilePath);
        } else if (inputFilePath.endsWith(".json")) {
            parseJSON(inputFilePath);
        } else if (inputFilePath.endsWith(".xml")) {
            parseXML(inputFilePath);
        } else {
            System.out.println("Unsupported file type.");
        }
    }
    
    public void parseCSV(String inputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter("./output/output.csv"))) {

            String line;
            CardFactory factory = new ConcreateCardFactory();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                CreditCard card = factory.createCard(values[0]);
                writer.println(card.getCardNumber() + "," + card.getCardType());
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found at "+ inputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseJSON(String inputFilePath) {
        try {
        String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        JSONArray jsonArray = new JSONArray(content);
        
        CardFactory factory = new ConcreateCardFactory();
        JSONArray outputArray = new JSONArray();
        try (PrintWriter writer = new PrintWriter(new FileWriter("./output/output.json"))) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                CreditCard card = factory.createCard(jsonObject.getString("cardNumber"));
                JSONObject outputObject = new JSONObject();
                outputObject.put("cardNumber", card.getCardNumber());
                outputObject.put("cardType", card.getCardType());
                outputArray.put(outputObject);
            }
            writer.println(outputArray.toString(4));
        }
    } catch (NoSuchFileException e) {
        System.out.println("File not found at "+ inputFilePath);
    } catch (IOException | JSONException e) {
        e.printStackTrace();
    }
    }

    public void parseXML(String inputFilePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            JSONObject jsonObject = XML.toJSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONObject("CARDS").getJSONArray("CARD");

            CardFactory factory = new ConcreateCardFactory();
            StringBuilder outputBuilder = new StringBuilder("<CARDS>");
            try (PrintWriter writer = new PrintWriter(new FileWriter("./output/output.xml"))) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    CreditCard card = factory.createCard(object.get("CARD_NUMBER").toString());
                    JSONObject outputObject = new JSONObject();
                    outputObject.put("CARD_NUMBER", card.getCardNumber());
                    outputObject.put("CARD_TYPE", card.getCardType());
                    outputBuilder.append(XML.toString(new JSONObject().put("CARD", outputObject)));
                }
                outputBuilder.append("</CARDS>");   
                String xml = outputBuilder.toString();
                writer.println(xml);
                SAXBuilder builder = new SAXBuilder();
                InputStream stream = new ByteArrayInputStream(xml.getBytes());
                Document document = builder.build(stream);
                Format format = Format.getPrettyFormat();
                XMLOutputter outputter = new XMLOutputter(format);
                outputter.output(document, writer);
            }
        } catch (NoSuchFileException e) {
        System.out.println("File not found at "+ inputFilePath);
    } catch (IOException | JSONException | JDOMException e) {
        e.printStackTrace();
    }
    }
}
