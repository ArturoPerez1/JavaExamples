package controller;

import model.PongModel;
import view.PongView;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * This class is an event handler for when the Pong's panel
 * is resized.
 *
 * @author bylander
 */
public class PongResizeController extends ComponentAdapter {
    private final PongModel model;
    private final PongView view;

    /**
     * @param model the model of this Pong game
     * @param view  the view of this Pong game
     */
    public PongResizeController(PongModel model, PongView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Ensure that the model gets the correct size of the view.PongPanel.
     */
    public void componentResized(ComponentEvent event) {
        Dimension size = view.getPongPanelSize();
        if (size.width != model.getWidth() || size.height != model.getHeight()) {
            model.setSize(size.width, size.height);
            view.setStatus("Size is " + size.width + " x " + size.height);
        }
    }
}


