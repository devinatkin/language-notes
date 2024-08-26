#include <gtk/gtk.h>
#include <cairo.h>

int window_height = 200;
int window_width = 200;

int ball_size = 10;
int ball_x = 20;
int ball_y = 20;

int ball_xspeed = 2;
int ball_yspeed = 1;

// Function to handle the draw event
static gboolean on_draw_event(GtkWidget *widget, cairo_t *cr, gpointer user_data) {
    // Set color to blue
    cairo_set_source_rgb(cr, 0.0, 0.0, 1.0);
    
    // Draw a ball
    cairo_arc(cr, ball_x, ball_y, ball_size, 0, 2 * G_PI);

    // Fill the rectangle with the current color
    cairo_fill(cr);

    return FALSE;
}

static gboolean update_position(gpointer user_data) {
    GtkWidget *widget = GTK_WIDGET(user_data);

    if(ball_y + ball_size > window_height || ball_y - ball_size < 0){
        ball_yspeed = -ball_yspeed;
    }

    if (ball_x + ball_size > window_width || ball_x - ball_size < 0){
        ball_xspeed = -ball_xspeed;
    }

    ball_x += ball_xspeed;
    ball_y += ball_yspeed;

    gtk_widget_queue_draw(widget);

    return TRUE;
}

int main(int argc, char *argv[]) {
    // Initialize GTK
    gtk_init(&argc, &argv);

    // Create a new window
    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "Ball");
    gtk_window_set_default_size(GTK_WINDOW(window), window_width, window_height);

    gtk_window_set_resizable(GTK_WINDOW(window), FALSE);

    // Create a new drawing area
    GtkWidget *drawing_area = gtk_drawing_area_new();
    
    // Set a minimum size for the drawing area
    gtk_widget_set_size_request(drawing_area, window_width, window_height);
    
    // Connect the draw event to the callback function
    g_signal_connect(G_OBJECT(drawing_area), "draw", G_CALLBACK(on_draw_event), NULL);
    
    // Add the drawing area to the window
    gtk_container_add(GTK_CONTAINER(window), drawing_area);
    
    // Connect the window's destroy signal to the GTK main loop
    g_signal_connect(window, "destroy", G_CALLBACK(gtk_main_quit), NULL);

    // Start a timer to update at 20fps
    g_timeout_add(50,update_position,drawing_area);

    // Show all widgets in the window
    gtk_widget_show_all(window);

    // Enter the GTK main loop
    gtk_main();

    return 0;
}
