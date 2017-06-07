package business.control;

import business.model.Enbroidery;


public class ProductEnbroideryControl {
    protected Enbroidery enbroidery;
    protected ProductEnbroideryCaretaker caretaker;

    public ProductEnbroideryControl() {
        this.caretaker = new ProductEnbroideryCaretaker();
	this.enbroidery = new Enbroidery();
    }

    public void addPersonalization(Enbroidery newEnbroidery) {
        caretaker.addMemento(new ProductEnbroideryMemento(this.enbroidery));
        this.enbroidery = newEnbroidery;
    }

    public void undoPersonalization() {
	this.enbroidery = caretaker.getLastSavedState().getSavedEnbroidery();
    }

    public boolean showPersonalization() {
	if(!this.enbroidery.equals(null)){
            System.out.println(this.enbroidery.toString());
            return true;
	}
	return false;
    }
}
