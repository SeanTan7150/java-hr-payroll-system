package hrpayrollsystem;

import java.io.Serializable;

public class Deduction implements Serializable {
    private static final long serialVersionUID = 20120731125400L;
    
    private int month;
    private double deductionValue;

    public Deduction(int month, double deductionValue) {
        this.month = month;
        this.deductionValue = deductionValue;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getDeductionValue() {
        return deductionValue;
    }

    public void setDeductionValue(double deductionValue) {
        this.deductionValue = deductionValue;
    }
}
