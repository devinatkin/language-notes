import sys
from PyQt5.QtWidgets import QApplication, QLabel, QMainWindow
from PyQt5.QtCore import QTimer, QTime, Qt
from PyQt5.QtGui import QFont

class FullScreenClock(QMainWindow):
    def __init__(self):
        super().__init__()

        # Set up the label for the clock display
        self.label = QLabel(self)
        self.label.setAlignment(Qt.AlignCenter)
        self.label.setStyleSheet("color: white; background-color: black;")
        self.label.setFont(QFont('Arial', 150))
        
        # Set the window to full screen
        self.setCentralWidget(self.label)
        self.showFullScreen()

        # Update the time every second
        timer = QTimer(self)
        timer.timeout.connect(self.update_time)
        timer.start(1000)
        
        # Display the initial time
        self.update_time()

    def update_time(self):
        current_time = QTime.currentTime().toString("hh:mm:ss")
        self.label.setText(current_time)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    clock = FullScreenClock()
    sys.exit(app.exec_())
