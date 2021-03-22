
import java.util.ArrayList;

public class ToyStore {
    private ArrayList<Toy> toyList;

    public ToyStore() {
    }

    public void loadToys(String toys) {
        toyList = new ArrayList<Toy>();
        for (String item : toys.split(" ")) {
            Toy t = getThatToy(item);
            if (t == null) {
                toyList.add(new Toy(item));
            } else {
                t.setCount(t.getCount() + 1);
            }
        }
    }

    public Toy getThatToy(String nm) {
        for (Toy item : toyList) {
            if (item.getName().equals(nm)) {
                return item;
            }
        }
        return null;
    }

    public String getMostFrequentToy() {
        int position = 0;
        int maximum = Integer.MIN_VALUE;
        for (int i = toyList.size() - 1; i >= 0; i--) {
        	if (toyList.get(i).getCount() > maximum) {
                maximum = toyList.get(i).getCount();
                position = i;
            }
        }
        return toyList.get(position).getName();
    }

    public void sortToysByCount() {
        ArrayList<Toy> t = new ArrayList<Toy>();
        int count = 0;
        int size = toyList.size();

        for (int i = size; i > 0; i--) {
            t.add(new Toy(getMostFrequentToy()));
            t.get(count).setCount(getThatToy(getMostFrequentToy()).getCount());
            toyList.remove(getThatToy(getMostFrequentToy()));
            count++;
        }

        toyList = t;
    }

    public String toString() {
        return toyList + "" + "\n" + "max == " + getMostFrequentToy();
    }
}