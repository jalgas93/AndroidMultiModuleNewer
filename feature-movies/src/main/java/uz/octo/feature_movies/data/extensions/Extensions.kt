package uz.octo.feature_movies.data.extensions

import ResultModel
import uz.octo.feature_movies.domain.model.Result


fun ResultModel.toMovie(): Result {
    return Result(
        adult,
        backdrop_path,
        genre_ids,
        id,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        release_date,
        title,
        video,
        vote_average,
        vote_count
    )
}
