package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 *
 * The {@code Renderer} class provides rendering models on the
 * screen
 * <p>
 * Implementation note: the screen must be prepared by {@prepare}
 * method before the model is rendered.
 *
 * @author kleinmichal
 * @since 31.DECEMBER.2018
 */
public class Renderer {

    /**
     * Prepares the renderer before rendering
     */
    public void prepare(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glClearColor(1,0,0,1);
    }

    /**
     * {@code renderer} renders specified {@code model} on
     * the screen.
     * @param model
     */
    public void render(RawModel model){
        GL30.glBindVertexArray(model.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawElements(GL11.GL_TRIANGLES,model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    }
}
