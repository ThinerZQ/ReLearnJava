package com.zq.innerclass;

/**
 * Created by zhengshouzi on 2015/9/29.
 */
public class OuterInner {
    private String label;

    private void setLabel(String s) {
        label = s;
    }

    protected class InnerClass {

        public void setOuterLabel() {
            label = "innerset";
        }


    }

    public void innerClassCall() {
        new InnerClass().setOuterLabel();
    }

    public static void main(String[] args) {
        OuterInner outerInner = new OuterInner();
        outerInner.innerClassCall();
        System.out.println(outerInner.label);
    }


}
