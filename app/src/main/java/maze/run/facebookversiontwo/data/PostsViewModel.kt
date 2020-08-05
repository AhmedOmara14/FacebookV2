package maze.run.facebookversiontwo.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import maze.run.facebookversiontwo.pojo.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel : ViewModel() {
    var mutableLiveData: MutableLiveData<List<Posts>> = MutableLiveData<List<Posts>>()


    private fun onFailure(t: Throwable) {
        Log.d(TAG, "onFailure: " + t)
    }

    private fun onResponse(response: List<Posts>) {
        val list: List<Posts>? = response
        mutableLiveData.value = list

    }

    fun getposts(): MutableLiveData<List<Posts>> {

        postsclient.getClient.getposts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<Posts>> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: List<Posts>) {
                    val list: List<Posts>? = t
                    mutableLiveData.value = list
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "onError: " + e)
                }


            })



        return mutableLiveData
    }

    companion object {
        private const val TAG = "PostsViewModel"
    }
}