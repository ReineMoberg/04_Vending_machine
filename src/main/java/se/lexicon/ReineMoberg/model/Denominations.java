package se.lexicon.ReineMoberg.model;

public enum Denominations {
    D1(1,"1kr"),
    D2(2,"2kr"),
    D5(5,"5kr"),
    D10(10,"10kr"),
    D20(20,"20kr"),
    D50(50,"50kr"),
    D100(100,"100kr"),
    D200(200,"200kr"),
    D500(500,"500kr"),
    D1000(1000,"1000kr");

    private int valueInt;
    private String valueText;

    Denominations(int valueInt, String valueText) {
        this.valueInt = valueInt;
        this.valueText = valueText;
    }

    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }
}
