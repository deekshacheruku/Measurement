package quantity;

public class LengthQuantity {
    private double value;
    private LengthType lengthName;

    public LengthQuantity(double value, LengthType quantityName) throws InValidQuantityValueException {
        if (value <= 0)
            throw new InValidQuantityValueException("Length Quantity doesn't support Negative Or Zero Values");
        this.value = value;
        this.lengthName = quantityName;
    }

    public LengthQuantity convertIntoExpectedLengthType(LengthType expectedLENGTH, double valueInMeter) throws InValidQuantityValueException {
        if (expectedLENGTH.name().equals("METER"))
            return new LengthQuantity(valueInMeter, LengthType.METER);
        else if (expectedLENGTH.name().equals("CENTIMETER"))
            return new LengthQuantity(valueInMeter * 100, LengthType.CENTIMETER);
        else
            return new LengthQuantity(valueInMeter / 1000, LengthType.KILOMETER);
    }

    private double convertQuantityValueInToMeters(LengthQuantity quantity) {
        if (quantity.lengthName.name().equals("CENTIMETER"))
            return quantity.value / 100;
        else if (quantity.lengthName.name().equals("KILOMETER"))
            return quantity.value * 1000;
        return quantity.value;
    }

    public LengthQuantity add(LengthQuantity quantity) throws InValidQuantityValueException {
        double valueInMeter = convertQuantityValueInToMeters(this) + convertQuantityValueInToMeters(quantity);
        return new LengthQuantity(valueInMeter, LengthType.METER);
    }

    public LengthQuantity subtract(LengthQuantity quantity) throws InValidQuantityValueException, NegativeSubtractionException {
        double firstQuantity = convertQuantityValueInToMeters(this);
        double secondQuantity = convertQuantityValueInToMeters(quantity);
        if(firstQuantity < secondQuantity)
            throw  new NegativeSubtractionException("Larger Quantity Value can't be subtracted from Smaller Quantity");
        double valueInMeter =  firstQuantity - secondQuantity;
        return new LengthQuantity(valueInMeter, LengthType.METER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthQuantity quantity = (LengthQuantity) o;
        return convertQuantityValueInToMeters(quantity) == convertQuantityValueInToMeters(this);
    }
}
