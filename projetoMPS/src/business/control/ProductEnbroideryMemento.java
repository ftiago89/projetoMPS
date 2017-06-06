package business.control;

import business.model.Enbroidery;


public class ProductEnbroideryMemento {
    protected Enbroidery EnbroideryState;

    public ProductEnbroideryMemento(Enbroidery enbroidery) {
	this.EnbroideryState = enbroidery;
    }

    public Enbroidery getSavedEnbroidery() {
	return this.EnbroideryState;
    }
}
