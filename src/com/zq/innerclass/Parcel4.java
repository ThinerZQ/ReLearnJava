package com.zq.innerclass;

/**
 * Created by zhengshouzi on 2015/9/29.
 */
public class Parcel4 {
    private class Pcontents implements Contents {

        @Override
        public int value() {
            return 12;
        }
    }

    protected class PDesctination implements Destination {
        private String label;

        private PDesctination(String whereto) {
            label = whereto;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDesctination(s);
    }

    public Contents contents() {
        return new Pcontents();
    }
}
