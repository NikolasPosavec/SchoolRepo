import os
import sys
import json
from PIL import Image, ImageTk
from colorama import Fore, Style
import tkinter as tk
from tkinter import filedialog, messagebox, simpledialog
from tkinter.ttk import Progressbar

# ASCII characters ordered from lightest to darkest
ascii_chars = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$"

settings_file = "settings.json"

def load_settings():
    if os.path.exists(settings_file):
        try:
            with open(settings_file, "r") as f:
                return json.load(f)
        except:
            pass
    return {}

def save_settings():
    settings = {
        "image_path": image_path_var.get(),
        "width": width_var.get(),
        "output_file": output_var.get(),
        "colored": colored_var.get(),
    }
    with open(settings_file, "w") as f:
        json.dump(settings, f)

# Image to ASCII Conversion Function
def image_to_ascii(image_path, new_width=100, output_file="ascii_art_output.txt", colored=False, progress_bar=None):
    try:
        im = Image.open(image_path).convert("RGB")
    except Exception as e:
        messagebox.showerror("Error", f"Error opening image: {e}")
        return

    width, height = im.size
    aspect_ratio = height / width

    new_height = int(aspect_ratio * new_width * 0.55) 
    im = im.resize((new_width, new_height))

    # Create brightness matrix using getdata
    brightness_matrix = [
        int(0.299 * r + 0.587 * g + 0.114 * b)
        for r, g, b in im.getdata()
    ]

    # Convert brightness values to ASCII characters
    ascii_art = [
        [ascii_chars[int(brightness / 255 * (len(ascii_chars) - 1))] for brightness in brightness_matrix[i:i + new_width]]
        for i in range(0, len(brightness_matrix), new_width)
    ]

    # Save ASCII art to the output file
    try:
        with open(output_file, "w") as f:
            for row in ascii_art:
                f.write("".join(row) + "\n")
    except Exception as e:
        messagebox.showerror("Error", f"Error saving ASCII art: {e}")
        return

    messagebox.showinfo("Success", f"ASCII art saved to {output_file}")

    if colored:
        def get_color_code(r, g, b):
            return f"\033[38;2;{r};{g};{b}m"

        for y in range(new_height):
            for x in range(new_width):
                r, g, b = im.getpixel((x, y))
                ascii_char = ascii_art[y][x]
                sys.stdout.write(get_color_code(r, g, b) + ascii_char)
            sys.stdout.write(Style.RESET_ALL + "\n")
    else:
        for row in ascii_art:
            print("".join(row))

    if progress_bar:
        progress_bar["value"] = 100
        root.update_idletasks()

def show_preview():
    try:
        im = Image.open(image_path_var.get()).convert("RGB")
        im = im.resize((200, 200))  # Resize the preview image
        preview_image = ImageTk.PhotoImage(im)

        preview_label.config(image=preview_image)
        preview_label.image = preview_image
    except Exception as e:
        messagebox.showerror("Error", f"Error loading preview: {e}")

def select_image():
    file_path = filedialog.askopenfilename(filetypes=[("Image Files", "*.png;*.jpg;*.jpeg;*.bmp;*.gif")])
    if file_path:
        image_path_var.set(file_path)
        show_preview()

def crop_image():
    try:
        im = Image.open(image_path_var.get())
        left = simpledialog.askinteger("Crop", "Enter left crop value:", minvalue=0, maxvalue=im.width)
        upper = simpledialog.askinteger("Crop", "Enter upper crop value:", minvalue=0, maxvalue=im.height)
        right = simpledialog.askinteger("Crop", "Enter right crop value:", minvalue=0, maxvalue=im.width)
        lower = simpledialog.askinteger("Crop", "Enter lower crop value:", minvalue=0, maxvalue=im.height)

        cropped_image = im.crop((left, upper, right, lower))
        cropped_image.save("cropped_image.png")
        image_path_var.set("cropped_image.png")
        show_preview()
    except Exception as e:
        messagebox.showerror("Error", f"Error cropping image: {e}")

def generate_ascii():
    image_path = image_path_var.get()
    try:
        width = int(width_var.get())
    except ValueError:
        messagebox.showerror("Error", "Width must be an integer.")
        return
    output_file = output_var.get()
    colored = colored_var.get()

    if not image_path:
        messagebox.showerror("Error", "Please select an image file.")
        return

    if not os.path.exists(image_path):
        messagebox.showerror("Error", "The selected image file does not exist.")
        return

    progress_bar["value"] = 0
    progress_bar["maximum"] = 100
    root.update_idletasks()

    image_to_ascii(image_path, width, output_file, colored, progress_bar)
    save_settings() 

# GUI setup
root = tk.Tk()
root.title("Image to ASCII Converter")

settings = load_settings()

image_path_var = tk.StringVar(value=settings.get("image_path", ""))
width_var = tk.StringVar(value=settings.get("width", "100"))
output_var = tk.StringVar(value=settings.get("output_file", "ascii_art_output.txt"))
colored_var = tk.BooleanVar(value=settings.get("colored", False))

# Layout
tk.Label(root, text="Select Image File:").pack(pady=5)
tk.Entry(root, textvariable=image_path_var, width=40).pack(pady=5)
tk.Button(root, text="Browse", command=select_image).pack(pady=5)

tk.Label(root, text="Width:").pack(pady=5)
tk.Entry(root, textvariable=width_var, width=10).pack(pady=5)

tk.Label(root, text="Output File:").pack(pady=5)
tk.Entry(root, textvariable=output_var, width=40).pack(pady=5)

tk.Checkbutton(root, text="Enable Colored ASCII Art", variable=colored_var).pack(pady=5)

tk.Button(root, text="Generate ASCII Art", command=generate_ascii).pack(pady=20)

tk.Button(root, text="Crop Image", command=crop_image).pack(pady=5)

# Progress bar
progress_bar = Progressbar(root, length=200, mode="determinate")
progress_bar.pack(pady=10)

# Preview image label
preview_button = tk.Button(root, text="Show Preview", command=show_preview)
preview_button.pack(pady=5)

preview_label = tk.Label(root)
preview_label.pack(pady=5)

root.mainloop()
