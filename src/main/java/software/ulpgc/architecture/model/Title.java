package software.ulpgc.architecture.model;

public record Title(String id, TitleType titleType,
                    String primaryTitle, String originalTitle,
                    boolean isAdult, int start_year, int end_year,
                    int duration, String genres) {

    public enum TitleType {
        VIDEOGAME,
        MOVIE,
        TVSHORT,
        TVSERIES,
        TVMINISERIES,
        TVSPECIAL,
        TVMOVIE,
        TVEPISODE,
        VIDEO,
        TVPILOT,
        SHORT
    }
}
