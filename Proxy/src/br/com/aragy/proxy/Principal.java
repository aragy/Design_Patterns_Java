package br.com.aragy.proxy;

public class Principal {

    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = 
        		new YoutubeDownloader(new ThirdPartyYouTubeClass());
        YoutubeDownloader smartDownloader = 
        		new YoutubeDownloader(new YoutubeCacheProxy());
        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " 
        + (naive - smart) + "ms");
    }
    private static long test(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}