package cl.uchile.dcc.scrabble.model.Types;

import cl.uchile.dcc.scrabble.model.Interfaces.ILogic;
import cl.uchile.dcc.scrabble.model.Abstract.AbstractBaseNumber;

/**
 * Scrabble binary type
 * Contains operation methods with other types and proper methods
 */
public class SBinary extends AbstractBaseNumber implements ILogic {
    private final String binary;

    /**
     * Scrabble binary constructor
     * @param binary Java string with 0's and 1's
     */
    public SBinary(String binary) {
        this.binary = binary;
    }

    /**
     * {@inheritDoc}
     * @param obj Object to compare
     * @return if equal to this binary
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SBinary) {
            var o = (SBinary) obj;
            return o.binary.equals(this.binary);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @return String
     */
    @Override
    public String toString() {
        return this.binary;
    }

    /**
     * {@inheritDoc}
     * @return Scrabble string of binary
     */
    @Override
    public SString toSString() {
        return new SString(this.binary);
    }

    /**
     * {@inheritDoc}
     * @return Scrabble int
     */
    @Override
    public SInt toSInt() {
        if (bitToInt(this.binary.charAt(0)) == 0) {
            return new SInt(positiveBinToInt(this.binary));
        } else {
            return new SInt(negativeBinaryToInt(this.binary));
        }
    }

    /**
     * Convert from negative binary string to int
     * @param binary String
     * @return int
     */
    private static int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    /**
     * Convert from positive binary to int
     * @param binary String
     * @return int
     */
    private static int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * Convert from single bit to int
     * @param bit char
     * @return int
     */
    private static int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /**
     * {@inheritDoc}
     * @return Scrabble float
     */
    @Override
    public SFloat toSFloat() {
        return this.toSInt().toSFloat();
    }

    /**
     * {@inheritDoc}
     * @return Scrabble binary
     */
    @Override
    public SBinary toSBinary() {
        return new SBinary(this.binary);
    }

    /**
     * {@inheritDoc}
     * @return Scrabble binary
     */
    @Override
    public SBinary negate() {
        StringBuilder negateStrBinary = new StringBuilder();
        for (char bit : this.binary.toCharArray()) {
            if (bit != '0') {
                negateStrBinary.append("0");
            } else {
                negateStrBinary.append("1");
            }
        }
        return new SBinary(negateStrBinary.toString());
    }

    /**
     * {@inheritDoc}
     * @param toOrSBinary Scrabble Binary
     * @return Scrabble binary
     */
    @Override
    public SBinary orSBinary(SBinary toOrSBinary) {
        StringBuilder outStringSBinary = new StringBuilder();
        for (int i = 0; i < this.binary.length(); i++) {
            if (this.binary.charAt(i) != '0' | toOrSBinary.toString().charAt(i) != '0') {
                outStringSBinary.append("1");
            } else {
                outStringSBinary.append("0");
            }
        }
        return new SBinary(outStringSBinary.toString());
    }

    /**
     * {@inheritDoc}
     * @param toAndSBinary Scrabble Binary
     * @return Scrabble binary
     */
    @Override
    public SBinary andSBinary(SBinary toAndSBinary) {
        StringBuilder outStringSBinary = new StringBuilder();
        for (int i = 0; i < this.binary.length(); i++) {
            if (this.binary.charAt(i) != '0' & toAndSBinary.toString().charAt(i) != '0') {
                outStringSBinary.append("1");
            } else {
                outStringSBinary.append("0");
            }
        }
        return new SBinary(outStringSBinary.toString());
    }

    /**
     * {@inheritDoc}
     * @param toOrSBool Scrabble Boolean
     * @return Scrabble binary
     */
    @Override
    public SBinary orSBool(SBool toOrSBool) {
        StringBuilder outStringSBinary = new StringBuilder();
        for (char bit : this.binary.toCharArray()) {
            if (bit != '0' | toOrSBool.getBool()) {
                outStringSBinary.append("1");
            } else {
                outStringSBinary.append("0");
            }
        }
        return new SBinary(outStringSBinary.toString());
    }

    /**
     * {@inheritDoc}
     * @param toAndSBool Scrabble Boolean
     * @return Scrabble binary
     */
    @Override
    public SBinary andSBool(SBool toAndSBool) {
        StringBuilder outStringSBinary = new StringBuilder();
        for (char bit : this.binary.toCharArray()) {
            if (bit != '0' & toAndSBool.getBool()) {
                outStringSBinary.append("1");
            } else {
                outStringSBinary.append("0");
            }
        }
        return new SBinary(outStringSBinary.toString());
    }

    /**
     * Change sign of binary
     * @return Scrabble binary
     */
    public SBinary twosComplements() {
        SBinary negateSBinary = this.negate();
        return negateSBinary.addOne();
    }

    /**
     * Sum binary with one
     * @return Scrabble binary
     */
    public SBinary addOne() {
        StringBuilder resultString = new StringBuilder();
        StringBuilder builderBinary = new StringBuilder(this.binary);
        int n = builderBinary.length() - 1;

        if (builderBinary.charAt(n) == '0') {
            builderBinary.setCharAt(n, '1');
            return new SBinary(builderBinary.toString());
        } else if (builderBinary.charAt(n) == '1' & n > 0) {
            resultString.append("0");
            SBinary recursionSBinary = new SBinary(builderBinary.substring(0, n));
            SBinary recursionSBinaryOne = recursionSBinary.addOne();
            return new SBinary(recursionSBinaryOne.toString() + resultString);
        } else {
            resultString.append("0");
            return new SBinary("1" + resultString);
        }
    }

    /**
     * {@inheritDoc}
     * @param toAddSBinary Scrabble binary
     * @return Scrabble binary
     */
    @Override
    public SBinary addSBinary(SBinary toAddSBinary) {
        SInt thisSInt = this.toSInt();
        SInt toAddSIntBinary = toAddSBinary.toSInt();
        SInt resultSInt = thisSInt.addSInt(toAddSIntBinary);
        return resultSInt.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toMinusSBinary Scrabble binary
     * @return Scrabble binary
     */
    @Override
    public SBinary minusSBinary(SBinary toMinusSBinary) {
        SInt sIntThis = this.toSInt();
        SInt toMinusSIntBinary = toMinusSBinary.toSInt();
        SInt resultSInt = sIntThis.minusSInt(toMinusSIntBinary);
        return resultSInt.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toTimesSBinary Scrabble binary
     * @return Scrabble binary
     */
    @Override
    public SBinary timesSBinary(SBinary toTimesSBinary) {
        SInt sIntThis = this.toSInt();
        SInt toTimesSIntBinary = toTimesSBinary.toSInt();
        SInt resultSInt = sIntThis.timesSInt(toTimesSIntBinary);
        return resultSInt.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toDivideSBinary Scrabble binary
     * @return Scrabble binary
     */
    @Override
    public SBinary divideSBinary(SBinary toDivideSBinary) {
        SInt sIntThis = this.toSInt();
        SInt toDivideSIntBinary = toDivideSBinary.toSInt();
        SInt resultSInt = sIntThis.divideSInt(toDivideSIntBinary);
        return resultSInt.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toAddSInt Scrabble int
     * @return Scrabble binary
     */
    @Override
    public SBinary addSInt(SInt toAddSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.addSInt(toAddSInt);
        return resultSInt.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toMinusSInt Scrabble int
     * @return Scrabble binary
     */
    @Override
    public SBinary minusSInt(SInt toMinusSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.minusSInt(toMinusSInt);
        return resultSInt.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toTimesSInt Scrabble int
     * @return Scrabble binary
     */
    @Override
    public SBinary timesSInt(SInt toTimesSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.timesSInt(toTimesSInt);
        return resultSInt.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toDivideSInt Scrabble int
     * @return Scrabble binary
     */
    @Override
    public SBinary divideSInt(SInt toDivideSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.divideSInt(toDivideSInt);
        return resultSInt.toSBinary();
    }
}