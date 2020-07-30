package vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JitaGroupVo {

    private String id;
    private String titleName = "";
    private List<Map<String,String>> showList = new ArrayList<>();

    public JitaGroupVo(String id, String titleName, List<Map<String, String>> showList) {
        this.id = id;
        this.titleName = titleName;
        this.showList = showList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public List<Map<String, String>> getShowList() {
        return showList;
    }

    public void setShowList(List<Map<String, String>> showList) {
        this.showList = showList;
    }
}
