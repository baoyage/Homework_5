package syr.project.homework_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Task2Activity : AppCompatActivity(),RecyclerViewFragment.OnRecyclerInteractionListener {
    var movie: MovieData? =null
    var posterid: Int? =null
    private var mTwoPane = false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment1,RecyclerViewFragment()).commit()
        }
//        if(findViewById<FrameLayout>(R.id.tablet) != null){
//            mTwoPane = true // Tablet layout is loaded
//        }
//        recyclerView.layoutManager= GridLayoutManager(this,1)
//        val myAdapter= MyMovieListAdapter(movieList,posterTable,this)
//        myAdapter.setMyItemClickListener(this)
//        recyclerView.adapter=myAdapter

    }

    override fun onItemClicked(movie:MovieData, posterid: Int?) {



        supportFragmentManager.beginTransaction().replace(R.id.fragment1,DetailFragment.newInstance(movie,
            posterid!!
        )).addToBackStack(null).commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable("movie",movie)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState!=null){
            movie=savedInstanceState.getSerializable("movie")as MovieData
        }
    }

}