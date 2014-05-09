package edu.neumont.csc380.Database;

import java.util.HashMap;

public class Items {
	private HashMap<Long, Item> table = new HashMap<Long, Item>();
	private long currentIndex = 1;
	
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