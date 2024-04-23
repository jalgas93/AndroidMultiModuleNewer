package uz.octo.mobile_android.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import dagger.hilt.android.scopes.ActivityScoped
import uz.octo.feature_movies.domain.model.Result
import uz.octo.feature_movies.domain.navigation.NavigationList
import uz.octo.mobile_android.R
import javax.inject.Inject

@ActivityScoped
class Navigator @Inject constructor(
    private val navController: NavController
) : NavigationList {

    override fun openMovie(id: Int) {
        val bundle = Bundle()
        bundle.putInt("movie_id", id)
        Log.d("Click", "HERE")
        navController?.navigate(R.id.descriptionHomeFragment, bundle)
    }

}
