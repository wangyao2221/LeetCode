package Test.enumTest;

public class StaticColor {
    private String rgb;
    private String hex;

    public static final StaticColor BLACK = new StaticColor("(0,0,0)","#000000");
    public static final StaticColor WHITE = new StaticColor("(0,0,0)","#000000");

    private StaticColor(String rgb, String hex) {
        this.rgb = rgb;
        this.hex = hex;
    }

//    public static StaticColor BLACK() {
//        return new StaticColor("(0,0,0)","#000000");
//    }
//
//    public static StaticColor WHITE() {
//        return new StaticColor("(0,0,0)","#000000");
//    }

    public static void main(String[] args) {
        StaticColor color = StaticColor.BLACK;
    }
}
