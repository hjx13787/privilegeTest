package privilegeTest.util;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public abstract class BasicJavaBeanModel {

    transient final protected PropertyChangeSupport pcs = new PropertyChangeSupport(
	    this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
	if (this.pcs != null)
	    this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
	if (this.pcs != null)
	    this.pcs.removePropertyChangeListener(listener);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
	return pcs;
    }

    public void clearPropertyChangeListeners() {
	final PropertyChangeListener[] propertyChangeListeners = this.pcs
		.getPropertyChangeListeners();
	for (PropertyChangeListener propertyChangeListener : propertyChangeListeners) {
	    this.pcs.removePropertyChangeListener(propertyChangeListener);
	}
    }

}
