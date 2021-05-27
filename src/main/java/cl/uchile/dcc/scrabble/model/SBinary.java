package cl.uchile.dcc.scrabble.model;

//COMPLETE: Implement operator add with int and binary
//COMPLETE: Implement operator minus with int and binary
//COMPLETE: Implement operator times with int and binary
//COMPLETE: Implement operator divide with int and binary
//COMPLETE: Implement toSInt method
//COMPLETE: Implement toSFloat method

public class SBinary extends abstractBaseNumber implements ILogic {
    private final String binary;

    public SBinary(String binary) {
        this.binary = binary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SBinary) {
            var o = (SBinary) obj;
            return o.binary.equals(this.binary);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.binary;
    }

    @Override
    public SString toSString() {
        return new SString(this.binary);
    }

    @Override
    public SInt toSInt() {
        if (bitToInt(this.binary.charAt(0)) == 0) {
            return new SInt(positiveBinToInt(this.binary));
        } else {
            return new SInt(negativeBinaryToInt(this.binary));
        }
    }

    private static int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    private static int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    private static int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    @Override
    public SFloat toSFloat() {
        return this.toSInt().toSFloat();
    }

    @Override
    public SBinary toSBinary() {
        return new SBinary(this.binary);
    }

    @Override
    public SBinary negate() {
        String negateStrBinary = "";
        for (char bit : this.binary.toCharArray()) {
            if (bit != '0') {
                negateStrBinary = negateStrBinary + "0";
            } else {
                negateStrBinary = negateStrBinary + "1";
            }
        }
        return new SBinary(negateStrBinary);
    }

    @Override
    public SBinary orSBinary(SBinary toOrSBinary) {
        String outStringSBinary = "";
        for (int i = 0; i < this.binary.length(); i++) {
            if (this.binary.charAt(i) != '0' | toOrSBinary.toString().charAt(i) != '0') {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    @Override
    public SBinary andSBinary(SBinary toAndSBinary) {
        String outStringSBinary = "";
        for (int i = 0; i < this.binary.length(); i++) {
            if (this.binary.charAt(i) != '0' & toAndSBinary.toString().charAt(i) != '0') {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    @Override
    public SBinary orSBool(SBool toOrSBool) {
        String outStringSBinary = "";
        for (char bit : this.binary.toCharArray()) {
            if (bit != '0' | toOrSBool.getBool()) {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    @Override
    public SBinary andSBool(SBool toAndSBool) {
        String outStringSBinary = "";
        for (char bit : this.binary.toCharArray()) {
            if (bit != '0' & toAndSBool.getBool()) {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    public SBinary twosComplements() {
        SBinary negateSBinary = this.negate();
        return negateSBinary.addOne();
    }

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

    @Override
    public SBinary addSBinary(SBinary toAddSBinary) {
        SInt thisSInt = this.toSInt();
        SInt toAddSIntBinary = toAddSBinary.toSInt();
        SInt resultSInt = thisSInt.addSInt(toAddSIntBinary);
        return resultSInt.toSBinary();
    }

    @Override
    public SBinary minusSBinary(SBinary toMinusSBinary) {
        SInt sIntThis = this.toSInt();
        SInt toMinusSIntBinary = toMinusSBinary.toSInt();
        SInt resultSInt = sIntThis.minusSInt(toMinusSIntBinary);
        return resultSInt.toSBinary();
    }

    @Override
    public SBinary timesSBinary(SBinary toTimesSBinary) {
        SInt sIntThis = this.toSInt();
        SInt toTimesSIntBinary = toTimesSBinary.toSInt();
        SInt resultSInt = sIntThis.timesSInt(toTimesSIntBinary);
        return resultSInt.toSBinary();
    }

    @Override
    public SBinary divideSBinary(SBinary toDivideSBinary) {
        SInt sIntThis = this.toSInt();
        SInt toDivideSIntBinary = toDivideSBinary.toSInt();
        SInt resultSInt = sIntThis.divideSInt(toDivideSIntBinary);
        return resultSInt.toSBinary();
    }

    @Override
    public SBinary addSInt(SInt toAddSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.addSInt(toAddSInt);
        return resultSInt.toSBinary();
    }

    @Override
    public SBinary minusSInt(SInt toMinusSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.minusSInt(toMinusSInt);
        return resultSInt.toSBinary();
    }

    @Override
    public SBinary timesSInt(SInt toTimesSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.timesSInt(toTimesSInt);
        return resultSInt.toSBinary();
    }

    @Override
    public SBinary divideSInt(SInt toDivideSInt) {
        SInt thisSInt = this.toSInt();
        SInt resultSInt = thisSInt.divideSInt(toDivideSInt);
        return resultSInt.toSBinary();
    }
}