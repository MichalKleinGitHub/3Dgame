package renderEngineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import renderEngine.shaders.StaticShader;

/**
 * MainGameLoop is the public class for testing renderEngine components.
 * These components include:
 * <ul>
 * <li>DisplayManager</li>
 * <li>Loader</li>
 * <li>RawModel</li>
 * <li>Renderer</li>
 * </ul>
 * <p>
 * The main purpose of the renderEngine components is to draw things on the screen
 * in this specific order:
 * <ol>
 * <li>create a Display if none</li>
 * <li>prepare all components from renderEngine package (for loading, rendering
 * and creating the 3D models of vertexes)</li>
 * <li>when everything is prepared the main game loop begins</li>
 * <li>before the Display is closed, delete all vertexArrays & buffers from VAO & VBO</li>
 * <li>the Display is closed</li>
 * </ol>
 * An important point to consider is that the OS running on your computer may have
 * an impact on how the 3D models are being drawn on the screen. In fact, in this
 * state of my understanding of this particular problem I am not able to closer specify
 * the problem, but on Windows 10 is everything running how it should.
 * <p>
 *
 * @author kleinmichal
 * @since 30.DECEMBER.2018
 */
public class MainGameLoop {
    public static void main(String[] args){
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, 0.5f, 0,    //V0
                -0.5f, -0.5f, 0,   //V1
                0.5f, -0.5f, 0,    //V2
                0.5f, 0.5f, 0    //V3
        };

        int[] indices = {
                0,1,3,  //Top left triangle (V0,V1,V3)
                3,1,2   //Bottom right triangle (V3,V1,V2)
        };

        RawModel model = loader.loadToVAO(vertices,indices);

        //The main game loop
        while(!Display.isCloseRequested()){
            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        //before the Display is closed, this deletes all vertexArrays & buffers from VAO & VBO
        shader.cleanUp();
        loader.cleanUP();
        DisplayManager.closeDisplay();
    }
}
