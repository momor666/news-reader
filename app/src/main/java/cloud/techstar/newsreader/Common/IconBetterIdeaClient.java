package cloud.techstar.newsreader.Common;

/**
 * Created by Doljko on 3/22/2018.
 */

class IconBetterIdeaClient {
    private static RenderedImageFactory client;

    public static RenderedImageFactory getClient() {
        return client;
    }

    public static void setClient(RenderedImageFactory client) {
        IconBetterIdeaClient.client = client;
    }
}
