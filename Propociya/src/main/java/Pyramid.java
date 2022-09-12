public class Pyramid implements PyramidInterface{
    @Override
    public double mathPyramid(double pyramid) {

        double bar;
        double ring;

        ring = 16.8 / (pyramid * 2);
        bar = (ring * 2) / 12;

        return bar;
    }
}
