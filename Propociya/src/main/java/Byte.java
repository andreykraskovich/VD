public class Byte implements ByteInterface{
    @Override
    public double mathByte(double kilobyte) {

        double bit;
        double byte1;

        byte1 = kilobyte * 1024;
        bit = byte1 * 8;

        return bit;
    }
}
