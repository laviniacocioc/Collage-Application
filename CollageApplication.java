package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {
        Image monaLisa = new Image("file:monalisa.png"); // Ensure the image path is correct

        int originalWidth = (int) monaLisa.getWidth();
        int originalHeight = (int) monaLisa.getHeight();
        int scaledWidth = originalWidth / 2;
        int scaledHeight = originalHeight / 2;

        WritableImage smallImage = new WritableImage(scaledWidth, scaledHeight);
        PixelReader reader = monaLisa.getPixelReader();
        PixelWriter writer = smallImage.getPixelWriter();

        // Create the smaller image
        for (int y = 0; y < scaledHeight; y++) {
            for (int x = 0; x < scaledWidth; x++) {
                Color color = reader.getColor(x * 2, y * 2);
                writer.setColor(x, y, color);
            }
        }

        // Create the final image with the grid
        WritableImage finalImage = new WritableImage(originalWidth, originalHeight);
        PixelWriter finalWriter = finalImage.getPixelWriter();

        // Top-left
        copyImage(smallImage, finalWriter, 0, 0);
        // Top-right
        copyImage(smallImage, finalWriter, scaledWidth, 0);
        // Bottom-left
        copyImage(smallImage, finalWriter, 0, scaledHeight);
        // Bottom-right
        copyImage(smallImage, finalWriter, scaledWidth, scaledHeight);

        // Apply negative effect
        applyNegativeEffect(finalImage);

        // Display the final image
        Pane pane = new Pane();
        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(finalImage);
        pane.getChildren().add(imageView);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Warhol-style Mona Lisa");
        stage.show();
    }

    private void copyImage(WritableImage source, PixelWriter writer, int offsetX, int offsetY) {
        PixelReader reader = source.getPixelReader();
        int width = (int) source.getWidth();
        int height = (int) source.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x + offsetX, y + offsetY, reader.getColor(x, y));
            }
        }
    }

    private void applyNegativeEffect(WritableImage image) {
        PixelReader reader = image.getPixelReader();
        PixelWriter writer = image.getPixelWriter();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = reader.getColor(x, y);
                Color negativeColor = new Color(1.0 - color.getRed(), 1.0 - color.getGreen(), 1.0 - color.getBlue(), color.getOpacity());
                writer.setColor(x, y, negativeColor);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
