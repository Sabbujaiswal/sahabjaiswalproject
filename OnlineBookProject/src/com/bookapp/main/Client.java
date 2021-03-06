package com.bookapp.main;

import java.util.List;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.service.BookImpl;
import com.bookapp.service.BookInter;

public class Client {
	

	public static void main(String[] args) throws AuthorNotFoundException,CategoryNotFoundException {
	
		BookInter bookInter = new BookImpl();
	
			
			
			Scanner sc=new Scanner(System.in);
			
		
			for(int i=0;i<1;i++) {
				Book book = new Book();
				
				System.out.println("Enter the book title: ");
				
				String title=sc.next();
				book.setTitle(title);
				System.out.println("Enter the author name: ");
				String author=sc.next();
				book.setAuthor(author);
				System.out.println("Enter book category: ");
				String category=sc.next();
				book.setCategory(category);
				System.out.println("Enter BookId: ");
				int bookId=sc.nextInt();
				book.setBookid(bookId);
				System.out.println("Enter the book price: ");
				int price=sc.nextInt();
				System.out.println();
				book.setPrice(price);
				bookInter.addBook(book);
				
			}
			
			System.out.println("If you want to filter books input 1|for No input 2");
			int searchFilter=sc.nextInt();
			switch (searchFilter) {
			case 1:
				
					System.out.println("Search by author (or) category ");
					String decision1=sc.next();
					
					if(decision1.equalsIgnoreCase("author")){
						System.out.println("Enter author name for search: ");
						sc.nextLine();
						String authorNameSearch=sc.nextLine();
					List authorName=bookInter.getBookbyAuthor(authorNameSearch);
					if(!authorName.isEmpty()) {
						System.out.println(authorName);
						
					}
				
					break;
						
						
						
					}
					else if (decision1.equalsIgnoreCase("Category")) {
						System.out.println("Enter category name for search: ");
						
						String categorySearch=sc.next();
						System.out.println(bookInter.getBookbycategory(categorySearch));
						List categoryName=bookInter.getBookbycategory(categorySearch);
						if (!categoryName.isEmpty()) {
							System.out.println(categoryName);
						}
						break;
						
					}else {
						System.out.println("Enter the correct input");
						System.out.println();
						
					}
					
			
				break;
				
			case 2:
				System.out.println(bookInter.getAllBooks());
				System.exit(0);	
			default:
				System.out.println("Enter the correct input");
			}
			sc.close();
			
		}
}
	


