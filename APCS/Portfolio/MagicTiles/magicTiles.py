import pygame
import random

# Initialize pygame
pygame.init()
pygame.mixer.init()

# Screen dimensions
WIDTH, HEIGHT = 400, 600
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Magic Tiles 3")

# Colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
LIGHT_BLUE = (173, 216, 230)

# Fonts
font = pygame.font.Font(None, 36)

# Clock
clock = pygame.time.Clock()
FPS = 60

# Tile dimensions
tile_width = WIDTH // 4
tile_height = 150

# Key bindings
key_bindings = {
    pygame.K_f: 0,
    pygame.K_g: 1,
    pygame.K_h: 2,
    pygame.K_j: 3
}

# Music
song_path = "tvgirl.mp3"  # Update with the path to your song

# Global variables
menu_active = True
game_active = False
tiles = []
score = 0
game_over = False
feedback_message = ""
feedback_color = BLACK
key_lightup = [False, False, False, False]

# Function to reset the game
def reset_game():
    global tiles, score, game_over, feedback_message, feedback_color, key_lightup
    tiles = []
    score = 0
    game_over = False
    feedback_message = ""
    feedback_color = BLACK
    key_lightup = [False, False, False, False]

# Function to generate a new tile
def generate_tile():
    column = random.randint(0, 3)
    x = column * tile_width
    return {"rect": pygame.Rect(x, -tile_height, tile_width, tile_height), "column": column, "clicked": False}

# Function to check tile hit
def check_tile_hit(column):
    global feedback_message, feedback_color, score

    for tile in tiles:
        if tile["column"] == column and not tile["clicked"]:
            # Check if the tile is in the click zone
            if HEIGHT - 150 <= tile["rect"].y + tile_height <= HEIGHT - 30:
                tile["clicked"] = True
                feedback_message = "Great!"
                feedback_color = GREEN
                score += 1
                return
    # If no valid tile was hit, provide neutral feedback but do not end the game
    feedback_message = "Miss!"
    feedback_color = RED

# Function to show the menu
def show_menu():
    global menu_active, game_active

    while menu_active:
        screen.fill(WHITE)

        # Display title
        title_text = font.render("Magic Tiles 3", True, BLACK)
        screen.blit(title_text, (WIDTH // 2 - title_text.get_width() // 2, HEIGHT // 4))

        # Display options
        start_text = font.render("Start Game", True, BLACK)
        screen.blit(start_text, (WIDTH // 2 - start_text.get_width() // 2, HEIGHT // 2))
        quit_text = font.render("Quit", True, BLACK)
        screen.blit(quit_text, (WIDTH // 2 - quit_text.get_width() // 2, HEIGHT // 2 + 50))

        # Handle events
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

            if event.type == pygame.MOUSEBUTTONDOWN:
                mouse_x, mouse_y = event.pos
                if HEIGHT // 2 <= mouse_y <= HEIGHT // 2 + 36:
                    menu_active = False
                    game_active = True
                elif HEIGHT // 2 + 50 <= mouse_y <= HEIGHT // 2 + 86:
                    pygame.quit()
                    quit()

        pygame.display.flip()
        clock.tick(FPS)

# Main game function
def main_game():
    global tiles, score, game_over, feedback_message, feedback_color, key_lightup, game_active

    reset_game()
    tile_speed = 5
    tile_spawn_time = 0
    pygame.mixer.music.load(song_path)
    pygame.mixer.music.play(-1, 0.0)

    while game_active:
        screen.fill(WHITE)

        # Event handling
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            if event.type == pygame.KEYDOWN and not game_over:
                if event.key in key_bindings:
                    check_tile_hit(key_bindings[event.key])
                    key_lightup[key_bindings[event.key]] = True

        # Manage key light-up
        key_lightup = [False] * 4

        # Spawn tiles
        tile_spawn_time += clock.get_time()
        if tile_spawn_time >= 800:  # Adjust spawn rate as needed
            tiles.append(generate_tile())
            tile_spawn_time = 0

        # Move tiles and check for misses
        for tile in tiles:
            tile["rect"].y += tile_speed
            if tile["rect"].y > HEIGHT and not tile["clicked"]:
                tile["clicked"] = True
                feedback_message = "Missed!"
                feedback_color = RED

        # Remove off-screen tiles
        tiles = [tile for tile in tiles if tile["rect"].y <= HEIGHT]

        # Draw tiles
        for tile in tiles:
            color = GREEN if tile["clicked"] else BLACK
            pygame.draw.rect(screen, color, tile["rect"])

        # Draw score and feedback
        score_text = font.render(f"Score: {score}", True, BLACK)
        screen.blit(score_text, (10, 10))
        feedback_text = font.render(feedback_message, True, feedback_color)
        screen.blit(feedback_text, (WIDTH // 2 - feedback_text.get_width() // 2, HEIGHT // 2))

        # Game over message
        if game_over:
            game_over_text = font.render("Game Over! Press R to restart", True, RED)
            screen.blit(game_over_text, (WIDTH // 2 - game_over_text.get_width() // 2, HEIGHT // 2 + 50))
            if pygame.key.get_pressed()[pygame.K_r]:
                reset_game()

        # Display keybinds
        key_texts = ['F', 'G', 'H', 'J']
        for i, key in enumerate(key_texts):
            key_text = font.render(key, True, BLACK if not key_lightup[i] else LIGHT_BLUE)
            screen.blit(key_text, (i * tile_width + (tile_width // 2 - key_text.get_width() // 2), HEIGHT - 50))

        pygame.display.flip()
        clock.tick(FPS)

    show_menu()

# Start the game
show_menu()
if game_active:
    main_game()
