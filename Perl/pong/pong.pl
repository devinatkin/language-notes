#!/usr/bin/perl

use strict;
use warnings;
use Tk;

my $my = MainWindow->new;
$my->title("Simple Pong Game Attempt");

# Ball velocity
my $ball_xv = -4;  # Horizontal velocity
my $ball_yv = 4;   # Vertical velocity

# Canvas dimensions
my $canvas_width = 400;
my $canvas_height = 300;

# Create a canvas
my $canvas = $my->Canvas(
    -width => $canvas_width,
    -height => $canvas_height,
    -background => 'black'
)->pack;

# Draw a ball on the canvas (x1, y1, x2, y2)
my $ball = $canvas->createOval(
    190, 140,  # Top-left corner of the oval
    210, 160,  # Bottom-right corner of the oval
    -fill => 'red',     # Fill color of the ball
    -outline => 'white' # Outline color of the ball
);

# Subroutine to move the ball
sub move_ball {
    # Move the ball by its velocity
    $canvas->move($ball, $ball_xv, $ball_yv);

    # Get the ball's current position
    my ($ball_left, $ball_top, $ball_right, $ball_bottom) = $canvas->coords($ball);

    # Reverse direction if the ball hits the left or right boundary
    if ($ball_left <= 0 || $ball_right >= $canvas_width) {
        $ball_xv = -$ball_xv;  # Reverse horizontal direction
    }

    # Reverse direction if the ball hits the top or bottom boundary
    if ($ball_top <= 0 || $ball_bottom >= $canvas_height) {
        $ball_yv = -$ball_yv;  # Reverse vertical direction
    }

    # Schedule the next frame
    $my->after(50, \&move_ball);

    # Force the canvas to redraw
    $canvas->update;
}

# Start moving the ball
move_ball();

# Create a label
my $label = $my->Label(
    -text => 'Pong Game Thing',
    -font => 'Arial 12'
)->pack(
    -padx => 10,
    -pady => 10
);

# Start the main event loop
MainLoop;
