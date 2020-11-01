package syr.project.homework_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_task2.*

class Task2Activity : AppCompatActivity(),RecyclerViewFragment.OnRecyclerInteractionListener {
    var movie: MovieData? =null
    var posterid: Int? =null
    private var mTwoPane = false






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)
        setSupportActionBar(toolbarTask2)

        if(savedInstanceState==null){
            val appBar = supportActionBar
            appBar!!.title = null
            toolBarTitle!!.text="Movie List"

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
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        // inflate the menu into toolbar
//        val inflater = menuInflater
//        inflater.inflate(R.menu.toolbar_menu_task2, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
    override fun onItemClicked(movie:MovieData, posterid: Int?) {
        val appBar = supportActionBar
        toolBarTitle!!.text = movie.title
        supportFragmentManager.beginTransaction().replace(R.id.fragment1,DetailFragment.newInstance(movie,
            posterid!!
        )).addToBackStack(null).commit()
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putSerializable("movie",movie)
//        val appBar = supportActionBar
//        appBar!!.title = "Movie List"
//        super.onSaveInstanceState(outState)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        if(savedInstanceState!=null){
//            movie=savedInstanceState.getSerializable("movie")as MovieData
//        }
//        val appBar = supportActionBar
//        appBar!!.title = "Movie List"
//    }


}