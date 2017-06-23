package com.example.theories.customSuppliers;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;


public class BetweenSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        Between annotation = (Between) sig.getAnnotation(Between.class);

        List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
        for (int i = annotation.first(); i <= annotation.last(); i++) {
            list.add(PotentialAssignment.forValue("" + i, i));
        }
        return list;
    }
}