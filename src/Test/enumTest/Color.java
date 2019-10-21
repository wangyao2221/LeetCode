package Test.enumTest;

public enum Color {
    BLACK("(0,0,0)","#000000"),WHITE("(255,255,255)","#FFFFFF");

    private String rgb;
    private String hex;

    Color(String rgb, String hex) {
        this.rgb = rgb;
        this.hex = hex;
    }

    public static void main(String[] args) {
        Color color = Color.BLACK;
    }
}
