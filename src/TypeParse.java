import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;

public class TypeParse {
    
    public void parseCSV(String inputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter("./data/output.csv"))) {

            String line;
            CardFactory factory = new ConcreateCardFactory();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                CreditCard card = factory.createCard(values[0]);
                writer.println(card.getCardNumber() + "," + card.getCardType());
            }
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
        try (PrintWriter writer = new PrintWriter(new FileWriter("./data/output.json"))) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                CreditCard card = factory.createCard(jsonObject.getString("cardNumber"));
                JSONObject outputObject = new JSONObject();
                outputObject.put("cardNumber", card.getCardNumber());
                outputObject.put("cardType", card.getCardType());
                outputArray.put(outputObject);
            }
            writer.println(outputArray.toString());
        }
    } catch (IOException | JSONException e) {
        e.printStackTrace();
    }
    }
}
