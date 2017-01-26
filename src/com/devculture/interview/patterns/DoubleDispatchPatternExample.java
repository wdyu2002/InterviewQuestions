package com.devculture.interview.patterns;

class DoubleDispatchPatternExample {

    static abstract class Shape {
        /**
         * Double-dispatch pattern implementation.
         * Concrete sub-class impl. of this method should always be s.intersectImpl(this);
         * 1st dispatch is object.intersects(another);
         * 1st dispatch determines object class-type without instanceof.
         * 2nd dispatch is another.intersects(object);
         * 2nd dispatch determines another class-type without instanceof.
         */
        abstract String intersects(Shape s);

        // force sub-classes to have to overload the concrete implementations of intersects.
        abstract String intersectImpl(Circle c);

        // force sub-classes to have to overload the concrete implementations of intersects.
        abstract String intersectImpl(Polygon p);

        // we can also implement the method in the super class.
        final String intersectImpl(HiddenShape h) {
            // implement weirdShape intersecting polygon algorithm here.
            return String.format("%s never intersects %s", getClass().getSimpleName(), h.getClass().getSimpleName());
        }
    }

    static class Circle extends Shape {
        @Override
        public String intersects(Shape s) {
            return s.intersectImpl(this);
        }

        @Override
        String intersectImpl(Circle c) {
            // implement circle intersecting circle algorithm here.
            return String.format("%s intersects %s", getClass().getSimpleName(), c.getClass().getSimpleName());
        }

        @Override
        String intersectImpl(Polygon p) {
            // implement circle intersecting polygon algorithm here.
            return String.format("%s intersects %s", getClass().getSimpleName(), p.getClass().getSimpleName());
        }
    }

    static class Polygon extends Shape {
        @Override
        public String intersects(Shape s) {
            return s.intersectImpl(this);
        }

        @Override
        String intersectImpl(Circle c) {
            // implement polygon intersecting circle algorithm here.
            return String.format("%s intersects %s", getClass().getSimpleName(), c.getClass().getSimpleName());
        }

        @Override
        String intersectImpl(Polygon p) {
            // implement polygon intersecting polygon algorithm here.
            return String.format("%s intersects %s", getClass().getSimpleName(), p.getClass().getSimpleName());
        }
    }

    static class HiddenShape extends Shape {
        @Override
        String intersects(Shape s) {
            return s.intersectImpl(this);
        }

        @Override
        String intersectImpl(Circle c) {
            // implement weirdShape intersecting circle algorithm here.
            return String.format("%s never intersects %s", getClass().getSimpleName(), c.getClass().getSimpleName());
        }

        @Override
        String intersectImpl(Polygon p) {
            // implement weirdShape intersecting polygon algorithm here.
            return String.format("%s never intersects %s", getClass().getSimpleName(), p.getClass().getSimpleName());
        }
    }

}
