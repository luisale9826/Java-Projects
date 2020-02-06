package com.venticas.dataTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venticas.data.TaxData;
import com.venticas.domain.Tax;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxTest {

	@Autowired
	TaxData taxData;

	@Test
	public void getAllTaxesTest() {
		List<Tax> taxes = taxData.getAllTaxes();
		assertTrue(!taxes.isEmpty());
	}
	
	@Test
	public void addTaxTest() {
		Tax tax = new Tax();
		tax.setPercentage((float) 45.5);
		tax.setType("Cosméticos");
		taxData.addTax(tax);
	}
	
	@Test
	public void updateTaxTest() {
		Tax tax = new Tax();
		tax.setId(2);
		tax.setPercentage((float) 47.5);
		tax.setType("Cosméticos");
		taxData.updateTax(tax);
	}
	
	@Test
	public void deleteTaxTest() {
		taxData.deleteTax(2);
	}
	
	@Test
	public void findTaxByTypeTest() {
		Tax tax = taxData.findTaxByType("Televisor (tradicional, plasma o LCD)");
		assertNotNull(tax);
	}

}
