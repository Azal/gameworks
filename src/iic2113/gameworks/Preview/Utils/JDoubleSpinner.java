package iic2113.gameworks.Preview.Utils;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
* Class JDoubleSpinner
*  Class which extends JSpinner for double support. Extracted from stackoverflow.
*	@version  1.0
* @created_by @group1/fjsandov
* @author CJxD and Vishal K (stackoverflow)
* @see http://stackoverflow.com/questions/15176695/jspinner-in-double-format
*/
public class JDoubleSpinner extends JSpinner {

    private static final long serialVersionUID = 1L;
    private static final double STEP_RATIO = 0.1;

    private SpinnerNumberModel model;
    
    public JDoubleSpinner() {
        super();
        // Model setup
        model = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
        this.setModel(model);

        // Step recalculation
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Double value = getDouble();
                // Steps are sensitive to the current magnitude of the value
                long magnitude = Math.round(Math.log10(value));
                double stepSize = STEP_RATIO * Math.pow(10, magnitude);
                model.setStepSize(stepSize);
            }
        });
    }
    
    /**
     * Returns the current value as a Double
     */
    public Double getDouble() {
        return (Double)getValue();
    }
    
    /**
     * Returns the current value as a Double
     */
    public void setDouble(double value) {
        setValue(value);
    }

}
