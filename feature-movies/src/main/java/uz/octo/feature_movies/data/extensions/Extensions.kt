package uz.octo.feature_movies.data.extensions

import uz.octo.feature_movies.data.model.PeoplePopular.KnownFor
import uz.octo.feature_movies.data.model.PeoplePopular.ResultPeople
import uz.octo.feature_movies.data.model.PopularMovie.ResultModel
import uz.octo.feature_movies.data.model.genres.GenreModel
import uz.octo.feature_movies.data.model.genres.GenresModel
import uz.octo.feature_movies.domain.model.PopularMovie.Result
import uz.octo.feature_movies.domain.model.PopularPeople.People
import uz.octo.feature_movies.domain.model.genres.Genre


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

fun ResultPeople.toPeople(): People {
    return People(
        adult,
        gender, id,
        known_for,
        known_for_department,
        name,
        original_name,
        popularity,
        profile_path
    )
}

fun GenreModel.toGenre(): Genre {
    return Genre(
        id,
        name,
    )
}
