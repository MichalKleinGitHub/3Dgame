package models;

/**
 *
 * The {@code RawModel} class provides
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
public class RawModel {

    private int vaoID;
    private int vertexCount;

    /**
     *
     * @param vaoID
     * @param vertexCount
     */
    public RawModel(int vaoID, int vertexCount){
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;
    }

    /**
     *
     * @return
     */
    public int getVaoID() {
        return vaoID;
    }

    /**
     *
     * @return
     */
    public int getVertexCount() {
        return vertexCount;
    }
}

