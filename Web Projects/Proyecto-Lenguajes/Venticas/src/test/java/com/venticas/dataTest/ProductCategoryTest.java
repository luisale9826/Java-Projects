package com.venticas.dataTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venticas.data.ProductCategoryData;
import com.venticas.domain.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTest {

	@Autowired
	ProductCategoryData productCategoryData;

	@Test
	public void getCategoriesTest() {
		List<ProductCategory> categories = productCategoryData.getCategories();
		assertTrue(!categories.isEmpty());
	}

	@Test
	public void addCategoryTest() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName("Cosmeticos");
		productCategory.getTax().setId(13);
		productCategoryData.addCategory(productCategory);
	}
	
	@Test
	public void updateCategoryTest() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(5);
		productCategory.setName("Cosmetico");
		productCategory.getTax().setId(13);
		productCategoryData.updateCategory(productCategory);
	}
	
	@Test
	public void deleteCategoryTest() {
		productCategoryData.deleteCategory(6);
	}
	
	@Test
	public void findCategoryByNameTest() {
		ProductCategory category = productCategoryData.findCategoryByName("Entretenimiento");
		assertNotNull(category);
	}

}
