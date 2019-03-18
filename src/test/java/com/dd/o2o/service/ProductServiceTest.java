package com.dd.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dd.o2o.BaseTest;
import com.dd.o2o.dto.ImageHolder;
import com.dd.o2o.dto.ProductExecution;
import com.dd.o2o.entity.Product;
import com.dd.o2o.entity.ProductCategory;
import com.dd.o2o.entity.Shop;
import com.dd.o2o.enums.ProductStateEnum;

public class ProductServiceTest extends BaseTest {
	@Autowired
	private ProductService productService;

	@Test
	@Ignore
	public void testAddProduct() throws FileNotFoundException {
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品1");
		product.setProductDesc("测试商品1");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		File thumbnailFile = new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\me.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		File productImg1 = new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\me.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\buyi.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

	@Test
	public void testModifyProduct() throws FileNotFoundException {
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("正式的商品");
		product.setProductDesc("正式的商品");
		File thumbnailFile = new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\me.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		File productImg1 = new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\me.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\me.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

}
