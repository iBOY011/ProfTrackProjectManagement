package ma.ac.usms.ensak.presentation.controller;


import ma.ac.usms.ensak.presentation.Views.VBoxes.DocumentBox;

/**
 * The DocumentBoxController class represents a controller for managing the DocumentBox.
 * It provides methods to access and manipulate the DocumentBox object.
 */
public class DocumentBoxController {
    private static DocumentBox documentBox = new DocumentBox();

    /**
     * Constructs a new DocumentBoxController object.
     */
    public DocumentBoxController() {
    }

    /**
     * Returns the DocumentBox object.
     *
     * @return the DocumentBox object
     */
    public DocumentBox getDocumentBox() {
        return documentBox;
    }
}
