package APCS.Portfolio.Flash_card_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FlashcardGUI 
{
    private terms_and_defs flashcards;
    private int currentCardIndex = 0;
    private boolean showingTerm = true;

    private JFrame frame;
    private JLabel cardLabel;
    private JButton flipButton;
    private JButton nextButton;
    private JButton prevButton;
    private JButton addButton;
    private JButton saveButton;
    private JButton loadButton;

    public FlashcardGUI() 
    {
        flashcards = new terms_and_defs();
        initializeGUI();
    }

    private void initializeGUI() 
    {
        frame = new JFrame("Flashcard App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        cardLabel = new JLabel("No flashcards available", SwingConstants.CENTER);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 24));
        cardLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(cardLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        flipButton = new JButton("Flip Card");
        flipButton.addActionListener(e -> flipCard());
        buttonPanel.add(flipButton);

        prevButton = new JButton("Previous");
        prevButton.addActionListener(e -> showPreviousCard());
        buttonPanel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> showNextCard());
        buttonPanel.add(nextButton);

        addButton = new JButton("Add Card");
        addButton.addActionListener(e -> addNewCard());
        buttonPanel.add(addButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveFlashcards());
        buttonPanel.add(saveButton);

        loadButton = new JButton("Load");
        loadButton.addActionListener(e -> loadFlashcards());
        buttonPanel.add(loadButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        updateButtons();
        frame.setVisible(true);
    }

    private void flipCard() 
    {
        showingTerm = !showingTerm;
        updateCardDisplay();
    }

    private void showNextCard() 
    {
        if (flashcards.terms.size() > 0) 
        {
            currentCardIndex = (currentCardIndex + 1) % flashcards.terms.size();
            showingTerm = true;
            updateCardDisplay();
        }
    }

    private void showPreviousCard() 
    {
        if (flashcards.terms.size() > 0) 
        {
            currentCardIndex = (currentCardIndex - 1 + flashcards.terms.size()) % flashcards.terms.size();
            showingTerm = true;
            updateCardDisplay();
        }
    }

    private void updateCardDisplay() 
    {
        if (flashcards.terms.size() == 0) 
        {
            cardLabel.setText("No flashcards available");
            return;
        }

        if (showingTerm) 
        {
            cardLabel.setText("<html><div style='text-align: center;'>TERM<br><br>" + flashcards.terms.get(currentCardIndex) + "</div></html>");
        } 
        else 
        {
            cardLabel.setText("<html><div style='text-align: center;'>DEFINITION<br><br>" + flashcards.definitions.get(currentCardIndex) + "</div></html>");
        }
    }

    private void updateButtons() 
    {
        boolean hasCards = flashcards.terms.size() > 0;
        flipButton.setEnabled(hasCards);
        nextButton.setEnabled(hasCards);
        prevButton.setEnabled(hasCards);
    }

    private void addNewCard() 
    {
        JTextField termField = new JTextField();
        JTextField definitionField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Term:"));
        panel.add(termField);
        panel.add(new JLabel("Definition:"));
        panel.add(definitionField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add New Flashcard", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) 
        {
            String term = termField.getText().trim();
            String definition = definitionField.getText().trim();
            
            if (!term.isEmpty() && !definition.isEmpty()) 
            {
                flashcards.addCard(term, definition);
                currentCardIndex = flashcards.terms.size() - 1;
                showingTerm = true;
                updateCardDisplay();
                updateButtons();
            }
        }
    }

    private void saveFlashcards() 
    {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) 
        {
            try 
            {
                flashcards.saveToFile(fileChooser.getSelectedFile().getPath());
                JOptionPane.showMessageDialog(frame, "Flashcards saved successfully!");
            } 
            catch (IOException e) 
            {
                JOptionPane.showMessageDialog(frame, "Error saving flashcards: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadFlashcards() 
    {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) 
        {
            try 
            {
                flashcards.loadFromFile(fileChooser.getSelectedFile().getPath());
                currentCardIndex = 0;
                showingTerm = true;
                updateCardDisplay();
                updateButtons();
                JOptionPane.showMessageDialog(frame, "Loaded " + flashcards.terms.size() + " flashcards");
            } 
            catch (IOException e) 
            {
                JOptionPane.showMessageDialog(frame, "Error loading flashcards: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new FlashcardGUI());
    }
}