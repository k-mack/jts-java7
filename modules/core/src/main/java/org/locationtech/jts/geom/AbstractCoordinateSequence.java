/*
 * Copyright (c) 2021 Vivid Solutions
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v20.html
 * and the Eclipse Distribution License is available at
 *
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.locationtech.jts.geom;

/**
 * Provides an internal default implementation of {@link CoordinateSequence}.
 */
public abstract class AbstractCoordinateSequence implements CoordinateSequence
{
    @Override
    public int getMeasures() {
        return 0;
    }

    @Override
    public boolean hasZ() {
        return (getDimension()-getMeasures()) > 2;
    }

    @Override
    public boolean hasM() {
        return getMeasures() > 0;
    }

    @Override
    public Coordinate createCoordinate() {
        return Coordinates.create(getDimension(), getMeasures());
    }

    @Override
    public double getZ(int index)
    {
        if (hasZ()) {
            return getOrdinate(index, 2);
        } else {
            return Double.NaN;
        }
    }

    @Override
    public double getM(int index)
    {
        if (hasM()) {
            final int mIndex = getDimension()-getMeasures();
            return getOrdinate( index, mIndex );
        }
        else {
            return Double.NaN;
        }
    }

    @Override
    public abstract Object clone();
}
