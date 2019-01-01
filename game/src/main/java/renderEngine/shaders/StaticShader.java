package renderEngine.shaders;


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

public class StaticShader extends ShaderProgram{

    private static final String VERTEX_FILE = "src/main/java/renderEngine/shaders/vertexShader.txt";
    private static final String FRAGMENT_FILE = "src/main/java/renderEngine/shaders/fragmentShader.txt";

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
