package com.john.mystore.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.mystore.models.Product;
import com.john.mystore.repositories.ProductRepository;

@Service
public class ProductServices {

	/*List<Product> products = new ArrayList<>(Arrays.asList(
			new Product(1, "IPhone 14", "Apple", "Phones", 80000, null,null),
			new Product(2, "Galaxy S24", "Samsung","Phones", 90000, null,null),
			new Product(3, "Alpha 7", "Sony", "Cameras",60000, null,null),
			new Product(4, "Pixma TS207", "Canon", "Printers", 45000,null,null)
		));*/
	
	@Autowired
	ProductRepository repo;
	
	public List <Product> getProducts(){
		return repo.findAll();
		//return products;
	}
	public void addProduct(Product product) {
		//products.add(product);
		repo.save(product);
	}
	public Product findProductById(int id) {
		/*int index=0;
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId() == id){
				index = i;
			}
		}
		return products.get(index);*/
		return repo.findById(id).orElse(new Product());
	}
	public void updateProduct(Product product) {
		/*int index=0;
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId() == product.getId()){
				index = i;
			}
		}
		products.set(index, product);*/
		repo.save(product);
	}
	public void deleteProduct(int id) {
		/*int index=0;
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId() == id){
				index = i;
			}
		}
		products.remove(index);*/
		repo.deleteById(id);
	}
}
