package cloud.techstar.newsreader.models;

import java.util.List;

import javax.xml.transform.Source;

/**
 * Created by Doljko on 3/22/2018.
 */

public class WebSite {
    public String status;
    private List<Source> sources;

    public WebSite(String status, List<Source> sources) {
        this.status = status;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
