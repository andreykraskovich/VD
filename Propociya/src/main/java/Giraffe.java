public class Giraffe implements GiraffeInterface{
    @Override
    public double mathGiraffe(double giraffe) {

        double hare;
        double cat;

        cat = 5 / (0.5 * giraffe);
        hare = (cat) * 4;

        return hare;
    }
}
