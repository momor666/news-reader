package cloud.techstar.newsreader.models;

import java.util.List;

/**
 * Created by Doljko on 3/22/2018.
 */

public class WebSite {
    public String status;
    private List<Sources> sources;

    public WebSite(String status, List<Sources> sources) {
        this.status = status;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Sources> getSources() {
        return sources;
    }

    public void setSources(List<Sources> sources) {
        this.sources = sources;
    }
}
