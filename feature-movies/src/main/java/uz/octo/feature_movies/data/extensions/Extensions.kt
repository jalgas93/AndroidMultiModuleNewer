package uz.octo.feature_movies.data.extensions

import android.util.Log
import uz.octo.feature_movies.data.model.People.PeopleItem
import uz.octo.feature_movies.data.model.Popular.PopularItem
import uz.octo.feature_movies.data.model.category.CategoryItem
import uz.octo.feature_movies.data.model.details.DataGenreDetails
import uz.octo.feature_movies.data.model.details.Details
import uz.octo.feature_movies.data.model.details.ProductionCompany
import uz.octo.feature_movies.data.model.details.ProductionCountry
import uz.octo.feature_movies.data.model.details.SpokenLanguage
import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem
import uz.octo.feature_movies.domain.model.People.DomainPeopleItem
import uz.octo.feature_movies.domain.model.category.DominCategoryItem
import uz.octo.feature_movies.domain.model.details.DomainDetails
import uz.octo.feature_movies.domain.model.details.DomainGenre
import uz.octo.feature_movies.domain.model.details.DomainProductionCompany
import uz.octo.feature_movies.domain.model.details.DomainProductionCountry
import uz.octo.feature_movies.domain.model.details.DomainSpokenLanguage
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

fun Details.toDetails(): DomainDetails {
    return DomainDetails(
        adult,
        backdrop_path,
        //belongs_to_collection,
        budget,
        genres?.map {
            it.toGenre()
        },
        homepage,
        id,
        imdb_id,
        origin_country,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        production_companies?.map {
            it.toProductionCompany()
        },
        production_countries?.map {
            it.toProductionCountry()
        },
        release_date,
        revenue,
        runtime,
        spoken_languages?.map {
            it.toSpokenLanguage()
        },
        status,
        tagline,
        title,
        video,
        vote_average,
        vote_count
    )
}

fun ProductionCompany.toProductionCompany(): DomainProductionCompany {
    return DomainProductionCompany(
        id,
        logo_path,
        name,
        origin_country
    )
}

fun ProductionCountry.toProductionCountry(): DomainProductionCountry {
    return DomainProductionCountry(
        iso_3166_1,
        name
    )
}

fun SpokenLanguage.toSpokenLanguage(): DomainSpokenLanguage {
    return DomainSpokenLanguage(
        english_name,
        iso_639_1,
        name
    )
}

fun DataGenreDetails.toGenre(): DomainGenre {
    return DomainGenre(
        id,
        name,
    )
}
