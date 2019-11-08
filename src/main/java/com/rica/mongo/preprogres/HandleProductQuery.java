package com.rica.mongo.preprogres;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.rica.mongo.model.Product;
import com.rica.mongo.model.Seller;
import com.rica.mongo.model.Staff;
import com.rica.mongo.repo.ProductRepository;

public class HandleProductQuery {

	public Product findProduct(String pName)  {
		Document document = null;
		try {
			document = Jsoup.connect("https://www.cimri.com/arama?q="+pName).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		Product nProduct=new Product();
		
		nProduct.setName(pName);
		List<Staff> staffList=new ArrayList<>();
		//A mechanism to skip ads
		boolean skipProduct=false;
	//	System.out.println("Doc ->"+document);
		Element aa=document.getElementById("main_container");
		Elements all=aa.getAllElements();
	//	System.out.println("All Size-> "+all.size());
	
    		for(Element element:all) {
    			Elements products = element.getElementsByTag("article");
    			Staff nstaff=new Staff();
    			List<Seller> sll= new ArrayList<>();
    			for(Element product:products) {

    				//Get Product Name
    				Elements names=product.getElementsByClass("product-title");
    				nstaff.setProductName(names.attr("title"));
    			
    	
    				Elements tag=product.getElementsByTag("img");
    				for(Element img1:tag) {
    					String imgurl=img1.attr("data-src");
    					if(imgurl!=null && !imgurl.isEmpty() ) {
    						//System.out.println("Resim Adresi-->"+imgurl);
    						nstaff.setImgUrl("http:"+imgurl);
    						//basic dublication prevents
    						//We could use HashMap but our client already coded. 
    						//I don't want to change rest flow
    						for(int i=0;i<staffList.size();i++) {
    							if(staffList.get(i).getImgUrl().equals(nstaff.getImgUrl())) {
    								skipProduct=true;
    							}
    								
    						}
    							
    					}
    				}
    				
    				//System.out.println("RIFAT ->"+maxProduct+ "\n"+nstaff.getImgUrl()+"\n"+"\n------ "+product+"\n------");
    	
    				
    				Elements links=product.getElementsByTag("a");
    		    	sll=new ArrayList<>();
    		    	//System.out.println("sll empty?"+sll.size());
    		    	if(!skipProduct)
    				for(Element link:links) {
    					//System.out.println("RIFAT -> "+maxProduct+"\n----LINK-----"+link+"\n\n\n\n");
    					Seller ns=new Seller();
    					String urlproduct=link.attr("href");
    					if(urlproduct.contains("PRODUCTBOOST"))
    						skipProduct=true;
    					ns.setUrl(urlproduct);
    					//System.out.println("Ürün sayfasi->"+urlproduct);
     					String price=link.text();
    					//Bottom fails
     					Elements tags2=link.getElementsByTag("div");
    					price=price.replaceAll(link.getElementsByTag("div").toString(),"");
    					price=price.replace(link.getElementsByTag("span").toString(), "");
    					ns.setName(tags2.text());
    					//System.out.println("Dükkan Adi->"+tags2.text());
    					for(Element txt:tags2) {
    						price=price.replace(txt.text(), "");
    					}
    					try {
    					if(price!=null && ns!=null)
    						ns.setPrice(price);
    					
    					if(!ns.getName().isEmpty())
    						sll.add(ns);
    					
	    				} catch (Exception e) {
	    					// TODO: handle exception
	    					System.out.println("EXCEPTION"+e);
	    				}
    				}

					
    			}
    			nstaff.setSellers(sll);
    			if(nstaff!=null && !skipProduct && nstaff.getImgUrl()!=null && nstaff.getSellers().size()>0)
    				staffList.add(nstaff);    			
    			skipProduct=false;
    		}
	

		
		if(staffList!=null)
			nProduct.setStaff(staffList);
		return nProduct!=null?nProduct:null;
	}
}
