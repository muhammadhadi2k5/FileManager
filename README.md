# File Manager
A simple Java program that organizes files in the current directory into categorized folders based on the file extensions.

## Features
- Automatically detects file extensions.
- Categorizes files into: Images, Videos, Audio, Documents, and Others.
- Handles duplicate files by appending '_1', '_2', etc. in their names.

 ## Categories
 | **Category** | **Extensions**             |
 |--------------|----------------------------|
 | Images       | jpg, jpeg, png, gif, bmp   |
 | Videos       | mp4, avi, mkv, mov, flv    |
 | Documents    | pdf, docx, txt, pptx, xlsx |
 | Others       | Anything else              |

 ## How to Run
 1. Open terminal in the project directory:
    ```bash
    javac Main.java
    java main
    ```

2. Make sure your files are in the same folder as `Main.java` when running it.

3. Your files will be moved into the folders like `/Images`, `/Videos`, etc. as mentioned above.
