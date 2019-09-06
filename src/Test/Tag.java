package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tag {
    private String tagStart;
    private String tagEnd;
    private List<Tag> subTag;

    public class Sub {

    }

    public Tag() {
    }

    public Tag(String tagStart, String tagEnd, List<Tag> subTag) {
        this.tagStart = tagStart;
        this.tagEnd = tagEnd;
        this.subTag = subTag;
    }

    public static void main(String[] args) {
//        Tag subTag = new Tag();
//        Tag root = new Tag("<div>","</div>",);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        List<String> strs = list.stream()
                .filter((num) -> num > 5)
                .map((num) -> "string" + num)
                .collect(Collectors.toList());

        strs.forEach((s) -> System.out.println(s));

        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
    }
}
