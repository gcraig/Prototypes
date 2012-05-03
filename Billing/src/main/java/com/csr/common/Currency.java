/*
 * Enhydra Java Application Server Project
 * 
 * The contents of this file are subject to the Enhydra Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License on
 * the Enhydra web site ( http://www.enhydra.org/ ).
 * 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See 
 * the License for the specific terms governing rights and limitations
 * under the License.
 * 
 * The Initial Developer of the Enhydra Application Server is Lutris
 * Technologies, Inc. The Enhydra Application Server and portions created
 * by Lutris Technologies, Inc. are Copyright Lutris Technologies, Inc.
 * All Rights Reserved.
 * 
 * Contributor(s):
 * 
 * $Id: Currency.java,v 1.8 2004/02/27 15:08:48 draganr Exp $
 */

package com.csr.common;

import java.math.BigDecimal;

/**
 * Object to store and manipulate money.
 */
public class Currency extends BigDecimal {
    /**
     * Construct a Currency object of value zero.
     */
    public Currency() {
        super(0);
    }

    /**
     * Construct a Currency object from a BigDecimal or Currency object.
     * A null value result in an object containing zero.
     */
    public Currency(BigDecimal value) {
        super((value == null) ? 0.0 : value.doubleValue());
    }
 
    /**
     * Construct a Currency object from a double.
     */
    public Currency(double value) {
        super(value);
    }
 
    /**
     * Construct a Currency object from a float.
     */
    public Currency(float value) {
        super((double)value);
    }
 
    /**
     * Construct a Currency object from a String.
     */
    public Currency(String value) {
        this(Double.valueOf(value).doubleValue());
    }

    /**
     * Check if equal to a float value.
     */
    public boolean equals(float value) {
        return compareTo(new Currency(value)) == 0;
    }

    /**
     * Check if equal to a double value.
     */
    public boolean equals(double value) {
        return compareTo(new Currency(value)) == 0;
    }

    /**
     * Returns a Currency whose value is (this + val).
     */
    public Currency add(Currency val) {
        return new Currency(super.add(val));
    }

    /**
     * Returns a Currency whose value is (this - val).
     */
    public Currency subtract(Currency val) {
        return new Currency(super.subtract(val));
    }

    /**
     * Returns a Currency whose value is (this * val)
     */
    public Currency multiply(Currency val){
        return new Currency(super.multiply(val));
    }
            
    /**
     * Returns a Currency whose value is (this * val)
     */
    public Currency multiply(int val){
        return multiply(new Currency(val));
    }
            
    /**
     * Returns a Currency whose value is (this / val).
     */
    public Currency divide(Currency val)
        throws ArithmeticException, IllegalArgumentException {
        return new Currency(super.divide(val, 2, ROUND_HALF_UP));
    }

    /**
     * Returns a Currency whose value is (this / val).
     */
    public Currency divide(int val)
        throws ArithmeticException, IllegalArgumentException {
        return divide(new Currency((double)val));
    }

    /**
     * Returns a Currency whose value is the absolute value of this
     * number.
     */
    public Currency absCurrency() {
        return (signum() < 0 ? negateCurrency() : this);
    }

    /**
     * Returns a Currency whose value is -1 * this.
     */
    public Currency negateCurrency() {
        return new Currency(negate());
    }

    /**
     * Convert to string with two decimals.
     */
    public String toString() {
        if (scale() == 2) {
            return super.toString();
        } else {
            return setScale(2, ROUND_HALF_UP).toString();
        }
    }
}

