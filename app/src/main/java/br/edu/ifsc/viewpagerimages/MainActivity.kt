package br.edu.ifsc.viewpagerimages

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * Objetivo desta classe:
 *  • Nesta tela vamos criar um view pager de uma lista de imagens, ou seja
 */
class MainActivity : AppCompatActivity() {

    private var images: ArrayList<Int>? = null
    private val options: BitmapFactory.Options? = null
    private var viewPager: HackyViewPager? = null
    private val btnNext: View? = null
    private  var btnPrev : View? = null
    private var adapter: FragmentStatePagerAdapter? = null


    private val resourceIDs = intArrayOf(R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d, R.drawable.e)


    /**
     * onCreate é um método usado para configurar a interface de usuário, e definir, qual layout será mostrado, eventos de componentes
     * e outras funcionalidaes caso sejam necessárias.
     *
     **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * setContentView é o método que passamos como parametro um layout(pode ser um objeto do tipo view ou um arquivo em xml)
         * para ele ser exibido ao abrir uma tela.
         *
         **/
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        images = ArrayList()

        //find view by id
        viewPager = findViewById(R.id.view_pager) as HackyViewPager

        setImagesData()

        // init viewpager adapter and attach
        adapter = ViewPagerAdapter(supportFragmentManager, images!!)
        viewPager!!.adapter = adapter

        supportActionBar!!.title = "Exemplo View Pager"
    }

    private fun setImagesData() {
        for (i in resourceIDs.indices) {
            images!!.add(resourceIDs.get(i))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
