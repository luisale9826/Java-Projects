package com.venticas.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.venticas.domain.Family;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyDataTest {

    @Autowired
    FamilyData familyData;

    @Test
    public void findAllTest() {
        List<Family> families = familyData.findAll();
        assertNotNull(families);
        assertTrue(!families.isEmpty());
    }

    @Test
    public void findFamilyByProductIdTest() {
        List<Family> families = familyData.findFamilyByProductId(26);
        Assert.assertNotNull(families);
    }

}
