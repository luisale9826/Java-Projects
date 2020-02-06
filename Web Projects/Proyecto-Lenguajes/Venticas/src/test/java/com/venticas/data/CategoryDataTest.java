package com.venticas.data;

import com.venticas.domain.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDataTest {

    @Autowired
    CategoryData categoryData;

    @Test
    public void findAllTest() {
        List<ProductCategory> categories = categoryData.findAll();
        assertNotNull(categories);
        assertTrue(!categories.isEmpty());
    }
}
