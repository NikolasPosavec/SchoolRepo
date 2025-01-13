
    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MagicTilesGame extends JFrame {
    private final int TILE_WIDTH = 100;
    private final int TILE_HEIGHT = 150;
    private final int NUM_COLUMNS = 4;
    private final int WINDOW_WIDTH = TILE_WIDTH * NUM_COLUMNS;
    private final int WINDOW_HEIGHT = 600;
    private final int TILE_SPEED = 5;

    private ArrayList<Tile> tiles;
    private Timer gameTimer;
    private int score;

    public MagicTilesGame() {
        setTitle("Magic Tiles");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        tiles = new ArrayList<>();
        score = 0;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) {
                    checkTileHit(key);
                }
            }
        });

        startGame();
    }

    private void startGame() {
        gameTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                repaint();
            }
        });
        gameTimer.start();
    }

    private void updateGame() {
        // Move tiles down
        Iterator<Tile> iterator = tiles.iterator();
        while (iterator.hasNext()) {
            Tile tile = iterator.next();
            tile.y += TILE_SPEED;

            // Remove tiles that go off-screen
            if (tile.y > WINDOW_HEIGHT) {
                iterator.remove();
                endGame();
            }
        }

        // Spawn new tiles randomly
        if (new Random().nextInt(100) < 2) {
            int column = new Random().nextInt(NUM_COLUMNS);
            tiles.add(new Tile(column * TILE_WIDTH, -TILE_HEIGHT));
        }
    }

    private void checkTileHit(int keyCode) {
        char keyChar = (char) keyCode;
        Iterator<Tile> iterator = tiles.iterator();
        while (iterator.hasNext()) {
            Tile tile = iterator.next();
            if (tile.matchesKey(keyChar)) {
                iterator.remove();
                score++;
                return;
            }
        }
    }

    private void endGame() {
        gameTimer.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score);
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw tiles
        for (Tile tile : tiles) {
            g2d.setColor(tile.color);
            g2d.fillRect(tile.x, tile.y, TILE_WIDTH, TILE_HEIGHT);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(tile.x, tile.y, TILE_WIDTH, TILE_HEIGHT);
            g2d.drawString(Character.toString(tile.key), tile.x + TILE_WIDTH / 2 - 5, tile.y + TILE_HEIGHT / 2);
        }

        // Draw score
        g2d.setColor(Color.BLACK);
        g2d.drawString("Score: " + score, 10, 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MagicTilesGame game = new MagicTilesGame();
            game.setVisible(true);
        });
    }

    private static class Tile {
        int x, y;
        char key;
        Color color;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
            this.key = (char) (new Random().nextInt(26) + 'A');
            this.color = new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
        }

        boolean matchesKey(char key) {
            return this.key == key;
        }
    }
}


