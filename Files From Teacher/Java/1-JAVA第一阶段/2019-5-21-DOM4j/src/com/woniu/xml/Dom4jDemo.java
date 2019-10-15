package com.woniu.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {

	public static void main(String[] args) throws DocumentException {
		List<Book> bookList = new ArrayList<Book>();
		//dom for java
		//生成一个解析对象
		SAXReader reader = new SAXReader();
		//读取文件内容
		Document document = reader.read("src/config.xml");
		//通过文档对象获得根标签
		Element root = document.getRootElement();
		//通过迭代获得标签的子标签
		Iterator<Element> it = root.elementIterator();
		while(it.hasNext()){
			Book book = new Book();
			Element element = it.next();
			System.out.println(element.getName());
//			List<Attribute> as = element.attributes();
//			for(Attribute a:as){
//				System.out.println(a.getName()+":"+a.getValue());
//			}
			//通过迭代获得标签的子标签
			Iterator<Element> it2 = element.elementIterator();
			while(it2.hasNext()){
				Element e = it2.next();
				switch(e.getName()){
					case "id":
						book.setId(Integer.parseInt(e.getStringValue()));
						break;
					case "name":
						book.setName(e.getStringValue());
						break;
					case "author":
						book.setAuthor(e.getStringValue());
						break;
					case "price":
						book.setPrice(Integer.parseInt(e.getStringValue()));
						break;
				}
				
			}
			bookList.add(book);
		}
		for(Book book:bookList){
			System.out.println(book);
		}
	}

}
