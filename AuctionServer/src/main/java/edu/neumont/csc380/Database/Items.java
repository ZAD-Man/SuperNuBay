package edu.neumont.csc380.Database;

import java.util.HashMap;

public class Items {
	private HashMap<Long, Item> table = new HashMap<Long, Item>();
	private long currentIndex = 1;
	
	//-- TEST CODE --//
//	public Items(){
//		Item norm = new Item();
//		norm.setId("1");
//		norm.setName("norm");
//		norm.setPassword("password");
//		
//		Item nick = new Item();
//		nick.setId("2");
//		nick.setName("nick");
//		nick.setPassword("boneThugs");
//		
//		Item david = new Item();
//		david.setId("3");
//		david.setName("david");
//		david.setPassword("twinkleTwinkle");
//		
//		table.put("1", norm);
//		table.put("2", nick);
//		table.put("3", david);
//	}
	
	public Item getById(String id) {
		return table.get(id);
	}
	
	public boolean containsItem(String id) {
		return table.containsKey(id);
	}
	
	public void addItem(Item item) {
		item.setId(currentIndex);
		table.put(currentIndex, item);
		currentIndex++;
	}
	
	public void deleteItem(Item item) {
		table.remove(item.getId());
	}
	
	public void deleteItem(long id) {
		table.remove(id);
	}
}