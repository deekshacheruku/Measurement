package quantity;

public class MassQuantity {
    private double value;
    private MassType massName;

    public MassQuantity(double value, MassType massName) throws InValidQuantityValueException {
        if(value <= 0)
            throw new InValidQuantityValueException("Mass Quantity doesn't support Zero or Negative Values");
        this.value = value;
        this.massName = massName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MassQuantity quantity = (MassQuantity) o;
        return convertQuantityValueInToGrams(quantity) == convertQuantityValueInToGrams(this);
    }

    private double convertQuantityValueInToGrams(MassQuantity quantity) {
        if(quantity.massName.name().equals("KILOGRAM"))
            return quantity.value * 1000;
        return quantity.value;
    }

    public MassQuantity add(MassQuantity quantity) throws InValidQuantityValueException {
        double valueInGram = convertQuantityValueInToGrams(this) + convertQuantityValueInToGrams(quantity);
        return new MassQuantity(valueInGram, MassType.GRAM);
    }

    public MassQuantity subtract(MassQuantity quantity) throws InValidQuantityValueException, NegativeSubtractionException {
        double firstQuantity = convertQuantityValueInToGrams(this);
        double secondQuantity = convertQuantityValueInToGrams(quantity);
        if(firstQuantity < secondQuantity)
            throw  new NegativeSubtractionException("Larger Quantity Value can't be subtracted from Smaller Quantity");
        double valueInGram =  firstQuantity - secondQuantity;
        return  new MassQuantity(valueInGram,MassType.GRAM);
    }
}
