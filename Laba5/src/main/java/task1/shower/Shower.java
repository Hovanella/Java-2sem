package task1.shower;

import task1.person.Person;
import java.util.ArrayList;

public class Shower {
    private ArrayList<Person> personsInShower = new ArrayList<>();
    private int _showerCapacity;

    public Shower(int _showerCapacity) {
        this._showerCapacity = _showerCapacity;
    }

    synchronized public void personGoInShower(Person person) throws InterruptedException {
        while(personsInShower.size() >  _showerCapacity || (!personsInShower.isEmpty() ? personsInShower.get(0).getGender() != person.getGender() : false)) {
            System.out.println(person + " is waiting");
            this.wait();
        }

        personsInShower.add(person);
        System.out.println(person + " got in the shower\npeople in shower: " + personsInShower.size());
    }

    synchronized public void personCameOutOfShower(Person person) throws InterruptedException {
        personsInShower.remove(person);
        System.out.println(person + " leave the shower\npeople in shower:  " + personsInShower.size());
        this.notifyAll();
    }
}
