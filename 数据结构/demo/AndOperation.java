public class AndOperation {

    public static void main(String[] args) {

        // 对210进行2^n 取模
        // hash & 2^n
        // 7 mod 4 = 7 & (4-1) = 0111 & 0011 = 0011
        // 12 mod 8 =  1100 & 0111 = 0100
        // 1101 1101 % 4 = 0011 0111

        System.out.println(Math.floorMod(221,8));
    }
}
