package com.kvvssut.interviews.java.comparable;

import java.util.Comparator;

public class EmployeeComparatorByIdAndName implements Comparator<EmployeeComparable> {

    @Override
    public int compare(EmployeeComparable o1, EmployeeComparable o2) {
        int flag = o1.getId() - o2.getId();
        if (flag == 0) flag = o1.getName().compareTo(o2.getName());
        return flag;
    }

}