print("Hello World!")
# Simplest Language to Learn

import sys
from PyQt5.QtWidgets import QApplication, QLabel, QWidget

def main():
    # Create the application object
    app = QApplication(sys.argv)
    
    # Create a QWidget object, which will be the main window
    window = QWidget()
    window.setWindowTitle('Hello World')
    
    # Create a label widget with the text "Hello, World!"
    label = QLabel('Hello, World!', parent=window)
    label.move(50, 50)  # Position the label within the window
    
    # Set the size of the main window
    window.setGeometry(100, 100, 200, 100)
    
    # Show the main window
    window.show()
    
    # Run the application's event loop
    sys.exit(app.exec_())

if __name__ == '__main__':
    main()
