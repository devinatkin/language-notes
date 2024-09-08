use beryllium::{
    events::Event,
    init::InitFlags,
    video::{CreateWinArgs, RendererFlags},
    Sdl,
  };
  use pixel_formats::r8g8b8a8_Srgb;
  
  fn check_collision(ball_x: i32, ball_y: i32, ball_w: i32, ball_h: i32, 
    paddle_x: i32, paddle_y: i32, paddle_w: i32, paddle_h: i32) -> bool {
    // Check for collision between two rectangles (ball and paddle)
    ball_x < paddle_x + paddle_w &&
    ball_x + ball_w > paddle_x &&
    ball_y < paddle_y + paddle_h &&
    ball_y + ball_h > paddle_y
    }

  fn main() {
    // Initializes SDL2
    let sdl = Sdl::init(InitFlags::EVERYTHING);
  
    for info in sdl.get_renderer_driver_infos().unwrap() {
      println!("RendererDriver: {info:?}");
    }
  
    // Makes the window with an associated SDL Renderer.
    let win = sdl
      .create_renderer_window(
        CreateWinArgs { title: "Ping Pong", ..Default::default() },
        RendererFlags::ACCELERATED_VSYNC,
      )
      .unwrap();
    println!("Created The Renderer Window!");
    println!("Selected Renderer Info: {:?}", win.get_renderer_info());
  
    let pix_buf = [r8g8b8a8_Srgb { r: 255, g: 127, b: 16, a: 255 }; 64];
    let surface = sdl.create_surface_from(&pix_buf, 8, 8).unwrap();
    let tex = win.create_texture_from_surface(&surface).unwrap();
  
    let mut ballX = 200;
    let mut ballY = 200;

    // Ball velocity (how much the ball moves each frame)
    let mut ballX_vel = -5;
    let mut ballY_vel = 3;

    let paddleX = 50;
    let mut paddleY = 50;

    let paddleX2 = 700;
    let mut paddleY2 = 50;

    let paddleWidth = 30;
    let paddleHeight = 200;

    let ballWidth = 20;
    let ballHeight = 20;

    // program "main loop".
    'the_loop: loop {
      // Process events from this frame.
      #[allow(clippy::never_loop)]
      #[allow(clippy::single_match)]
      while let Some((event, _timestamp)) = sdl.poll_events() {
        match event {
            Event::MouseMotion { win_id, mouse_id, button_state, x_win, y_win, x_delta, y_delta } => {
                paddleY = y_win;
                if (paddleY+ paddleHeight > 600){
                    paddleY = 600 - paddleHeight;
                }
            }
          Event::Quit => break 'the_loop,
          _ => (),
        }



      }


    if((ballY + (ballHeight/2) > paddleY2 + (paddleHeight/2))){
        paddleY2 = paddleY + 1;
    } else{
        paddleY2 = paddleY2 - 1;
    }

    // Update Ball Position
    ballX = ballX + ballX_vel;
    ballY = ballY + ballY_vel;

    // Simple boundary check (reverse direction when hitting screen edges)
    if ballX <= 0 || ballX + ballWidth >= 800 {  // assuming window width is 800
        ballX_vel = -ballX_vel;
    }
    if ballY <= 0 || ballY + ballHeight >= 600 {  // assuming window height is 600
        ballY_vel = -ballY_vel;
    }

    // Collision detection with the left paddle
    if check_collision(ballX, ballY, ballWidth, ballHeight, paddleX, paddleY, paddleWidth, paddleHeight) {
        ballX_vel = -ballX_vel; // Reverse ball direction on X-axis
    }

    // Collision detection with the right paddle
    if check_collision(ballX, ballY, ballWidth, ballHeight, paddleX2, paddleY2, paddleWidth, paddleHeight) {
        ballX_vel = -ballX_vel; // Reverse ball direction on X-axis
    }

    // Check ball intersection with the paddles

    win.set_draw_color(u8::MAX, u8::MAX, u8::MAX, u8::MAX).unwrap();
    win.clear().unwrap();
  
    win.set_draw_color(0, 0, 0, u8::MAX).unwrap();
    win.draw_rects(&[[ paddleX, paddleY , paddleWidth, paddleHeight]]).unwrap();
    win.draw_rects(&[[ paddleX2, paddleY2 , paddleWidth, paddleHeight]]).unwrap();
    
    win.fill_rects(&[[ballX, ballY, ballWidth, ballHeight]]).unwrap();

      win.present();
    }
  

    // All the cleanup is handled by the various drop impls.
  }