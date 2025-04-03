package APCS.Portfolio.Flash_card_game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FlashCardGUI 
{
    private final terms_and_defs flashcards;
    private int currentCardIndex = 0;
    private boolean showingTerm = true;
    private int currentStreak = 0;

    private static final Color DARK_BG = new Color(30, 30, 36);
    private static final Color CARD_BG = new Color(45, 45, 55);
    private static final Color TEXT_COLOR = new Color(230, 230, 230);
    private static final Color ACCENT_COLOR = new Color(100, 149, 237);
    private static final Color BUTTON_BG = new Color(60, 60, 70);
    private static final Color BUTTON_HOVER = new Color(80, 80, 90);
    private static final Color CORRECT_COLOR = new Color(46, 125, 50);
    private static final Color WRONG_COLOR = new Color(211, 47, 47);

    private JFrame frame;
    private JLabel cardLabel;
    private JLabel statusLabel;
    private JLabel streakLabel;
    private JButton flipButton;
    private JButton nextButton;
    private JButton prevButton;
    private JButton addButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton correctButton;
    private JButton wrongButton;

    public FlashCardGUI() 
    {
        flashcards = new terms_and_defs();
        initializeGUI();
    }

    private void initializeGUI() 
    {
        frame = new JFrame("Flashcard Master");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.getContentPane().setBackground(DARK_BG);
        frame.setLayout(new BorderLayout(10, 10));

        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        cardPanel.setBackground(CARD_BG);
        
        cardLabel = new JLabel("No flashcards available", SwingConstants.CENTER);
        cardLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        cardLabel.setForeground(TEXT_COLOR);
        cardLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 2),
            BorderFactory.createEmptyBorder(30, 20, 30, 20)
        ));
        cardPanel.add(cardLabel, BorderLayout.CENTER);
        
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(DARK_BG);
        
        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        statusLabel.setForeground(TEXT_COLOR);
        statusLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
        statusPanel.add(statusLabel, BorderLayout.WEST);
        
        streakLabel = new JLabel("Streak: 0");
        streakLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        streakLabel.setForeground(TEXT_COLOR);
        streakLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
        statusPanel.add(streakLabel, BorderLayout.EAST);
        
        frame.add(statusPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(DARK_BG);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        prevButton = createStyledButton("← Previous", e -> showPreviousCard());
        buttonPanel.add(prevButton, gbc);

        flipButton = createStyledButton("Flip Card", e -> flipCard());
        buttonPanel.add(flipButton, gbc);

        nextButton = createStyledButton("Next →", e -> showNextCard());
        buttonPanel.add(nextButton, gbc);

        gbc.gridy = 1;
        addButton = createStyledButton("Add Card", e -> addNewCard());
        buttonPanel.add(addButton, gbc);

        saveButton = createStyledButton("Save", e -> saveFlashcards());
        buttonPanel.add(saveButton, gbc);

        loadButton = createStyledButton("Load", e -> loadFlashcards());
        buttonPanel.add(loadButton, gbc);

        gbc.gridy = 2;
        correctButton = createStyledButton("Correct", e -> answerCorrect());
        correctButton.setBackground(CORRECT_COLOR);
        correctButton.setVisible(false);
        buttonPanel.add(correctButton, gbc);

        wrongButton = createStyledButton("Wrong", e -> answerWrong());
        wrongButton.setBackground(WRONG_COLOR);
        wrongButton.setVisible(false);
        buttonPanel.add(wrongButton, gbc);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        updateUI();
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text, ActionListener action) 
    {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setBackground(BUTTON_BG);
        button.setForeground(TEXT_COLOR);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.addActionListener(action);
        
        button.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
                button.setBackground(BUTTON_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
                button.setBackground(button.getText().equals("Correct") ? CORRECT_COLOR : 
                                   button.getText().equals("Wrong") ? WRONG_COLOR : BUTTON_BG);
            }
        });
        
        return button;
    }

    private void flipCard() 
    {
        showingTerm = !showingTerm;
        updateCardDisplay();
        correctButton.setVisible(!showingTerm);
        wrongButton.setVisible(!showingTerm);
    }

    private void showNextCard() 
    {
        if (!flashcards.terms.isEmpty()) 
        {
            currentCardIndex = (currentCardIndex + 1) % flashcards.terms.size();
            showingTerm = true;
            updateCardDisplay();
            correctButton.setVisible(false);
            wrongButton.setVisible(false);
        }
    }

    private void showPreviousCard() 
    {
        if (!flashcards.terms.isEmpty()) 
        {
            currentCardIndex = (currentCardIndex - 1 + flashcards.terms.size()) % flashcards.terms.size();
            showingTerm = true;
            updateCardDisplay();
            correctButton.setVisible(false);
            wrongButton.setVisible(false);
        }
    }

    private void answerCorrect() 
    {
        currentStreak++;
        streakLabel.setText("Streak: " + currentStreak);
        showNextCard();
    }

    private void answerWrong() 
    {
        currentStreak = 0;
        streakLabel.setText("Streak: " + currentStreak);
        showNextCard();
    }

    private void updateCardDisplay() 
    {
        if (flashcards.terms.isEmpty()) 
        {
            cardLabel.setText("No flashcards available");
            statusLabel.setText(" ");
            return;
        }

        String header = showingTerm ? "TERM" : "DEFINITION";
        String content = showingTerm ? 
            flashcards.terms.get(currentCardIndex) : 
            flashcards.definitions.get(currentCardIndex);

        cardLabel.setText(String.format(
            "<html><div style='text-align: center; color: %s;'><b style='color: %s;'>%s #%d</b><br><br>%s</div></html>",
            TEXT_COLOR.getRGB(), ACCENT_COLOR.getRGB(), header, currentCardIndex + 1, content
        ));

        statusLabel.setText(String.format(
            "Card %d of %d | %s", 
            currentCardIndex + 1, 
            flashcards.terms.size(),
            showingTerm ? "Term side" : "Definition side"
        ));
    }

    private void updateButtons() 
    {
        boolean hasCards = !flashcards.terms.isEmpty();
        flipButton.setEnabled(hasCards);
        nextButton.setEnabled(hasCards);
        prevButton.setEnabled(hasCards);
    }

    private void updateUI() 
    {
        updateCardDisplay();
        updateButtons();
        streakLabel.setText("Streak: " + currentStreak);
    }

    private void addNewCard() 
    {
        JTextArea termArea = new JTextArea(5, 20);
        termArea.setBackground(CARD_BG);
        termArea.setForeground(TEXT_COLOR);
        termArea.setCaretColor(TEXT_COLOR);
        termArea.setLineWrap(true);
        termArea.setWrapStyleWord(true);
        JScrollPane termScroll = new JScrollPane(termArea);
        termScroll.setBorder(BorderFactory.createLineBorder(ACCENT_COLOR));
        
        JTextArea definitionArea = new JTextArea(5, 20);
        definitionArea.setBackground(CARD_BG);
        definitionArea.setForeground(TEXT_COLOR);
        definitionArea.setCaretColor(TEXT_COLOR);
        definitionArea.setLineWrap(true);
        definitionArea.setWrapStyleWord(true);
        JScrollPane definitionScroll = new JScrollPane(definitionArea);
        definitionScroll.setBorder(BorderFactory.createLineBorder(ACCENT_COLOR));

        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setBackground(DARK_BG);
        
        JPanel inputPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        inputPanel.setBackground(DARK_BG);
        
        JLabel termLabel = new JLabel("Term:");
        termLabel.setForeground(TEXT_COLOR);
        inputPanel.add(termLabel);
        inputPanel.add(termScroll);
        
        JLabel defLabel = new JLabel("Definition:");
        defLabel.setForeground(TEXT_COLOR);
        inputPanel.add(defLabel);
        inputPanel.add(definitionScroll);
        
        panel.add(inputPanel, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(
            frame, 
            panel, 
            "Add New Flashcard", 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) 
        {
            String term = termArea.getText().trim();
            String definition = definitionArea.getText().trim();
            
            if (!term.isEmpty() && !definition.isEmpty()) 
            {
                flashcards.addCard(term, definition);
                currentCardIndex = flashcards.terms.size() - 1;
                showingTerm = true;
                updateUI();
            }
        }
    }

    private void saveFlashcards() 
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Flashcards");
        
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) 
        {
            try 
            {
                String path = fileChooser.getSelectedFile().getPath();
                if (!path.endsWith(".cards")) 
                {
                    path += ".cards";
                }
                flashcards.saveToFile(path);
                JOptionPane.showMessageDialog(
                    frame, 
                    "Flashcards saved successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            } 
            catch (IOException e) 
            {
                showErrorDialog("Error saving flashcards: " + e.getMessage());
            }
        }
    }

    private void loadFlashcards() 
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load Flashcards");
        
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) 
        {
            try 
            {
                flashcards.loadFromFile(fileChooser.getSelectedFile().getPath());
                currentCardIndex = 0;
                showingTerm = true;
                updateUI();
                JOptionPane.showMessageDialog(
                    frame, 
                    "Loaded " + flashcards.terms.size() + " flashcards", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            } 
            catch (IOException e) 
            {
                showErrorDialog("Error loading flashcards: " + e.getMessage());
            }
        }
    }

    private void showErrorDialog(String message) 
    {
        JOptionPane.showMessageDialog(
            frame, 
            message, 
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            try 
            {
                new FlashCardGUI();
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(
                    null, 
                    "Failed to start application: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}