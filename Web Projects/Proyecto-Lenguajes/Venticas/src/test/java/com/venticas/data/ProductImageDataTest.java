package com.venticas.data;

import com.venticas.domain.ProductImage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductImageDataTest {

    @Autowired
    ProductImageData productImageData;

    @Test
    public void getProductImagesTest() {
        List<ProductImage> images = productImageData.getProductImages(26);
        Assert.assertNotNull(images);
        Assert.assertTrue(!images.isEmpty());
    }

    @Test
    public void deleteImagesTest() throws IOException {
        productImageData.deleteImages(25);
    }

}
