package business.control;

import java.util.ArrayList;
import java.util.List;


public class ProductEnbroideryCaretaker {
    protected List<ProductEnbroideryMemento> states;

    public ProductEnbroideryCaretaker() {
        this.states = new ArrayList<ProductEnbroideryMemento>();
    }

    public void addMemento(ProductEnbroideryMemento memento) {
        if(this.states.size() == 5)
            this.states.remove(0); //erases the zero position of saved states
        this.states.add(memento);
	}

    public ProductEnbroideryMemento getLastSavedState() {
	if (this.states.size() <= 0) {
            return new ProductEnbroideryMemento(null);
	}
	ProductEnbroideryMemento savedState = this.states.get(this.states.size() - 1);
	this.states.remove(this.states.size() - 1);
	return savedState;
    }
}
