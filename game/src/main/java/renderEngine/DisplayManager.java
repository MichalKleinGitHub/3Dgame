package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 *
 * The {@code DisplayManager} class provides useful static methods
 * which can do these 3 things:
 * <ul>
 * <li>to create a display</li>
 * <li>to update a display</li>
 * <li>to close a display</li>
 * </ul>
 * Some very important constants for dealing with FPS regulation
 * and display sizes are defined here (such as {@code FPS}).
 * <p>
 * Implementation note: the OS running on your computer may have
 * an impact on how the 3D models are being drawn on the screen.
 * In fact, in this state of my understanding of this particular
 * problem I am not able to closer specify the problem, but on
 * Windows 10 is everything running how it should.
 *
 * @author kleinmichal
 * @since 31.DECEMBER.2018
 */

public class DisplayManager {

    /**
     *  A constant holding FPS value
     */
    private static final int FPS = 120;

    /**
     * Constants for defining the size of the display
     */
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    /**
     * Creates the 3D display with the width and height values saved in the
     * {@code WIDTH} and {@code HEIGHT} constants. OpenGL versions are specified
     * for {@code ContextAttribs} object creation which is a must for creating
     * {@code Display}
     * @see ContextAttribs
     *
     */
    public static void createDisplay(){
        ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("Game 21DEC18");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0,0,WIDTH,HEIGHT);

    }

    /**
     * Updates a display. The Display must be updated every time
     * when any object is expected to move to properly show
     * the movement.
     */
    public static void updateDisplay(){
        Display.sync(FPS);
        Display.update();
    }

    /**
     * Closes a display. The Display should be destroyed every
     * time when the application is expected to turn off.
     */
    public static void closeDisplay(){
        Display.destroy();
    }
}
