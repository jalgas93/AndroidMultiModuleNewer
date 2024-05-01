package uz.octo.feature_movies.data.extensions

import uz.octo.feature_movies.data.model.People.PeopleItem
import uz.octo.feature_movies.data.model.Popular.PopularItem
import uz.octo.feature_movies.data.model.category.CategoryItem
import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem
import uz.octo.feature_movies.domain.model.People.DomainPeopleItem
import uz.octo.feature_movies.domain.model.category.DominCategoryItem
import uz.octo.feature_movies.domain.model.genre.DomainGenreItem


fun PopularItem.toPopular(): DomainPopularItem {
    return DomainPopularItem(
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

fun PeopleItem.toPeople(): DomainPeopleItem {
    return DomainPeopleItem(
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

fun uz.octo.feature_movies.data.model.genres.Genre.toGenre(): DomainGenreItem {
    return DomainGenreItem(
        id,
        name,
    )
}
fun CategoryItem.toCategory(): DominCategoryItem {
    return DominCategoryItem(
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
