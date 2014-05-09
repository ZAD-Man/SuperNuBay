package edu.neumont.csc380.Database;

import java.util.HashMap;

public class Items {
	private HashMap<Long, Item> table = new HashMap<Long, Item>();
	private long currentIndex = 1;
	
	public Item getById(long id) {
		return table.get(id);
	}
	
	public boolean containsItem(long id) {
		return table.containsKey(id);
	}
	
	public Item addItem(Item item) {
		item.setId(currentIndex);
		currentIndex++;
		return table.put(currentIndex, item);
		
	}
	
	public void deleteItem(Item item) {
		table.remove(item.getId());
	}
	
	public void deleteItem(long id) {
		table.remove(id);
	}
}