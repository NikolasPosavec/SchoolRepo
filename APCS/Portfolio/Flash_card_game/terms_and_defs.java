package APCS.Portfolio.Flash_card_game;

import java.util.ArrayList;
import java.io.*;

public class terms_and_defs 
{
    public ArrayList<String> terms;
    public ArrayList<String> definitions;
    private static final String FILE_EXTENSION = ".cards";
    private static final String DELIMITER = "::";

    public terms_and_defs() 
    {
        terms = new ArrayList<String>();
        definitions = new ArrayList<String>();
    }

    public void addCard(String term, String definition) 
    {
        if (term == null || term.trim().isEmpty() || 
            definition == null || definition.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Term and definition cannot be empty");
        }
        terms.add(term.trim());
        definitions.add(definition.trim());
    }

    public void saveToFile(String filename) throws IOException 
    {
        if (!filename.endsWith(FILE_EXTENSION)) 
        {
            filename += FILE_EXTENSION;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) 
        {
            for (int i = 0; i < terms.size(); i++) 
            {
                writer.println(terms.get(i) + DELIMITER + definitions.get(i));
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
                String[] parts = line.split(DELIMITER, 2);
                if (parts.length == 2) 
                {
                    terms.add(parts[0]);
                    definitions.add(parts[1]);
                }
            }
        }
    }

    public int getCardCount() 
    {
        return terms.size();
    }

    public boolean isEmpty() 
    {
        return terms.isEmpty();
    }

    public void removeCard(int index) 
    {
        if (index < 0 || index >= terms.size()) 
        {
            throw new IndexOutOfBoundsException("Invalid card index");
        }
        terms.remove(index);
        definitions.remove(index);
    }
}