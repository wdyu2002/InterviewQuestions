package com.devculture.interview;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestDoubleDispatchPattern {

    private DoubleDispatchPatternExample.HiddenShape h;
    private DoubleDispatchPatternExample.Circle c;
    private DoubleDispatchPatternExample.Polygon p;

    @Before
    public void init() {
        h = new DoubleDispatchPatternExample.HiddenShape();
        c = new DoubleDispatchPatternExample.Circle();
        p = new DoubleDispatchPatternExample.Polygon();
    }

    @Test
    public void circleCanIntersectWithCircle() {
        assertEquals(c.intersects(c), "Circle intersects Circle");
    }

    @Test
    public void circleCanIntersectWithPolygon() {
        assertEquals(c.intersects(p), "Polygon intersects Circle");
    }

    @Test
    public void circleCannotIntersectWithHiddenShape() {
        assertEquals(c.intersects(h), "HiddenShape never intersects Circle");
    }

    @Test
    public void polygonCanIntersectWithCircle() {
        assertEquals(p.intersects(c), "Circle intersects Polygon");
    }

    @Test
    public void polygonCanIntersectWithPolygon() {
        assertEquals(p.intersects(p), "Polygon intersects Polygon");
    }

    @Test
    public void polygonCannotIntersectWithHiddenShape() {
        assertEquals(p.intersects(h), "HiddenShape never intersects Polygon");
    }

    @Test
    public void hiddenShapeCannotIntersectWithCircle() {
        assertEquals(h.intersects(c), "Circle never intersects HiddenShape");
    }

    @Test
    public void hiddenShapeCannotIntersectWithPolygon() {
        assertEquals(h.intersects(p), "Polygon never intersects HiddenShape");
    }

    @Test
    public void hiddenShapeCannotIntersectWithHiddenShape() {
        assertEquals(h.intersects(h), "HiddenShape never intersects HiddenShape");
    }

}
