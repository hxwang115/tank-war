import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * <H2> </H2>
 *
 * @author hxwang
 * @data 2022/12/20
 */

public class ImageTest {
    @Test
    void test(){
        try {
            // ClassLoader 为类加载器
            BufferedImage read = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("imge/0.jpg"));
            assertNotNull(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        fail("Not");
        assertNotNull(new Object());

    }
}
