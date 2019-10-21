package Test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] str = {"\n\022d-concurrent.proto\022\013dconcurrent\"G\n\007DOb" +
                "ject\022\021\n\tclassName\030\001 \001(\014\022\021\n\tmetaParam\030\002 \001" +
                "(\014\022\026\n\016metaParamClass\030\003 \001(\014\"U\n\006DField\022\021\n\t" +
                "className\030\001 \001(\014\022\021\n\tfieldType\030\002 \001(\014\022\021\n\tfi" +
                "eldName\030\003 \001(\014\022\022\n\nfieldValue\030\004 \001(\014\"\025\n\006DBy" +
                "tes\022\013\n\003res\030\001 \001(\014\".\n\007DStatus\022\020\n\010runCount\030" +
                "\001 \001(\005\022\021\n\tcallCount\030\002 \001(\0052\336\002\n\021DConcurrent" +
                "Server\0226\n\010GetField\022\023.dconcurrent.DField\032" +
                "\023.dconcurrent.DBytes\"\000\0226\n\010SetField\022\023.dco" +
                "ncurrent.DField\032\023.dconcurrent.DBytes\"\000\0228",
        "\n\tResetStat\022\024.dconcurrent.DStatus\032\023.dcon" +
                "current.DBytes\"\000\0226\n\007GetStat\022\023.dconcurren" +
                "t.DBytes\032\024.dconcurrent.DStatus\"\000\0222\n\003Run\022" +
                "\024.dconcurrent.DObject\032\023.dconcurrent.DByt" +
                "es\"\000\0223\n\004Call\022\024.dconcurrent.DObject\032\023.dco" +
                "ncurrent.DBytes\"\000B8\n\'com.iqiyi.bigdata.u" +
                "til.dconcurrent.coreB\013DConcurrentP\001"};
        for (String s : str) {
            System.out.println(s.getBytes());
        }
    }
}
