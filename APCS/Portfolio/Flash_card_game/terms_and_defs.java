package APCS.Portfolio.Flash_card_game;
import java.util.ArrayList;
import java.io.*;

public class terms_and_defs 
{
    public ArrayList<String> terms;
    public ArrayList<String> definitions;

    public terms_and_defs() 
    {
        terms = new ArrayList<String>();
        definitions = new ArrayList<String>();
    }

    public void addCard(String term, String definition) 
    {
        terms.add(term);
        definitions.add(definition);
    }

    public void saveToFile(String filename) throws IOException 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) 
        {
            for (int i = 0; i < terms.size(); i++) 
            {
                writer.println(terms.get(i) + "::" + definitions.get(i));
            }
        }
    }

    public void loadFromFile(String filename) throws IOException 
    {
        terms.clear();
        definitions.clear();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split("::", 2);
                if (parts.length == 2) 
                {
                    terms.add(parts[0]);
                    definitions.add(parts[1]);
                }
            }
        }
    }
}