package assignment.pkg8;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author anisoaraavram
 */
public class MovingFace extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;

    // GAME VARIABLES WOULD GO HERE
    //new colour that is skin like
    Color skin = new Color(247, 213, 198);

    //new colour for the hair that is brown
    Color brown = new Color(148, 104, 55);

    //new colour for the hoodie that is worn
    Color hoodieCol = new Color(63, 204, 197);

    //creating strokes to make lines thicker
    Stroke normal = new BasicStroke();
    //A 20 stroke
    Stroke thicker = new BasicStroke(20);
    //A 50 stroke
    Stroke thickerline = new BasicStroke(50);
    
    //creating the closing mouth
    int mouth = 250;
    //creating the animation for the mouth, starting setting
    int mouthdirection = 1;
    
    //creaing the top eye lid
    int topeye = 250;
    //creating the animation for the eye, starting setting
    int eyedirection = 1;
    
    //creating the land height
    int runheight = 350;
    //creating the animation for the land
    int landdirection = 1;

    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //more advanced version of the Grpagics
        Graphics2D g2d = (Graphics2D) g;

        //making stroke normal
        g2d.setStroke(normal);
        // GAME DRAWING GOES HERE 
        
        //drawing the sky
        g.setColor(Color.cyan);
        
        //drawing the rectangle
        g.fillRect(0, 0, 800, 600);
        //drawing the grass
        g.setColor(Color.GREEN);
        
        //drawing the grass
        g.fillOval(-200, runheight, 1200, 500);
        
        //sking colour for the face
        g.setColor(skin);

        //drawing the eyebrow section of the face
        g.fillOval(200, 150, 300, 140);

        //drawing the mouth base
        g.fillOval(210, 160, 100, 350);

        //drawing the forehead
        g.fillOval(210, 80, 300, 250);

        //drawing the reast of the head in
        g.fillOval(220, 250, 200, 200);

        //fill in the back space of the head
        g.fillOval(270, 250, 200, 200);

        //drawing the nose
        g.fillOval(195, 260, 60, 50);

        //making the lines thicker
        g2d.setStroke(thickerline);

        //grawing the jaw
        g.drawLine(274, 477, 440, 400);

        //changing into another stroke
        g2d.setStroke(thicker);

        //drawing the nose bridge
        g.drawLine(205, 284, 163, 380);

        //making the line thinner
        g2d.setStroke(normal);

        //drawing the bottom of the nose
        g.fillOval(150, 370, 100, 30);

        //filling in the nose
        g.fillOval(180, 290, 50, 90);
        g.fillOval(170, 355, 30, 30);

        //building the neck
        g.fillOval(340, 320, 150, 400);

        //building the body
        g.fillOval(245, 500, 300, 250);

        //chaning the colour for the hair
        g.setColor(brown);
        //making the line tihicker
        g2d.setStroke(thickerline);
        //drawing the eyebrow
        g.drawLine(220, 145, 300, 120);

        //reseating the line to another thickness
        g2d.setStroke(thicker);
        //drawing a line for the hair line
        g.drawLine(400, 280, 410, 340);

        //changing the colour
        g.setColor(hoodieCol);
        //drawing the hair
        g.fillArc(160, 10, 500, 600, 250, 250);

        //creating the rest of the hoodie
        g.fillOval(245, 500, 350, 300);

        //changing the color to make the white part of the eye
        g.setColor(Color.WHITE);
        //darwing the eye
        g.fillOval(240, 260, 50, 30);

        //changing the colour for the eyes and mouth
        g.setColor(Color.black);
        //drawing the eye
        g.fillOval(240, 265, 20, 20);
        //drawing the nouth
        g.fillOval(240, 440, 25,30);
        
        //setting the skin color
        g.setColor(skin);
        //drawing the animtion of the mouth closing
        g.fillOval(mouth, 435, 30, 40);
        //drawing a thicker line for the eyelids
        g2d.setStroke(thickerline);
        //drawing the eyes to close them
        g.drawLine(245, topeye, 290, topeye);
        
        //chaning the colour for the hair
        g.setColor(brown);
        //making the line tihicker
        g2d.setStroke(thicker);
        //drawing the eyebrow
        g.drawLine(240, 230, 300, 240);
        

        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //creating the animation for the land to move up and down
            if(runheight == HEIGHT-250){
                landdirection = 1;
            }
            //making the land go back up
            if(runheight == HEIGHT-200){
                landdirection = -1;
            }
            //moving the land
            runheight = runheight + landdirection;
            
            //creating the animation for the mouth, making it move left
            if(mouth > WIDTH-520){
                mouthdirection = -1;
            }
            //moving the mouth to it's left limit then going back right
            if(mouth < 245){
                mouthdirection = 1;
            }
            //moving the mouth
            mouth = mouth + mouthdirection*1;
            
            //having the eyes close
            if(topeye > HEIGHT-240){
                eyedirection = -1;
            }
            //creating the animation of the eye blinking down
            if(topeye < 266){
                eyedirection = 1;
            }
            //creating the animation to move
            topeye = topeye + eyedirection*1;
            
            //making the chest moving back and forth.
            
            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        MovingFace game = new MovingFace();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());

        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
