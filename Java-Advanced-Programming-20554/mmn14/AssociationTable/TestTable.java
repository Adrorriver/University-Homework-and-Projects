/**
 * Class for testing AssociationTable class
 * 
 * @author (amir dror) 
 * 
 */
public class TestTable {

	private static int NUM_OF_NEW_ITEM = 1;
	private static int ITEM_EXIST = 1;

	public static void main(String[] args) {
		AssociationTable<Item, Integer> table = null;
		Item[] itemArr = new Item[3];
		itemArr[0] = new Item("sl12", "white_shirt", 65);
		itemArr[1] = new Item("a", "blue_shirt", 23);
		itemArr[2] = new Item("111jk", "red_shirt", 75.6);

		Integer[] countArr = { 4, 6, 8 };
		try {
			table = new AssociationTable<Item, Integer>(itemArr, countArr);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		table.printTable();
		addNewItem(table, new Item("sl1", "orange_shirt", 50));
		if (table.keyIterator().hasNext()) {
			Item del = table.keyIterator().next();
			deleteItem(table, del);
		}
		System.out.println("\n\n after change: \n "); 
		table.printTable();
	}

	private static boolean deleteItem(AssociationTable<Item, Integer> table, Item item) {
		if (!table.contains(item)) {
			System.out.println("item to delete not exist");
			return false;
		} else if (table.get(item) > ITEM_EXIST) {
			int tmp = table.get(item);
			tmp--;
			table.add(item, tmp);// add on top of the item no need to remove
			return true;
		} else {
			table.remove(item);
			return true;
		}
	}

	public static void addNewItem(AssociationTable<Item, Integer> table, Item item) {
		if (table.contains(item)) {
			int tmp = table.get(item);
			tmp++;
			table.remove(item); //no need to remove jest for check
			table.add(item, tmp);
		} else {
			table.add(item, NUM_OF_NEW_ITEM);
		}
	}

}
