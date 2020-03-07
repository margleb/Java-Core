import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("img/java.jpg");
        BufferedImage image = ImageIO.read(file);
        BufferedImage imageFiltered = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        AffineTransform affintTransform = AffineTransform.getRotateInstance(45, image.getWidth() / 2, image.getWidth() / 2);
        BufferedImageOp Op = new AffineTransformOp(affintTransform, AffineTransformOp.TYPE_BILINEAR);
        Op.filter(image, imageFiltered);

        ImageIO.write(imageFiltered, "png", new File("javaExample.jpg"));
    }
}
